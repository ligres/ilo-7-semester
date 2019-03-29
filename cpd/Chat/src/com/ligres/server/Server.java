package com.ligres.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.ligres.client.Client;
import com.ligres.client.User;
import com.ligres.helper.Message;

public class Server extends Thread {
	
	private final int SERVER_PORT = 4442; 
	
	private ArrayList<Client> clients;
	private ServerSocket socket;
	
	public Server()
	{
		try {
			socket = new ServerSocket(SERVER_PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(socket != null && !socket.isClosed())
		{
			try {
				Socket client = socket.accept();
				reciveMessage(client);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean sendMessage(Socket currentSocket, Message message) {
		try {
			OutputStream os = currentSocket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeInt(Client.CLIENT_MESSAGE);
			dos.writeUTF(message.getOwner().getUsername());
			dos.writeUTF(message.getMsg());
			dos.close();
			os.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean reciveMessage(Socket currentSocket) {
		try {
			InputStream is = currentSocket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			if (dis.readInt() == Client.CLIENT_MESSAGE) {
				String username = dis.readUTF();
				String msgString = dis.readUTF();

				for (int i = 0; i < clients.size(); i++) {
					sendMessage(currentSocket, new Message(getUser(username), msgString));
				}
				
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private User getUser(String username)
	{
		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i).getUser().getUsername() == username)
			{
				return clients.get(i).getUser();
			}
		}
		return new User(username);
	}
}
