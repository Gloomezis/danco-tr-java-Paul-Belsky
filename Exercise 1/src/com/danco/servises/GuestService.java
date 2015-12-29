package com.danco.servises;

import java.util.ArrayList;

import com.danco.gloomezis.MainStorage;
import com.danco.models.Guest;
import com.danco.models.Service;

public class GuestService {
	MainStorage mainStorage = MainStorage.getInstance();

	public GuestService() {
	}

	// +show number of all guest
	public void showAllGuestNumber() {
		mainStorage.showAllGuestNumber();
	}

	// +show summ to paid guest
	public void showSummToPaidGuest(Guest guest) {
		mainStorage.showSummToPaidGuest(guest);
	}

	// + get all guest sorted by alphabet / date of departure
	public void showAllGuests(String a) {
		mainStorage.showAllGuests(a);
	}

	// + add guest to array Guest
	public void addAllGuests(Guest guest) {
		mainStorage.addGuest(guest);
	}

	// +show services of selected guest and price sorted by date and price
	public void showListOfService(Guest guest, String sortCondition) {
		mainStorage.showListOfService(guest, sortCondition);
	}

	// add service to selected guest
	public void addServiceToGuest(Guest guest, Service service) {
		mainStorage.addServiceToGuest(guest, service);
	}

	// +
	// public void setDateOfDeparture(String dateOfDeparture, Guest guest) {
	// mainStorage.setDateOfDeparture(dateOfDeparture, guest);
	// }

	// +
	// public void setDateOfArrive(String dateOfArrive, Guest guest) {
	// mainStorage.setDateOfArrive(dateOfArrive, guest);
	// }

	// writing to file
	public ArrayList<Guest> getAllGuests() {
		return mainStorage.getAllGuests();
	}
}
