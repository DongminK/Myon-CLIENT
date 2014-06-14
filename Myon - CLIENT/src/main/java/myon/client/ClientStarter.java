package myon.client;

import myon.client.log.ClientLogManager;

import org.apache.logging.log4j.Logger;

public class ClientStarter {

	public static void main(String[] args) throws Exception {
	
		Logger cliLogger = ClientLogManager.getInstance().getClientLogger();
		Logger uiLogger = ClientLogManager.getInstance().getUILogger();
		Logger connLogger = ClientLogManager.getInstance().getConnectLogger();
		
		cliLogger.info("Client Logger");
		uiLogger.info("Client Logger");
		connLogger.info("Client Logger");
		
	}
	
}
