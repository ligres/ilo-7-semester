package com.ligres.userinterface;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ligres.threads.PieceMaker;

public class PieceDisplay extends JPanel{

	private static final long serialVersionUID = -8424980173401607990L;
	
	private PieceMaker piece;
	private JTextField currentStock;
	private JTextField maximumStock;
	private JProgressBar progress;
	
	public PieceDisplay(PieceMaker piece)
	{
		super();
		this.piece = piece;
		this.currentStock = new JTextField("0");
		this.maximumStock = new JTextField(piece.getPiece().getStock() + "");
		this.progress = new JProgressBar(SwingConstants.HORIZONTAL);
		
		super.setLayout(new GridLayout(1, 4));
		
		super.add(currentStock);
		super.add(new JTextField("/"));
		super.add(maximumStock);
		super.add(progress);
	}
	
	public void update()
	{
		currentStock.setText(piece.getReadyProducts() + "");
		maximumStock.setText(piece.getPiece().getStock() + "");
		progress.setValue((int)(piece.getProgress() * 100));
	}
}
