package myon.client.task.impl;

import myon.client.task.ClientTask;
import myon.client.task.TaskNames;

public class GetUser extends ClientTask {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return TaskNames.GET_USER;
	}
	
	@Override
	public ClientTask newInstance() {
		// TODO Auto-generated method stub
		return new GetUser();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	

}
