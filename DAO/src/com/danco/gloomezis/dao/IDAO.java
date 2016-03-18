package com.danco.gloomezis.dao;

import java.sql.SQLException;
import java.util.List;

import com.danco.gloomezis.dataSet.IDataSet;

public interface IDAO<T> {
	
	public int create(IDataSet dataSet) throws SQLException;
	
	public IDataSet read(int id) throws SQLException;
	
	public IDataSet readByName(String name) throws SQLException;
	
	public int update (int id,IDataSet dataSet) throws SQLException;
	
	public int delete(int id) throws SQLException;
	
	public List<T>  getAll() throws SQLException;
	
	
	

	

}
