package com.ligres.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.text.View;

import com.ligres.sql.Answer;
import com.ligres.sql.ConnectionClient;
import com.ligres.sql.Data;
import com.ligres.sql.Information;
import com.ligres.sql.ViewRegister;

public class ButtonRegister extends JButton implements ActionListener {

	Information information;
	ViewRegister view;

	public ButtonRegister(Information i, ViewRegister v) {
		super("Cadastrar");

		this.information = i;
		this.view = v;

		this.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Data tmp = new Data(view.getName(), view.getPhone(), view.getEMail(), view.getPassword());

		information.setRegister(tmp);

		view.setTextName("");
		view.setTextEMail("");
		view.setTextPhone("");
		view.setTextPassword("");

		try {
			ConnectionClient c = new ConnectionClient(tmp);
			c.submit();
			boolean r = c.receiver();
			information.getWindows().setVisible(false);
			Answer a = new Answer(r, information);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}

}
