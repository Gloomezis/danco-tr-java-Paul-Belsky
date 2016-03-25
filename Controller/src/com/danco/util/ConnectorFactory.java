package com.danco.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.danco.controller.MainController;
import com.danco.properties.PropertyManager;

//alternative version

public class ConnectorFactory {
	
	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";
	
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(MainController.class
			.getName());
	
	

	// static reference to itself
	private static ConnectorFactory instance = new ConnectorFactory();

	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	// private constructor

	private ConnectorFactory() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			LOG1.error(EXCEPTION, e);
		}
	}

	private  Connection createConnection() {
		Connection connection = null;
		try {

			DriverManager.registerDriver((Driver) Class.forName(
					PropertyManager.getInstance().getJDBCDriver()
				//	"com.mysql.jdbc.Driver"
					).newInstance());
			
			/*
			StringBuilder url = new StringBuilder();

			url.append("jdbc:mysql://").
			append("localhost:").
			append("3306/").
			append("hotel_admin?").
			append("user=root&").
			append("password=1111");
			System.out.append("URL:" + url + "\n");
			*/
			
            String url = PropertyManager.getInstance().getJDBCSettings();
			connection = DriverManager.getConnection(url);
			return connection;
		} catch (SQLException e) {
			LOG1.error(EXCEPTION, e);
		} catch (InstantiationException e) {
			LOG1.error(EXCEPTION, e);
		} catch (IllegalAccessException e) {
			LOG1.error(EXCEPTION, e);
		} catch (ClassNotFoundException e) {
			LOG1.error(EXCEPTION, e);
		}

		return null;
	}

	public static Connection getConnection() {
		return instance.createConnection();
	}

}
