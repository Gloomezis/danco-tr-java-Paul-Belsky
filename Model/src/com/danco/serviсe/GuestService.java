package com.danco.serviñe;

import java.util.List;

import org.apache.log4j.Logger;

import com.danco.model.Guest;
import com.danco.model.Service;
import com.danco.storages.MainStorage;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestService.
 */
public class GuestService {

	/** The main storage. */
	private MainStorage mainStorage = MainStorage.getInstance();

	private final Logger LOG1 = Logger.getLogger(GuestService.class.getName());

	private static GuestService instance;

	public static GuestService getInstance() {
		if (instance == null) {
			instance = new GuestService();
		}
		return instance;
	}

	/**
	 * Creates the guest.
	 *
	 * @param name
	 *            the name
	 * @return the guest
	 */
	public Guest createGuest(String name) {

		try {
			return mainStorage.createGuest(name);
		} catch (Exception e) {
			LOG1.error("Exception", e);
			return null;
		}

	}

	/**
	 * Gets the guest by name.
	 *
	 * @param NameOfGuest
	 *            the name of guest
	 * @return the guest by name
	 */
	public Guest getGuestByName(String NameOfGuest) {

		try {
			return mainStorage.getGuestByName(NameOfGuest);
		} catch (Exception e) {
			LOG1.error("Exception", e);
			return null;
		}

	}

	/**
	 * Instantiates a new guest service.
	 */
	private GuestService() {
	}

	public void addGuest(Guest guest) {
		try {
			mainStorage.addGuest(guest);
		} catch (Exception e) {
			LOG1.error("Exception", e);
		}
	}

	/**
	 * Show all guest number.
	 * @return 
	 */

	public int showAllGuestNumber() {
		try {
			return mainStorage.showAllGuestNumber();
		} catch (Exception e) {
			LOG1.error("Exception", e);
			return 0;
		}
	}

	/**
	 * Show summ to paid guest.
	 *
	 * @param guest
	 *            the guest
	 */

	public int showSummToPaidGuest(Guest guest) {
		try {
			return mainStorage.showSummToPaidGuest(guest);
		} catch (Exception e) {
			LOG1.error("Wrong guest name", e);
			return 0;
		}
	}

	/**
	 * Show all guests.
	 *
	 * @param a
	 *            the a
	 */

	public List<Guest>   showAllGuests(String a) {
		try {
			return	mainStorage.showAllGuests(a);
		} catch (Exception e) {
			LOG1.error("Exception", e);
			//thinking
			return null;
		}
	}

	/**
	 * Show list of service.
	 *
	 * @param guest
	 *            the guest
	 * @param sortCondition
	 *            the sort condition
	 */

	public List<Service> showListOfService(Guest guest, String sortCondition) {
		try {
		return	mainStorage.showListOfService(guest, sortCondition);
		} catch (Exception e) {
			LOG1.error("Wrong guest name", e);
        return null;
		}
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
		try {

			mainStorage.addServiceToGuest(guest, service);

		} catch (Exception e) {
			// nullpointexc
			LOG1.error("No have this service or guest", e);

		}
	}

	/**
	 * Gets the all guests.
	 *
	 * @return the all guests
	 */

	public List<Guest> getAllGuests() {
		List<Guest> guest = null;
		try {
			guest = mainStorage.getAllGuests();
		} catch (Exception e) {
			LOG1.error("Exception", e);
		}
		return guest;
	}
}
