package com.ligres.factory;

import com.ligres.pieces.Car;
import com.ligres.pieces.Piece;
import com.ligres.pieces.PieceType;
import com.ligres.threads.PieceMaker;

public class FactoryManager extends Thread {
	private PieceMaker[] pieces;

	public FactoryManager() {
		this.pieces = new PieceMaker[PieceType.values().length];

		Piece pieceMotor = new Piece(PieceType.MOTOR, 10, 12000);
		Piece pieceCarroceria = new Piece(PieceType.CARROCERIA, 20, 15000);
		Piece piecePneu = new Piece(PieceType.PNEU, 100, 9000);
		Piece pieceBanco = new Piece(PieceType.BANCO, 25, 6000);
		Piece pieceEletronica = new Piece(PieceType.ELETRONICA, 8, 7000);

		PieceMaker makerMotor = new PieceMaker(pieceMotor);
		PieceMaker makerCarroceria = new PieceMaker(pieceCarroceria);
		PieceMaker makerPneu = new PieceMaker(piecePneu);
		PieceMaker makerBanco = new PieceMaker(pieceBanco);
		PieceMaker makerEletronica = new PieceMaker(pieceEletronica);

		this.pieces[0] = makerMotor;
		this.pieces[1] = makerCarroceria;
		this.pieces[2] = makerPneu;
		this.pieces[3] = makerBanco;
		this.pieces[4] = makerEletronica;
	}

	public void startFactory() {
		start();
		for (int i = 0; i < pieces.length; i++) {
			pieces[i].start();
		}
	}

	@Override
	public void run() {
		while (true) {
			boolean isCarReadyToBuild = true;
			for (int i = 0; i < pieces.length; i++) {
				if (pieces[i].getReadyProducts() < Car.getRequirement(pieces[i].getPiece().getProductName())) {
					isCarReadyToBuild = false;
				}
			}
			if (isCarReadyToBuild) {
				System.out.println("One car has been made!");
				for (int i = 0; i < pieces.length; i++) {
					synchronized (pieces[i]) {
						int needed = Car.getRequirement(pieces[i].getPiece().getProductName());
						pieces[i].setReadyProducts(pieces[i].getReadyProducts() - needed);
						if (pieces[i].isWaiting()) {
							pieces[i].notify();
						}
					}

				}
			}
		}
	}

	public synchronized void notifyPieces() {
		for (int i = 0; i < pieces.length; i++) {
		}
	}

	public PieceMaker[] getPieces() {
		return pieces;
	}
}
