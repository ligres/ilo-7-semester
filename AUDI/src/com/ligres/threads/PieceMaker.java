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
		while(true) {
			if (readyProducts < piece.getStock())
			{
				isWaiting = false;
				startToWaitTime = -1;
				try {
					Thread.sleep(piece.getTimeToBuild());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				readyProducts++;
				System.out.println("Thread: " + piece.getProductName() + " has made 1 piece to a total of " + readyProducts + "/" + piece.getStock() + ".");
			}
			else
			{
				try {
					System.out.println("Thread: " + piece.getProductName() + " is waiting. Stock is full.");
					startToWaitTime = System.currentTimeMillis();
					isWaiting = true;
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
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

	public long getProgress()
	{
		if (isWaiting) {
			return 1;
		}
		long curTime = System.currentTimeMillis() - startToWaitTime;
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
