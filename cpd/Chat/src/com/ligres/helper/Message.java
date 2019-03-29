package com.ligres.helper;

import com.ligres.client.User;

public class Message
{
	private User owner;
	private String msg;
	
	public Message(User owner, String msg) {
		super();
		this.owner = owner;
		this.msg = msg;
	}

	public User getOwner() {
		return owner;
	}

	public String getMsg() {
		return msg;
	}
}
