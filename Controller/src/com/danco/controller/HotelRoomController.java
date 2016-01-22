package com.danco.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.danco.model.Guest;
import com.danco.model.HotelRoom;
import com.danco.properties.PropertyManager;
import com.danco.serviñe.GuestService;
import com.danco.serviñe.HotelRoomService;
import com.danco.util.InputManager;
import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomController.
 */
public class HotelRoomController {

	/** The hotel room service. */
	private HotelRoomService hotelRoomService = HotelRoomService.getInstance();

	private PrintUtil printUtil = new PrintUtil();

	/** The Constant HOTEL_ROOM_INPUT_MESSAGE. */
	private static final String HOTEL_ROOM_INPUT_MESSAGE = "Enter hotel room number";
	

	/** The Constant HOTEL_ROOM_INPUT_MESSAGE. */
	private static final String NEW_HOTEL_ROOM_INPUT_MESSAGE = "Enter new room number";

	/** The Constant PRICE_INPUT_MESSAGE. */
	private static final String PRICE_INPUT_MESSAGE = "Write room price";

	/** The Constant PRICE_INPUT_MESSAGE. */
	private static final String PRICE_INPUT_MESSAGE1 = "Enter new price of hotel room";

	/** The Constant SLEEPING_NUMBERS_INPUT_MESSAGE. */
	private static final String SLEEPING_NUMBERS_INPUT_MESSAGE = "Write sleeping numbers";

	/** The Constant STAR_CATEGORY_INPUT_MESSAGE. */
	private static final String STAR_CATEGORY_INPUT_MESSAGE = "Write star category";

	/** The Constant GUEST_INPUT_MESSAGE. */
	private static final String GUEST_INPUT_MESSAGE = "Enter guest name";

	/** The Constant DATE_ARRIVE_INPUT_MESSAGE. */
	private static final String DATE_ARRIVE_INPUT_MESSAGE = "Enter date of Arrive / year-month-day  :  yyyy-MM-dd";

	/** The Constant DATE_DEPARTURE_INPUT_MESSAGE. */
	private static final String DATE_DEPARTURE_INPUT_MESSAGE = "Enter date of Departure / year-month-day  :  yyyy-MM-dd";

	/** The Constant SORT_INPUT_MESSAGE. */
	private static final String SORT_INPUT_MESSAGE = "Enter room sort condition : price/sleepN/star";

	/** The Constant FREE. */
	private static final String FREE = "free";

	/** The Constant FREE. */
	private static final String FREE1 = "";

	/** The Constant DATE_INPUT_MESSAGE. */
	private static final String DATE_INPUT_MESSAGE = "Enter date / year-month-day  :  yyyy-MM-dd";

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

	/** The df. */
	private static final DateFormat DF = new SimpleDateFormat(DATE_FORMAT);

	/** The Constant ROOM_PRINTER_FORMAT. */
	private static final String ROOM_PRINTER_FORMAT = "room: %s  , sleeping numbers: %d,  stars category: %d,  price: %d";
	
	/** The Constant ROOM_PRINTER_FORMAT. */
	private static final String MODIFY_QUESTION = "Modify? YES/NO";

	/**
	 * Show all roms.
	 *
	 * @param sortCondition
	 *            the sort condition
	 * @param free
	 *            the free
	 */

