package com.danco.serviñe;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.model.Guest;
import com.danco.model.HotelRoom;
import com.danco.storages.MainStorage;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomService.
 */
public class HotelRoomService {

	/** The main storage. */
	private MainStorage mainStorage = MainStorage.getInstance();

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(HotelRoomService.class.getName());

	/** The instance. */
	private static HotelRoomService instance;

	/**
	 * Gets the single instance of HotelRoomService.
	 *
	 * @return single instance of HotelRoomService
	 */
	public static HotelRoomService getInstance() {
		if (instance == null) {
			instance = new HotelRoomService();
		}
		return instance;
	}

	/**
	 * Instantiates a new hotel room service.
	 */
	private HotelRoomService() {

	}

	/**
	 * Creates the hotel room.
	 *
	 * @param name
	 *            the name
	 * @param roomPrice
	 *            the room price
	 * @param sleepingNumbers
	 *            the sleeping numbers
	 * @param starCategory
	 *            the star category
	 * @return the hotel room
	 */
	public HotelRoom createHotelRoom(String name, int roomPrice, int sleepingNumbers, int starCategory) {

		try {
			return mainStorage.createHotelRoom(name, roomPrice, sleepingNumbers, starCategory);
		} catch (Exception e) {
			LOG1.error("Exception", e);
			return null;
		}
	}

	/**
	 * Gets the hotel room by number.
	 *
	 * @param NumberOfRoom
	 *            the number of room
	 * @return the hotel room by number
	 */
	public HotelRoom getHotelRoomByNumber(String NumberOfRoom) {

		try {
			return mainStorage.getHotelRoomByNumber(NumberOfRoom);
		} catch (Exception e) {
			LOG1.error("Exception", e);
			return null;
		}
	}

	/**
	 * Show all roms.
	 *
	 * @param sortCondition
	 *            the sort condition
	 * @param free
	 *            the free
	 */

	public List<HotelRoom> showAllRooms(String sortCondition, String free) {
		try {
			return mainStorage.showAllRooms(sortCondition, free);
		} catch (Exception e) {
			LOG1.error("Exception", e);
			return null;
		}
	}

	/**
	 * Show free roms after date.
	 *
	 * @param sortCondition
	 *            the sort condition
	 * @param date
	 *            the date
	 */

	public List<HotelRoom> showFreeRomsAfterDate(String sortCondition, Date date) {
		try {
			return mainStorage.showFreeRomsAfterDate(sortCondition, date);
		} catch (Exception e) {
			LOG1.error("Not correct date", e);
			return null;
		}
	}

	/**
	 * Show number of free hotel rooms.
	 */

	public int showNumberOfFreeHotelRooms() {
		try {
		return	mainStorage.showNumberOfFreeHotelRooms();
		} catch (Exception e) {
			LOG1.error("Exception", e);
			return 0;
		}
	}

	/**
	 * Show last3 guest of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 */

	public List<Guest> showLast3GuestOfHotelRoom(HotelRoom hotelRoom) {
		try {
			return mainStorage.showLast3GuestOfHotelRoom(hotelRoom);
		} catch (Exception e) {
			LOG1.error("Wrong hotel room name", e);
		}
		return null;
	}

	/**
	 * Show detail of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 */

	public String showDetailOfHotelRoom(HotelRoom hotelRoom) {
		try {
			return mainStorage.showDetailOfHotelRoom(hotelRoom);
		} catch (Exception e) {
			LOG1.error("Wrong hotel room name", e);
		}
		return null;
		
	}

	/**
	 * Settle guest to hotel room.
	 *
	 * @param guest
	 *            the guest
	 * @param hotelRoom
	 *            the hotel room
	 * @param dateOfArrive
	 *            the date of arrive
	 * @param dateOfDeparture
	 *            the date of departure
	 */

	public void settleGuestToHotelRoom(Guest guest, HotelRoom hotelRoom, Date dateOfArrive, Date dateOfDeparture) {
		try {

			mainStorage.settleGuestToHotelRoom(guest, hotelRoom, dateOfArrive, dateOfDeparture);
		} catch (Exception e) {
			LOG1.error("input does not exist", e);
		}

	}

	/**
	 * Depart guest from hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 */

	public void departGuestFromHotelRoom(HotelRoom hotelRoom) {
		try {
			mainStorage.departGuestFromHotelRoom(hotelRoom);
		} catch (Exception e) {
			LOG1.error("Wrong hotel room name", e);
		}
	}

	/**
	 * Change status.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 */

	public void changeStatus(HotelRoom hotelRoom) {
		try {
			mainStorage.changeStatus(hotelRoom);
		} catch (Exception e) {
			LOG1.error("Wrong hotel room name", e);
		}

	}

	/**
	 * Adds the rooms.
	 *
	 * @param room
	 *            the room
	 */

	public void addRooms(HotelRoom room) {
		try {
			mainStorage.addRooms(room);
		} catch (Exception e) {
			LOG1.error("Exception", e);
		}
	}

	/**
	 * Change price of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 * @param roomPrice
	 *            the room price
	 */

	public void changePriceOfHotelRoom(HotelRoom hotelRoom, int roomPrice) {
		try {
			mainStorage.changePriceOfHotelRoom(hotelRoom, roomPrice);
		} catch (Exception e) {
			LOG1.error("Wrong hotel room name", e);
		}
	}

	/**
	 * Show price services.
	 */

	public List<HotelRoom> showPriceHotelRoom() {
		try {
			return mainStorage.showPriceHotelRoom();
		} catch (Exception e) {
			LOG1.error("Exception", e);
			return null;
		}
	}

	/**
	 * Clone.
	 *
	 * @param room
	 *            the room
	 * @return the hotel room
	 * @throws CloneNotSupportedException
	 *             the clone not supported exception
	 */
	public HotelRoom cloneHotelRoom(HotelRoom room) {
		try {
			return mainStorage.cloneHotelRoom(room);
		} catch (Exception e) {
			LOG1.error("Exception", e);
			return null;
		}
	}

}
