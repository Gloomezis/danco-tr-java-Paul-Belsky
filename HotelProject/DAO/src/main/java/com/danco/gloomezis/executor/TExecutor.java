/*
 * 
 */
package com.danco.gloomezis.executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.danco.gloomezis.hadleer.TResultHandler;

public class TExecutor {

	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(TExecutor.class.getName());

	// Inserts,Deletes & Updates
	public int execUpdate(Connection connection, String update)
			throws SQLException {
		try {
			Statement stmt = connection.createStatement();
			stmt.execute(update);
			int updated = stmt.getUpdateCount();
			stmt.close();
			return updated;
		} catch (SQLException e) {
			LOG1.error(EXCEPTION, e);
			throw e;
		}

	};

	/*
	 * вызов обрабоnчика с анонимкой execQuery TExecutor execT= new TExecutor();
	 * String query="select name from users where id=1";
	 * 
	 * String name=execT.execQuery(connection , query, new
	 * TResultHandler<String>()){ public String handle(ResultSet result) throws
	 * SQLException{
	 * 
	 * result.next(); return result.getString("name"); } } );
	 */

	public <T> T execQuery(Connection connection, String query,
			TResultHandler<T> handler) throws SQLException {
		try {
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			ResultSet result = stmt.getResultSet();
			T value = handler.handle(result);
			result.close();
			stmt.close();
			return value;
		} catch (SQLException e) {
			LOG1.error(EXCEPTION, e);
			throw e;
		}
	}
}
