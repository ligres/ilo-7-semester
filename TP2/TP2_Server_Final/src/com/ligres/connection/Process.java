package com.ligres.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;

import com.ligres.data.Data;

public class Process extends Thread {
	private ObjectInputStream input;
	private ObjectOutputStream output;

	public Process(ObjectInputStream input, ObjectOutputStream output) {
		this.input = input;
		this.output = output;
	}

	public void run() {
		try {
			devolverResp(DataDAO.insert(reciveData()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Data reciveData() throws IOException {
		return new Data(input.readUTF(), input.readUTF(), input.readUTF(), input.readUTF());
	}

	public void devolverResp(boolean control) throws IOException {
		output.writeBoolean(control);
		output.flush();
	}

}
