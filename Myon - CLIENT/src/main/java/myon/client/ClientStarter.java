package myon.client;

import myon.client.common.ClientConfig;
import myon.client.common.LoginUser;
import myon.client.log.ClientLogManager;
import myon.client.net.ConnectManager;
import myon.client.ui.MyonMain;
import myon.client.ui.UIManager;

import org.apache.logging.log4j.Logger;

public class ClientStarter {

	public static void main(String[] args) throws Exception {

		Logger cliLogger = ClientLogManager.getInstance().getClientLogger();
		Logger uiLogger = ClientLogManager.getInstance().getUILogger();
		Logger connLogger = ClientLogManager.getInstance().getConnectLogger();

		cliLogger.info("Client Logger");
		uiLogger.info("Client Logger");
		connLogger.info("Client Logger");

		ClientConfig.IP = "192.168.1.106";
		ClientConfig.PORT = 7777;

		ConnectManager.getInstance();

		ClientStarter starter = new ClientStarter();
		starter.loginDmk();
		//		starter.loginNmp();
	}

	public void loginDmk() {
		MyonMain main = new MyonMain();
		main.myonStart();

		LoginUser loginUser = new LoginUser();
		loginUser.setUserId("dmk");
		loginUser.setUserName("±èµ¿¹Î");
		loginUser.setUserEmail("dmkim@in-soft.co.kr");

		UIManager.getInstance().setLoginUser(loginUser);
	}

	public void loginNmp() {
		MyonMain main = new MyonMain();
		main.myonStart();

		LoginUser loginUser = new LoginUser();
		loginUser.setUserId("nmp");
		loginUser.setUserName("¹Ú³ª¹Ì");
		loginUser.setUserEmail("nmpark@in-soft.co.kr");

		UIManager.getInstance().setLoginUser(loginUser);
	}
}
