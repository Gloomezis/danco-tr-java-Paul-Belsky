package com.danco.servises;

import java.util.List;

import com.danco.gloomezis.ExceptionLogger;
import com.danco.gloomezis.MainStorage;
import com.danco.models.Guest;
import com.danco.models.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestService.
 */
public class GuestService {

	/** The main storage. */
	MainStorage mainStorage = MainStorage.getInstance();
	
	
	
	private static GuestService instance;
	
	
	public static GuestService getInstance() {
		if (instance == null) {
			instance = new GuestService();
		}
		return instance;
	}
	
	/**
	 * Instantiates a new guest service.
	 */
	private GuestService() {
	}
	
	
	
	


	public void writeGuestToFile() {
		try {
			mainStorage.writeGuestToFile();
		} catch (Exception e) {
			ExceptionLogger.logEx(e);
		}
	}

	public void readGuestFromFile() {

		mainStorage.readGuestFromFile();

	}

	public void addGuest(Guest guest) {
		mainStorage.addGuest(guest);
	}
	
	/**
	 * Show all guest number.
	 */

	public void showAllGuestNumber() {
		mainStorage.showAllGuestNumber();
	}

	/**
	 * Show summ to paid guest.
	 *
	 * @param guest
	 *            the guest
	 */

	public void showSummToPaidGuest(Guest guest) {
		mainStorage.showSummToPaidGuest(guest);
	}

	/**
	 * Show all guests.
	 *
	 * @param a
	 *            the a
	 */

	public void showAllGuests(String a) {
		mainStorage.showAllGuests(a);
	}

	

	/**
	 * Show list of service.
	 *
	 * @param guest
	 *            the guest
	 * @param sortCondition
	 *            the sort condition
	 */

	public void showListOfService(Guest guest, String sortCondition) {
		mainStorage.showListOfService(guest, sortCondition);
	}

	/**
	 * Adds the service to guest.
	 *
	 * @param guest
	 *            the guest
	 * @param service
	 *            the service
	 */

	public void addServiceToGuest(Guest guest, Service service) {
		mainStorage.addServiceToGuest(guest, service);
	}

	/**
	 * Gets the all guests.
	 *
	 * @return the all guests
	 */

	public List<Guest> getAllGuests() {
		return mainStorage.getAllGuests();
	}
}
