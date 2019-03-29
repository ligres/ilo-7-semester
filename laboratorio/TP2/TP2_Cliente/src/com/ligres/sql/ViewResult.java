package com.ligres.sql;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ligres.ui.ButtonCancel;
import com.ligres.ui.ButtonNewRegister;

public class ViewResult extends JPanel {

	Information information;

	public ViewResult(String m, Information information) {
		super(new GridLayout(2, 1));

		this.information = information;

		JPanel line1 = new JPanel();
		JLabel mensager = new JLabel(m);
		line1.add(mensager);

		JPanel line2 = new JPanel(new GridLayout(1, 2));

		line2.add(new ButtonNewRegister(this.information));
		line2.add(new ButtonCancel());

		super.add(line1);
		super.add(line2);

	}

}
