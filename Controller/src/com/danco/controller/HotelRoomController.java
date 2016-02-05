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
import com.danco.utils.IInputManager;
import com.danco.utils.IPrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomController.
 */
public class HotelRoomController {

	/** The hotel room service. */
	private IHotelRoomService hotelRoomService = (IHotelRoomService)DependencyInjectionManager.getClassInstance(IHotelRoomService.class);
	
	/** The guest service. */
	private IGuestService guestService = (IGuestService)DependencyInjectionManager.getClassInstance(IGuestService.class);

	/** The print util. */
	private IPrintUtil printUtil = (IPrintUtil)DependencyInjectionManager.getClassInstance(IPrintUtil.class);
	
	/** The input manager. */
	private IInputManager inputManager = (IInputManager)DependencyInjectionManager.getClassInstance(IInputManager.class);

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
	 */

	public void showAllRooms() {

		printUtil.printString(SORT_INPUT_MESSAGE);

		String userInputSortCondition = inputManager.userInputString();

		List<HotelRoom> freeRooms =  hotelRoomService.showAllRooms(userInputSortCondition, FREE1);
		
		for (HotelRoom s : freeRooms) {
			printUtil.printString(String.format(ROOM_PRINTER_FORMAT, s.getNumber(), s.getSleepingNumbers(),
					s.getStarCategory(), s.getRoomPrice()));
			}
	}

	/**
	 * Show all roms.
	 */

	public void showAllFreeRooms() {

		printUtil.printString(SORT_INPUT_MESSAGE);

		String userInputSortCondition = inputManager.userInputString();
		List<HotelRoom> freeRooms = hotelRoomService.showAllRooms(userInputSortCondition, FREE);

		for (HotelRoom s : freeRooms) {
			printUtil.printString(String.format(ROOM_PRINTER_FORMAT, s.getNumber(), s.getSleepingNumbers(),
					s.getStarCategory(), s.getRoomPrice()));
		}
	}

	/**
	 * Show free roms after date.
	 */

	public void showFreeRomsAfterDate() {
		printUtil.printString(SORT_INPUT_MESSAGE);
		String userInputSortCondition = inputManager.userInputString();

		printUtil.printString(DATE_INPUT_MESSAGE);
		Date date = inputManager.userInputDate();

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
	 */

	public void showLast3GuestOfHotelRoom() {

		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);

		String userInputHotelRoomNumber = inputManager.userInputString();
		HotelRoom hr = hotelRoomService.getHotelRoomByNumber(userInputHotelRoomNumber);

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
	 */

	public void showDetailOfHotelRoom() {

		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);

		String userInputHotelRoomNumber = inputManager.userInputString();
		HotelRoom hr = hotelRoomService.getHotelRoomByNumber(userInputHotelRoomNumber);

		String detail = hotelRoomService.showDetailOfHotelRoom(hr);

		printUtil.printString(detail);

	}

	/**
	 * Show price hotel room.
	 */
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
	 */

	public void settleGuestToHotelRoom() {

		printUtil.printString(GUEST_INPUT_MESSAGE);
		String userInputGuestName = inputManager.userInputString();
		Guest g = guestService.getGuestByName(userInputGuestName);

		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);
		String userInputHotelRoomNumber = inputManager.userInputString();
		HotelRoom hr = hotelRoomService.getHotelRoomByNumber(userInputHotelRoomNumber);

		printUtil.printString(DATE_ARRIVE_INPUT_MESSAGE);
		Date userinpitDateOfArrive = inputManager.userInputDate();

		printUtil.printString(DATE_DEPARTURE_INPUT_MESSAGE);
		Date userInputDateOfDeparture = inputManager.userInputDate();

		hotelRoomService.settleGuestToHotelRoom(g, hr, userinpitDateOfArrive, userInputDateOfDeparture);

		hotelRoomService.settleGuestToHotelRoom(g, hr, userinpitDateOfArrive, userInputDateOfDeparture);
	}

	/**
	 * Depart guest from hotel room.
	 */

	public void departGuestFromHotelRoom() {

		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);
		String userInputHotelRoomNumber = inputManager.userInputString();
		HotelRoom hr = hotelRoomService.getHotelRoomByNumber(userInputHotelRoomNumber);

		hotelRoomService.departGuestFromHotelRoom(hr);
	}

	/**
	 * Change status.
	 */

	public void changeStatus() {
		
		boolean statusChangeProperty = PropertyManager.getInstance().getStatusChangeProperty();
		if(statusChangeProperty==true){
		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);

		String userInputHotelRoomNumber = inputManager.userInputString();
		HotelRoom hr = hotelRoomService.getHotelRoomByNumber(userInputHotelRoomNumber);

		hotelRoomService.changeStatus(hr);}
		else{
		System.out.println("Blocked by property manager");
		}
	}

	/**
	 * Adds the rooms.
	 */

	public void addRooms() {

		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);
		String userInputHotelRoomName = inputManager.userInputString();

		printUtil.printString(PRICE_INPUT_MESSAGE);
		int userInputRoomPrice = inputManager.userInputInt();

		printUtil.printString(SLEEPING_NUMBERS_INPUT_MESSAGE);
		int userInputSleepingNumbers = inputManager.userInputInt();

		printUtil.printString(STAR_CATEGORY_INPUT_MESSAGE);
		int userInputStarCategory = inputManager.userInputInt();

		HotelRoom hr = hotelRoomService.createHotelRoom(userInputHotelRoomName, userInputRoomPrice,
				userInputSleepingNumbers, userInputStarCategory);

		hotelRoomService.addRooms(hr);
	}

	/**
	 * Change price of hotel room.
	 */

	public void changePriceOfHotelRoom() {

		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);
		String userInputHotelRoomNumber = inputManager.userInputString();
		HotelRoom hr = hotelRoomService.getHotelRoomByNumber(userInputHotelRoomNumber);

		printUtil.printString(PRICE_INPUT_MESSAGE1);
		int userInputRoomPrice = inputManager.userInputInt();

		hotelRoomService.changePriceOfHotelRoom(hr, userInputRoomPrice);
	}

	/**
	 * Clone.
	 *
	 * @return the hotel room
	 */
	public void cloneHotelRoom() {

		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);

		String userInputHotelRoomNumber = inputManager.userInputString();
		HotelRoom hr = hotelRoomService.getHotelRoomByNumber(userInputHotelRoomNumber);
		HotelRoom hotelRoom = hotelRoomService.cloneHotelRoom(hr);
		
		printUtil.printString(NEW_HOTEL_ROOM_INPUT_MESSAGE);
		String userInputHotelRoomNumberModify = inputManager.userInputString();
		hotelRoom.setNumber(userInputHotelRoomNumberModify);
		
		printUtil.printString(MODIFY_QUESTION);
		String modify = inputManager.userInputString();
		if (modify.equals("YES")){
	    printUtil.printString(PRICE_INPUT_MESSAGE);	
	    int roomPriceModify = inputManager.userInputInt();
		hotelRoom.setRoomPrice(roomPriceModify);
		printUtil.printString(SLEEPING_NUMBERS_INPUT_MESSAGE);	
	    int sleepingNumberModify = inputManager.userInputInt();
		hotelRoom.setSleepingNumbers(sleepingNumberModify);
		printUtil.printString(STAR_CATEGORY_INPUT_MESSAGE);	
	    int starModify = inputManager.userInputInt();
		hotelRoom.setStarCategory(starModify);
		}
		// TODO write methods to format room
		hotelRoomService.addRooms(hotelRoom);
	}

}
