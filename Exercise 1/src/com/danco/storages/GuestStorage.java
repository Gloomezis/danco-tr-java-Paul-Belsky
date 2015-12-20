package com.danco.storages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.danco.models.Guest;
import com.danco.models.Service;
import com.danco.storages.ServiceStorage.PriceCompare;

public class GuestStorage {

	ArrayList<Guest> allGuests = new ArrayList<Guest>();

	// singleton
	private static volatile GuestStorage instance;

	private GuestStorage() {
	}

	public static GuestStorage getInstance() {
		if (instance == null) {
			synchronized (GuestStorage.class) {
				if (instance == null) {
					instance = new GuestStorage();
				}

			}
		}
		return instance;
	}

	// + list of all guest and they hotel rooms sorted by alphabet and date
	// of departure
	public void getAllGuests(String a) {
		if (a.equals("alphabet")) {
			Collections.sort(allGuests, new NameCompare());
			for (Guest s : allGuests) {
				System.out.println("Guest: " + s.getName() + " , room: " + s.getNumberOfRoom() + " date of departure: "
						+ s.getDateOfDeparture());
			}
		} else {
			if (a.equals("date")) {
				Collections.sort(allGuests, new DateOfDepartureCompare());
				for (Guest s : allGuests) {
					System.out.println("Guest: " + s.getName() + " , room: " + s.getNumberOfRoom()
							+ " date of departure: " + s.getDateOfDeparture());
				}
			} else {
				System.out.println("wrong sorted condition");
			}
		}

	}

	// +add guest to array Guest
	public void AddGuest(Guest guest) {
		allGuests.add(guest);
	}

	// +show number of all guest
	public void showAllGuestNumber() {
		System.out.println("All guest number is:" + allGuests.size());
	}

	// +show summ to paid selected guest
	public void showSummToPaidGuest(Guest guest) {
		System.out.println("Summ to paid is: " + guest.getSummToPaid());
	}

	// TODO show services of selected guest and price sorted by date and price
	public ArrayList<Service> showListOfService(Guest guest) {
		return guest.getServises();
	}
	//+
	public void setDateOfDeparture(String dateOfDeparture,Guest guest){
	guest.setDateOfDeparture(dateOfDeparture);
	}
	
	//+
		public void setDateOfArrive(String dateOfArrive,Guest guest){
		guest.setDateOfArrive(dateOfArrive);
		}

	/////////////////
	/// Comparators///
	/////////////////

	// comparator by name
	class NameCompare implements Comparator<Guest> {

		@Override
		public int compare(Guest guest1, Guest guest2) {
			return guest1.getName().compareTo(guest2.getName());

		}

	}
//+
	public class DateOfDepartureCompare implements Comparator<Guest> {

		public int compare(Guest p, Guest q) {

			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date Pdate = null;
			Date Qdate = null;
			try {
				Pdate = df.parse(p.getDateOfDeparture());
				Qdate = df.parse(q.getDateOfDeparture());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return Pdate.compareTo(Qdate);
		}
	}

}
