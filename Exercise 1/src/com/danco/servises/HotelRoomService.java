package com.danco.servises;

import java.util.Date;

import com.danco.gloomezis.MainStorage;
import com.danco.models.Guest;
import com.danco.models.HotelRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomService.
 */
public class HotelRoomService {
	
	/** The main storage. */
	MainStorage mainStorage = MainStorage.getInstance();

	
	/**
	 * Show all roms.
	 *
	 * @param sortCondition the sort condition
	 * @param free the free
	 */
	
	public void showAllRoms(String sortCondition, String free) {
		mainStorage.showAllRooms(sortCondition, free);
	}

	/**
	 * Show free roms after date.
	 *
	 * @param sortCondition the sort condition
	 * @param date the date
	 */
	
	public void showFreeRomsAfterDate(String sortCondition, Date date) {
		mainStorage.showFreeRomsAfterDate(sortCondition, date);
	}

	/**
	 * Show number of free hotel rooms.
	 */
	
	public void showNumberOfFreeHotelRooms() {
		mainStorage.showNumberOfFreeHoterRooms();
	}

	/**
	 * Show last3 guest of hotel room.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void showLast3GuestOfHotelRoom(HotelRoom hotelRoom) {
		mainStorage.showLast3GuestOfHotelRoom(hotelRoom);
	}

	/**
	 * Show detail of hotel room.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void showDetailOfHotelRoom(HotelRoom hotelRoom) {
		mainStorage.showDetailOfHotelRoom(hotelRoom);

	}

	/**
	 * Settle guest to hotel room.
	 *
	 * @param guest the guest
	 * @param hotelRoom the hotel room
	 * @param dateOfArrive the date of arrive
	 * @param dateOfDeparture the date of departure
	 */
	
	public void settleGuestToHotelRoom(Guest guest, HotelRoom hotelRoom,
			Date dateOfArrive, Date dateOfDeparture) {
		mainStorage.settleGuestToHotelRoom(guest, hotelRoom, dateOfArrive,
				dateOfDeparture);

	}

	/**
	 * Depart guest from hotel room.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void departGuestFromHotelRoom(HotelRoom hotelRoom) {
		mainStorage.departGuestFromHotelRoom(hotelRoom);
	}

	/**
	 * Change status.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void changeStatus(HotelRoom hotelRoom) {
		mainStorage.changeStatus(hotelRoom);
	}

	/**
	 * Adds the rooms.
	 *
	 * @param room the room
	 */
	
	public void addRooms(HotelRoom room) {
		mainStorage.addRooms(room);
	}

	/**
	 * Change price of hotel room.
	 *
	 * @param hotelRoom the hotel room
	 * @param roomPrice the room price
	 */
	
	public void changePriceOfHotelRoom(HotelRoom hotelRoom, int roomPrice) {
		mainStorage.changePriceOfHotelRoom(hotelRoom, roomPrice);
		;
	}
}
