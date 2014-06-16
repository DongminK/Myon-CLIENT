package myon.client.task;

import insoft.openmanager.message.Message;

public abstract class ClientTask implements Runnable {
	
	protected Message msgTask;
	
	public void setTask(Message msgTask) {
		this.msgTask = msgTask;
	}

	public void run() {
		execute();
	}
	
	abstract public String getName();
	abstract public ClientTask newInstance();
	abstract public void execute();
}
