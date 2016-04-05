package com.danco.gloomezis.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.danco.model.IBaseModel;

public interface IDAO<T> {
	
	public int create(Connection con,IBaseModel baseModel) throws SQLException;
	
	public IBaseModel read(Connection con, int id) throws SQLException;
	
	public IBaseModel readByName(Connection con,String name) throws SQLException;
	
	public int update (Connection con,int id,IBaseModel dataSet) throws SQLException;
	
	public int delete(Connection con,int id) throws SQLException;
	
	public List<T>  getAll(Connection con) throws SQLException;
	
	
	

	

}
