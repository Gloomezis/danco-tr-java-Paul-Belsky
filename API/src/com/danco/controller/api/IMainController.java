package com.danco.controller.api;

public interface IMainController {

	public void addGuest();

	/**
	 * Show all guest number.
	 */
	public void showAllGuestNumber();

	/**
	 * Show summ to paid guest.
	 */
	public void showSummToPaidGuest();

	/**
	 * Show all guests.
	 */
	public void showAllGuests();

	/**
	 * Show list of service.
	 */
	public void showListOfService();

	/**
	 * Adds the service to guest.
	 */
	public void addServiceToGuest();

	/**
	 * Gets the all guests.
	 *
	 * @return the all guests
	 */
	public void getAllGuests();

	/**
	 * Show all rooms.
	 */
	public void showAllRooms();

	/**
	 * Show all free rooms.
	 */
	public void showAllFreeRooms();

	/**
	 * Show free roms after date.
	 */
	public void showFreeRomsAfterDate();

	/**
	 * Show number of free hotel rooms.
	 */
	public void showNumberOfFreeHotelRooms();

	/**
	 * Show last3 guest of hotel room.
	 */
	public void showLast3GuestOfHotelRoom();

	/**
	 * Show detail of hotel room.
	 */
	public void showDetailOfHotelRoom();

	/**
	 * Settle guest to hotel room.
	 */
	public void settleGuestToHotelRoom();

	/**
	 * Depart guest from hotel room.
	 */
	public void departGuestFromHotelRoom();

	/**
	 * Change status.
	 */
	public void changeStatus();

	/**
	 * Adds the rooms.
	 */
	public void addRooms();

	/**
	 * Change price of hotel room.
	 */
	public void changePriceOfHotelRoom();

	/**
	 * Clone hotel room.
	 */
	public void cloneHotelRoom();

	/**
	 * Adds the services.
	 */
	public void addServices();

	/**
	 * Show price service and hotel room.
	 */
	public void showPriceServiceAndHotelRoom();

	/**
	 * Change price of service.
	 */
	public void changePriceOfService();

	/**
	 * Guest read csv file.
	 */
	public void guestReadCsvFile();

	/**
	 * Guest write csv file.
	 */
	public void guestWriteCsvFile();

	/**
	 * Hotel room read csv file.
	 */
	public void hotelRoomReadCsvFile();

	/**
	 * Hotel room write csv file.
	 */
	public void hotelRoomWriteCsvFile();

	/**
	 * Service read csv file.
	 */
	public void serviceReadCsvFile();

	/**
	 * Service write csv file.
	 */
	public void serviceWriteCsvFile();

	/**
	 * Show guest reflected object info detailed.
	 */
	public void showGuestReflectedObjectInfoDetailed();

	/**
	 * Show guest reflected object info short.
	 */
	public void showGuestReflectedObjectInfoShort();

	/**
	 * Show hotel room reflected object info detailed.
	 */
	public void showHotelRoomReflectedObjectInfoDetailed();

	/**
	 * Show hotel room reflected object info short.
	 */
	public void showHotelRoomReflectedObjectInfoShort();

	/**
	 * Show service reflected object info detailed.
	 */
	public void showServiceReflectedObjectInfoDetailed();

	/**
	 * Show service reflected object info short.
	 */
	public void showServiceReflectedObjectInfoShort();

}