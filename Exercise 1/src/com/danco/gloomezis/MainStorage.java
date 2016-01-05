package com.danco.gloomezis;

import java.util.Date;
import java.util.List;

import com.danco.models.Guest;
import com.danco.models.HotelRoom;
import com.danco.models.Service;
import com.danco.storages.GuestStorage;
import com.danco.storages.HotelRoomStorage;
import com.danco.storages.ServiceStorage;
import com.danco.training.TextFileWorker;

// TODO: Auto-generated Javadoc
/**
 * The Class MainStorage.
 */
public class MainStorage {

	/** The guest storage. */
	private GuestStorage guestStorage;
	
	/** The hotel room storage. */
	private HotelRoomStorage hotelRoomStorage;
	
	/** The service storage. */
	private ServiceStorage serviceStorage;
	
	/** The file path guests. */
	final String FILE_PATH_GUESTS = "guests.txt";
	
	/** The fw guest. */
	TextFileWorker fwGuest; 
	
	/** The guest txt worker. */
	TxtWorker guestTxtWorker;
	
	


	/** The instance. */
	// singleton
	private static MainStorage instance;

	/**
	 * Instantiates a new main storage.
	 */
	private MainStorage() {
		guestStorage = new GuestStorage();
		hotelRoomStorage = new HotelRoomStorage();
		serviceStorage = new ServiceStorage();
		fwGuest = new TextFileWorker(FILE_PATH_GUESTS);
		guestTxtWorker=new TxtWorker(fwGuest);
	}

	/**
	 * Gets the single instance of MainStorage.
	 *
	 * @return single instance of MainStorage
	 */
	public static MainStorage getInstance() {
		if (instance == null) {
			instance = new MainStorage();
		}
		return instance;
	}
	
	/**
	 * Write guest to file.
	 */
	public void writeGuestToFile(){
	guestTxtWorker.writeGuests(getInstance());
	}
	
	/**
	 * Read guest from file.
	 */
	public void readGuestFromFile(){
	guestTxtWorker.readGuests();
	}

	/**
	 * Show price service and hotel room.
	 */
	
	public void showPriceServiceAndHotelRoom() {
		
		hotelRoomStorage.showPriceHotelRoom();
		serviceStorage.showPriceServices();

		// ////////////////////////
		// /// Hotel Room Methods//
		// ////////////////////////

	}

	
	/**
	 * Show all rooms.
	 *
	 * @param sortCondition the sort condition
	 * @param free the free
	 */
	
	public void showAllRooms(String sortCondition, String free) {
		hotelRoomStorage.showAllRooms(sortCondition, free);
	}

	/**
	 * Show free roms after date.
	 *
	 * @param sortCondition the sort condition
	 * @param date the date
	 */
	
	public void showFreeRomsAfterDate(String sortCondition, Date date) {
		hotelRoomStorage.showFreeRomsAfterDate(sortCondition, date);
	}

	/**
	 * Show number of free hoter rooms.
	 */
	
	public void showNumberOfFreeHoterRooms() {
		hotelRoomStorage.showNumberOfFreeHotelRooms();
	}

	/**
	 * Show last3 guest of hotel room.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void showLast3GuestOfHotelRoom(HotelRoom hotelRoom) {
		hotelRoomStorage.showLast3GuestOfHotelRoom(hotelRoom);
	}

	/**
	 * Show detail of hotel room.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void showDetailOfHotelRoom(HotelRoom hotelRoom) {
		hotelRoomStorage.showDetailOfHotelRoom(hotelRoom);
	}

	

	/**
	 * Settle guest to hotel room.
	 *
	 * @param guest the guest
	 * @param hotelRoom the hotel room
	 * @param dateOfArrival the date of arrival
	 * @param dateOfDeparture the date of departure
	 */
	public void settleGuestToHotelRoom(Guest guest, HotelRoom hotelRoom,
			Date dateOfArrival, Date dateOfDeparture) {
		hotelRoomStorage.settleGuestToHotelRoom(guest, hotelRoom,
				dateOfArrival, dateOfDeparture);
		guestStorage.setDates(dateOfArrival, dateOfDeparture, guest);

	}

	/**
	 * Depart guest from hotel room.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void departGuestFromHotelRoom(HotelRoom hotelRoom) {
		hotelRoomStorage.departGuestFromHotelRoom(hotelRoom);
	}

	/**
	 * Change status.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void changeStatus(HotelRoom hotelRoom) {
		hotelRoomStorage.changeStatus(hotelRoom);
	}

	/**
	 * Adds the rooms.
	 *
	 * @param room the room
	 */
	
	public void addRooms(HotelRoom room) {
		hotelRoomStorage.addRooms(room);
	}

	/**
	 * Change price of hotel room.
	 *
	 * @param hotelRoom the hotel room
	 * @param roomPrice the room price
	 */
	
	public void changePriceOfHotelRoom(HotelRoom hotelRoom, int roomPrice) {
		hotelRoomStorage.changePriceOfHotelRoom(hotelRoom, roomPrice);
		;
	}

	// ///////////////////
	// /// Guest Methods//
	// ///////////////////

	/**
	 * Show all guests.
	 *
	 * @param a the a
	 */
	
	public void showAllGuests(String sortCondition) {
		guestStorage.showAllGuests(sortCondition);
	}

	/**
	 * Adds the guest.
	 *
	 * @param guest the guest
	 */
	
	public void addGuest(Guest guest) {
		guestStorage.addGuest(guest);
	}

	/**
	 * Show all guest number.
	 */

	public void showAllGuestNumber() {
		guestStorage.showAllGuestNumber();
	}

	/**
	 * Show summ to paid guest.
	 *
	 * @param guest the guest
	 */
	
	public void showSummToPaidGuest(Guest guest) {
		guestStorage.showSummToPaidGuest(guest);
	}

	/**
	 * Show list of service.
	 *
	 * @param guest the guest
	 * @param sortCondition the sort condition
	 */
	
	public void showListOfService(Guest guest, String sortCondition) {
		guestStorage.showListOfService(guest, sortCondition);
	}

	/**
	 * Adds the service to guest.
	 *
	 * @param guest the guest
	 * @param service the service
	 */
	
	public void addServiceToGuest(Guest guest, Service service) {
		guestStorage.addServiceToGuest(guest, service);
	}

	/**
	 * Gets the all guests.
	 *
	 * @return the all guests
	 */
	public List<Guest> getAllGuests() {
		return guestStorage.getAllGuests();
	}

	// /////////////////////
	// /// Service Methods//
	// /////////////////////
	/**
	 * Adds the services.
	 *
	 * @param service the service
	 */
	
	public void addServices(Service service) {
		serviceStorage.addServices(service);
	}

	/**
	 * Change price of service.
	 *
	 * @param service the service
	 * @param price the price
	 */
	
	public void changePriceOfService(Service service, int price) {
		serviceStorage.changePriceOfService(service, price);
	}
}
