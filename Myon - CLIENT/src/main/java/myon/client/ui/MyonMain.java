package myon.client.ui;


public class MyonMain {

	private UIManager uiManager = UIManager.getInstance();
	
	public void myonStart() {
		
		MyonUI loginUI = uiManager.createMyonUI(UINames.LOGIN);
		loginUI.draw();
		
	}
}
