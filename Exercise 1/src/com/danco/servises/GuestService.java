package com.danco.servises;

import java.util.ArrayList;

import com.danco.models.Guest;
import com.danco.models.Service;
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
		
	

	// +show number of all guest
	public void showAllGuestNumber() {
		guestStorage.showAllGuestNumber();
	}

	// +show summ to paid guest
	public void showSummToPaidGuest(Guest guest) {
		guestStorage.showSummToPaidGuest(guest);
	}

	// TODO get all guest sorted by alphabet / date of departure
	public void getAllGuests(String a) {
		guestStorage.getAllGuests(a);
	}

	//+ add guest to array Guest
	public void AddAllGuests(Guest guest) {
		guestStorage.AddGuest(guest);
	}
	
	//TODO show services of selected guest and price sorted by date and price
		public ArrayList<Service> showListOfService(Guest guest){
			return guestStorage.showListOfService(guest);
		}
		public void setDateOfDeparture(String dateOfDeparture, Guest guest){
		guestStorage.setDateOfDeparture(dateOfDeparture, guest);
		}
		
		public void setDateOfArrive(String dateOfArrive, Guest guest){
			guestStorage.setDateOfArrive(dateOfArrive, guest);
			}
}
