package com.ligres.connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ligres.data.Data;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;

public class DataDAO {

	public static boolean insert(Data data) throws SQLException {
		try {
			Connection connection = (Connection) new LigresConnection().getConnection();
			PreparedStatement result = (PreparedStatement) connection
					.prepareStatement("insert into data (name,email,phone,password) values (?,?,?,?)");

			result.setString(1, data.getName());
			result.setString(2, data.getemail());
			result.setString(3, data.getNumber());
			result.setString(4, data.getPassword());
			result.executeUpdate();

			connection.close();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public ArrayList<Data> listarTodos() throws SQLException {
		Connection connection = (Connection) new LigresConnection().getConnection();
		ResultSet result = connection.prepareStatement("select * from data order by name").executeQuery();

		ArrayList<Data> array = new ArrayList<Data>();

		Data dt;
		while (result.next()) {
			dt = new Data(result.getString("name"), result.getString("email"), result.getString("phone"),
					result.getString("password"));
			array.add(dt);
		}

		connection.close();
		return array;
	}

}
