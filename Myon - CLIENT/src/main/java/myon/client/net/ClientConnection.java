package myon.client.net;

import insoft.openmanager.message.ClientPacket;
import insoft.openmanager.message.Message;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
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

		try {

			SocketAddress addr = new InetSocketAddress(ip, port);
			socketChannel = SocketChannel.open(addr);
			socketChannel.configureBlocking(false);
			socketChannel.socket().setSendBufferSize(1 * 1024);
			socketChannel.socket().setReceiveBufferSize(1 * 1024);
			socketChannel.socket().setTcpNoDelay(true);
			selector = Selector.open();
			socketChannel.finishConnect();
			socketChannel.register(selector, SelectionKey.OP_READ);

			start();

		} catch(Exception e) {
			logger.error(e.toString());
			logger.trace("", e);
			e.printStackTrace();
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
						e.printStackTrace();
					}
				}

				iterSelectionKey.remove();
			}

		}
	}

	public void close() {

		if (socketChannel != null)
			try {
				socketChannel.close();
			} catch (IOException e) {}

		if (selector != null)
			try {
				selector.close();
			} catch (IOException e) {}
	}

}
