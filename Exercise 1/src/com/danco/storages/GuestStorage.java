package com.danco.storages;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.danco.models.Guest;
import com.danco.models.Service;

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
	public void showAllGuests(String a) {
		if (a.equals("alphabet")) {
			Collections.sort(allGuests, new NameCompare());
			for (Guest s : allGuests) {
				System.out.println("Guest: " + s.getName() + " , room: "
						+ s.getNumberOfRoom() + " date of departure: "
						+ s.getDateOfDeparture());
			}
		} else {
			if (a.equals("date")) {
				Collections.sort(allGuests, new DateOfDepartureCompare());
				for (Guest s : allGuests) {
					System.out.println("Guest: " + s.getName() + " , room: "
							+ s.getNumberOfRoom() + " date of departure: "
							+ s.getDateOfDeparture());
				}
			} else {
				System.out.println("wrong sorted condition");
			}
		}

	}

	// +add guest to array Guest
	public void addGuest(Guest guest) {
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

	// +show services of selected guest and price sorted by date and price
	public void showListOfService(Guest guest, String sortCondinion) {
		ArrayList<Service> s = guest.getServises();
		System.out.println(guest.getName() + ":");
		if (sortCondinion.equals("price")) {
			Collections.sort(s, new PriceCompare());
		}
		if (sortCondinion.equals("date")) {
			Collections.sort(s, new DateOfUsing());
		} else {
			System.out.println("wrong sort condition");
		}
		for (Service c : s) {
			System.out.println("service : " + c.getNameOfService()
					+ ", price: " + c.getPrice() + " ,date of using :"
					+ c.getDate());
		}
	}

	// + add service to selected guest
	public void addServiceToGuest(Guest guest, Service service) {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy ");
		Date date = Calendar.getInstance().getTime();
		service.setDate(df.format(date));
		guest.setServices(service);
		guest.setSummToPaid(guest.getSummToPaid() + service.getPrice());

	}

	// +
	public void setDateOfDeparture(String dateOfDeparture, Guest guest) {
		guest.setDateOfDeparture(dateOfDeparture);
	}

	// +
	public void setDateOfArrive(String dateOfArrive, Guest guest) {
		guest.setDateOfArrive(dateOfArrive);
	}

	public ArrayList<Guest> getAllGuests() {
		return allGuests;
	}

	public void setAllGuests(ArrayList<Guest> allGuests) {
		this.allGuests = allGuests;
	}

	// ///////////////
	// / Comparators///
	// ///////////////

	// + comparator by name
	class NameCompare implements Comparator<Guest> {

		@Override
		public int compare(Guest guest1, Guest guest2) {
			return guest1.getName().compareTo(guest2.getName());

		}

	}

	// +
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

	// comparator by name
	class PriceCompare implements Comparator<Service> {

		@Override
		public int compare(Service service1, Service service2) {

			int price1 = service1.getPrice();
			int price2 = service2.getPrice();

			if (price1 > price2) {
				return 1;
			} else if (price1 < price2) {
				return -1;
			}
			return 0;

		}
	}

	// + date of using service comparator
	public class DateOfUsing implements Comparator<Service> {

		public int compare(Service p, Service q) {

			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date Pdate = null;
			Date Qdate = null;
			try {
				Pdate = df.parse(p.getDate());
				Qdate = df.parse(q.getDate());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return Pdate.compareTo(Qdate);
		}

	}

}
