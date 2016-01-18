package com.danco.serviñe;

import java.util.Date;

import org.apache.log4j.Logger;

import com.danco.gloomezis.MainStorage;
import com.danco.model.Guest;
import com.danco.model.HotelRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomService.
 */
public class HotelRoomService {
	
	/** The main storage. */
	MainStorage mainStorage = MainStorage.getInstance();
	final Logger LOG1=Logger.getLogger(HotelRoomService.class.getName());

	
private static HotelRoomService instance;
	
	
	public static HotelRoomService getInstance() {
		if (instance == null) {
			instance = new HotelRoomService();
		}
		return instance;
	}
	
	
	private  HotelRoomService() {
		
	}
	
	/**
	 * Show all roms.
	 *
	 * @param sortCondition the sort condition
	 * @param free the free
	 */
	
	public void showAllRooms(String sortCondition, String free) {
		mainStorage.showAllRooms(sortCondition, free);
	}

	/**
	 * Show free roms after date.
	 *
	 * @param sortCondition the sort condition
	 * @param date the date
	 */
	
	public void showFreeRomsAfterDate(String sortCondition, Date date) {
		try {
		mainStorage.showFreeRomsAfterDate(sortCondition, date);
		} catch (NullPointerException e) {
			LOG1.error("Not correct date",e);
		}
	}

	/**
	 * Show number of free hotel rooms.
	 */
	
	public void showNumberOfFreeHotelRooms() {
		mainStorage.showNumberOfFreeHotelRooms();
	}

	/**
	 * Show last3 guest of hotel room.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void showLast3GuestOfHotelRoom(HotelRoom hotelRoom) {
		try {
		mainStorage.showLast3GuestOfHotelRoom(hotelRoom);
		} catch (NullPointerException e) {
			LOG1.error("Wrong hotel room name",e);
		}
	}

	/**
	 * Show detail of hotel room.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void showDetailOfHotelRoom(HotelRoom hotelRoom) {
		try {
		mainStorage.showDetailOfHotelRoom(hotelRoom);
		} catch (NullPointerException e) {
			LOG1.error("Wrong hotel room name",e);
		}
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
		try {
			
		
		mainStorage.settleGuestToHotelRoom(guest, hotelRoom, dateOfArrive,
				dateOfDeparture);
	} catch (NullPointerException e) {
		LOG1.error("input does not exist",e);
	}

	}

	/**
	 * Depart guest from hotel room.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void departGuestFromHotelRoom(HotelRoom hotelRoom) {
		try {
		mainStorage.departGuestFromHotelRoom(hotelRoom);
		} catch (NullPointerException e) {
			LOG1.error("Wrong hotel room name",e);
		}
	}

	/**
	 * Change status.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void changeStatus(HotelRoom hotelRoom) {
		try {
		mainStorage.changeStatus(hotelRoom);
		} catch (NullPointerException e) {
			LOG1.error("Wrong hotel room name",e);
		}
		
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
		try {
		mainStorage.changePriceOfHotelRoom(hotelRoom, roomPrice);
	} catch (NullPointerException e) {
		LOG1.error("Wrong hotel room name",e);
	}
	}
}
