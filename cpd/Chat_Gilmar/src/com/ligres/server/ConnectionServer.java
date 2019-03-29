package com.ligres.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ConnectionServer {

	private int port = 1235;

	ServerSocket socket;
	Socket conexao;
	ObjectOutputStream saida;
	ObjectInputStream entrada;
	
	ArrayList<User> users = new ArrayList<User>();

	public ConnectionServer() throws IOException { 
		socket = new ServerSocket(port);

		System.out.println("Aguardando Cliente ...");
		while(true) {
			conexao = socket.accept();

			saida = new ObjectOutputStream(conexao.getOutputStream());
			entrada = new ObjectInputStream(conexao.getInputStream());
			
			users.add(new User(new Send(saida), new Receiver(entrada), users,conexao));
		}
	}

}
