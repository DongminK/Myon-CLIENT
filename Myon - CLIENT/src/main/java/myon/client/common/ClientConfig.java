package myon.client.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientConfig {

	public static String HOME = System.getProperty("myon.home");
	public static String IP = "127.0.0.1";
	public static int PORT = 2543;
	public static int CLIENT_TASK = 20;
	
	private Logger logger = LogManager.getLogger(this);
	
	public ClientConfig() {
		initialize();
	}
	
	private void initialize() {
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(HOME + File.separator + "config" + File.separator + "server.properties"));
			
			IP = prop.getProperty("IP");
			PORT = Integer.parseInt(prop.getProperty("PORT", "2543"));
			CLIENT_TASK = Integer.parseInt(prop.getProperty("CLIENT_TASK", "20"));
			
		} catch(Exception e) {
			logger.error(e.toString() + " Properties load error");
			logger.trace("Properties load error", e);
			System.exit(1);
		} finally {
			prop.clear();
		}
		
	}
	
}
