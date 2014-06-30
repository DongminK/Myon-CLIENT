package myon.client.net;

import insoft.openmanager.message.Message;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import myon.client.common.ClientConfig;
import myon.client.task.ClientTask;
import myon.client.task.ClientTaskManager;

public class ResponseQueue extends Thread {

	private static ResponseQueue rspQueue = new ResponseQueue();
	private LinkedBlockingQueue<Message> quResponse = new LinkedBlockingQueue<Message>();
	private ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(ClientConfig.CLIENT_TASK);
	
	private Object objWait = new Object();
	
	private ResponseQueue() {
		start();
	}
	
	public static ResponseQueue getInstance() {
		return rspQueue;
	}
	
	public void add(Message rspMsg) {
		quResponse.add(rspMsg);
		
		synchronized (objWait) {
			objWait.notifyAll();
		}
	}
	
	public void run() {
		
		ClientTaskManager taskManager = ClientTaskManager.getInstance();
		Message quMsg = null;
		
		while(true) {
		
			while((quMsg = quResponse.poll()) != null) {
				
				ConnectManager.getInstance().setSessionId(quMsg);
				
				ClientTask task = taskManager.getTask(quMsg.getMessageName());
				task.setTask(quMsg);
				executor.execute(task);
				
			}
			
			try {
				synchronized (objWait) {
					objWait.wait();
				}
			} catch (InterruptedException e) {}
			
		}
	}
	
}
