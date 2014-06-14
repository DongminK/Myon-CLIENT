package myon.client.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientLogManager {

	private static ClientLogManager logManager = new ClientLogManager();
	
	private Logger clientLogger = LogManager.getLogger("CLIENT");
	private Logger connLogger = LogManager.getLogger("CONNECTION");
	private Logger uiLogger = LogManager.getLogger("UI");
	
	private ClientLogManager() {}
	
	public static ClientLogManager getInstance() {
		return logManager;
	}
	
	public Logger getClientLogger() {
		return clientLogger;
	}
	
	public Logger getConnectLogger() {
		return connLogger;
	}
	
	public Logger getUILogger() {
		return uiLogger;
	}
	
}
