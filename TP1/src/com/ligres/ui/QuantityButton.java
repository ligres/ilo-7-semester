package com.ligres.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.ligres.sql.Information;

public class QuantityButton extends JButton implements ActionListener {
	
	Information information;

	public QuantityButton(Information i) {
		super("OK");

		information = i;

		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String s = information.getScreenDefiniQuantityOfNumber().getBox();

		int n = Integer.parseInt(s);

		information.setNumberOfNumbers(n);
		
		information.getScreenDefiniQuantityOfNumber().setVisible(false);

		information.getWindows().inputNumbers();

	}

}
