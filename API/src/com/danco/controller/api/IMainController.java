package com.danco.controller.api;

public interface IMainController {

	/**
	 * Adds the guest.
	 */
	void addGuest();

	/**
	 * Show all guest number.
	 */

	void showAllGuestNumber();

	/**
	 * Show summ to paid guest.
	 */

	void showSummToPaidGuest();

	/**
	 * Show all guests.
	 */

	void showAllGuests();

	/**
	 * Show list of service.
	 */

	void showListOfService();

	/**
	 * Adds the service to guest.
	 */

	void addServiceToGuest();

	/**
	 * Gets the all guests.
	 *
	 * @return the all guests
	 */

	void getAllGuests();

	/**
	 * Show all roms.
	 */

	void showAllRooms();

	/**
	 * Show all free rooms.
	 */
	void showAllFreeRooms();

	/**
	 * Show free roms after date.
	 */

	void showFreeRomsAfterDate();

	/**
	 * Show number of free hotel rooms.
	 */

	void showNumberOfFreeHotelRooms();

	/**
	 * Show last3 guest of hotel room.
	 */

	void showLast3GuestOfHotelRoom();

	/**
	 * Show detail of hotel room.
	 */

	void showDetailOfHotelRoom();

	/**
	 * Settle guest to hotel room.
	 */

	void settleGuestToHotelRoom();

	/**
	 * Depart guest from hotel room.
	 */

	void departGuestFromHotelRoom();

	/**
	 * Change status.
	 */

	void changeStatus();

	/**
	 * Adds the rooms.
	 */

	void addRooms();

	/**
	 * Change price of hotel room.
	 */

	void changePriceOfHotelRoom();

	/**
	 * Clone.
	 *
	 * @return the hotel room
	 */
	void cloneHotelRoom();

	/**
	 * Adds the services.
	 */

	void addServices();

	/**
	 * Show price services.
	 */

	void showPriceServiceAndHotelRoom();

	/**
	 * Change price of service.
	 */

	void changePriceOfService();

	/**
	 * Guest read csv file.
	 */
	void guestReadCsvFile();

	/**
	 * Guest write csv file.
	 */
	void guestWriteCsvFile();

	/**
	 * Hotel room read csv file.
	 */
	void hotelRoomReadCsvFile();

	/**
	 * Hotel room write csv file.
	 */
	void hotelRoomWriteCsvFile();

	/**
	 * Service read csv file.
	 */
	void serviceReadCsvFile();

	/**
	 * Service write csv file.
	 */
	void serviceWriteCsvFile();

}