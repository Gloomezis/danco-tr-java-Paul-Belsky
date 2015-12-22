package com.danco.servises;

import java.util.ArrayList;

import com.danco.models.Guest;
import com.danco.models.Service;
import com.danco.storages.GuestStorage;

public class GuestService {
	GuestStorage guestStorage = GuestStorage.getInstance();

	// singleton
	private static volatile GuestService instance;

	private GuestService() {
	}

	public static GuestService getInstance() {
		if (instance == null) {
			synchronized (GuestService.class) {
				if (instance == null) {
					instance = new GuestService();
				}

			}
		}
		return instance;
	}

	// +show number of all guest
	public void showAllGuestNumber() {
		guestStorage.showAllGuestNumber();
	}

	// +show summ to paid guest
	public void showSummToPaidGuest(Guest guest) {
		guestStorage.showSummToPaidGuest(guest);
	}

	// + get all guest sorted by alphabet / date of departure
	public void showAllGuests(String a) {
		guestStorage.showAllGuests(a);
	}

	// + add guest to array Guest
	public void addAllGuests(Guest guest) {
		guestStorage.addGuest(guest);
	}

	// +show services of selected guest and price sorted by date and price
	public void showListOfService(Guest guest, String sortCondition) {
		guestStorage.showListOfService(guest, sortCondition);
	}

	// add service to selected guest
	public void addServiceToGuest(Guest guest, Service service) {
		guestStorage.addServiceToGuest(guest, service);
	}

	// +
	public void setDateOfDeparture(String dateOfDeparture, Guest guest) {
		guestStorage.setDateOfDeparture(dateOfDeparture, guest);
	}

	// +
	public void setDateOfArrive(String dateOfArrive, Guest guest) {
		guestStorage.setDateOfArrive(dateOfArrive, guest);
	}

	// writing to file
	public ArrayList<Guest> getAllGuests() {
		return guestStorage.getAllGuests();
	}
}
