package com.ligres.factory;

import com.ligres.pieces.Car;
import com.ligres.pieces.Piece;
import com.ligres.pieces.PieceType;
import com.ligres.threads.PieceMaker;

public class FactoryManager extends Thread{
	private PieceMaker[] pieceMaker;
	
	public FactoryManager() {
		this.pieceMaker = new PieceMaker[PieceType.values().length];

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

		this.pieceMaker[0] = makerMotor;
		this.pieceMaker[1] = makerCarroceria;
		this.pieceMaker[2] = makerPneu;
		this.pieceMaker[3] = makerBanco;
		this.pieceMaker[4] = makerEletronica;
	}

	public void startFactory() {
		start();
		for (int i = 0; i < pieceMaker.length; i++) {
			pieceMaker[i].start();
		}
	}
	
	@Override
	public void run() {
		while (true) {
			boolean isCarReadyToBuild = true;
			for (int i = 0; i < pieceMaker.length; i++) {
				if (pieceMaker[i].getReadyProducts() < Car.getRequirement(pieceMaker[i].getPiece().getProductName())) {
					isCarReadyToBuild = false;
				}
			}
			if (isCarReadyToBuild)
			{
				for (int i = 0; i < pieceMaker.length; i++) {
					pieceMaker[i].setReadyProducts(Car.getRequirement(pieceMaker[i].getPiece().getProductName()));
				}
			}
			for (int i = 0; i < pieceMaker.length; i++) {
				pieceMaker[i].notify();
			}
		}
	}

	public PieceMaker[] getPieces() {
		return null;
	}
}
