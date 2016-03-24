package com.danco.dao.api;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.danco.model.Guest;
import com.danco.model.IBaseModel;
import com.danco.model.Service;

public interface IGuestDAO {

	
	public int create(Connection con, IBaseModel baseModel) throws SQLException;

	
	public Guest read(Connection con, int id) throws SQLException;

	
	public Guest readByName(Connection con, String name) throws SQLException;

	
	public int update(Connection con, int id, IBaseModel baseModel)
			throws SQLException;

	
	public int delete(Connection con, int id) throws SQLException;

	public List<Guest> getAll(Connection con);
	
	public List<Guest> getAllSorted(Connection con,String sortCondition);

	
	public int getAllGuestNumber(Connection con) throws SQLException;

	public List<String> getNameGuestsAndTheyHotelRoom(Connection con,
			String sortCondition);

	public List<Service> getGuestService(Connection con, String name);

}