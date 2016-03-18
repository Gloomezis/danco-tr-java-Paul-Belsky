package com.danco.gloomezis.dao;

import java.sql.SQLException;

import com.danco.gloomezis.dataSet.GuestDataSet;

public interface IGuestDAO {
	GuestDataSet get(int id) throws SQLException;
	
	GuestDataSet getByName(String name) throws SQLException;
	
	void add(GuestDataSet dataSet) throws SQLException;
	
	void delete(int id) throws SQLException;
	
	void update (int id) throws SQLException;
	

}
