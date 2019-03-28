package com.ligres.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import com.ligres.philosophers.Philosopher;
import com.ligres.philosophers.Table;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1432221137330384320L;
	private PhilosopherIcon[] icons;
	
	public MainWindow(int numOfPhilosophers) throws HeadlessException {
		super("Philosophers");
		this.icons = new PhilosopherIcon[numOfPhilosophers];
		this.setSize(80 * numOfPhilosophers, 180);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1, numOfPhilosophers));
		for (int i = 0; i < icons.length; i++) {
			icons[i] = new PhilosopherIcon(i +1);
			add(icons[i]);
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void update(Philosopher[] philosophers)
	{
		for (int i = 0; i < icons.length; i++) {
			icons[i].update(philosophers[i].isEating());
		}
	}
}
