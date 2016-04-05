package com.danco.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.danco.dao.api.IGuestDAO;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Guest;
import com.danco.model.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestController.
 */
public class GuestController {

	/** The guest service. */
	private IGuestDAO guestDAO = (IGuestDAO) DependencyInjectionManager
			.getClassInstance(IGuestDAO.class);

	/**
	 * Creates the.
	 *
	 * @param con the con
	 * @param g the g
	 * @throws SQLException the SQL exception
	 */
	public void create(Connection con, Guest g) throws SQLException {

		guestDAO.create(con, g);

	}

	/**
	 * Gets the all guest number.
	 *
	 * @param con the con
	 * @return the all guest number
	 * @throws SQLException the SQL exception
	 */
	public int getAllGuestNumber(Connection con) throws SQLException {

		return guestDAO.getAllGuestNumber(con);

	}

	/**
	 * Gets the all sorted.
	 *
	 * @param con the con
	 * @param userInputSortCondition the user input sort condition
	 * @return the all sorted
	 * @throws SQLException the SQL exception
	 */
	public List<Guest> getAllSorted(Connection con,
			String userInputSortCondition) throws SQLException {

		return guestDAO.getAllSorted(con, userInputSortCondition);

	}

	/**
	 * Gets the guest service.
	 *
	 * @param con the con
	 * @param userInputGuestName the user input guest name
	 * @return the guest service
	 * @throws SQLException the SQL exception
	 */
	public List<Service> getGuestService(Connection con,
			String userInputGuestName) throws SQLException {

		return guestDAO.getGuestService(con, userInputGuestName);

	}

}
