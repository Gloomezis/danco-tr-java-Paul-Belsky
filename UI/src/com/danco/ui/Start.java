package com.danco.ui;

import java.io.FileNotFoundException;

import org.apache.log4j.PropertyConfigurator;

import com.danco.controller.SerializeController;
import com.danco.storages.MainStorage;


// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Start {

	
	
	
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		
		PropertyConfigurator.configure("log4j.properties");
		
	   
	
		/*
		GuestService guestService = GuestService.getInstance();
		HotelRoomService hotelRoomService =HotelRoomService.getInstance();
		ServiceService serviceService =ServiceService.getInstance();

		// creating hotel rooms
		HotelRoom hr1 = new HotelRoom("101", 100, 1, 5);
		HotelRoom hr2 = new HotelRoom("102", 50, 2, 4);
		HotelRoom hr3 = new HotelRoom("201", 75, 3, 3);
		HotelRoom hr4 = new HotelRoom("301", 200, 1, 5);
		HotelRoom hr5 = new HotelRoom("103", 65, 1, 2);

		// creating guests
		Guest gue1 = new Guest("Paul");
		Guest gue2 = new Guest("Linda");
		Guest gue3 = new Guest("Archie");
		Guest gue4 = new Guest("Serinity");
		Guest gue5 = new Guest("Nobel");
		Guest gue6 = new Guest("Andrea");
		Guest gue7 = new Guest("Stephany");
		Guest gue8 = new Guest("Don");
		// creating servises
		Service servs1 = new Service(10, "Diner");
		Service servs2 = new Service(5, "Cleaning room");
		Service servs3 = new Service(8, "Parking");
		
		
		
		
		
		

		// adding service
		serviceService.addServices(servs1);
		serviceService.addServices(servs2);
		serviceService.addServices(servs3);
		// adding rooms
		hotelRoomService.addRooms(hr1);
		hotelRoomService.addRooms(hr2);
		hotelRoomService.addRooms(hr3);
		hotelRoomService.addRooms(hr4);
		hotelRoomService.addRooms(hr5);
		// test showing service and rooms sorted by category and price
		serviceService.showPriceService();
		hotelRoomService.showPriceHotelRoom();

		guestService.addGuest(gue1);
		guestService.addGuest(gue2);
		guestService.addGuest(gue3);
		guestService.addGuest(gue4);
		guestService.addGuest(gue5);
		guestService.addGuest(gue6);
		guestService.addGuest(gue7);
		guestService.addGuest(gue8);

		
		
		
		// settle all guest to rooms
		hotelRoomService.settleGuestToHotelRoom(gue1, hr1, new GregorianCalendar(2015, 11, 15).getTime(), 
				new GregorianCalendar(2015,11,18).getTime());
		hotelRoomService.settleGuestToHotelRoom(gue2, hr2, new GregorianCalendar(2015,11,16).getTime(),
				new GregorianCalendar(2015,11,25).getTime());
		hotelRoomService.settleGuestToHotelRoom(gue3, hr2, new GregorianCalendar(2015,11,16).getTime(),
				new GregorianCalendar(2015,11,25).getTime());
		hotelRoomService.settleGuestToHotelRoom(gue4, hr3, new GregorianCalendar(2015,11,15).getTime(),
				new GregorianCalendar(2015,11,25).getTime());
		hotelRoomService.settleGuestToHotelRoom(gue5, hr3, new GregorianCalendar(2015,11,15).getTime(),
				new GregorianCalendar(2015,11,24).getTime());
		hotelRoomService.settleGuestToHotelRoom(gue6, hr3, new GregorianCalendar(2015,11,15).getTime(),
				new GregorianCalendar(2015,11,24).getTime());
		hotelRoomService.settleGuestToHotelRoom(gue7, hr4, new GregorianCalendar(2015,11,17).getTime(),
				new GregorianCalendar(2015,11,19).getTime());

		// settle a guest to room (2 not settle because have no space in room
		hotelRoomService.settleGuestToHotelRoom(gue2, hr1, new GregorianCalendar(2015,11,16).getTime(),
				new GregorianCalendar(2015,11,25).getTime());

		// test showing list of guest and his rooms sorted by alphabet
		System.out.println("//////////////by alphabet////////////////////");
		guestService.showAllGuests("alphabet");
		System.out.println("//////////////by date/////////////////////");
		guestService.showAllGuests("date");

		// testing showing a free rooms
		hotelRoomService.showNumberOfFreeHotelRooms();
		hotelRoomService.departGuestFromHotelRoom(hr1);
		hotelRoomService.showNumberOfFreeHotelRooms();

		// show number of all guests
		guestService.showAllGuestNumber();

		// show summ to paid guest(name)
		guestService.showSummToPaidGuest(gue1);

		// departure guest gue1 from hotel room hr1
		hotelRoomService.departGuestFromHotelRoom(hr1);

		// testing room history
		hotelRoomService.settleGuestToHotelRoom(gue3, hr1, new GregorianCalendar(2015,11,15).getTime(),
				new GregorianCalendar(2015,11,16).getTime());
		hotelRoomService.departGuestFromHotelRoom(hr1);
		hotelRoomService.settleGuestToHotelRoom(gue2, hr1, new GregorianCalendar(2015,11,16).getTime(),
				new GregorianCalendar(2015,11,17).getTime());
		hotelRoomService.departGuestFromHotelRoom(hr1);
		hotelRoomService.settleGuestToHotelRoom(gue4, hr1, new GregorianCalendar(2015,11,17).getTime(),
				new GregorianCalendar(2015,11,18).getTime());
		hotelRoomService.departGuestFromHotelRoom(hr1);
		hotelRoomService.settleGuestToHotelRoom(gue3, hr1, new GregorianCalendar(2015,11,18).getTime(),
				new GregorianCalendar(2015,11,19).getTime());
		hotelRoomService.departGuestFromHotelRoom(hr1);
		hotelRoomService.settleGuestToHotelRoom(gue2, hr1, new GregorianCalendar(2015,11,19).getTime(),
				new GregorianCalendar(2015,11,20).getTime());
		hotelRoomService.departGuestFromHotelRoom(hr1);
		hotelRoomService.settleGuestToHotelRoom(gue7, hr1,new GregorianCalendar(2015,11,21).getTime(),
				new GregorianCalendar(2015,11,22).getTime());
		hotelRoomService.departGuestFromHotelRoom(hr1);
		System.out.println("///////////////////////last 3 guest of room 101");
		// show last 3 guests of room hr1
		hotelRoomService.showLast3GuestOfHotelRoom(hr1);

		// show detail of hotel room
		hotelRoomService.showDetailOfHotelRoom(hr1);

		// testing change status
		System.out.println("///////////////////////Change status");
		hotelRoomService.changeStatus(hr1);
		hotelRoomService.showDetailOfHotelRoom(hr1);
		hotelRoomService.changeStatus(hr1);
		hotelRoomService.showDetailOfHotelRoom(hr1);

		hotelRoomService.changePriceOfHotelRoom(hr1, 80);
		hotelRoomService.showDetailOfHotelRoom(hr1);

		// adding service to guest
		guestService.addServiceToGuest(gue1, servs1);
		guestService.addServiceToGuest(gue1, servs2);
		guestService.addServiceToGuest(gue1, servs3);

		// show list of all services sorted by condition
		System.out.println("/////////////////sorted by price/////////");
		guestService.showListOfService(gue1, "price");
		System.out.println("/////////////////sorted by date/////////");
		guestService.showListOfService(gue1, "date");

		// show list of all rooms sorted by condition
		System.out.println("Rooms by price");
		hotelRoomService.showAllRooms("price", "");
		System.out.println("Rooms by sleepN");
		hotelRoomService.showAllRooms("sleepN", "");
		System.out.println("Rooms by starN");
		hotelRoomService.showAllRooms("star", "");

		// testing show list of all free rooms sorted by condition

		hotelRoomService.departGuestFromHotelRoom(hr1);
		hotelRoomService.departGuestFromHotelRoom(hr2);
		hotelRoomService.departGuestFromHotelRoom(hr3);
		hotelRoomService.departGuestFromHotelRoom(hr4);
		guestService.showAllGuests("alphabet");
		System.out.println("Free Rooms by price");
		hotelRoomService.showAllRooms("price", "free");
		System.out.println("free Rooms by sleepN");
		hotelRoomService.showAllRooms("sleepN", "free");
		System.out.println("free Rooms by starN");
		hotelRoomService.showAllRooms("star", "free");
		// hotel.settleGuestToHotelRoom(gue1, hr1, "15-12-2015", "18-12-2015");
		// hotel.settleGuestToHotelRoom(gue2, hr2, "16-12-2015", "25-12-2015");
		hotelRoomService.settleGuestToHotelRoom(gue3, hr2, new GregorianCalendar(2015,11,16).getTime(), 
				new GregorianCalendar(2015,11,25).getTime());
		hotelRoomService.settleGuestToHotelRoom(gue4, hr3, new GregorianCalendar(2015,11,15).getTime(),
				new GregorianCalendar(2015,11,24).getTime());
		hotelRoomService.settleGuestToHotelRoom(gue5, hr3, new GregorianCalendar(2015,11,15).getTime(),
				new GregorianCalendar(2015,11,24).getTime());
		hotelRoomService.settleGuestToHotelRoom(gue6, hr3, new GregorianCalendar(2015,11,15).getTime(),
				new GregorianCalendar(2015,11,24).getTime());
		hotelRoomService.settleGuestToHotelRoom(gue7, hr4, new GregorianCalendar(2015,11,17).getTime(),
				new GregorianCalendar(2015,11,19).getTime());
		System.out.println("free Rooms by price");
		hotelRoomService.showAllRooms("price", "free");
		hotelRoomService.showDetailOfHotelRoom(hr1);
		hotelRoomService.showDetailOfHotelRoom(hr2);
		hotelRoomService.showDetailOfHotelRoom(hr3);

		// testing show list of all free rooms sorted by condition
		hotelRoomService.showFreeRomsAfterDate("star", new GregorianCalendar(2015,11,24).getTime());

	System.out.println("printing  getted guest"+GuestService.getInstance().getGuestByName("Paul").toString());
	System.out.println("printing  getted hotel room "+HotelRoomService.getInstance().getHotelRoomByNumber("101").toString());
	System.out.println("printing  getted service "+ServiceService.getInstance().getServiceByName("Diner").toString());
	
	
	
	
	*/
      
	
       
	 
    MainStorage.setInstance(SerializeController.getInstance().serialFromFile());  
	Controller controller = new Controller();
	controller.run();
	SerializeController.getInstance().serialToFile();
	

		}
	
	
	}
	
	

