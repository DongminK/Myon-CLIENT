package myon.client.ui;

import insoft.openmanager.message.Message;

import javax.swing.JFrame;

import myon.client.common.Version;

abstract public class MyonUI {

	protected JFrame mainFrame = new JFrame();
	protected int uiIndex = 0;
	
	protected MyonUI() {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle(Version.version + " - " + getTitle());
	}
	
	public void setUIIndex(int uiIndex) {
		this.uiIndex = uiIndex;
	}
	public int getUIIndex() {
		return uiIndex;
	}
	
	abstract public String getTitle();
	abstract public void draw();
	abstract public void setResponse(Message rspMsg);
	
}
