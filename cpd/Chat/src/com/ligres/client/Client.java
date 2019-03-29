package com.ligres.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.ligres.helper.Message;

public class Client extends Thread {

	public static final int CLIENT_MESSAGE = 0;

	private User user;
	private Socket socket;

	public Client(String username) {
		this.user = new User(username);
		this.socket = null;
	}
	
	@Override
	public void run() {
		while(socket != null || socket.isConnected())
		{
			reciveMessage();
		}
		this.close();
		this.interrupt();
	}

	public boolean connect(String ip, int port) {
		try {
			this.socket = new Socket(ip, port);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean close() {
		if (socket == null) return true;
		try {
			socket.close();
			socket = null;
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean sendMessage(String message) {
		try {
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeInt(CLIENT_MESSAGE);
			dos.writeUTF(user.getUsername());
			dos.writeUTF(message);
			dos.close();
			os.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean reciveMessage() {
		try {
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			if (dis.readInt() == CLIENT_MESSAGE) {
				String username = dis.readUTF();
				String msgString;

				msgString = dis.readUTF();

				Message msg = new Message(getUsername(username), msgString);
				user.addMessage(msg);
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private User getUsername(String username) {
		Message[] msgs = user.getMessages();
		for (int i = 0; i < msgs.length; i++) {
			if (msgs[i].getOwner().getUsername() == username) {
				return msgs[i].getOwner();
			}
		}
		return new User(username);
	}

	public User getUser() {
		return user;
	}
}
