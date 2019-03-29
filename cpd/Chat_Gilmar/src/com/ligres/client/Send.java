package com.ligres.client;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class Send{
	
	private ObjectOutputStream output;
	private String username;
	
	public Send(ObjectOutputStream output, String username) {
		this.output = output;
		this.username = username;
	}
	
	public void run(String inPutT) {
			try {
				output.writeUTF(username + ": " + inPutT);
				output.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	public ObjectOutputStream getSend() {
		return this.output;
		
	}
}
