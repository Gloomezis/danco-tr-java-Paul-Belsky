package com.danco.gloomezis.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.danco.gloomezis.dataSet.GuestToServiceDataSet;
import com.danco.gloomezis.dataSet.IDataSet;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestToServiceDAO.
 */
public class GuestToServiceDAO implements IDAO<GuestToServiceDAO>{

	private Connection con;

	public GuestToServiceDAO(Connection con) {
		this.con = con;
	}



	@Override
	public int create(IDataSet dataSet) throws SQLException {
		return 0;
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public GuestToServiceDataSet read(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GuestToServiceDataSet readByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public int update(int id,IDataSet dataSet) throws SQLException {
		return id;
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int delete(int id) throws SQLException {
		return id;
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<GuestToServiceDAO> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	
}
