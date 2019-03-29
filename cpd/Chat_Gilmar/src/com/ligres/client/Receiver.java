package com.ligres.client;


import java.io.IOException;
import java.io.ObjectInputStream;

import com.ligres.userinterface.*;

public class Receiver extends Thread {

	private ObjectInputStream input;
	private MainWindow window;

	public Receiver(ObjectInputStream input, MainWindow window) {
		this.input = input;
		this.window = window;
		start();

	}

	public void run() {
		String inputString = "0";
		while (!inputString.equals("000")) {
			try {
				inputString = input.readUTF();
				window.windowsUpdate(inputString);
				System.out.println("s: " + inputString);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
