package myon.client.ui.chat;

import insoft.openmanager.message.Message;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.DefaultCaret;

import myon.client.net.RequestQueue;
import myon.client.task.impl.SendMessage;
import myon.client.ui.MyonUI;
import myon.client.ui.UINames;

public class ChatMain extends MyonUI implements ActionListener {

	private RequestQueue reqQueue = RequestQueue.getInstance();
	private JTextArea textArea;
	private JTextField text;

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return UINames.CHAT;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

		JPanel textPanel = new JPanel();

		JButton button = new JButton("전송");
		button.addActionListener(this);

		text = new JTextField("", 15);
		text.setHorizontalAlignment(JTextField.LEFT);
		text.addKeyListener(new TextSender(button));

		textPanel.add(text);
		textPanel.add(button);

		JPanel panel = new JPanel();

		textArea = new JTextArea(20, 20);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		JScrollPane scroller = new JScrollPane(textArea);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		panel.add(scroller);

		mainFrame.getContentPane().add(BorderLayout.CENTER, panel);
		mainFrame.getContentPane().add(BorderLayout.SOUTH, textPanel);

		mainFrame.setSize(300, 450);
		mainFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent ev) {

		// 메세지 전송
		String message = text.getText().trim();

		if (message.length() == 0)
			return;

		reqQueue.add(SendMessage.sendMessage(getUIIndex(), message));
		text.setText("");

	}

	@Override
	public void setResponse(Message rspMsg) {
		// TODO Auto-generated method stub

		String userName = rspMsg.getString("user_name");
		String message = rspMsg.getString("message");

		textArea.append("[" + userName + "] - " + message + "\n");

	}

}
