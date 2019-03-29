package com.ligres.server;

import java.io.IOException;
import java.io.ObjectInputStream;

public class Receiver extends Thread {

	private ObjectInputStream input;
	private User user;

	public Receiver(ObjectInputStream inPut) {
		this.input = inPut;

		start();
	}

	public void run() {
		String inputString;
		while (true) {
			try {
				inputString = input.readUTF();
				System.out.println("c: " + inputString);
				sendToAll(inputString);
			} catch (IOException e) {
				user.getUserTools().remove(user);
				try {
					user.stopConexao();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				this.interrupt();
			}
		}
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void sendToAll(String str) {
		for (User user : this.user.getUserTools()) {

			user.getSend().send(str);

		}
	}
}
