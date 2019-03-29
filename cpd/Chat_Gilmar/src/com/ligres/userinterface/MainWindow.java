package com.ligres.userinterface;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.ligres.client.Send;

public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private View view;
	private JScrollPane scrollView;
	private JPanel mainPanel = new JPanel(new BorderLayout());
	private Interaction interaction;
	private Send send;

	public MainWindow(Send send) {
		super.getContentPane().setBackground(Color.black);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(300, 200);
		super.setLocation(550, 250);
		this.send = send;
		
		interaction = new Interaction(this);
		
		view = new View();
		
		view.setSize(300,500);
		scrollView = new JScrollPane(view);
		
		mainPanel.add(scrollView);
		mainPanel.add(interaction, BorderLayout.SOUTH);
		
		super.add(mainPanel);
	}

	public void start() {
		super.setVisible(true);
	}
	
	public void windowsUpdate(String msg) {
		view.addJLabel(msg);
		super.setVisible(true);
	}
	
	public Send getSend() {
		return this.send;
	}
}
