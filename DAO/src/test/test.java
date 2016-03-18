package test;

import java.sql.Connection;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.danco.gloomezis.connection.ConnectorFactory;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Connection connection =ConnectorFactory.getConnection();	
    try {
		Statement stmt = connection.createStatement();
	
    ResultSet rset;
    rset=stmt.executeQuery("SELECT * from guest");
    while(rset.next()){
    	String name =rset.getString("name");
    	System.out.println("NAME: "+name);
    }
    rset.close();
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	}

}
