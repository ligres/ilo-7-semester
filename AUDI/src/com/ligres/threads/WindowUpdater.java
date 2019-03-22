package com.ligres.threads;

import com.ligres.userinterface.MainWindow;

public class WindowUpdater extends Thread {
	
	private MainWindow mainWindow;

	public WindowUpdater(MainWindow mainWindow) {
		super();
		this.mainWindow = mainWindow;
	}
	
	@Override
	public void run() {
		mainWindow.update();
	}
}
