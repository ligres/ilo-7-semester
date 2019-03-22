package com.ligres.main;

import com.ligres.factory.FactoryManager;
import com.ligres.threads.WindowUpdater;
import com.ligres.userinterface.MainWindow;

public class FrodoMain {

	public static void main(String[] args) {
		FactoryManager fm = new FactoryManager();
		fm.startFactory();
		MainWindow mw = new MainWindow(fm);
		WindowUpdater windowUpdater = new WindowUpdater(mw);
		windowUpdater.start();
	}

}
