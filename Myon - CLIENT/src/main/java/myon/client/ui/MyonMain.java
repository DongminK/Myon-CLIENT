package myon.client.ui;


public class MyonMain {

	private UIManager uiManager = UIManager.getInstance();
	
	public void myonStart() {
		
		MyonUI chatUI = uiManager.createMyonUI("Chat");
		chatUI.draw();
		
	}
}
