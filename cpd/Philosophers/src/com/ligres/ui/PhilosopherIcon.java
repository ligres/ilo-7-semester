package com.ligres.ui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PhilosopherIcon extends JPanel {
	
	private final Color EATING_COLOR = new Color(0, 1, 0, 1);
	private final Color THINKING_COLOR = new Color(1, 1, 1, 1);
	
	private JLabel icon;
	private JLabel nameText;
	private JLabel statusText;
	
	public PhilosopherIcon(int philosopherNumber)
	{
		Icon imgIcon = new ImageIcon("res/philosopher.png");
		icon = new JLabel("", imgIcon, JLabel.CENTER);
		nameText = new JLabel("Filósofo " + philosopherNumber);
		statusText = new JLabel("");
		this.setLayout(new GridLayout(3, 1));
		this.add(nameText);
		this.add(icon);
		this.add(statusText);
	}
	
	public void update(boolean isEating)
	{
		if (isEating)
		{
			statusText.setText("Comendo");
			statusText.setBackground(EATING_COLOR);
		}
		else
		{
			statusText.setText("Pensando");
			statusText.setBackground(THINKING_COLOR);
		}
		statusText.revalidate();
		this.revalidate();
	}
}
