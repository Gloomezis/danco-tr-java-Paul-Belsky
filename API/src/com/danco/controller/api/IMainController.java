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
	 * @param userInputGuestName
	 *            the user input guest name
	 */
	public void addGuest(String userInputGuestName);

	/**
	 * Show all guest number.
	 *
	 * @return the string
	 */
	public String showAllGuestNumber();

	/**
	 * Show summ to paid guest.
	 *
	 * @param userInputGuestName
	 *            the user input guest name
	 * @return the string
	 */
	public String showSummToPaidGuest(String userInputGuestName);

	/**
	 * Show all guests.
	 *
	 * @param userInputSortCondition
	 *            the user input sort condition
	 * @return the string
	 */
	public String showAllGuests(String userInputSortCondition);

	/**
	 * Show list of service.
	 *
	 * @param userInputGuestName
	 *            the user input guest name
	 * @param userInputSortCondition
	 *            the user input sort condition
	 * @return the string
	 */
	public String showListOfService(String userInputGuestName,
			String userInputSortCondition);


	/**
	 * Show all rooms.
	 *
	 * @param userInputSortCondition
	 *            the user input sort condition
	 * @return the string
	 */
	public String showAllRooms(String userInputSortCondition);

	/**
	 * Show all free rooms.
	 *
	 * @param userInputSortCondition
	 *            the user input sort condition
	 * @return the string
	 */
	public String showAllFreeRooms(String userInputSortCondition);

	/**
	 * Show free roms after date.
	 *
	 * @param userInputSortCondition
	 *            the user input sort condition
	 * @param date
	 *            the date
	 * @return the string
	 */
	public String showFreeRomsAfterDate(String userInputSortCondition, Date date);

	/**
	 * Show number of free hotel rooms.
	 *
	 * @return the string
	 */
	public String showNumberOfFreeHotelRooms();

	/**
	 * Show last3 guest of hotel room.
	 *
	 * @param userInputHotelRoomNumber
	 *            the user input hotel room number
	 * @return the string
	 */
	public String showLast3GuestOfHotelRoom(String userInputHotelRoomNumber);

	/**
	 * Show detail of hotel room.
	 *
	 * @param userInputHotelRoomNumber
	 *            the user input hotel room number
	 * @return the string
	 */
	public String showDetailOfHotelRoom(String userInputHotelRoomNumber);

	/**
	 * Settle guest to hotel room.
	 *
	 * @param userInputGuestName
	 *            the user input guest name
	 * @param userInputHotelRoomNumber
	 *            the user input hotel room number
	 * @param userinpitDateOfArrive
	 *            the userinpit date of arrive
	 * @param userInputDateOfDeparture
	 *            the user input date of departure
	 */
	public void settleGuestToHotelRoom(String userInputGuestName,
			String userInputHotelRoomNumber, Date userinpitDateOfArrive,
			Date userInputDateOfDeparture);

	/**
	 * Depart guest from hotel room.
	 *
	 * @param userInputHotelRoomName
	 *            the user input hotel room name
	 */
	public void departGuestFromHotelRoom(String userInputHotelRoomName);

	/**
	 * Change status.
	 *
	 * @param userInputHotelRoomName
	 *            the user input hotel room name
	 */
	public void changeStatus(String userInputHotelRoomName);

	/**
	 * Adds the rooms.
	 *
	 * @param userInputHotelRoomName
	 *            the user input hotel room name
	 * @param userInputRoomPrice
	 *            the user input room price
	 * @param userInputSleepingNumbers
	 *            the user input sleeping numbers
	 * @param userInputStarCategory
	 *            the user input star category
	 */
	public void addRooms(String userInputHotelRoomName, int userInputRoomPrice,
			int userInputSleepingNumbers, int userInputStarCategory);

	/**
	 * Change price of hotel room.
	 *
	 * @param userInputHotelRoomName
	 *            the user input hotel room name
	 * @param userInputRoomPrice
	 *            the user input room price
	 */
	public void changePriceOfHotelRoom(String userInputHotelRoomName,
			int userInputRoomPrice);


	/**
	 * Adds the services.
	 *
	 * @param userInputServiceName
	 *            the user input service name
	 * @param userInputPrice
	 *            the user input price
	 */
	public void addService(int userInputOrderId,String userInputServiceName, int userInputPrice);

	/**
	 * Show price service and hotel room.
	 *
	 * @return the string
	 */
	public String showPriceServiceAndHotelRoom();

	/**
	 * Change price of service.
	 *
	 * @param userInputServiceName
	 *            the user input service name
	 * @param userInputPrice
	 *            the user input price
	 */
	public void changePriceOfService(String userInputServiceName,
			int userInputPrice);

	/**
	 * Guest read csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 */
	public String guestReadCsvFile(String userInputFileName);

	/**
	 * Guest write csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 */
	public String guestWriteCsvFile(String userInputFileName);

	/**
	 * Hotel room read csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 */
	public String hotelRoomReadCsvFile(String userInputFileName);

	/**
	 * Hotel room write csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 */
	public String hotelRoomWriteCsvFile(String userInputFileName);

	/**
	 * Service read csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 */
	public String serviceReadCsvFile(String userInputFileName);

	/**
	 * Service write csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 */
	public String serviceWriteCsvFile(String userInputFileName);



}