/*
 * 
 */
package com.danco.controller;

import java.util.List;

import org.hibernate.Session;

import com.danco.dao.api.IGuestDAO;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Guest;

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
	 * @param session the session
	 * @param g            the g
	 * @throws Exception the exception
	 */
	public void createGuest(Session session, Guest g) throws Exception {

		guestDAO.create(session, g);

	}

	/**
	 * Delete guest.
	 *
	 * @param session the session
	 * @param g the g
	 * @throws Exception the exception
	 */
	public void deleteGuest(Session session, Guest g) throws Exception {

		guestDAO.delete(session, g);

	}

	/**
	 * Update guset.
	 *
	 * @param session the session
	 * @param g the g
	 * @throws Exception the exception
	 */
	public void updateGuset(Session session, Guest g) throws Exception {

		guestDAO.update(session, g);

	}

	/**
	 * Gets the guest by id.
	 *
	 * @param session the session
	 * @param id the id
	 * @return the guest by id
	 * @throws Exception the exception
	 */
	public Guest getGuestById(Session session, int id) throws Exception {

		return guestDAO.getById(session, id);

	}

	/**
	 * Gets the guest list.
	 *
	 * @param session the session
	 * @param SortCondition the sort condition
	 * @return the guest list
	 * @throws Exception the exception
	 */
	public List<Guest> getGuestList(Session session, String sortCondition)
			throws Exception {
		return guestDAO.getList(session, sortCondition);

	}
	
	
	/**
	 * Gets the all guest number.
	 *
	 * @param session the session
	 * @return the all guest number
	 * @throws Exception the exception
	 */
	public int getAllGuestNumber(Session session) throws Exception {

		return guestDAO.getAllGuestNumber(session);

	}


}
