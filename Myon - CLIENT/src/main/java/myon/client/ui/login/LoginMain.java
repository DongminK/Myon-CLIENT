package myon.client.ui.login;

import insoft.openmanager.message.Message;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import myon.client.ui.MyonUI;
import myon.client.ui.UINames;

public class LoginMain extends MyonUI {
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;

		JLabel lbUsername = new JLabel("아이디");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbUsername, cs);

		JTextField tfUsername = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfUsername, cs);

		JLabel lbPassword = new JLabel("비밀번호");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbPassword, cs);

		JPasswordField pfPassword = new JPasswordField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(pfPassword, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		JButton btnLogin = new JButton("Login");
		JButton btnCancel = new JButton("Cancel");
		
		JPanel bp = new JPanel();
		bp.add(btnLogin);
		bp.add(btnCancel);
		
		JButton btnLogin1 = new JButton("Login");
		JButton btnCancel1 = new JButton("Cancel");
		JPanel bp1 = new JPanel();
		bp1.add(btnLogin1);
		bp1.add(btnCancel1);

		mainFrame.getContentPane().add(bp1, BorderLayout.NORTH);
		mainFrame.getContentPane().add(panel, BorderLayout.CENTER);
		mainFrame.getContentPane().add(bp, BorderLayout.PAGE_END);

		mainFrame.pack();
		mainFrame.setResizable(false);
		//mainFrame.setLocationRelativeTo(parent);
		mainFrame.setSize(300, 500);
		mainFrame.setVisible(true);
		
		/*
		 JLabel labelId = new JLabel("ID", JLabel.CENTER);
		 
		JTextField textId = new JTextField();
		JLabel labelPw = new JLabel("PW", JLabel.CENTER);
		JPasswordField passWorkd = new JPasswordField();

		JPanel panelId = new JPanel(new GridLayout(2, 3));
		panelId.add(labelId);
		panelId.add(textId);
		panelId.add(labelPw);
		panelId.add(passWorkd);




		mainFrame.setLayout(new GridLayout(4,1));
		mainFrame.getContentPane().add(new JPanel());
		mainFrame.getContentPane().add(panelId);
		mainFrame.getContentPane().add(new JPanel());

		mainFrame.setSize(300, 500);
		mainFrame.setVisible(true);
*/
		
		
		/*
		JLabel label1 = new JLabel();
		label1.setText("Username:");
		JTextField text1 = new JTextField(15);

		JLabel label2 = new JLabel();
		label2.setText("Password:");
		JPasswordField text2 = new JPasswordField(15);

		JButton SUBMIT=new JButton("SUBMIT");

		JPanel panel=new JPanel(new GridLayout(3,1));
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(SUBMIT);

		mainFrame.getContentPane().add(panel);
		mainFrame.setSize(300, 500);
		mainFrame.setVisible(true);
		 */

	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return UINames.LOGIN;
	}

	@Override
	public void setResponse(Message rspMsg) {
		// TODO Auto-generated method stub

	}

}
