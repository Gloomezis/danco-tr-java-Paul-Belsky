package com.danco.gloomezis;


import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.model.Guest;
import com.danco.model.HotelRoom;
import com.danco.model.Service;
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
	
	final Logger LOG1=Logger.getLogger(MainStorage.class.getName());
	
	


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
		try {
		
		fwGuest = new TextFileWorker(FILE_PATH_GUESTS);
	
		} catch (IllegalArgumentException e) {
			LOG1.error("File not found",e);	
		}
	//	java.lang.IllegalArgumentException
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
	public void writeGuestToFile() throws ArrayIndexOutOfBoundsException, NullPointerException{
	guestTxtWorker.writeGuests(getInstance());
	}
	
	/**
	 * Read guest from file.
	 * 
	 */
	public void readGuestFromFile() throws ArrayIndexOutOfBoundsException, NullPointerException{
	guestTxtWorker.readGuests();
	}

	/**
	 * Show price service and hotel room.
	 */
	
	public void showPriceServiceAndHotelRoom() {
		
		hotelRoomStorage.showPriceHotelRoom();
		serviceStorage.showPriceServices();
	}
	
		//////////////////////////
		///// Hotel Room Methods//
		//////////////////////////

	

	/**
		 * Gets the hotel room by number.
		 *
		 * @param NumberOfRoom the number of room
		 * @return the hotel room by number
		 */
		public HotelRoom getHotelRoomByNumber(String NumberOfRoom) {
		return hotelRoomStorage.getHotelRoomByNumber(NumberOfRoom);
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
	
	public void showFreeRomsAfterDate(String sortCondition, Date date)  throws NullPointerException{
		hotelRoomStorage.showFreeRomsAfterDate(sortCondition, date);
	}

	/**
	 * Show number of free hoter rooms.
	 */
	
	public void showNumberOfFreeHotelRooms() {
		hotelRoomStorage.showNumberOfFreeHotelRooms();
	}

	/**
	 * Show last3 guest of hotel room.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void showLast3GuestOfHotelRoom(HotelRoom hotelRoom) throws NullPointerException{
		hotelRoomStorage.showLast3GuestOfHotelRoom(hotelRoom);
	}

	/**
	 * Show detail of hotel room.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void showDetailOfHotelRoom(HotelRoom hotelRoom) throws NullPointerException{
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
			Date dateOfArrival, Date dateOfDeparture) throws NullPointerException{
		hotelRoomStorage.settleGuestToHotelRoom(guest, hotelRoom,
				dateOfArrival, dateOfDeparture);
		guestStorage.setDates(dateOfArrival, dateOfDeparture, guest);

	}

	/**
	 * Depart guest from hotel room.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void departGuestFromHotelRoom(HotelRoom hotelRoom) throws NullPointerException{
		hotelRoomStorage.departGuestFromHotelRoom(hotelRoom);
	}

	/**
	 * Change status.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void changeStatus(HotelRoom hotelRoom) throws NullPointerException{
		hotelRoomStorage.changeStatus(hotelRoom);
	}

	
	/**
	 * Creates the hotel room.
	 *
	 * @param name the name
	 * @param roomPrice the room price
	 * @param sleepingNumbers the sleeping numbers
	 * @param starCategory the star category
	 * @return the hotel room
	 */
	public HotelRoom createHotelRoom(String name, int roomPrice, int sleepingNumbers,int starCategory){
		return hotelRoomStorage.createHotelRoom(name, roomPrice, sleepingNumbers, starCategory);
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
	
	public void changePriceOfHotelRoom(HotelRoom hotelRoom, int roomPrice)  throws NullPointerException {
		hotelRoomStorage.changePriceOfHotelRoom(hotelRoom, roomPrice);
		;
	}

	// ///////////////////
	// /// Guest Methods//
	// ///////////////////

	/**
	 * Creates the guest.
	 *
	 * @param name the name
	 * @return the guest
	 */
	public Guest createGuest(String name){
		return guestStorage.createGuest(name);
		
	}
	
	/**
	 * Gets the guest by name.
	 *
	 * @param NameOfGuest the name of guest
	 * @return the guest by name
	 */
	public Guest getGuestByName(String NameOfGuest) {
		
		return guestStorage.getGuestByName(NameOfGuest);
	}
	
	/**
	 * Show all guests.
	 *
	 * @param sortCondition the sort condition
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
	
	public void showSummToPaidGuest(Guest guest) throws NullPointerException{
		guestStorage.showSummToPaidGuest(guest);
	}

	/**
	 * Show list of service.
	 *
	 * @param guest the guest
	 * @param sortCondition the sort condition
	 */
	
	public void showListOfService(Guest guest, String sortCondition) throws NullPointerException {
		guestStorage.showListOfService(guest, sortCondition);
	}

	/**
	 * Adds the service to guest.
	 *
	 * @param guest the guest
	 * @param service the service
	 */
	
	public void addServiceToGuest(Guest guest, Service service) throws NullPointerException{
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
	 * Gets the service by name.
	 *
	 * @param nameOfService the name of service
	 * @return the service by name
	 */
	public Service getServiceByName(String nameOfService) {
		return serviceStorage.getServiceByName(nameOfService);
	}
	
	
	
	/**
	 * Creates the service.
	 *
	 * @param nameOfService the name of service
	 * @param price the price
	 * @return the service
	 */
	public Service createService(String nameOfService, int price){
		return serviceStorage.createService(nameOfService, price);
		
		
	}
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
	
	public void changePriceOfService(Service service, int price) throws NullPointerException {
		serviceStorage.changePriceOfService(service, price);
	}
	
	
	/**
	 * Exit program.
	 */
	public void exitProgram(){
		System.exit(0);
	}
}
