package com.ligres.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.ligres.sql.Information;

public class ButtonNewRegister extends JButton implements ActionListener {

	Information information;

	public ButtonNewRegister(Information i) {
		super("Novo Registro");
		this.information = i;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		information.getWindows().add(information.getViewRegister());
		information.getWindows().setVisible(true);

	}

}
