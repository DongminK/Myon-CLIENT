package myon.client.net;

import insoft.openmanager.message.ClientPacket;
import insoft.openmanager.message.Message;

import java.io.IOException;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientConnection extends Thread {

	private Logger logger = LogManager.getLogger(this);
	private SocketChannel socketChannel = null;
	private Selector selector = null;
	private ResponseQueue rspQueue = ResponseQueue.getInstance();
	
	public ClientConnection(String ip, int port) {
		
		Socket socket = null;
		
		try {
			socket = new Socket(ip, port);
			socketChannel = socket.getChannel();
			
			selector = Selector.open();
			socketChannel.register(selector, SelectionKey.OP_READ);
			socketChannel.configureBlocking(false);
			socketChannel.finishConnect();
			
			start();
			
		} catch(Exception e) {
			logger.error(e.toString());
			logger.trace("", e);
		}
		
	}
	
	public void write(Message writeMsg) throws Exception  {
		ClientPacket clientPacket = new ClientPacket();
		clientPacket.writeClientPacket(socketChannel, writeMsg);
	}
	
	public void read() throws Exception {
		
		ClientPacket clientPacket = new ClientPacket();
		Message readMsg = clientPacket.readClientPacket(socketChannel);
		rspQueue.add(readMsg);
		
	}
	
	public void run() {
		
		while(true) {
			
			try {
				selector.select(10);
			} catch (IOException e) {}
			
			Iterator<SelectionKey> iterSelectionKey = selector.selectedKeys().iterator();
				
			while(iterSelectionKey.hasNext()) {
				
				SelectionKey selectionKey = iterSelectionKey.next();
				
				if (selectionKey.isReadable()) {
				
					SocketChannel channel = (SocketChannel) selectionKey.channel();
					
					try {
						
						ClientPacket clientPacket = new ClientPacket();
						Message readMsg = clientPacket.readClientPacket(channel);
						rspQueue.add(readMsg);
						
					} catch(Exception e) {
						logger.error(e.toString());
						logger.trace("", e);
					}
				}
				
				iterSelectionKey.remove();
			}
			
		}
	}
	
}
