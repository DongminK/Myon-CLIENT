package myon.client.task;

import java.util.HashMap;

import myon.client.task.impl.GetUser;
import myon.client.task.impl.SendMessage;

public class ClientTaskManager {

	private static ClientTaskManager taskManager = new ClientTaskManager();
	private HashMap<String, ClientTask> mapTask = new HashMap<String, ClientTask>();
	
	private ClientTaskManager() {
		initalize();
	}
	
	public static ClientTaskManager getInstance() {
		return taskManager;
	}
	
	private void initalize() {
		GetUser getUser = new GetUser();
		SendMessage sendMsg = new SendMessage();
		
		mapTask.put(getUser.getName(), getUser);
		mapTask.put(sendMsg.getName(), sendMsg);
	}
	
	public ClientTask getTask(String msgName) {
		return mapTask.get(msgName).newInstance();
	}
}
