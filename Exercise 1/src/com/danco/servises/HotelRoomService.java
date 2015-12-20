package com.danco.servises;

import java.util.ArrayList;

import com.danco.models.Guest;
import com.danco.models.HotelRoom;
import com.danco.storages.HotelRoomStorage;

public class HotelRoomService {
	HotelRoomStorage hotelRoomStorage = HotelRoomStorage.getInstance();

	// singleton
	private static volatile HotelRoomService instance;

	private HotelRoomService() {
	}

	public static HotelRoomService getInstance() {
		if (instance == null) {
			synchronized (HotelRoomService.class) {
				if (instance == null) {
					instance = new HotelRoomService();
				}

			}
		}
		return instance;
	}

	// TODO get array of Hotel rooms (Sorted by price/sleeping numbers/star
	// category)
	public ArrayList<HotelRoom> showAllRoms() {
		return hotelRoomStorage.showAllRooms();
	}

	// TODO get array of free rooms (Sorted by price/sleeping numbers/star
	// category)
	public ArrayList<HotelRoom> showFreeRoms() {
		return hotelRoomStorage.showFreeRoms();
	}

	// TODO get array of free rooms after date (not sorded)
	public ArrayList<HotelRoom> showFreeRomsAfterDate() {
		return hotelRoomStorage.showFreeRomsAfterDate();
	}

	// show number of all free rooms
	public void showNumberOfFreeHotelRooms() {
		hotelRoomStorage.showNumberOfFreeHotelRooms();
	}

	// +show last 3 guest of hotel room
	public void showLast3GuestOfHotelRoom(HotelRoom hotelRoom) {
		hotelRoomStorage.showLast3GuestOfHotelRoom(hotelRoom);
	}

	// +
	public void showPriceHotelRoom() {
		hotelRoomStorage.showPriceHotelRoom();
	}

	// +
	public void showDetailOfHotelRoom(HotelRoom hotelRoom) {
		hotelRoomStorage.showDetailOfHotelRoom(hotelRoom);

	}

	// + settle guest to hotel room
	public void settleGuestToHotelRoom(Guest guest, HotelRoom hotelRoom) {
		hotelRoomStorage.settleGuestToHotelRoom(guest, hotelRoom);

	}

	// +depart all guest from hotel number
	public void departGuestFromHotelRoom(HotelRoom hotelRoom) {
		hotelRoomStorage.departGuestFromHotelRoom(hotelRoom);
	}

	// +
	public void changeStatus(HotelRoom hotelRoom) {
		hotelRoomStorage.changeStatus(hotelRoom);
	}

	// + Add room to array rooms
	public void AddRooms(HotelRoom room) {
		hotelRoomStorage.setRooms(room);
	}

	// + change room price of selected room
	public void changePriceOfHotelRoom(HotelRoom hotelRoom, int roomPrice) {
		hotelRoomStorage.changePriceOfHotelRoom(hotelRoom, roomPrice);
		;
	}

	// +
	public void setDateOfArrival(String dateOfArrival, HotelRoom hotelRoom) {
		hotelRoomStorage.setDateOfArrival(dateOfArrival, hotelRoom);
	}

	// +
	public void setDateOfDeparture(String dateOfDeparture, HotelRoom hotelRoom) {
		hotelRoomStorage.setDateOfDeparture(dateOfDeparture, hotelRoom);
	}
}