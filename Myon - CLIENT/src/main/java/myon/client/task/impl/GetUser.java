package myon.client.task.impl;

import myon.client.task.ClientTask;

public class GetUser extends ClientTask {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "GET_USER";
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
