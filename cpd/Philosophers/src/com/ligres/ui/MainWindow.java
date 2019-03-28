package com.ligres.ui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

import com.ligres.philosophers.Philosopher;
import com.ligres.philosophers.Table;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1432221137330384320L;
	private static final int ICON_SIZE = 50;
	private static final int ICONS_GAP = 3;
	private static final Color EATING_COLOR = new Color(0, 1, 0, 1);
	private static final Color THINKING_COLOR = new Color(1, 1, 1, 1);
	
	private Table table;
	private PhilosopherIcon[] philosophersIcon;
	private int philosophersCount;

	public MainWindow(Table table) {
		
		this.philosophersCount = table.getNumOfPhilosophers();
		this.table = table;
		
		this.setTitle("Philosophers");
		this.setSize(ICON_SIZE * philosophersCount, 2 * ICON_SIZE + 2 * ICONS_GAP);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1, philosophersCount));
		
		philosophersIcon = new PhilosopherIcon[philosophersCount];
		for (int i = 0; i < philosophersCount; i++) {
			PhilosopherIcon icon = new PhilosopherIcon(0, 0, ICON_SIZE, ICON_SIZE);
			philosophersIcon[i] = icon;
			this.add(philosophersIcon[i]);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
	}

	public void setColors(Philosopher[] philosophers) {
		for (int i = 0; i < philosophers.length; i++) {
			if (philosophers[i].isEating())
			{
				philosophersIcon[i].changeColor(EATING_COLOR);
			}
			else
			{
				philosophersIcon[i].changeColor(THINKING_COLOR);
			}
		}
		
	}

}
