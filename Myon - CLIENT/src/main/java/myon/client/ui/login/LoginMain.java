package myon.client.ui.login;

import insoft.openmanager.message.Message;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import myon.client.ui.MyonUI;

public class LoginMain extends MyonUI {

	@Override
	public void draw() {
		// TODO Auto-generated method stub

		JLabel labelId = new JLabel("ID");
		JLabel labelPw = new JLabel("PW");

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));// places at the left
		panel.add( labelId );
		panel.add( labelPw );

		mainFrame.getContentPane().add(panel);

		mainFrame.setSize(300, 500);
		mainFrame.setVisible(true);

	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Login";
	}

	@Override
	public void setResponse(Message rspMsg) {
		// TODO Auto-generated method stub
		
	}

}
