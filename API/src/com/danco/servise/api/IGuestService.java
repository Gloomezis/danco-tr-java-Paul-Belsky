package com.danco.servise.api;

import java.util.List;

import com.danco.model.Guest;
import com.danco.model.Service;

// TODO: Auto-generated Javadoc
/**
 * The Interface IGuestService.
 */
public interface IGuestService {

	/**
	 * Creates the guest.
	 *
	 * @param name
	 *            the name
	 * @return the guest
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.serviñe.IGuestService#createGuest(java.lang.String)
	 */
	public Guest createGuest(String name);

	/**
	 * Gets the guest by name.
	 *
	 * @param NameOfGuest
	 *            the name of guest
	 * @return the guest by name
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.serviñe.IGuestService#getGuestByName(java.lang.String)
	 */
	public Guest getGuestByName(String NameOfGuest);

	/**
	 * Adds the guest.
	 *
	 * @param guest
	 *            the guest
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.serviñe.IGuestService#addGuest(com.danco.model.Guest)
	 */
	public void addGuest(Guest guest);

	/**
	 * Show all guest number.
	 *
	 * @return the int
	 */
	public int showAllGuestNumber();

	/**
	 * Show summ to paid guest.
	 *
	 * @param guest
	 *            the guest
	 * @return the int
	 */
	public int showSummToPaidGuest(Guest guest);

	/**
	 * Show all guests.
	 *
	 * @param a
	 *            the a
	 * @return the list
	 */
	public List<Guest> showAllGuests(String a);

	/**
	 * Show list of service.
	 *
	 * @param guest
	 *            the guest
	 * @param sortCondition
	 *            the sort condition
	 * @return the list
	 */
	public List<Service> showListOfService(Guest guest, String sortCondition);

	/**
	 * Adds the service to guest.
	 *
	 * @param guest
	 *            the guest
	 * @param service
	 *            the service
	 */
	public void addServiceToGuest(Guest guest, Service service);

	/**
	 * Gets the all guests.
	 *
	 * @return the all guests
	 */
	public List<Guest> getAllGuests();

}