package com.danco.storages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.danco.comparator.GuestDateOfDepartureComparator;
import com.danco.comparator.GuestNameComparator;
import com.danco.comparator.ServiceDateOfUsingComparator;
import com.danco.comparator.ServicePriceComparator;
import com.danco.model.Guest;
import com.danco.model.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestStorage.
 */
public class GuestStorage implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant ALPHABET. */
	private static final String ALPHABET = "alphabet";

	/** The Constant DATE. */
	private static final String DATE = "date";

	/** The Constant PRICE. */
	private static final String PRICE = "price";

	/** The all guests. */
	private List<Guest> allGuests = new ArrayList<Guest>();

	/**
	 * Creates the guest.
	 *
	 * @param name the name
	 * @return the guest
	 * @throws Exception the exception
	 */
	public Guest createGuest(String name) throws Exception {
		Guest guest = new Guest(name);
		return guest;

	}

	/**
	 * Adds the guest.
	 *
	 * @param guest the guest
	 * @throws Exception the exception
	 */

	public void addGuest(Guest guest) throws Exception {
		allGuests.add(guest);
	}

	/**
	 * Adds the service to guest.
	 *
	 * @param guest the guest
	 * @param service the service
	 * @throws Exception the exception
	 */

	public void addServiceToGuest(Guest guest, Service service) throws Exception {

		Date date = Calendar.getInstance().getTime();
		service.setDate(date);
		guest.setServices(service);
		guest.setSummToPaid(guest.getSummToPaid() + service.getPrice());

	}

	/**
	 * Gets the guest by name.
	 *
	 * @param NameOfGuest the name of guest
	 * @return the guest by name
	 * @throws Exception the exception
	 */
	public Guest getGuestByName(String NameOfGuest) throws Exception {

		Guest g = null;
		for (Guest gue : allGuests) {
			if (gue.getName().equals(NameOfGuest)) {
				g = gue;
			}
		}
		return g;
	}

	/**
	 * Gets the all guests.
	 *
	 * @return the all guests
	 * @throws Exception the exception
	 */
	public List<Guest> getAllGuests() throws Exception {
		return allGuests;
	}

	/**
	 * Sets the all guests.
	 *
	 * @param allGuests the new all guests
	 * @throws Exception the exception
	 */
	public void setAllGuests(ArrayList<Guest> allGuests) throws Exception {
		this.allGuests = allGuests;
	}

	/**
	 * Sets the dates.
	 *
	 * @param dateOfArrive the date of arrive
	 * @param dateOfDeparture the date of departure
	 * @param guest the guest
	 * @throws Exception the exception
	 */
	public void setDates(Date dateOfArrive, Date dateOfDeparture, Guest guest) throws Exception {
		setDateOfArrive(dateOfArrive, guest);
		setDateOfDeparture(dateOfDeparture, guest);
	}

	/**
	 * Sets the date of arrive.
	 *
	 * @param dateOfArrive the date of arrive
	 * @param guest the guest
	 * @throws Exception the exception
	 */
	// +
	public void setDateOfArrive(Date dateOfArrive, Guest guest) throws Exception {

		guest.setDateOfArrive(dateOfArrive);
	}

	/**
	 * Sets the date of departure.
	 *
	 * @param dateOfDeparture the date of departure
	 * @param guest the guest
	 * @throws Exception the exception
	 */
	// +
	public void setDateOfDeparture(Date dateOfDeparture, Guest guest) throws Exception {

		guest.setDateOfDeparture(dateOfDeparture);
	}

	// TODO returnStatement
	/**
	 * Show all guest number.
	 *
	 * @return the int
	 * @throws Exception the exception
	 */

	public int showAllGuestNumber() throws Exception {

		return allGuests.size();
	}

	// TODO returnStatement
	// + list of all guest and they hotel rooms sorted by alphabet and date
	/**
	 * Show all guests.
	 *
	 * @param a the a
	 * @return the list
	 * @throws Exception the exception
	 */

	public List<Guest> showAllGuests(String a) throws Exception {

		List<Guest> allGuestsForSort = new ArrayList<Guest>(allGuests);

		if (ALPHABET.equals(a)) {

			Collections.sort(allGuestsForSort, new GuestNameComparator());
		} else {
			if (DATE.equals(a)) {
				Collections.sort(allGuestsForSort, new GuestDateOfDepartureComparator());
			} else {
				return null;
			}
		}

		return allGuestsForSort;
	}

	// TODO returnStatement
	/**
	 * Show list of service.
	 *
	 * @param guest the guest
	 * @param sortCondinion the sort condinion
	 * @return the list
	 * @throws Exception the exception
	 */

	public List<Service> showListOfService(Guest guest, String sortCondinion) throws Exception {
		List<Service> s = guest.getServises();

		if (PRICE.equals(sortCondinion)) {
			Collections.sort(s, new ServicePriceComparator());
		} else {
			if (DATE.equals(sortCondinion)) {
				Collections.sort(s, new ServiceDateOfUsingComparator());
			} else {
				return null;
			}
		}

		return s;

	}

	
	/**
	 * Show summ to paid guest.
	 *
	 * @param guest the guest
	 * @return the int
	 * @throws Exception the exception
	 */

	public int showSummToPaidGuest(Guest guest) throws Exception {
		return guest.getSummToPaid();

	}

}
