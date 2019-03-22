package com.ligres.pieces;

public class Car {
	private static final int CAR_REQUERIMENTS[] = { 1, 1, 4, 5, 1 };

	private Car(){}
	public static int getRequirement(PieceType type) {
		return CAR_REQUERIMENTS[type.ordinal()];
	}

}
