package com.danco.gloomezis;

import java.util.ArrayList;

import com.danco.models.Guest;
import com.danco.models.HotelRoom;
import com.danco.models.Service;
import com.danco.storages.GuestStorage;
import com.danco.storages.HotelRoomStorage;
import com.danco.storages.ServiceStorage;

public class MainStorage {

	GuestStorage guestStorage;
	HotelRoomStorage hotelRoomStorage;
	ServiceStorage serviceStorage;
	

	// singleton
	private static MainStorage instance;

	private MainStorage() {
		guestStorage = GuestStorage.getInstance();
		hotelRoomStorage = HotelRoomStorage.getInstance();
		serviceStorage = ServiceStorage.getInstance();
	}

	public static MainStorage getInstance() {
		if (instance == null) {
			instance = new MainStorage();
		}
		return instance;
	}

	// + show price servises and hotel rooms sorted by price and category
	public void showPriceServiceAndHotelRoom() {
		hotelRoomStorage.showPriceHotelRoom();
		serviceStorage.showPriceServices();

		// ////////////////////////
		// /// Hotel Room Methods//
		// ////////////////////////

	}

	// +get array of Hotel rooms all or free (Sorted by price/sleeping
	// numbers/star
	// category)
	public void showAllRooms(String sortCondition, String free) {
		hotelRoomStorage.showAllRooms(sortCondition, free);
	}

	// + get array of free rooms after date (not sorded)
	public void showFreeRomsAfterDate(String sortCondition, String date) {
		hotelRoomStorage.showFreeRomsAfterDate(sortCondition, date);
	}

	// +show number of all free rooms
	public void showNumberOfFreeHoterRooms() {
		hotelRoomStorage.showNumberOfFreeHotelRooms();
	}

	// +show last 3 guest of hotel room
	public void showLast3GuestOfHotelRoom(HotelRoom hotelRoom) {
		hotelRoomStorage.showLast3GuestOfHotelRoom(hotelRoom);
	}

	// + show detail of selected hotel room
	public void showDetailOfHotelRoom(HotelRoom hotelRoom) {
		hotelRoomStorage.showDetailOfHotelRoom(hotelRoom);
	}

	// +settle guest to hotel room

	public void settleGuestToHotelRoom(Guest guest, HotelRoom hotelRoom, String dateOfArrival, String dateOfDeparture) {
		hotelRoomStorage.settleGuestToHotelRoom(guest, hotelRoom, dateOfArrival, dateOfDeparture);
		guestStorage.setDates(dateOfArrival, dateOfDeparture, guest);

	}

	// + Depart all guest from selected hotel room
	public void departGuestFromHotelRoom(HotelRoom hotelRoom) {
		hotelRoomStorage.departGuestFromHotelRoom(hotelRoom);
	}

	// + Change status selected hotel room
	public void changeStatus(HotelRoom hotelRoom) {
		hotelRoomStorage.changeStatus(hotelRoom);
	}

	// + Add room to array rooms
	public void addRooms(HotelRoom room) {
		hotelRoomStorage.addRooms(room);
	}

	// + change room price of selected room
	public void changePriceOfHotelRoom(HotelRoom hotelRoom, int roomPrice) {
		hotelRoomStorage.changePriceOfHotelRoom(hotelRoom, roomPrice);
		;
	}

	// ///////////////////
	// /// Guest Methods//
	// ///////////////////

	// + get all guest sorted by alphabet / date of departure
	public void showAllGuests(String a) {
		guestStorage.showAllGuests(a);
	}

	// + add guest to array Guest
	public void addGuest(Guest guest) {
		guestStorage.addGuest(guest);
	}

	// + show number of all guest
	public void showAllGuestNumber() {
		guestStorage.showAllGuestNumber();
	}

	// + show summ to paid guest
	public void showSummToPaidGuest(Guest guest) {
		guestStorage.showSummToPaidGuest(guest);
	}

	// + show services of selected guest and price sorted by date and price
	public void showListOfService(Guest guest, String sortCondition) {
		guestStorage.showListOfService(guest, sortCondition);
	}

	// add service to selected guest
	public void addServiceToGuest(Guest guest, Service service) {
		guestStorage.addServiceToGuest(guest, service);
	}

	public ArrayList<Guest> getAllGuests() {
		return guestStorage.getAllGuests();
	}

	// /////////////////////
	// /// Service Methods//
	// /////////////////////
	// + add service to array servises
	public void addServices(Service service) {
		serviceStorage.addServices(service);
	}

	// +change price of service
	public void changePriceOfService(Service service, int price) {
		serviceStorage.changePriceOfService(service, price);
	}
}