	public void showAllRooms() {

		printUtil.printString(SORT_INPUT_MESSAGE);

		String userInputSortCondition = InputManager.getInstance().userInputString();

		List<HotelRoom> freeRooms =  hotelRoomService.showAllRooms(userInputSortCondition, FREE1);
		
		for (HotelRoom s : freeRooms) {
			printUtil.printString(String.format(ROOM_PRINTER_FORMAT, s.getNumber(), s.getSleepingNumbers(),
					s.getStarCategory(), s.getRoomPrice()));
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

	public void showAllFreeRooms() {

		printUtil.printString(SORT_INPUT_MESSAGE);

		String userInputSortCondition = InputManager.getInstance().userInputString();
		List<HotelRoom> freeRooms = hotelRoomService.showAllRooms(userInputSortCondition, FREE);

		for (HotelRoom s : freeRooms) {
			printUtil.printString(String.format(ROOM_PRINTER_FORMAT, s.getNumber(), s.getSleepingNumbers(),
					s.getStarCategory(), s.getRoomPrice()));
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

	public void showFreeRomsAfterDate() {
		printUtil.printString(SORT_INPUT_MESSAGE);
		String userInputSortCondition = InputManager.getInstance().userInputString();

		printUtil.printString(DATE_INPUT_MESSAGE);
		Date date = InputManager.getInstance().userInputDate();

		List<HotelRoom> freeRoomsAfterDate=hotelRoomService.showFreeRomsAfterDate(userInputSortCondition, date);
		
		for (HotelRoom s : freeRoomsAfterDate) {
			printUtil.printString(String.format(ROOM_PRINTER_FORMAT, s.getNumber(), s.getSleepingNumbers(),
					s.getStarCategory(), s.getRoomPrice()));
		}
	}

	/**
	 * Show number of free hotel rooms.
	 */

	public void showNumberOfFreeHotelRooms() {
		int n = hotelRoomService.showNumberOfFreeHotelRooms();

		printUtil.printString(String.format(FREE_ROOM_NUMB_FORMAT, n));

	}

	/**
	 * Show last3 guest of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 */

	public void showLast3GuestOfHotelRoom() {

		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);

		String userInputHotelRoomNumber = InputManager.getInstance().userInputString();
		HotelRoom hr = HotelRoomService.getInstance().getHotelRoomByNumber(userInputHotelRoomNumber);

		List<Guest> last3Guest = hotelRoomService.showLast3GuestOfHotelRoom(hr);

		StringBuilder sb = new StringBuilder(500).append(String.format(LAST_3_GUEST_FORMAT, hr.getNumber()));

		for (Guest a : last3Guest) {
			sb.append(String.format(LAST_GUEST_FORMAT, a.getName(), DF.format(a.getDateOfArrive()),
					DF.format(a.getDateOfDeparture())));

		}
		printUtil.printString(sb.toString());
	}

	/**
	 * Show detail of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 */

	public void showDetailOfHotelRoom() {

		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);

		String userInputHotelRoomNumber = InputManager.getInstance().userInputString();
		HotelRoom hr = HotelRoomService.getInstance().getHotelRoomByNumber(userInputHotelRoomNumber);

		String detail = hotelRoomService.showDetailOfHotelRoom(hr);

		printUtil.printString(detail);

	}

	public void showPriceHotelRoom() {

		List<HotelRoom> sortedHotelRoom = hotelRoomService.showPriceHotelRoom();
		StringBuilder sb = new StringBuilder(100);
		for (HotelRoom s : sortedHotelRoom) {
			sb.append(String.format(HOTEL_ROOM_FORMAT, s.getNumber(), s.getRoomPrice()));
		}
		printUtil.printString(sb.toString());
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

	public void settleGuestToHotelRoom() {

		printUtil.printString(GUEST_INPUT_MESSAGE);
		String userInputGuestName = InputManager.getInstance().userInputString();
		Guest g = GuestService.getInstance().getGuestByName(userInputGuestName);

		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);
		String userInputHotelRoomNumber = InputManager.getInstance().userInputString();
		HotelRoom hr = HotelRoomService.getInstance().getHotelRoomByNumber(userInputHotelRoomNumber);

		printUtil.printString(DATE_ARRIVE_INPUT_MESSAGE);
		Date userinpitDateOfArrive = InputManager.getInstance().userInputDate();

		printUtil.printString(DATE_DEPARTURE_INPUT_MESSAGE);
		Date userInputDateOfDeparture = InputManager.getInstance().userInputDate();

		HotelRoomService.getInstance().settleGuestToHotelRoom(g, hr, userinpitDateOfArrive, userInputDateOfDeparture);

		hotelRoomService.settleGuestToHotelRoom(g, hr, userinpitDateOfArrive, userInputDateOfDeparture);
	}

	/**
	 * Depart guest from hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 */

	public void departGuestFromHotelRoom() {

		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);
		String userInputHotelRoomNumber = InputManager.getInstance().userInputString();
		HotelRoom hr = HotelRoomService.getInstance().getHotelRoomByNumber(userInputHotelRoomNumber);

		hotelRoomService.departGuestFromHotelRoom(hr);
	}

	/**
	 * Change status.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 */

	public void changeStatus() {
		
		boolean statusChangeProperty = PropertyManager.getInstance().getStatusChangeProperty();
		if(statusChangeProperty==true){
		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);

		String userInputHotelRoomNumber = InputManager.getInstance().userInputString();
		HotelRoom hr = HotelRoomService.getInstance().getHotelRoomByNumber(userInputHotelRoomNumber);

		hotelRoomService.changeStatus(hr);}
		else{
		System.out.println("Blocked by property manager");
		}
	}

