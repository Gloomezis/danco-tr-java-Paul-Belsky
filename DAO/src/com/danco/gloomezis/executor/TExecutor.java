package com.danco.gloomezis.executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Map;


import com.danco.gloomezis.hadleer.TResultHandler;


public class TExecutor {
	// Inserts,Deletes & Updates
	public static int execUpdate(Connection connection, String update) {
		try {
			Statement stmt = connection.createStatement();
			stmt.execute(update);
			int updated = stmt.getUpdateCount();
			stmt.close();
			return updated;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	};

	// необязательный код multiQuery
	public void execUpdate(Connection connection, String[] updates) {
		try {
			connection.setAutoCommit(false);
			for (String update : updates) {
				Statement stmt = connection.createStatement();
				stmt.execute(update);
				stmt.close();
			}
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
				connection.setAutoCommit(true); //insert in finally block
			} catch (SQLException ignore) {}
			}

		} 
			
		
// prepared statements need adding transacion
	public void execUpdate(Connection connection, Map<Integer,String> idToName){
		try{
			String update ="insert into guest(id, name) values(?,?)";
			PreparedStatement stmt =  connection.prepareStatement(update);
			for(Integer id: idToName.keySet()){
				stmt.setInt(1, id);
				stmt.setString(2, idToName.get(id));
				stmt.executeUpdate();
			}
			stmt.close();
		
			}catch(SQLException e){
				e.printStackTrace();
		}
	}
	
	

	/*
	 * вызов обрабоnчика с анонимкой  execQuery 
	 * TExecutor execT= new TExecutor();
	 * String query="select name from users where id=1";
	 * 
	 * String name=execT.execQuery(connection , query, new TResultHandler<String>()){ 
	 * public String handle(ResultSet result) throws SQLException{
	 * 
	 * result.next();  
	 * return result.getString("name");
	 * }
	 * } );
	 */

	public <T> T execQuery(Connection connection, String query,
			TResultHandler <T> handler)  {
		try {
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			ResultSet result = stmt.getResultSet();
			T value = handler.handle(result);
			result.close();
			stmt.close();
			return value;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
