package com.danco.gloomezis;

import java.util.ArrayList;

import com.danco.models.Guest;
import com.danco.models.HotelRoom;
import com.danco.models.Service;
import com.danco.servises.GuestService;
import com.danco.servises.HotelRoomService;
import com.danco.servises.ServiceService;

public class Hotel {

	GuestService guestService;
	HotelRoomService hotelRoomService;
	ServiceService serviceService;

	// singleton
	private static volatile Hotel instance;

	private Hotel() {
		guestService = GuestService.getInstance();
		hotelRoomService = HotelRoomService.getInstance();
		serviceService = ServiceService.getInstance();
	}

	public static Hotel getInstance() {
		if (instance == null) {
			synchronized (Hotel.class) {
				if (instance == null) {
					instance = new Hotel();
				}

			}
		}
		return instance;
	}

	// + show price servises and hotel rooms sorted by price and category
	public void showPriceServiceAndHotelRoom() {
		hotelRoomService.showPriceHotelRoom();
		serviceService.showPriceServices();

		// ////////////////////////
		// /// Hotel Room Methods//
		// ////////////////////////

	}

	// +get array of Hotel rooms all or free (Sorted by price/sleeping
	// numbers/star
	// category)
	public void showAllRoms(String sortCondition, String free) {
		hotelRoomService.showAllRoms(sortCondition, free);
	}

	// + get array of free rooms after date (not sorded)
	public void showFreeRomsAfterDate(String sortCondition, String date) {
		hotelRoomService.showFreeRomsAfterDate(sortCondition, date);
	}

	// +show number of all free rooms
	public void showNumberOfFreeHoterRoom() {
		hotelRoomService.showNumberOfFreeHotelRooms();
	}

	// +show last 3 guest of hotel room
	public void showLast3GuestOfHotelRoom(HotelRoom hotelRoom) {
		hotelRoomService.showLast3GuestOfHotelRoom(hotelRoom);
	}

	// + show detail of selected hotel room
	public void showDetailOfHotelRoom(HotelRoom hotelRoom) {
		hotelRoomService.showDetailOfHotelRoom(hotelRoom);
	}

	// +settle guest to hotel room

	public void settleGuestToHotelRoom(Guest guest, HotelRoom hotelRoom,
			String dateOfArrival, String dateOfDeparture) {
		hotelRoomService.settleGuestToHotelRoom(guest, hotelRoom);
		hotelRoomService.setDateOfArrival(dateOfArrival, hotelRoom);
		hotelRoomService.setDateOfDeparture(dateOfDeparture, hotelRoom);
		guestService.setDateOfDeparture(dateOfDeparture, guest);
		guestService.setDateOfArrive(dateOfArrival, guest);

	}

	// + Depart all guest from selected hotel room
	public void departGuestFromHotelRoom(HotelRoom hotelRoom) {
		hotelRoomService.departGuestFromHotelRoom(hotelRoom);
	}

	// + Change status selected hotel room
	public void changeStatus(HotelRoom hotelRoom) {
		hotelRoomService.changeStatus(hotelRoom);
	}

	// + Add room to array rooms
	public void addRooms(HotelRoom room) {
		hotelRoomService.addRooms(room);
	}

	// + change room price of selected room
	public void changePriceOfHotelRoom(HotelRoom hotelRoom, int roomPrice) {
		hotelRoomService.changePriceOfHotelRoom(hotelRoom, roomPrice);
		;
	}

	// ///////////////////
	// /// Guest Methods//
	// ///////////////////

	// + get all guest sorted by alphabet / date of departure
	public void showAllGuests(String a) {
		guestService.showAllGuests(a);
	}

	// + add guest to array Guest
	public void addAllGuests(Guest guest) {
		guestService.addAllGuests(guest);
	}

	// + show number of all guest
	public void showAllGuestNumber() {
		guestService.showAllGuestNumber();
	}

	// + show summ to paid guest
	public void showSummToPaidGuest(Guest guest) {
		guestService.showSummToPaidGuest(guest);
	}

	// + show services of selected guest and price sorted by date and price
	public void showListOfService(Guest guest, String sortCondition) {
		guestService.showListOfService(guest, sortCondition);
	}

	// add service to selected guest
	public void addServiceToGuest(Guest guest, Service service) {
		guestService.addServiceToGuest(guest, service);
	}

	public ArrayList<Guest> getAllGuests() {
		return guestService.getAllGuests();
	}

	// /////////////////////
	// /// Service Methods//
	// /////////////////////
	// + add service to array servises
	public void addServices(Service service) {
		serviceService.addServices(service);
	}

	// +change price of service
	public void changePriceOfService(Service service, int price) {
		serviceService.changePriceOfService(service, price);
	}
}
