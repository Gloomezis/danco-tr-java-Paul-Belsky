package com.danco.servises;

import java.util.ArrayList;

import com.danco.models.Guest;
import com.danco.storages.GuestStorage;

public class GuestService {
	GuestStorage guestStorage = GuestStorage.getInstance();

	//singleton
	private static volatile GuestService instance;
	
	private  GuestService() {}
	public static GuestService getInstance(){
		if (instance ==null){
			synchronized (GuestService.class) {
				if(instance == null){
					instance = new GuestService();
				}
				
			}
		}
		return instance;
	}
		
	

	// show number of all guest
	public void showAllGuestNumber() {
		System.out.println("All guest number is:" + guestStorage.getAllGuests().size());
	}

	// show summ to paid guest
	public void showSummToPaidGuest(Guest guest) {
		guestStorage.showSummToPaidGuest(guest);
	}

	// TODO Get all free rooms (Sorted by alphabet/by date dapartyre)
	public ArrayList<Guest> getAllGuests() {
		return guestStorage.getAllGuests();
	}

	// add guest to array Guest
	public void setAllGuests(Guest guest) {
		guestStorage.getAllGuests().add(guest);
	}
}
