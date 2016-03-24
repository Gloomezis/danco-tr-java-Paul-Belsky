package com.danco.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionUtil {
	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";
	
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ConnectionUtil.class
			.getName());
	
	
	
	
private static ConnectionUtil instance;

	/**
	 * Instantiates a new main storage.
	 */
	private ConnectionUtil() {

	}

	/**
	 * Gets the single instance of MainStorage.
	 *
	 * @return single instance of MainStorage
	 */
	public static ConnectionUtil getInstance() {
		if (instance == null) {
			instance = new ConnectionUtil();
		}
		return instance;
	}

	
	
	
	public Connection getConnection()  {
		 Connection con= null;
		 try{
        con =  ConnectorFactory.getConnection();
		 }catch(Exception e){
			 LOG1.error(EXCEPTION, e);
		 }
        return con;
    } 
	

	public void beginTransaction(Connection con)  {
		try {
			 con.setAutoCommit(false);
		} catch (SQLException e) {
			LOG1.error(EXCEPTION, e);
		}
	}
	
	public void endTransaction(Connection con)  {
		try {
			 if (con.getAutoCommit()==false) {
				 con.setAutoCommit(true);
			}
			
		} catch (SQLException e) {
			LOG1.error(EXCEPTION, e);
		}
	}

	public void commitTransaction(Connection con)  {
		try {
			con.commit();
		} catch (SQLException e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			endTransaction(con);
			closeConnection(con);
		}
	}

	public void rollbackTransaction(Connection con)  {
		try {
			con.rollback();
		} catch (SQLException e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			closeConnection(con);
		}
	}

	public void closeConnection(Connection con)  {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
				
			}
		} catch (SQLException e) {
			LOG1.error(EXCEPTION, e);
		}
	}
}
