package com.danco.dao.api;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.danco.model.HotelRoom;
import com.danco.model.IBaseModel;

public interface IHotelRoomDAO {

	// +
	public int create(Connection con, IBaseModel baseModel) throws SQLException;

	// +
	public HotelRoom read(Connection con, int id) throws SQLException;

	// +
	public HotelRoom readByName(Connection con, String number)
			throws SQLException;

	// TODO
	public int update(Connection con, int id, IBaseModel baseModel)
			throws SQLException;

	// +
	public int delete(Connection con, int id) throws SQLException;

	// +
	public List<HotelRoom> getAll(Connection con) throws SQLException;

	// +
	public List<HotelRoom> getAllSorted(Connection con, String sortCondition)
			throws SQLException;

	// +
	public List<HotelRoom> getAllFreeSorted(Connection con, String sortCondition)
			throws SQLException;

	// +
	public int getNumberFreeHotelRooms(Connection con) throws SQLException;

	// +TODO написать обработчик сортировки
	// write to select last of hotel room oorder
	public List<HotelRoom> getFreeHotelRoomsAfterDate(Connection con,
			String sortCondition, Date date) throws SQLException;

	// + update only price
	public int updatePrice(Connection con, int id, int rPrice)
			throws SQLException;

	// + update only status
	public int updateStatus(Connection con, int id, boolean status)
			throws SQLException;

	//составное с ценой номеров - возможно можно заменить на обычный достать все хотелрумы 
	// + get price all service order by price
	public List<String> getPriceHotelRoom(Connection con) throws SQLException;
	
	public Boolean getStatus(Connection con,String number) throws SQLException;


}