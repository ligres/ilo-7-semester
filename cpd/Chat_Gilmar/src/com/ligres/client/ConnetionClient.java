package com.ligres.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.ligres.userinterface.MainWindow;

public class ConnetionClient {

	private int port = 1235;

	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket socket;

	public ConnetionClient(String username) throws UnknownHostException, IOException {
		socket = new Socket("localhost", port);

		output = new ObjectOutputStream(socket.getOutputStream());
		input = new ObjectInputStream(socket.getInputStream());

		MainWindow window = new MainWindow(new Send(output, username));
		new Receiver(input, window);
		window.start();
	}
}
