package com.ligres.userinterface;

import java.awt.GridLayout;

import javax.swing.JFrame;

import com.ligres.factory.FactoryManager;

public class MainWindow extends JFrame {
	
	private FactoryManager factoryManager;
	private PieceDisplay[] piecesDisplay;
	
	public MainWindow(FactoryManager factoryManager)
	{
		super("AUDI");
		
		int piecesCount = factoryManager.getPieces().length;
		
		this.setSize(800, 60 * piecesCount);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(piecesCount, 1));
		
		this.factoryManager = factoryManager;
		
		piecesDisplay = new PieceDisplay[factoryManager.getPieces().length];
		for (int i = 0; i < factoryManager.getPieces().length; i++) {
			piecesDisplay[i] = new PieceDisplay(factoryManager.getPieces()[i]);
			this.add(piecesDisplay[i]);
		}
		this.setVisible(true);
	}
	
	public void update()
	{
		for (int i = 0; i < piecesDisplay.length; i++) {
			piecesDisplay[i].update();
		}
	}
}
