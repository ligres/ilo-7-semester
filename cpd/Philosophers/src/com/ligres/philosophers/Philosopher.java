package com.ligres.philosophers;

import java.util.Random;

public class Philosopher implements Runnable {

	private final double STARVATION_INCREACE = 1;
	private String pName;
	private float starvation;
	private boolean isEating;
	private Philosopher leftNeightbout;
	private Philosopher rightNeighbour;
	private Random random;

	public Philosopher(String pName) {
		this.pName = pName;
		starvation = 0;
		isEating = false;
		random = new Random();
	}

	public void SetNeighbours(Philosopher leftNeightbout, Philosopher rightNeighbour) {
		this.leftNeightbout = leftNeightbout;
		this.rightNeighbour = rightNeighbour;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			if (!isEating) {
				if (!leftNeightbout.isEating && !rightNeighbour.isEating) {
					if (starvation >= leftNeightbout.starvation && starvation >= rightNeighbour.starvation) {
						isEating = true;
						starvation = 0;
						try {
							Thread.sleep((long) (10000 * random.nextDouble()));
						} catch (InterruptedException e) {
							Thread.currentThread().interrupt();
							e.printStackTrace();
						}
						isEating = false;
					} else {
						starvation += STARVATION_INCREACE;
					}
				} else {
					starvation += STARVATION_INCREACE;
				}
			}
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}

	public double getStarvation() {
		return starvation;
	}

	public boolean isEating() {
		return isEating;
	}

	public String getPhilosopherName() {
		return pName;
	}

	public Philosopher getLeftNeightbout() {
		return leftNeightbout;
	}

	public Philosopher getRightNeighbour() {
		return rightNeighbour;
	}

}
