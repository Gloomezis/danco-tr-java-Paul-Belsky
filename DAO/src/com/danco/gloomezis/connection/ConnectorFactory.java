package com.danco.gloomezis.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

//alternative version

public class ConnectorFactory {

	// static reference to itself
	private static ConnectorFactory instance = new ConnectorFactory();

	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	// private constructor

	private ConnectorFactory() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private  Connection createConnection() {
		Connection connection = null;
		try {

			DriverManager.registerDriver((Driver) Class.forName(
					"com.mysql.jdbc.Driver").newInstance());
			StringBuilder url = new StringBuilder();

			url.append("jdbc:mysql://").append("localhost:").append("3306/")
					.append("hotel_admin?").append("user=root&")
					.append("password=1111");

			System.out.append("URL:" + url + "\n");

			connection = DriverManager.getConnection(url.toString());
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Connection getConnection() {
		return instance.createConnection();
	}

}
