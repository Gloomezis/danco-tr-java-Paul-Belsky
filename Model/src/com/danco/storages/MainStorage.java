package com.danco.storages;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.danco.controller.SerializeController;
import com.danco.model.Guest;
import com.danco.model.HotelRoom;
import com.danco.model.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class MainStorage.
 */
public class MainStorage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The guest storage. */
	private GuestStorage guestStorage;

	/** The hotel room storage. */
	private HotelRoomStorage hotelRoomStorage;

	/** The service storage. */
	private ServiceStorage serviceStorage;

	/** The file path guests. */
	final String FILE_PATH_GUESTS = "guests.txt";

	

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
		
	}

	/**
	 * Gets the single instance of MainStorage.
	 *
	 * @return single instance of MainStorage
	 */
	public static MainStorage getInstance() {
		if (instance == null) {
			
		//	instance = new MainStorage();
			instance = SerializeController.getInstance().serialFromFile();  
		}
		return instance;
	}


	/**
	 * Show price service and hotel room.
	 *
	 * @throws Exception
	 *             the exception
	 */

	public  List<Service> showPriceService() throws Exception {

		return serviceStorage.showPriceServices();
	}
	

	public List<HotelRoom> showPriceHotelRoom() throws Exception {

		return hotelRoomStorage.showPriceHotelRoom();
		
	}

	//////////////////////////
	///// Hotel Room Methods//
	//////////////////////////

	/**
	 * Gets the hotel room by number.
	 *
	 * @param NumberOfRoom
	 *            the number of room
	 * @return the hotel room by number
	 * @throws Exception
	 *             the exception
	 */
	public HotelRoom getHotelRoomByNumber(String NumberOfRoom) throws Exception {
		return hotelRoomStorage.getHotelRoomByNumber(NumberOfRoom);
	}

	/**
	 * Show all rooms.
	 *
	 * @param sortCondition
	 *            the sort condition
	 * @param free
	 *            the free
	 * @throws Exception
	 *             the exception
	 */

	public List<HotelRoom> showAllRooms(String sortCondition, String free) throws Exception {
		return hotelRoomStorage.showAllRooms(sortCondition, free);
	}

	/**
	 * Show free roms after date.
	 *
	 * @param sortCondition
	 *            the sort condition
	 * @param date
	 *            the date
	 * @throws Exception
	 *             the exception
	 */

	public List<HotelRoom> showFreeRomsAfterDate(String sortCondition, Date date) throws Exception {
	return	hotelRoomStorage.showFreeRomsAfterDate(sortCondition, date);
	}

	/**
	 * Show number of free hoter rooms.
	 *
	 * @throws Exception
	 *             the exception
	 */

	public int showNumberOfFreeHotelRooms() throws Exception {
		return hotelRoomStorage.showNumberOfFreeHotelRooms();
	}

	/**
	 * Show last3 guest of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 * @throws Exception
	 *             the exception
	 */

	public List<Guest> showLast3GuestOfHotelRoom(HotelRoom hotelRoom) throws Exception {
		return hotelRoomStorage.showLast3GuestOfHotelRoom(hotelRoom);
	}

	/**
	 * Show detail of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 * @throws Exception
	 *             the exception
	 */

	public String showDetailOfHotelRoom(HotelRoom hotelRoom) throws Exception {
		return hotelRoomStorage.showDetailOfHotelRoom(hotelRoom);
	}

	/**
	 * Settle guest to hotel room.
	 *
	 * @param guest
	 *            the guest
	 * @param hotelRoom
	 *            the hotel room
	 * @param dateOfArrival
	 *            the date of arrival
	 * @param dateOfDeparture
	 *            the date of departure
	 * @throws Exception
	 *             the exception
	 */
	public void settleGuestToHotelRoom(Guest guest, HotelRoom hotelRoom, Date dateOfArrival, Date dateOfDeparture)
			throws Exception {
		hotelRoomStorage.settleGuestToHotelRoom(guest, hotelRoom, dateOfArrival, dateOfDeparture);
		guestStorage.setDates(dateOfArrival, dateOfDeparture, guest);

	}

	/**
	 * Depart guest from hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 * @throws Exception
	 *             the exception
	 */

	public void departGuestFromHotelRoom(HotelRoom hotelRoom) throws Exception {
		hotelRoomStorage.departGuestFromHotelRoom(hotelRoom);
	}

	/**
	 * Change status.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 * @throws Exception
	 *             the exception
	 */

	public void changeStatus(HotelRoom hotelRoom) throws Exception {
		hotelRoomStorage.changeStatus(hotelRoom);
	}

	/**
	 * Creates the hotel room.
	 *
	 * @param name
	 *            the name
	 * @param roomPrice
	 *            the room price
	 * @param sleepingNumbers
	 *            the sleeping numbers
	 * @param starCategory
	 *            the star category
	 * @return the hotel room
	 * @throws Exception
	 *             the exception
	 */
	public HotelRoom createHotelRoom(String name, int roomPrice, int sleepingNumbers, int starCategory)
			throws Exception {
		return hotelRoomStorage.createHotelRoom(name, roomPrice, sleepingNumbers, starCategory);
	}

	/**
	 * Adds the rooms.
	 *
	 * @param room
	 *            the room
	 * @throws Exception
	 *             the exception
	 */

	public void addRooms(HotelRoom room) throws Exception {
		hotelRoomStorage.addRooms(room);
	}

	/**
	 * Change price of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 * @param roomPrice
	 *            the room price
	 * @throws Exception
	 *             the exception
	 */

	public void changePriceOfHotelRoom(HotelRoom hotelRoom, int roomPrice) throws Exception {
		hotelRoomStorage.changePriceOfHotelRoom(hotelRoom, roomPrice);

	}

	/**
	 * Clone.
	 *
	 * @param room
	 *            the room
	 * @return the hotel room
	 * @throws CloneNotSupportedException
	 *             the clone not supported exception
	 */
	public HotelRoom cloneHotelRoom(HotelRoom room) throws CloneNotSupportedException {
		return hotelRoomStorage.cloneHotelRoom(room);
	}

	// ///////////////////
	// /// Guest Methods//
	// ///////////////////

	/**
	 * Creates the guest.
	 *
	 * @param name
	 *            the name
	 * @return the guest
	 * @throws Exception
	 *             the exception
	 */
	public Guest createGuest(String name) throws Exception {
		return guestStorage.createGuest(name);

	}

	/**
	 * Gets the guest by name.
	 *
	 * @param NameOfGuest
	 *            the name of guest
	 * @return the guest by name
	 * @throws Exception
	 *             the exception
	 */
	public Guest getGuestByName(String NameOfGuest) throws Exception {

		return guestStorage.getGuestByName(NameOfGuest);
	}

	/**
	 * Show all guests.
	 *
	 * @param sortCondition
	 *            the sort condition
	 * @throws Exception
	 *             the exception
	 */

	public List<Guest> showAllGuests(String sortCondition) throws Exception {
		return guestStorage.showAllGuests(sortCondition);
	}

	/**
	 * Adds the guest.
	 *
	 * @param guest
	 *            the guest
	 * @throws Exception
	 *             the exception
	 */

	public void addGuest(Guest guest) throws Exception {
		guestStorage.addGuest(guest);
	}

	/**
	 * Show all guest number.
	 * 
	 * @return
	 *
	 * @throws Exception
	 *             the exception
	 */

	public int showAllGuestNumber() throws Exception {
		return guestStorage.showAllGuestNumber();
	}

	/**
	 * Show summ to paid guest.
	 *
	 * @param guest
	 *            the guest
	 * @throws Exception
	 *             the exception
	 */

	public int showSummToPaidGuest(Guest guest) throws Exception {
		return guestStorage.showSummToPaidGuest(guest);
	}

	/**
	 * Show list of service.
	 *
	 * @param guest
	 *            the guest
	 * @param sortCondition
	 *            the sort condition
	 * @throws Exception
	 *             the exception
	 */

	public List<Service> showListOfService(Guest guest, String sortCondition) throws Exception {
		return guestStorage.showListOfService(guest, sortCondition);
	}

	/**
	 * Adds the service to guest.
	 *
	 * @param guest
	 *            the guest
	 * @param service
	 *            the service
	 * @throws Exception
	 *             the exception
	 */

	public void addServiceToGuest(Guest guest, Service service) throws Exception {
		guestStorage.addServiceToGuest(guest, service);
	}

	/**
	 * Gets the all guests.
	 *
	 * @return the all guests
	 * @throws Exception
	 *             the exception
	 */
	public List<Guest> getAllGuests() throws Exception {
		return guestStorage.getAllGuests();
	}

	// /////////////////////
	// /// Service Methods//
	// /////////////////////

	/**
	 * Gets the service by name.
	 *
	 * @param nameOfService
	 *            the name of service
	 * @return the service by name
	 * @throws Exception
	 *             the exception
	 */
	public Service getServiceByName(String nameOfService) throws Exception {
		return serviceStorage.getServiceByName(nameOfService);
	}

	/**
	 * Creates the service.
	 *
	 * @param nameOfService
	 *            the name of service
	 * @param price
	 *            the price
	 * @return the service
	 * @throws Exception
	 *             the exception
	 */
	public Service createService(String nameOfService, int price) throws Exception {
		return serviceStorage.createService(nameOfService, price);

	}

	/**
	 * Adds the services.
	 *
	 * @param service
	 *            the service
	 * @throws Exception
	 *             the exception
	 */

	public void addServices(Service service) throws Exception {
		serviceStorage.addServices(service);
	}

	/**
	 * Change price of service.
	 *
	 * @param service
	 *            the service
	 * @param price
	 *            the price
	 * @throws Exception
	 *             the exception
	 */

	public void changePriceOfService(Service service, int price) throws Exception {
		serviceStorage.changePriceOfService(service, price);
	}

	/**
	 * Exit program.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public void exitProgram() throws Exception {
		System.exit(0);
	}
}
