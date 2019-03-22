package com.ligres.userinterface;

import javax.swing.JFrame;

import com.ligres.factory.FactoryManager;

public class MainWindow extends JFrame {
	
	private FactoryManager factoryManager;
	private PieceDisplay[] piecesDisplay;
	
	public MainWindow(FactoryManager factoryManager)
	{
		super("AUDI");
		this.factoryManager = factoryManager;
		piecesDisplay = new PieceDisplay[factoryManager.getPieces().length];
		for (int i = 0; i < factoryManager.getPieces().length; i++) {
			piecesDisplay[i] = new PieceDisplay(factoryManager.getPieces()[i]);
			super.add(piecesDisplay[i]);
		}
		super.setVisible(true);
	}
	
	public void update()
	{
		for (int i = 0; i < piecesDisplay.length; i++) {
			piecesDisplay[i].update();
		}
	}
}
