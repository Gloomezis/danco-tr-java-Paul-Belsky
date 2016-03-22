package com.danco.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Guest;
import com.danco.model.HotelRoom;
import com.danco.properties.PropertyManager;
import com.danco.servise.api.IGuestService;
import com.danco.servise.api.IHotelRoomService;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomController.
 */
public class HotelRoomController {

	/** The hotel room service. */
	private IHotelRoomService hotelRoomService = (IHotelRoomService) DependencyInjectionManager
			.getClassInstance(IHotelRoomService.class);

	/** The guest service. */
	private IGuestService guestService = (IGuestService) DependencyInjectionManager
			.getClassInstance(IGuestService.class);

	/** The Constant FREE. */
	private static final String FREE = "free";

	/** The Constant FREE1. */
	private static final String FREE1 = "";

	/** The Constant HOTEL_ROOM_FORMAT. */
	private static final String HOTEL_ROOM_FORMAT = "Hotel room: %s, price: %d \n";

	/** The Constant FREE_ROOM_NUMB_FORMAT. */
	private static final String FREE_ROOM_NUMB_FORMAT = "free room: %d";

	/** The Constant LAST_3_GUEST_FORMAT. */
	private static final String LAST_3_GUEST_FORMAT = "The last 3 guest of hotel room: %s \n";

	/** The Constant LAST_GUEST_FORMAT. */
	private static final String LAST_GUEST_FORMAT = " Name : %s, arrive: %s , depart : %s \n";

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "dd-MM-yyyy";

	/** The Constant DF. */
	private static final DateFormat DF = new SimpleDateFormat(DATE_FORMAT);

	/** The Constant ROOM_PRINTER_FORMAT. */
	private static final String ROOM_PRINTER_FORMAT = "room: %s  , sleeping numbers: %d,  stars category: %d,  price: %d \n";

	/**
	 * Show all rooms.
	 *
	 * @param userInputSortCondition the user input sort condition
	 * @return the string
	 */

	public String showAllRooms(String userInputSortCondition) {
		StringBuilder sb = new StringBuilder();

		List<HotelRoom> freeRooms = hotelRoomService.showAllRooms(
				userInputSortCondition, FREE1);

		for (HotelRoom s : freeRooms) {
			sb.append(String.format(ROOM_PRINTER_FORMAT, s.getNumber(),
					s.getSleepingNumbers(), s.getStarCategory(),
					s.getRoomPrice()));
		}
		return sb.toString();
	}

	/**
	 * Show all free rooms.
	 *
	 * @param userInputSortCondition the user input sort condition
	 * @return the string
	 */

	public String showAllFreeRooms(String userInputSortCondition) {
		StringBuilder sb = new StringBuilder();

		List<HotelRoom> freeRooms = hotelRoomService.showAllRooms(
				userInputSortCondition, FREE);

		for (HotelRoom s : freeRooms) {
			sb.append(String.format(ROOM_PRINTER_FORMAT, s.getNumber(),
					s.getSleepingNumbers(), s.getStarCategory(),
					s.getRoomPrice()));
		}
		return sb.toString();
	}

	/**
	 * Show free roms after date.
	 *
	 * @param userInputSortCondition the user input sort condition
	 * @param date the date
	 * @return the string
	 */

	public String showFreeRomsAfterDate(String userInputSortCondition, Date date) {
		StringBuilder sb = new StringBuilder();

		List<HotelRoom> freeRoomsAfterDate = hotelRoomService
				.showFreeRomsAfterDate(userInputSortCondition, date);

		for (HotelRoom s : freeRoomsAfterDate) {
			sb.append(String.format(ROOM_PRINTER_FORMAT, s.getNumber(),
					s.getSleepingNumbers(), s.getStarCategory(),
					s.getRoomPrice()));
		}
		return sb.toString();
	}

	/**
	 * Show number of free hotel rooms.
	 *
	 * @return the string
	 */

	public String showNumberOfFreeHotelRooms() {
		int n = hotelRoomService.showNumberOfFreeHotelRooms();

		return String.format(FREE_ROOM_NUMB_FORMAT, n);

	}

	/**
	 * Show last3 guest of hotel room.
	 *
	 * @param userInputHotelRoomNumber the user input hotel room number
	 * @return the string
	 */

	public String showLast3GuestOfHotelRoom(String userInputHotelRoomNumber) {

		HotelRoom hr = hotelRoomService
				.getHotelRoomByNumber(userInputHotelRoomNumber);

		List<Guest> last3Guest = hotelRoomService.showLast3GuestOfHotelRoom(hr);

		StringBuilder sb = new StringBuilder(500).append(String.format(
				LAST_3_GUEST_FORMAT, hr.getNumber()));

		for (Guest a : last3Guest) {
			sb.append(String.format(LAST_GUEST_FORMAT, a.getName(),
					DF.format(a.getDateOfArrive()),
					DF.format(a.getDateOfDeparture())));

		}
		return sb.toString();
	}

