package com.danco.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.danco.dao.api.IHotelRoomDAO;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.HotelRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomController.
 */
public class HotelRoomController {

	/** The service service. */
	private IHotelRoomDAO hotelRoomDAO = (IHotelRoomDAO) DependencyInjectionManager
			.getClassInstance(IHotelRoomDAO.class);

	/**
	 * Creates the.
	 *
	 * @param con the con
	 * @param hotelRoom the hotel room
	 * @return the int
	 * @throws SQLException the SQL exception
	 */
	public int create(Connection con, HotelRoom hotelRoom) throws SQLException {
		return hotelRoomDAO.create(con, hotelRoom);
	}

	/**
	 * Gets the all sorted.
	 *
	 * @param con the con
	 * @param userInputSortCondition the user input sort condition
	 * @return the all sorted
	 * @throws SQLException the SQL exception
	 */
	public List<HotelRoom> getAllSorted(Connection con,
			String userInputSortCondition) throws SQLException {

		return hotelRoomDAO.getAllSorted(con, userInputSortCondition);

	}

	/**
	 * Gets the all free sorted.
	 *
	 * @param con the con
	 * @param userInputSortCondition the user input sort condition
	 * @return the all free sorted
	 * @throws SQLException the SQL exception
	 */
	public List<HotelRoom> getAllFreeSorted(Connection con,
			String userInputSortCondition) throws SQLException {

		return hotelRoomDAO.getAllFreeSorted(con, userInputSortCondition);

	}

	/**
	 * Gets the free hotel rooms after date.
	 *
	 * @param con the con
	 * @param userInputSortCondition the user input sort condition
	 * @param date the date
	 * @return the free hotel rooms after date
	 * @throws SQLException the SQL exception
	 */
	public List<HotelRoom> getFreeHotelRoomsAfterDate(Connection con,
			String userInputSortCondition, Date date) throws SQLException {

		return hotelRoomDAO.getFreeHotelRoomsAfterDate(con,
				userInputSortCondition, date);

	}

	/**
	 * Gets the number free hotel rooms.
	 *
	 * @param con the con
	 * @return the number free hotel rooms
	 * @throws SQLException the SQL exception
	 */
	public int getNumberFreeHotelRooms(Connection con) throws SQLException {

		return hotelRoomDAO.getNumberFreeHotelRooms(con);

	}

	/**
	 * Read by name.
	 *
	 * @param con the con
	 * @param userInputHotelRoomNumber the user input hotel room number
	 * @return the hotel room
	 * @throws SQLException the SQL exception
	 */
	public HotelRoom readByName(Connection con, String userInputHotelRoomNumber)
			throws SQLException {

		return hotelRoomDAO.readByName(con, userInputHotelRoomNumber);

	}

	/**
	 * Gets the status.
	 *
	 * @param con the con
	 * @param userInputHotelRoomName the user input hotel room name
	 * @return the status
	 * @throws SQLException the SQL exception
	 */
	public Boolean getStatus(Connection con, String userInputHotelRoomName)
			throws SQLException {
		return hotelRoomDAO.getStatus(con, userInputHotelRoomName);
	}

	/**
	 * Update status.
	 *
	 * @param con the con
	 * @param id the id
	 * @param status the status
	 * @return the int
	 * @throws SQLException the SQL exception
	 */
	public int updateStatus(Connection con, int id, boolean status)
			throws SQLException {

		return hotelRoomDAO.updateStatus(con, id, status);
	}

	/**
	 * Update price.
	 *
	 * @param con the con
	 * @param id the id
	 * @param price the price
	 * @return the int
	 * @throws SQLException the SQL exception
	 */
	public int updatePrice(Connection con, int id, int price)
			throws SQLException {

		return hotelRoomDAO.updatePrice(con, id, price);
	}

	/**
	 * Gets the price hotel room.
	 *
	 * @param con the con
	 * @return the price hotel room
	 * @throws SQLException the SQL exception
	 */
	public List<String> getPriceHotelRoom(Connection con) throws SQLException {

		return hotelRoomDAO.getPriceHotelRoom(con);

	}

}
