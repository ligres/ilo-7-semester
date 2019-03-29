package com.ligres.userinterface;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;


public class Interaction extends JPanel {
	private static final long serialVersionUID = -6735264467409432554L;
	private JTextField box = new JTextField();
	private ButtonSend botao;
	
	
	public Interaction(MainWindow w) {
		super(new BorderLayout());
		
		box.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == Event.ENTER) {
					String str = box.getText();
					box.setText("");
					w.getSend().run(str);
				}
			}
		});
		
		
		botao = new ButtonSend(box,w);	
		super.add(box);
		
		super.add(botao,BorderLayout.EAST);
	}

}
