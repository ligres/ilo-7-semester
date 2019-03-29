package com.ligres.connection;

import java.io.*;
import java.net.*;

public class ConnectionServe {

	private int serverDoor = 1234;
	private ServerSocket socket;
	private Socket connection;
	private ObjectOutputStream output;
	private ObjectInputStream input;

	public ConnectionServe() throws Exception {

		socket = new ServerSocket(serverDoor);

		System.out.println("Aguardando Cliente ...");

		while (true) {
			connection = socket.accept();
			output = new ObjectOutputStream(connection.getOutputStream());
			input = new ObjectInputStream(connection.getInputStream());
			new Process(input, output).start();
		}
	}
}