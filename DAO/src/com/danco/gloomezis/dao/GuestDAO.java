package com.danco.gloomezis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.danco.gloomezis.dataSet.GuestDataSet;
import com.danco.gloomezis.dataSet.IDataSet;
import com.danco.gloomezis.executor.TExecutor;
import com.danco.gloomezis.hadleer.TResultHandler;

public class GuestDAO implements IDAO<GuestDataSet>{

	private Connection con;

	public GuestDAO(Connection con) {
		this.con = con;
	}

	@Override
	public int create(IDataSet dataSet) throws SQLException {
		TExecutor exec = new TExecutor();
		String name = ((GuestDataSet) dataSet).getName();
		//String sql = "INSERT INTO guest (name) values ("+name+");"; need prepared statement
		return exec.execUpdate(con, "INSERT INTO guest (name) values ("+name+");");	

	}

	@Override
	public GuestDataSet read(int id) throws SQLException {
		TExecutor exec = new TExecutor();
		String sql = "SELECT * FROM guest WHERE id ="; 
		return exec.execQuery(con, sql + id+ ";",   // need prepared statement	
				new TResultHandler<GuestDataSet>() {

					@Override
					public GuestDataSet handle(ResultSet result)
							throws SQLException {
						result.next();
						GuestDataSet dataSet = new GuestDataSet(result
								.getInt(1), result.getString(2));
						return dataSet;
					}
				}
		);
	};

	@Override
	public GuestDataSet readByName(String name) throws SQLException {
		TExecutor exec = new TExecutor();
		String sql ="SELECT * FROM guest WHERE name =";
		return exec.execQuery(con, sql + name+";",    // need prepared statement	
				new TResultHandler<GuestDataSet>() {

					@Override
					public GuestDataSet handle(ResultSet result)
							throws SQLException {
						result.next();
						GuestDataSet dataSet = new GuestDataSet(result
								.getInt(1), result.getString(2));
						return dataSet;
					}
				}
		);
	}

	@Override
	public int delete(int id) throws SQLException {
		TExecutor exec = new TExecutor();
		String sql="DELETE * FROM guest WHERE id =";
		return exec.execUpdate(con, sql + id+";");		// need prepared statement			
	}

	@Override
	public int update(int id,IDataSet dataSet) throws SQLException {
		TExecutor exec = new TExecutor();
		String name = ((GuestDataSet) dataSet).getName();
		//String sql="UPDATE  guest SET name="+name+"where id="+id; need prepared statement
		return exec.execUpdate(con, "UPDATE  guest SET name="+name+"where id="+id+";");		
	}
	
	@Override
	public List<GuestDataSet> getAll() {
		

		String sql = "SELECT * FROM Guest;";
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql,
				new TResultHandler<List<GuestDataSet>>() {

					@Override
					public List<GuestDataSet> handle(ResultSet result)
							throws SQLException {
						List<GuestDataSet> list = new ArrayList<GuestDataSet>();
						while (result.next()) {
							GuestDataSet g = new GuestDataSet(result
									.getInt("id"), result.getString("name"));
							list.add(g);
						}
						return list;
					}
				}
		);

	}

}
