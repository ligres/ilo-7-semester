package com.ligres.server;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class Send {

	private ObjectOutputStream output;
	private User user;

	public Send(ObjectOutputStream outPut) {
		this.output = outPut;

	}

	public void send(String inPutT) {
		try {
			output.writeUTF(inPutT);
			output.flush();
		} catch (IOException e) {
			user.getUserTools().remove(user);
			try {
				user.stopConexao();
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			user.getUserTools().remove(user);
			user.getReceiver().interrupt();
		}
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}
