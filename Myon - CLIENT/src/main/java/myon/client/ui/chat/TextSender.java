package myon.client.ui.chat;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class TextSender implements KeyListener {

	private JButton button;
	
	public TextSender(JButton button) {
		this.button = button;
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		int key=e.getKeyCode();

		if(key==KeyEvent.VK_ENTER)
			button.doClick();                  
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
