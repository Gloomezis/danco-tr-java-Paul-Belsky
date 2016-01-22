package com.danco.controller;

// TODO: Auto-generated Javadoc
/**
 * The Class MainController.
 */
public class MainController {

	/** The hotel room controller. */
	GuestController guestController = new GuestController();
	HotelRoomController hotelRoomController = new HotelRoomController();
	ServiceController serviceController = new ServiceController();

	/** The instance. */
	private static MainController instance;

	/**
	 * Gets the single instance of MainController.
	 *
	 * @return single instance of MainController
	 */
	public static MainController getInstance() {
		if (instance == null) {
			instance = new MainController();
		}
		return instance;
	}


	/**
	 * Adds the guest.
	 *
	 * @param guest the guest
	 */
	public void addGuest() {
		guestController.addGuest();
	}

	/**
	 * Show all guest number.
	 */

	public void showAllGuestNumber() {
		guestController.showAllGuestNumber();
	}

	/**
	 * Show summ to paid guest.
	 *
	 * @param guest
	 *            the guest
	 */

	public void showSummToPaidGuest() {
		guestController.showSummToPaidGuest();
	}

	/**
	 * Show all guests.
	 *
	 * @param a
	 *            the a
	 */

	public void showAllGuests() {
		guestController.showAllGuests();
	}

	/**
	 * Show list of service.
	 *
	 * @param guest
	 *            the guest
	 * @param sortCondition
	 *            the sort condition
	 */

	public void showListOfService() {
		guestController.showListOfService();
	}

	/**
	 * Adds the service to guest.
	 *
	 * @param guest
	 *            the guest
	 * @param service
	 *            the service
	 */

	public void addServiceToGuest() {
		guestController.addServiceToGuest();
	}

	/**
	 * Gets the all guests.
	 *
	 * @return the all guests
	 */

	public void getAllGuests() {
		guestController.getAllGuests();
	}


	/**
	 * Show all roms.
	 *
	 * @param sortCondition
	 *            the sort condition
	 * @param free
	 *            the free
	 */

	public void showAllRooms() {
		hotelRoomController.showAllRooms();
	}
	
	public void showAllFreeRooms() {
		hotelRoomController.showAllFreeRooms();
		
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
		hotelRoomController.showFreeRomsAfterDate();
	}

	/**
	 * Show number of free hotel rooms.
	 */

	public void showNumberOfFreeHotelRooms() {
		hotelRoomController.showNumberOfFreeHotelRooms();
	}

	/**
	 * Show last3 guest of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 */

	public void showLast3GuestOfHotelRoom() {
		hotelRoomController.showLast3GuestOfHotelRoom();
	}

	/**
	 * Show detail of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 */

	public void showDetailOfHotelRoom() {
		hotelRoomController.showDetailOfHotelRoom();
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
		hotelRoomController.settleGuestToHotelRoom();
	}

	/**
	 * Depart guest from hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 */

	public void departGuestFromHotelRoom() {
		hotelRoomController.departGuestFromHotelRoom();
	}

	/**
	 * Change status.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 */

	public void changeStatus() {
		hotelRoomController.changeStatus();
	}

	/**
	 * Adds the rooms.
	 *
	 * @param room
	 *            the room
	 */

	public void addRooms() {
		hotelRoomController.addRooms();
	}

	/**
	 * Change price of hotel room.
	 *
	 * @param hotelRoom the hotel room
	 * @param roomPrice the room price
	 */

	public void changePriceOfHotelRoom() {
		hotelRoomController.changePriceOfHotelRoom();
	}
	
	/**
	 * Clone.
	 *
	 * @param room the room
	 * @return the hotel room
	 */
	public void cloneHotelRoom() {
		 hotelRoomController.cloneHotelRoom();

	}
	

	/**
	 * Adds the services.
	 *
	 * @param service
	 *            the service
	 */

	public void addServices() {
			serviceController.addServices();
	}

	/**
	 * Show price services.
	 */

	public void showPriceServiceAndHotelRoom() {
			serviceController.showPriceService();
			hotelRoomController.showPriceHotelRoom();
			
	}

	/**
	 * Change price of service.
	 *
	 * @param service
	 *            the service
	 * @param price
	 *            the price
	 */

	public void changePriceOfService() {
			serviceController.changePriceOfService();
		
	}


	

}
