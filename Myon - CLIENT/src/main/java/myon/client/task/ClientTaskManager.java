package myon.client.task;

import java.util.HashMap;

import myon.client.task.impl.GetUser;

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
		mapTask.put("GET_USER", new GetUser());
	}
	
	public ClientTask getTask(String msgName) {
		return mapTask.get(msgName);
	}
}
