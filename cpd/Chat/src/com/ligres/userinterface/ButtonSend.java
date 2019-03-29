package com.ligres.userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ButtonSend extends JButton implements ActionListener {
	
	private static final long serialVersionUID = -1852082361791567908L;
	private JTextField box;
	private MainWindow w;

	public ButtonSend(JTextField box, MainWindow w) {
		super("Enviar");
		super.setSize(60, 40);
		this.w = w;
		this.box = box;

		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = box.getText();
		box.setText("");
		w.getSend().run(str);

	}

}
