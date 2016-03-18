package com.danco.gloomezis.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.danco.gloomezis.dataSet.HotelRoomDataSet;
import com.danco.gloomezis.dataSet.IDataSet;

public class HotelRoomDAO implements IDAO<HotelRoomDataSet>{

	private Connection con;

	public HotelRoomDAO(Connection con) {
		this.con = con;
	}



	@Override
	public int create(IDataSet dataSet) throws SQLException {
		return 0;
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public HotelRoomDataSet read(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelRoomDataSet readByName(String name) throws SQLException {
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
	public List<HotelRoomDataSet> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	
	
	
}
