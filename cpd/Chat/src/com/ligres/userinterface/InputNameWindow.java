package com.ligres.userinterface;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ligres.client.ConnetionClient;

public class InputNameWindow extends JFrame {
	
	private static final long serialVersionUID = 4174945549597015785L;
	
	private JTextField textField = new JTextField();
	private JButton button;
	private String username;
	
	public InputNameWindow() {
		super("Digite seu nome");
		super.setSize(300, 90);
		super.setLocationRelativeTo(null);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		username = "";

		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == Event.ENTER) {
					String str = textField.getText();
					textField.setText("");
					System.out.println(str);
					try {
						new ConnetionClient(str);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		button = new JButton("Pronto!");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				username = textField.getText();
			}
		});
		
		mainPanel.add(textField);
		mainPanel.add(button, BorderLayout.EAST);
		
		super.add(mainPanel);
		super.setVisible(true);
	}
	
	public String getUsername()
	{
		return username;
	}
}
