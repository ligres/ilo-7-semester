package com.ligres.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LigresConnection {
	private String dataBase;
	private String host;
	private String user;
	private String password;

	public LigresConnection() {
		this.dataBase = "tp2";
		this.host = "localhost";
		this.user = "root";
		this.password = "35741458";
	}

	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://" + this.host + "/" + this.dataBase;
		return DriverManager.getConnection(url, this.user, this.password);
	}
}
