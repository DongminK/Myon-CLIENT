package myon.client.ui;

import java.util.HashMap;

import myon.client.common.LoginUser;
import myon.client.ui.chat.ChatMain;

public class UIManager {

	private LoginUser loginUser = null;
	private int index = 0;
	private HashMap<Integer, MyonUI> mapUsedMyonUI = new HashMap<Integer, MyonUI>();
	private static HashMap<String, MyonUI> mapMyonUI = new HashMap<String, MyonUI>();
	private static UIManager uiManager = new UIManager();
	private UIManager() {}
	
	static {
		ChatMain chatMain = new ChatMain();
		mapMyonUI.put(chatMain.getTitle(), chatMain);
	}
	
	public static UIManager getInstance() {
		return uiManager;
	}
	
	public synchronized int generateUiIndex() {
		
		if (index > Integer.MAX_VALUE) {
			index = 0;
		}
		
		return index++;
		
	}
	
	public MyonUI getMyonUI(int uiIndex) {
		return mapUsedMyonUI.get(uiIndex);
	}
	
	public void closeMyonUI(int uiIndex) {
		synchronized (mapUsedMyonUI) {
			mapUsedMyonUI.remove(uiIndex);
		}
	}
	
	public MyonUI createMyonUI(String uiName) {
		
		MyonUI ui = mapMyonUI.get(uiName);
		
		if (ui != null) {
			ui.setUIIndex(generateUiIndex());
			mapUsedMyonUI.put(ui.getUIIndex(), ui);
		}
		
		return ui;
	}
	
	public void setLoginUser(LoginUser loginUser) {
		this.loginUser = loginUser;
	}
	
	public LoginUser getLoginUser() {
		return this.loginUser;
	}

}
