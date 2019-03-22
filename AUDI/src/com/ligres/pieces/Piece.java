package com.ligres.pieces;

public class Piece {

	private PieceType product;
	private int stock;
	private long timeToBuild;
	
	public Piece(PieceType product, int stock, int timeToBuild) {
		this.product = product;
		this.stock = stock;
		this.timeToBuild = timeToBuild;
	}
	
	public long getTimeToBuild() {
		return timeToBuild;
	}

	public PieceType getProductName() {
		return product;
	}
	
	public int getStock() {
		return stock;
	}
}