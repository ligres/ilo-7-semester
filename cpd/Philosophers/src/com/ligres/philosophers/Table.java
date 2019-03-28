package com.ligres.philosophers;

import com.ligres.ui.MainWindow;

public class Table implements Runnable {
	private final int PRINTS_PER_SECOND = 30;
	private Philosopher[] philosophers;
	private int numOfPhilosophers;
	private MainWindow mainWindow;

	public Table(int numOfPhilosophers) {
		this.numOfPhilosophers = numOfPhilosophers;
		philosophers = new Philosopher[numOfPhilosophers];
		for (int i = 0; i < philosophers.length; i++) {
			philosophers[i] = new Philosopher(i + "");
		}
		for (int i = 0; i < philosophers.length; i++) {
			philosophers[i].SetNeighbours(philosophers[(i + philosophers.length - 1) % philosophers.length],
					philosophers[(i + 1) % philosophers.length]);
		}
		for (int i = 0; i < philosophers.length; i++) {
			// System.out.println(i + ": L:" + philosophers[i].getLeftNeightbout().getPhilosopherName() + " R: " + philosophers[i].getRightNeighbour().getPhilosopherName());
			new Thread(philosophers[i]).start();
		}
		mainWindow = new MainWindow(numOfPhilosophers);
	}

	@Override
	public void run() {
		while (true) {
			String s = "";
			for (int i = 0; i < philosophers.length; i++) {
				if (philosophers[i].isEating() && philosophers[(i + 1) % philosophers.length].isEating())
				{
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
			}
			s += "S: [";
			for (int i = 0; i < philosophers.length - 1; i++) {
				s += philosophers[i].getStarvation() + ", ";
			}
			s += philosophers[philosophers.length - 1].getStarvation() + "]\n";
			s += "E: [";
			for (int i = 0; i < philosophers.length - 1; i++) {
				s += philosophers[i].isEating() + ", ";
			}
			s += philosophers[philosophers.length - 1].isEating() + "]";
			System.out.println(s);
			
			mainWindow.update(philosophers);

			try {
				Thread.sleep(1000 / PRINTS_PER_SECOND);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int getNumOfPhilosophers() {
		return numOfPhilosophers;
	}
	
	public boolean isPhilosopherEating(int id)
	{
		return philosophers[id].isEating();
	}
}
