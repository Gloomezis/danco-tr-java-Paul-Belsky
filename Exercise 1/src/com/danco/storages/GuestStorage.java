package com.danco.storages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import com.danco.comparators.GuestDateOfDepartureComparator;
import com.danco.comparators.GuestNameComparator;
import com.danco.comparators.ServiceDateOfUsingComparator;
import com.danco.comparators.ServicePriceComparator;
import com.danco.models.Guest;
import com.danco.models.Service;

public class GuestStorage {

	private String DATE_FORMAT = "dd-MM-yyyy";
	private String GUEST_FORMAT = "Guest: %s , room: %s , date of departure: %s \n";
	private String ALL_GUEST_NUMB_FORMAT = "All guest number is: %d";
	private String SERVICE_FORMAT = "service : %s, price: %d, date: %s ";
	private String SUMM_TO_PAID_FORMAT = "Summ to paid is: %d";
	private String WRONG_SORT_CONDITION = "wrong sorted condition";
	private String ALPHABET = "alphabet";
	private String DATE = "date";
	private String PRICE = "price";

	ArrayList<Guest> allGuests = new ArrayList<Guest>();
	DateFormat df = new SimpleDateFormat(DATE_FORMAT);
	// singleton
	private static GuestStorage instance;

	public static GuestStorage getInstance() {
		if (instance == null) {
			instance = new GuestStorage();
		}
		return instance;
	}

	private GuestStorage() {
	}

	// +add guest to array Guest
	public void addGuest(Guest guest) {
		allGuests.add(guest);
	}

	// + add service to selected guest
	public void addServiceToGuest(Guest guest, Service service) {

		Date date = Calendar.getInstance().getTime();
		service.setDate(date);
		guest.setServices(service);
		guest.setSummToPaid(guest.getSummToPaid() + service.getPrice());

	}

	public ArrayList<Guest> getAllGuests() {
		return allGuests;
	}

	public void setAllGuests(ArrayList<Guest> allGuests) {
		this.allGuests = allGuests;
	}

	public void setDates(String dateOfArrive, String dateOfDeparture,
			Guest guest) {
		setDateOfArrive(dateOfArrive, guest);
		setDateOfDeparture(dateOfDeparture, guest);
	}

	// +
	public void setDateOfArrive(String dateOfArrive, Guest guest) {

		Date Pdate = null;
		try {
			Pdate = df.parse(dateOfArrive);
		} catch (Exception e) {
			e.printStackTrace();
		}
		guest.setDateOfArrive(Pdate);
	}

	// +
	public void setDateOfDeparture(String dateOfDeparture, Guest guest) {

		Date Pdate = null;
		try {
			Pdate = df.parse(dateOfDeparture);
		} catch (Exception e) {
			e.printStackTrace();
		}
		guest.setDateOfDeparture(Pdate);

	}

	// TODO returnStatement
	// +show number of all guest
	public void showAllGuestNumber() {
		System.out.println(new StringBuilder(String.format(
				ALL_GUEST_NUMB_FORMAT, allGuests.size())));

	}

	// TODO returnStatement
	// + list of all guest and they hotel rooms sorted by alphabet and date
	// of departure
	public void showAllGuests(String a) {

		StringBuilder sb = new StringBuilder(500);
		if (a.equals(ALPHABET)) {

			Collections.sort(allGuests, new GuestNameComparator());

			for (Guest s : allGuests) {
				sb.append(String.format(GUEST_FORMAT, s.getName(),
						s.getNumberOfRoom(), df.format(s.getDateOfDeparture())));

			}
		} else {
			if (a.equals(DATE)) {
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
	// +show services of selected guest and price sorted by date and price
	public void showListOfService(Guest guest, String sortCondinion) {
		ArrayList<Service> s = guest.getServises();
		System.out.println(guest.getName() + ":");

		if (sortCondinion.equals(PRICE)) {
			Collections.sort(s, new ServicePriceComparator());
		} else {
			if (sortCondinion.equals(DATE)) {
				Collections.sort(s, new ServiceDateOfUsingComparator());
			} else {
				System.out.println(WRONG_SORT_CONDITION);
			}
		}
		for (Service c : s) {
			System.out
					.println(new StringBuilder(String.format(SERVICE_FORMAT,
							c.getNameOfService(), c.getPrice(),
							df.format(c.getDate()))));

		}
	}

	// TODO returnStatement
	// +show summ to paid selected guest
	public void showSummToPaidGuest(Guest guest) {
		System.out.println(new StringBuilder(String.format(SUMM_TO_PAID_FORMAT,
				guest.getSummToPaid())));

	}

}
