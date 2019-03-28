package com.ligres.main;

import com.ligres.philosophers.Table;
import com.ligres.ui.MainWindow;

public class Main
{
	public static void main(String[] args)
	{
		Table table = new Table(5);
		new Thread(table).start();
	}
}
