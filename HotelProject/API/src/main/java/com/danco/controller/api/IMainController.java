package com.danco.controller.api;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Interface IMainController.
 */
public interface IMainController {

	/**
	 * Adds the guest.
	 *
	 * @param userInputGuestName the user input guest name
	 */
	//+
	public abstract void addGuest(String userInputGuestName);

	/**
	 * Show all guest number.
	 *
	 * @return the string
	 */
	//+
	public abstract String showAllGuestNumber();

	/**
	 * Show all guests.
	 *
	 * @param userInputSortCondition the user input sort condition
	 * @return the string
	 */
	public abstract String showAllGuests(String userInputSortCondition);

	/**
	 * Creates the service.
	 *
	 * @param userInputOrderId the user input order id
	 * @param userInputGuestName the user input guest name
	 * @param userInputPrice the user input price
	 */
	//+
	public abstract void createService(int userInputOrderId,
			String userInputGuestName, int userInputPrice);

	/**
	 * Adds the service.
	 *
	 * @param userInputGuestId the user input guest id
	 * @param userInputServiceId the user input service id
	 */
	//+
	public abstract void addService(int userInputGuestId, int userInputServiceId);

	/**
	 * Show list of service guest.
	 *
	 * @param idGuest the id guest
	 * @param userInputSortCondition the user input sort condition
	 * @return the string
	 */
	//TODO string id to integer
	public abstract String showListOfServiceGuest(String idGuest,
			String userInputSortCondition);

	/**
	 * Change price of service.
	 *
	 * @param idService the id service
	 * @param userInputPrice the user input price
	 */
	//TODO string to integer
	public abstract void changePriceOfService(String idService,
			int userInputPrice);

	/**
	 * Show list of service.
	 *
	 * @return the string
	 */
	public abstract String showListOfService();

	/**
	 * Adds the rooms.
	 *
	 * @param userInputHotelRoomName the user input hotel room name
	 * @param userInputRoomPrice the user input room price
	 * @param userInputSleepingNumbers the user input sleeping numbers
	 * @param userInputStarCategory the user input star category
	 */
	//+
	public abstract void addRooms(String userInputHotelRoomName,
			int userInputRoomPrice, int userInputSleepingNumbers,
			int userInputStarCategory);

	/**
	 * Show all rooms.
	 *
	 * @param userInputSortCondition the user input sort condition
	 * @return the string
	 */
	public abstract String showAllRooms(String userInputSortCondition);

	/**
	 * Show all free rooms.
	 *
	 * @param userInputSortCondition the user input sort condition
	 * @return the string
	 */
	public abstract String showAllFreeRooms(String userInputSortCondition);

	/**
	 * Show free roms after date.
	 *
	 * @param userInputSortCondition the user input sort condition
	 * @param date the date
	 * @return the string
	 */
	public abstract String showFreeRomsAfterDate(String userInputSortCondition,
			Date date);

	/**
	 * Change status.
	 *
	 * @param idHotelRoom the id hotel room
	 */
	public abstract void changeStatus(String idHotelRoom);

	/**
	 * Show number of free hotel rooms.
	 *
	 * @return the string
	 */
	public abstract String showNumberOfFreeHotelRooms();

	/**
	 * Show detail of hotel room.
	 *
	 * @param idHotelRoom the id hotel room
	 * @return the string
	 */
	//TODO id to integer
	public abstract String showDetailOfHotelRoom(String idHotelRoom);

	/**
	 * Change price of hotel room.
	 *
	 * @param idHotelRoom the id hotel room
	 * @param userInputRoomPrice the user input room price
	 */
	//TODO string to integer
	public abstract void changePriceOfHotelRoom(String idHotelRoom,
			int userInputRoomPrice);

	/**
	 * Show price service and hotel room.
	 *
	 * @return the string
	 */
	public abstract String showPriceServiceAndHotelRoom();

	/**
	 * Show summ to paid guest.
	 *
	 * @param idGuest the id guest
	 * @return the string
	 */
	//TODO string to int
	public abstract String showSummToPaidGuest(String idGuest);

	/**
	 * Guest read csv file.
	 *
	 * @param userInputFileName the user input file name
	 * @return the string
	 */
	public abstract String guestReadCsvFile(String userInputFileName);

	/**
	 * Guest write csv file.
	 *
	 * @param userInputFileName the user input file name
	 * @return the string
	 */
	public abstract String guestWriteCsvFile(String userInputFileName);

	/**
	 * Hotel room read csv file.
	 *
	 * @param userInputFileName the user input file name
	 * @return the string
	 */
	public abstract String hotelRoomReadCsvFile(String userInputFileName);

	/**
	 * Hotel room write csv file.
	 *
	 * @param userInputFileName the user input file name
	 * @return the string
	 */
	public abstract String hotelRoomWriteCsvFile(String userInputFileName);

	/**
	 * Service read csv file.
	 *
	 * @param userInputFileName the user input file name
	 * @return the string
	 */
	public abstract String serviceReadCsvFile(String userInputFileName);

	/**
	 * Service write csv file.
	 *
	 * @param userInputFileName the user input file name
	 * @return the string
	 */
	public abstract String serviceWriteCsvFile(String userInputFileName);

	/**
	 * Settle guest to hotel room.
	 *
	 * @param idGuest the id guest
	 * @param idHotelRoom the id hotel room
	 * @param userinpitDateOfArrive the userinpit date of arrive
	 * @param userInputDateOfDeparture the user input date of departure
	 * @return the string
	 */
	public abstract String settleGuestToHotelRoom(String idGuest,
			String idHotelRoom, Date userinpitDateOfArrive,
			Date userInputDateOfDeparture);

	/**
	 * Depart guest from hotel room.
	 *
	 * @param idGuest the id guest
	 */
	public abstract void departGuestFromHotelRoom(String idGuest);

}