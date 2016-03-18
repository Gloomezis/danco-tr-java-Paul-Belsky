package com.danco.gloomezis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.danco.gloomezis.dataSet.GuestDataSet;
import com.danco.gloomezis.executor.TExecutor;
import com.danco.gloomezis.hadleer.TResultHandler;

public class GuestDAO implements IGuestDAO {

	private Connection con;

	public GuestDAO(Connection con) {
		this.con = con;
	}

	@Override
	public GuestDataSet get(int id) throws SQLException {
		TExecutor exec = new TExecutor();
		return exec.execQuery(con, "select * from guest where id =" + id,
				new TResultHandler<GuestDataSet>() {

					@Override
					public GuestDataSet handle(ResultSet result)
							throws SQLException {
						result.next();
						GuestDataSet dataSet = new GuestDataSet(result.getInt(1), result.getString(2));
						return dataSet;
					}
				});
	}

	@Override
	public GuestDataSet getByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(GuestDataSet dataSet) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

}
