package myon.client.net;

import insoft.openmanager.message.Message;

import java.util.concurrent.LinkedBlockingQueue;

public class RequestQueue extends Thread {

	private static RequestQueue reqQueue = new RequestQueue();
	private LinkedBlockingQueue<Message> quRequeset = new LinkedBlockingQueue<Message>();
	
	private Object objWait = new Object();
	
	private RequestQueue() {
		start();
	}
	
	public static RequestQueue getInstance() {
		return reqQueue;
	}
	
	public void add(Message rspMsg) {
		quRequeset.add(rspMsg);
		
		synchronized (objWait) {
			objWait.notifyAll();
		}
	}
	
	public void run() {
		
		ConnectManager connManager = ConnectManager.getInstance();
		Message quMsg = null;
		
		while(true) {
		
			while((quMsg = quRequeset.poll()) != null) {
				connManager.write(quMsg);
			}
			
			try {
				objWait.wait();
			} catch (InterruptedException e) {}
			
		}
	}
	
	
}
