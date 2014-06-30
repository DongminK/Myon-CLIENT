package myon.client.net;

import insoft.openmanager.message.Message;
import myon.client.common.ClientConfig;

public class ConnectManager {

	private static ConnectManager connManager = new ConnectManager();
	private ClientConnection conn;
	private int sessionId = -1;
	
	private ConnectManager() {
		initialize();
	}
	
	public static ConnectManager getInstance() {
		return connManager;
	}
	
	private void initialize() {
		conn = new ClientConnection(ClientConfig.IP, ClientConfig.PORT);
	}
	
	public void write(Message writeMsg) {
		try {
			conn.write(writeMsg);
		} catch (Exception e) {}
	}
	
	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(Message rspMsg) {
		
		int sessionId = rspMsg.getInteger("session_id", -1);
		
		if (sessionId > -1)
			this.sessionId = sessionId;
		
	}
	
	
}
