package com.danco.gloomezis.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.danco.gloomezis.dataSet.IDataSet;
import com.danco.gloomezis.dataSet.ServiceDataSet;

public class ServiceDAO implements IDAO<ServiceDataSet>{

	private Connection con;
	

	public ServiceDAO(Connection con) {
		this.con = con;
	}

	

	@Override
	public int create(IDataSet dataSet) throws SQLException {
		return 0;
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public ServiceDataSet read(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceDataSet readByName(String name) throws SQLException {
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
	public List<ServiceDataSet> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	
	
}
