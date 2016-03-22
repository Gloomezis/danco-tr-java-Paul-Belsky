package com.danco.gloomezis.dao;

import java.sql.SQLException;
import java.util.List;

import com.danco.gloomezis.dataSet.IBaseModel;

public interface IDAO<T> {
	
	public int create(IBaseModel baseModel) throws SQLException;
	
	public IBaseModel read(int id) throws SQLException;
	
	public IBaseModel readByName(String name) throws SQLException;
	
	public int update (int id,IBaseModel dataSet) throws SQLException;
	
	public int delete(int id) throws SQLException;
	
	public List<T>  getAll() throws SQLException;
	
	
	

	

}