	/**
	 * Show detail of hotel room.
	 *
	 * @param userInputHotelRoomNumber the user input hotel room number
	 * @return the string
	 */

	public String showDetailOfHotelRoom(String userInputHotelRoomNumber) {

		HotelRoom hr = hotelRoomService
				.getHotelRoomByNumber(userInputHotelRoomNumber);

		String detail = hotelRoomService.showDetailOfHotelRoom(hr);

		return detail;

	}

	/**
	 * Show price hotel room.
	 *
	 * @return the string
	 */
	public String showPriceHotelRoom() {

		List<HotelRoom> sortedHotelRoom = hotelRoomService.showPriceHotelRoom();
		StringBuilder sb = new StringBuilder(100);
		for (HotelRoom s : sortedHotelRoom) {
			sb.append(String.format(HOTEL_ROOM_FORMAT, s.getNumber(),
					s.getRoomPrice()));
		}
		return sb.toString();
	}

	/**
	 * Settle guest to hotel room.
	 *
	 * @param userInputGuestName the user input guest name
	 * @param userInputHotelRoomNumber the user input hotel room number
	 * @param userinpitDateOfArrive the userinpit date of arrive
	 * @param userInputDateOfDeparture the user input date of departure
	 */

	public synchronized void settleGuestToHotelRoom(String userInputGuestName,
			String userInputHotelRoomNumber, Date userinpitDateOfArrive,
			Date userInputDateOfDeparture) {

		Guest g = guestService.getGuestByName(userInputGuestName);

		HotelRoom hr = hotelRoomService
				.getHotelRoomByNumber(userInputHotelRoomNumber);

		hotelRoomService.settleGuestToHotelRoom(g, hr, userinpitDateOfArrive,
				userInputDateOfDeparture);

	}

	/**
	 * Depart guest from hotel room.
	 *
	 * @param userInputHotelRoomName the user input hotel room name
	 */

	public synchronized void departGuestFromHotelRoom(String userInputHotelRoomName) {

		HotelRoom hr = hotelRoomService
				.getHotelRoomByNumber(userInputHotelRoomName);

		hotelRoomService.departGuestFromHotelRoom(hr);
	}

	/**
	 * Change status.
	 *
	 * @param userInputHotelRoomName the user input hotel room name
	 */

	public synchronized void changeStatus(String userInputHotelRoomName) {

		boolean statusChangeProperty = PropertyManager.getInstance()
				.getStatusChangeProperty();
		if (statusChangeProperty == true) {

			HotelRoom hr = hotelRoomService
					.getHotelRoomByNumber(userInputHotelRoomName);

			hotelRoomService.changeStatus(hr);
		} else {
			System.out.println("Blocked by property manager");
		}
	}

	/**
	 * Adds the rooms.
	 *
	 * @param userInputHotelRoomName the user input hotel room name
	 * @param userInputRoomPrice the user input room price
	 * @param userInputSleepingNumbers the user input sleeping numbers
	 * @param userInputStarCategory the user input star category
	 */

	public void addRooms(String userInputHotelRoomName, int userInputRoomPrice,
			int userInputSleepingNumbers, int userInputStarCategory) {

		HotelRoom hr = hotelRoomService.createHotelRoom(userInputHotelRoomName,
				userInputRoomPrice, userInputSleepingNumbers,
				userInputStarCategory);

		hotelRoomService.addRooms(hr);
	}

	/**
	 * Change price of hotel room.
	 *
	 * @param userInputHotelRoomName the user input hotel room name
	 * @param userInputRoomPrice the user input room price
	 */

	public synchronized void changePriceOfHotelRoom(String userInputHotelRoomName,
			int userInputRoomPrice) {

		HotelRoom hr = hotelRoomService
				.getHotelRoomByNumber(userInputHotelRoomName);

		hotelRoomService.changePriceOfHotelRoom(hr, userInputRoomPrice);
	}

	/**
	 * Clone hotel room.
	 *
	 * @param userInputHotelRoomName the user input hotel room name
	 * @param userInputHotelRoomNumberModify the user input hotel room number modify
	 * @param modify the modify
	 * @param roomPriceModify the room price modify
	 * @param sleepingNumberModify the sleeping number modify
	 * @param starModify the star modify
	 */
	public void cloneHotelRoom(String userInputHotelRoomName,
			String userInputHotelRoomNumberModify, String modify,
			int roomPriceModify, int sleepingNumberModify, int starModify) {

		HotelRoom hr = hotelRoomService
				.getHotelRoomByNumber(userInputHotelRoomName);
		HotelRoom hotelRoom = hotelRoomService.cloneHotelRoom(hr);

		hotelRoom.setNumber(userInputHotelRoomNumberModify);

		if ("YES".equals(modify)) {

			hotelRoom.setRoomPrice(roomPriceModify);

			hotelRoom.setSleepingNumbers(sleepingNumberModify);

			hotelRoom.setStarCategory(starModify);
		}
		// TODO write methods to format room
		hotelRoomService.addRooms(hotelRoom);
	}

}
