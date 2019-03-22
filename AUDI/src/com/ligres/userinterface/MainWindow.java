package com.ligres.userinterface;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.ligres.factory.FactoryManager;

public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = -6280311789470040983L;
	private PieceDisplay[] piecesDisplay;
	private JLabel carLabel;
	private JLabel currentCarStockLabel;
	private JLabel maximumCarStockLabel;
	private JProgressBar progress;
	private FactoryManager factoryManager;
	
	public MainWindow(FactoryManager factoryManager)
	{
		super("AUDI");
		
		this.factoryManager = factoryManager;
		
		int piecesCount = factoryManager.getPieces().length;
		
		this.setSize(800, 60 * (piecesCount + 1));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(piecesCount + 1, 1));
		
		piecesDisplay = new PieceDisplay[factoryManager.getPieces().length];
		for (int i = 0; i < factoryManager.getPieces().length; i++) {
			piecesDisplay[i] = new PieceDisplay(factoryManager.getPieces()[i]);
			this.add(piecesDisplay[i]);
		}
		
		JPanel namePanel = new JPanel(new GridLayout(1, 1));
		carLabel = new JLabel("CARRO");
		namePanel.add(carLabel);
		
		JPanel stockInfoPanel = new JPanel(new GridLayout(1, 3));
		this.currentCarStockLabel = new JLabel("0");
		this.currentCarStockLabel.setAlignmentX(RIGHT_ALIGNMENT);
		this.maximumCarStockLabel = new JLabel(FactoryManager.MAX_CAR_STOCK + "");
		this.maximumCarStockLabel.setAlignmentX(LEFT_ALIGNMENT);
		stockInfoPanel.add(currentCarStockLabel);
		stockInfoPanel.add(new JLabel("/"));
		stockInfoPanel.add(maximumCarStockLabel);
		
		JPanel progressLayout = new JPanel(new GridLayout(1, 1)); 
		this.progress = new JProgressBar(0, 100);
		this.progress.setValue(0);
		this.progress.setStringPainted(true);
		progressLayout.add(progress);
		
		JPanel carPanel = new JPanel(new GridLayout(1, 3));
		carPanel.add(namePanel);
		carPanel.add(stockInfoPanel);
		carPanel.add(progressLayout);
		this.add(carPanel);
		
		this.setVisible(true);
	}
	
	public void update()
	{
		for (int i = 0; i < piecesDisplay.length; i++) {
			piecesDisplay[i].update();
		}
		currentCarStockLabel.setText(factoryManager.getCardDone() + "");
		progress.setValue((int)(factoryManager.getCarProgress() * 100));
		this.revalidate();
	}
}
