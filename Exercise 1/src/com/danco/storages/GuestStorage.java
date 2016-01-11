package com.danco.storages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.danco.comparators.GuestDateOfDepartureComparator;
import com.danco.comparators.GuestNameComparator;
import com.danco.comparators.ServiceDateOfUsingComparator;
import com.danco.comparators.ServicePriceComparator;
import com.danco.models.Guest;
import com.danco.models.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestStorage.
 */
public class GuestStorage {

	/** The Constant DATE_FORMAT. */
	private static final  String DATE_FORMAT = "dd-MM-yyyy";
	
	/** The Constant GUEST_FORMAT. */
	private static final  String GUEST_FORMAT = "Guest: %s , room: %s , date of departure: %s \n";
	
	/** The Constant ALL_GUEST_NUMB_FORMAT. */
	private static final  String ALL_GUEST_NUMB_FORMAT = "All guest number is: %d";
	
	/** The Constant SERVICE_FORMAT. */
	private static final  String SERVICE_FORMAT = "service : %s, price: %d, date: %s ";
	
	/** The Constant SUMM_TO_PAID_FORMAT. */
	private static final  String SUMM_TO_PAID_FORMAT = "Summ to paid is: %d";
	
	/** The Constant WRONG_SORT_CONDITION. */
	private static final  String WRONG_SORT_CONDITION = "wrong sorted condition";
	
	/** The Constant ALPHABET. */
	private static final  String ALPHABET = "alphabet";
	
	/** The Constant DATE. */
	private static final  String DATE = "date";
	
	/** The Constant PRICE. */
	private static final  String PRICE = "price";

	/** The all guests. */
	private List<Guest> allGuests = new ArrayList<Guest>();
	
	/** The df. */
	private DateFormat df = new SimpleDateFormat(DATE_FORMAT);
	
	
	/**
	 * Creates the guest.
	 *
	 * @param name the name
	 * @return the guest
	 */
	public Guest createGuest(String name){
		Guest guest = new Guest(name);
		return 	guest;
		
	}

	/**
	 * Adds the guest.
	 *
	 * @param guest the guest
	 */
	
	public void addGuest(Guest guest) {
		allGuests.add(guest);
	}

	/**
	 * Adds the service to guest.
	 *
	 * @param guest the guest
	 * @param service the service
	 */
	
	public void addServiceToGuest(Guest guest, Service service) {

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
	 */
	public Guest getGuestByName(String NameOfGuest) {
		
		Guest g = null;
		for(Guest gue:allGuests){
			if(gue.getName().equals(NameOfGuest)){
				g=gue;
			}
		}
		return g;
	}
	
	
	/**
	 * Gets the all guests.
	 *
	 * @return the all guests
	 */
	public List<Guest> getAllGuests() {
		return allGuests;
	}

	/**
	 * Sets the all guests.
	 *
	 * @param allGuests the new all guests
	 */
	public void setAllGuests(ArrayList<Guest> allGuests) {
		this.allGuests = allGuests;
	}

	/**
	 * Sets the dates.
	 *
	 * @param dateOfArrive the date of arrive
	 * @param dateOfDeparture the date of departure
	 * @param guest the guest
	 */
	public void setDates(Date dateOfArrive, Date dateOfDeparture,
			Guest guest) {
		setDateOfArrive(dateOfArrive, guest);
		setDateOfDeparture(dateOfDeparture, guest);
	}

	/**
	 * Sets the date of arrive.
	 *
	 * @param dateOfArrive the date of arrive
	 * @param guest the guest
	 */
	// +
	public void setDateOfArrive(Date dateOfArrive, Guest guest) {

		
		guest.setDateOfArrive(dateOfArrive);
	}

	/**
	 * Sets the date of departure.
	 *
	 * @param dateOfDeparture the date of departure
	 * @param guest the guest
	 */
	// +
	public void setDateOfDeparture(Date dateOfDeparture, Guest guest) {

		
		guest.setDateOfDeparture(dateOfDeparture);

	}

	// TODO returnStatement
	/**
	 * Show all guest number.
	 */
	
	public void showAllGuestNumber() {
		System.out.println(String.format(
				ALL_GUEST_NUMB_FORMAT, allGuests.size()));

	}

	// TODO returnStatement
	// + list of all guest and they hotel rooms sorted by alphabet and date
	/**
	 * Show all guests.
	 *
	 * @param a the a
	 */
	
	public void showAllGuests(String a) {

		StringBuilder sb = new StringBuilder(500);
		if (ALPHABET.equals(a)) {

			Collections.sort(allGuests, new GuestNameComparator());

			for (Guest s : allGuests) {
				sb.append(String.format(GUEST_FORMAT, s.getName(),
						s.getNumberOfRoom(), df.format(s.getDateOfDeparture())));

			}
		} else {
			if (DATE.equals(a)) {
				Collections.sort(allGuests,
						new GuestDateOfDepartureComparator());
				for (Guest s : allGuests) {
					sb.append(String.format(GUEST_FORMAT, s.getName(),
							s.getNumberOfRoom(),
							df.format(s.getDateOfDeparture())));

				}
			} else {
				sb.append(WRONG_SORT_CONDITION);
			}
		}
		System.out.println(sb);
	}

	// TODO returnStatement
	/**
	 * Show list of service.
	 *
	 * @param guest the guest
	 * @param sortCondinion the sort condinion
	 */
	
	public void showListOfService(Guest guest, String sortCondinion) {
		List<Service> s = guest.getServises();
		System.out.println(guest.getName() + ":");

		if (PRICE.equals(sortCondinion)) {
			Collections.sort(s, new ServicePriceComparator());
		} else {
			if (DATE.equals(sortCondinion)) {
				Collections.sort(s, new ServiceDateOfUsingComparator());
			} else {
				System.out.println(WRONG_SORT_CONDITION);
			}
		}
		for (Service c : s) {
			System.out
					.println(String.format(SERVICE_FORMAT,
							c.getNameOfService(), c.getPrice(),
							df.format(c.getDate())));

		}
	}

	// TODO returnStatement
	/**
	 * Show summ to paid guest.
	 *
	 * @param guest the guest
	 */
	
	public void showSummToPaidGuest(Guest guest) {
		System.out.println(String.format(SUMM_TO_PAID_FORMAT,
				guest.getSummToPaid()));

	}

}
