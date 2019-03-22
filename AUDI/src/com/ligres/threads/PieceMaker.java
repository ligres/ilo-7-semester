package com.ligres.threads;

import com.ligres.pieces.Piece;

public class PieceMaker extends Thread {
	private int readyProducts;
	private Piece piece;
	private long startToWaitTime;
	private boolean isWaiting;

	public PieceMaker(Piece piece) {
		this.piece = piece;
		this.startToWaitTime = -1;
		this.isWaiting = false;
	}

	@Override
	public void run() {
		while (true) {
			if (readyProducts < piece.getStock()) {
				isWaiting = false;
				try {
					startToWaitTime = System.currentTimeMillis();
					Thread.sleep(piece.getTimeToBuild());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				readyProducts++;
				System.out.println("One " + piece.getProductName() + " has been made to a total of " + readyProducts
						+ "/" + piece.getStock() + ".");
			} else {
				synchronized (this) {
					try {
						System.out.println("The stock of " + piece.getProductName() + " is full. Production stopped.");
						isWaiting = true;
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public int getReadyProducts() {
		return readyProducts;
	}

	public Piece getPiece() {
		return piece;
	}

	public float getProgress() {
		if (isWaiting) {
			return 1;
		}
		float curTime = System.currentTimeMillis() - startToWaitTime;
		curTime = curTime / piece.getTimeToBuild();
		return curTime;
	}

	public boolean isWaiting() {
		return isWaiting;
	}

	public void setReadyProducts(int readyProducts) {
		this.readyProducts = readyProducts;
	}
}
