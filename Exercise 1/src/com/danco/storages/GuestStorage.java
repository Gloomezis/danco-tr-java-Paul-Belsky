package com.danco.storages;

import java.util.ArrayList;

import com.danco.models.Guest;

public class GuestStorage {

	ArrayList<Guest> allGuests = new ArrayList<Guest>();
	
	
	//singleton
		private static volatile GuestStorage instance;
		
		private  GuestStorage() {}
		public static GuestStorage getInstance(){
			if (instance ==null){
				synchronized (GuestStorage.class) {
					if(instance == null){
						instance = new GuestStorage();
					}
					
				}
			}
			return instance;
		}

	// TODO Get all free rooms (Sorted by alphabet/by date dapartyre)
	public ArrayList<Guest> getAllGuests() {
		return allGuests;
	}

	// add guest to array Guest
	public void AddGuest(Guest guest) {
		allGuests.add(guest);
	}

	// show number of all guest
	public void showAllGuestNumber() {
		System.out.println("All guest number is:" + allGuests.size());
	}

	// show summ to paid selected guest
	public void showSummToPaidGuest(Guest guest) {
		System.out.println("Summ to paid is: " + guest.getSummToPaid());
	}

}