package com.danco.servises;

import com.danco.gloomezis.MainStorage;
import com.danco.models.Guest;
import com.danco.models.HotelRoom;

public class HotelRoomService {
	MainStorage mainStorage= MainStorage.getInstance();


	//  get array of Hotel rooms (Sorted by price/sleeping numbers/star
	// category)
	public void showAllRoms(String sortCondition, String free) {
		mainStorage.showAllRooms(sortCondition, free);
	}

	// TODO get array of free rooms after date (not sorded)
	public void showFreeRomsAfterDate(String sortCondition, String date) {
		mainStorage.showFreeRomsAfterDate(sortCondition, date);
	}

	// show number of all free rooms
	public void showNumberOfFreeHotelRooms() {
		mainStorage.showNumberOfFreeHoterRooms();
	}

	// +show last 3 guest of hotel room
	public void showLast3GuestOfHotelRoom(HotelRoom hotelRoom) {
		mainStorage.showLast3GuestOfHotelRoom(hotelRoom);
	}

	
	// +
	public void showDetailOfHotelRoom(HotelRoom hotelRoom) {
		mainStorage.showDetailOfHotelRoom(hotelRoom);

	}

	// + settle guest to hotel room
	public void settleGuestToHotelRoom(Guest guest, HotelRoom hotelRoom,String dateOfArrive, String dateOfDeparture) {
		mainStorage.settleGuestToHotelRoom(guest, hotelRoom,dateOfArrive,dateOfDeparture);

	}

	// +depart all guest from hotel number
	public void departGuestFromHotelRoom(HotelRoom hotelRoom) {
		mainStorage.departGuestFromHotelRoom(hotelRoom);
	}

	// +
	public void changeStatus(HotelRoom hotelRoom) {
		mainStorage.changeStatus(hotelRoom);
	}

	// + Add room to array rooms
	public void addRooms(HotelRoom room) {
		mainStorage.addRooms(room);
	}

	// + change room price of selected room
	public void changePriceOfHotelRoom(HotelRoom hotelRoom, int roomPrice) {
		mainStorage.changePriceOfHotelRoom(hotelRoom, roomPrice);
		;
	}
}
	
	
