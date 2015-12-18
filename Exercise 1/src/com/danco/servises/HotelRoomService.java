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
	public ArrayList<HotelRoom> getRooms() {
		return hotelRoomStorage.getRooms();
	}

	// Add room to array rooms
	public void AddRooms(HotelRoom room) {
		hotelRoomStorage.setRooms(room);
	}

	// TODO
	public void showDetailOfHotelRoom(HotelRoom hotelRoom) {
		hotelRoom.toString();

	}

	// settle guest to hotel room
	// TODO adding date of settle and date of departure
	public void settleGuestToHotelRoom(Guest guest, HotelRoom hotelRoom) {
		hotelRoomStorage.settleGuestToHotelRoom(guest, hotelRoom);

	}

	// depart all guest from hotel number
	public void departGuestFromHotelRoom(HotelRoom hotelRoom) {
		hotelRoomStorage.departGuestFromHotelRoom(hotelRoom);
	}

	// show last 3 guest of hotel room
	public void showLast3GuestOfHotelRoom(HotelRoom hotelRoom) {
		hotelRoomStorage.showLast3GuestOfHotelRoom(hotelRoom);
	}

	public void showPriceHotelRoom() {
		hotelRoomStorage.showPriceHotelRoom();
	}
}
