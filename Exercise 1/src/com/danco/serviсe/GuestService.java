package com.danco.serviñe;

import java.util.List;

import org.apache.log4j.Logger;

import com.danco.gloomezis.MainStorage;
import com.danco.model.Guest;
import com.danco.model.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestService.
 */
public class GuestService {

	/** The main storage. */
	MainStorage mainStorage = MainStorage.getInstance();
	final Logger LOG1=Logger.getLogger(GuestService.class.getName());
	
	
	
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
		} catch (ArrayIndexOutOfBoundsException |NullPointerException e) {
			LOG1.error("Error in write method/not find file",e);	
		}
		
	}

	public void readGuestFromFile() {
		try {
		mainStorage.readGuestFromFile();
		} catch (ArrayIndexOutOfBoundsException |NullPointerException e) {
			LOG1.error("Error in write method/not find file",e);	
		}

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
		try {
		mainStorage.showSummToPaidGuest(guest);
		} catch (NullPointerException e) {
			LOG1.error("Wrong guest name",e);
		}
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
		try {
		mainStorage.showListOfService(guest, sortCondition);
	} catch (NullPointerException e) {
		LOG1.error("Wrong guest name",e);
		
		
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
		
		} catch (NullPointerException e) {
			//nullpointexc
			LOG1.error("No have this service or guest",e);	
			
		}
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