	/**
	 * Adds the rooms.
	 *
	 * @param room
	 *            the room
	 */

	public void addRooms() {

		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);
		String userInputHotelRoomName = InputManager.getInstance().userInputString();

		printUtil.printString(PRICE_INPUT_MESSAGE);
		int userInputRoomPrice = InputManager.getInstance().userInputInt();

		printUtil.printString(SLEEPING_NUMBERS_INPUT_MESSAGE);
		int userInputSleepingNumbers = InputManager.getInstance().userInputInt();

		printUtil.printString(STAR_CATEGORY_INPUT_MESSAGE);
		int userInputStarCategory = InputManager.getInstance().userInputInt();

		HotelRoom hr = HotelRoomService.getInstance().createHotelRoom(userInputHotelRoomName, userInputRoomPrice,
				userInputSleepingNumbers, userInputStarCategory);

		hotelRoomService.addRooms(hr);
	}

	/**
	 * Change price of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 * @param roomPrice
	 *            the room price
	 */

	public void changePriceOfHotelRoom() {

		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);
		String userInputHotelRoomNumber = InputManager.getInstance().userInputString();
		HotelRoom hr = HotelRoomService.getInstance().getHotelRoomByNumber(userInputHotelRoomNumber);

		printUtil.printString(PRICE_INPUT_MESSAGE1);
		int userInputRoomPrice = InputManager.getInstance().userInputInt();

		hotelRoomService.changePriceOfHotelRoom(hr, userInputRoomPrice);
	}

	/**
	 * Clone.
	 *
	 * @param room
	 *            the room
	 * @return the hotel room
	 */
	public void cloneHotelRoom() {

		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);

		String userInputHotelRoomNumber = InputManager.getInstance().userInputString();
		HotelRoom hr = HotelRoomService.getInstance().getHotelRoomByNumber(userInputHotelRoomNumber);
		HotelRoom hotelRoom = hotelRoomService.cloneHotelRoom(hr);
		
		printUtil.printString(NEW_HOTEL_ROOM_INPUT_MESSAGE);
		String userInputHotelRoomNumberModify = InputManager.getInstance().userInputString();
		hotelRoom.setNumber(userInputHotelRoomNumberModify);
		
		printUtil.printString(MODIFY_QUESTION);
		String modify = InputManager.getInstance().userInputString();
		if (modify.equals("YES")){
	    printUtil.printString(PRICE_INPUT_MESSAGE);	
	    int roomPriceModify = InputManager.getInstance().userInputInt();
		hotelRoom.setRoomPrice(roomPriceModify);
		printUtil.printString(SLEEPING_NUMBERS_INPUT_MESSAGE);	
	    int sleepingNumberModify = InputManager.getInstance().userInputInt();
		hotelRoom.setSleepingNumbers(sleepingNumberModify);
		printUtil.printString(STAR_CATEGORY_INPUT_MESSAGE);	
	    int starModify = InputManager.getInstance().userInputInt();
		hotelRoom.setStarCategory(starModify);
		}
		// TODO write methods to format room
		hotelRoomService.addRooms(hotelRoom);
	}

}
