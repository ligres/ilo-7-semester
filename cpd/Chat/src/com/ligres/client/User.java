package com.ligres.client;

import java.util.ArrayList;

import com.ligres.helper.Message;

public class User
{
	
	private String username;
	private ArrayList<Message> messages;
	
	public User(String username) {
		this.username = username;
		this.messages = new ArrayList<Message>();
	}

	public String getUsername() {
		return username;
	}

	public Message[] getMessages() {
		return (Message[]) messages.toArray();
	}

	public void addMessage(Message message)
	{
		messages.add(message);
	}
}
