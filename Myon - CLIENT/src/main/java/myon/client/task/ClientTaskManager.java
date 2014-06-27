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
		mapTask.put("GET_USER", new GetUser());
		mapTask.put("SEND_MESSAGE", new SendMessage());
	}
	
	public ClientTask getTask(String msgName) {
		return mapTask.get(msgName).newInstance();
	}
}
