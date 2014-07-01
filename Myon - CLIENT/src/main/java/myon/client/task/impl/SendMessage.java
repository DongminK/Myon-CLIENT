package myon.client.task.impl;

import insoft.openmanager.message.Message;
import myon.client.common.LoginUser;
import myon.client.task.ClientTask;
import myon.client.task.TaskNames;
import myon.client.ui.MyonUI;
import myon.client.ui.UIManager;

public class SendMessage extends ClientTask {

	private UIManager uiManager = UIManager.getInstance();
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return TaskNames.SEND_MESSAGE;
	}

	@Override
	public ClientTask newInstance() {
		// TODO Auto-generated method stub
		return new SendMessage();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		int uiIndex = msgTask.getInteger("ui_index");
		MyonUI myonUI = uiManager.getMyonUI(uiIndex);
		
		if (myonUI != null)
			myonUI.setResponse(msgTask);
		
	}

	public static Message sendMessage(int uiIndex, String message) {
		
		LoginUser loginUser = UIManager.getInstance().getLoginUser();
		
		String userId = loginUser.getUserId();
		String userName = loginUser.getUserName();
		
		Message msg = new Message("SEND_MESSAGE");
		
		msg.setString("user_id", userId);
		msg.setString("user_name", userName);
		msg.setInteger("ui_index", uiIndex);
		msg.setString("message", message);
		
		return msg;
	}

}
