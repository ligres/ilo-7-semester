package com.ligres.userinterface;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import com.ligres.threads.PieceMaker;

public class PieceDisplay extends JPanel{

	private static final long serialVersionUID = -8424980173401607990L;
	
	private PieceMaker piece;
	private JLabel name;
	private JLabel currentStock;
	private JLabel maximumStock;
	private JProgressBar progress;
	
	public PieceDisplay(PieceMaker piece)
	{
		super();
		
		this.piece = piece;
		
		JPanel namePanel = new JPanel(new GridLayout(1, 1));
		this.name = new JLabel(piece.getPiece().getProductName().toString());
		namePanel.add(name);
		
		JPanel stockInfoPanel = new JPanel(new GridLayout(1, 3));
		this.currentStock = new JLabel("0");
		this.currentStock.setAlignmentX(RIGHT_ALIGNMENT);
		this.maximumStock = new JLabel(piece.getPiece().getStock() + "");
		this.maximumStock.setAlignmentX(LEFT_ALIGNMENT);
		stockInfoPanel.add(currentStock);
		stockInfoPanel.add(new JLabel("/"));
		stockInfoPanel.add(maximumStock);
		
		JPanel progressLayout = new JPanel(new GridLayout(1, 1)); 
		this.progress = new JProgressBar(0, 100);
		this.progress.setValue(0);
		this.progress.setStringPainted(true);
		progressLayout.add(progress);
		
		this.setLayout(new GridLayout(1, 3));
		this.add(namePanel);
		this.add(stockInfoPanel);
		this.add(progressLayout);
	}
	
	public void update()
	{
		currentStock.setText(piece.getReadyProducts() + "");
		maximumStock.setText(piece.getPiece().getStock() + "");
		progress.setValue((int)(piece.getProgress() * 100));
		this.revalidate();
	}
}
