package com.danco.gloomezis;

import java.util.GregorianCalendar;

import com.danco.models.Guest;
import com.danco.models.HotelRoom;
import com.danco.models.Service;


// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	//final static String FILE_PATH_GUESTS = "src/src/files/guests.txt";
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		

		
		
	//	TextFileWorker fwGuest = new TextFileWorker(FILE_PATH_GUESTS);
	//	TxtWorker guestTxtWorker=new TxtWorker(fwGuest);
		
		

		MainStorage mainStorage = MainStorage.getInstance();

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
		mainStorage.addServices(servs1);
		mainStorage.addServices(servs2);
		mainStorage.addServices(servs3);
		// adding rooms
		mainStorage.addRooms(hr1);
		mainStorage.addRooms(hr2);
		mainStorage.addRooms(hr3);
		mainStorage.addRooms(hr4);
		mainStorage.addRooms(hr5);
		// test showing service and rooms sorted by category and price
		mainStorage.showPriceServiceAndHotelRoom();

		mainStorage.addGuest(gue1);
		mainStorage.addGuest(gue2);
		mainStorage.addGuest(gue3);
		mainStorage.addGuest(gue4);
		mainStorage.addGuest(gue5);
		mainStorage.addGuest(gue6);
		mainStorage.addGuest(gue7);
		mainStorage.addGuest(gue8);

		// settle all guest to rooms
		mainStorage.settleGuestToHotelRoom(gue1, hr1, new GregorianCalendar(2015, 11, 15).getTime(), 
				new GregorianCalendar(2015,11,18).getTime());
		mainStorage.settleGuestToHotelRoom(gue2, hr2, new GregorianCalendar(2015,11,16).getTime(),
				new GregorianCalendar(2015,11,25).getTime());
		mainStorage.settleGuestToHotelRoom(gue3, hr2, new GregorianCalendar(2015,11,16).getTime(),
				new GregorianCalendar(2015,11,25).getTime());
		mainStorage.settleGuestToHotelRoom(gue4, hr3, new GregorianCalendar(2015,11,15).getTime(),
				new GregorianCalendar(2015,11,25).getTime());
		mainStorage.settleGuestToHotelRoom(gue5, hr3, new GregorianCalendar(2015,11,15).getTime(),
				new GregorianCalendar(2015,11,24).getTime());
		mainStorage.settleGuestToHotelRoom(gue6, hr3, new GregorianCalendar(2015,11,15).getTime(),
				new GregorianCalendar(2015,11,24).getTime());
		mainStorage.settleGuestToHotelRoom(gue7, hr4, new GregorianCalendar(2015,11,17).getTime(),
				new GregorianCalendar(2015,11,19).getTime());

		// settle a guest to room (2 not settle because have no space in room
		mainStorage.settleGuestToHotelRoom(gue2, hr1, new GregorianCalendar(2015,11,16).getTime(),
				new GregorianCalendar(2015,11,25).getTime());

		// test showing list of guest and his rooms sorted by alphabet
		System.out.println("//////////////by alphabet////////////////////");
		mainStorage.showAllGuests("alphabet");
		System.out.println("//////////////by date/////////////////////");
		mainStorage.showAllGuests("date");

		// testing showing a free rooms
		mainStorage.showNumberOfFreeHoterRooms();
		mainStorage.departGuestFromHotelRoom(hr1);
		mainStorage.showNumberOfFreeHoterRooms();

		// show number of all guests
		mainStorage.showAllGuestNumber();

		// show summ to paid guest(name)
		mainStorage.showSummToPaidGuest(gue1);

		// departure guest gue1 from hotel room hr1
		mainStorage.departGuestFromHotelRoom(hr1);

		// testing room history
		mainStorage.settleGuestToHotelRoom(gue3, hr1, new GregorianCalendar(2015,11,15).getTime(),
				new GregorianCalendar(2015,11,16).getTime());
		mainStorage.departGuestFromHotelRoom(hr1);
		mainStorage.settleGuestToHotelRoom(gue2, hr1, new GregorianCalendar(2015,11,16).getTime(),
				new GregorianCalendar(2015,11,17).getTime());
		mainStorage.departGuestFromHotelRoom(hr1);
		mainStorage.settleGuestToHotelRoom(gue4, hr1, new GregorianCalendar(2015,11,17).getTime(),
				new GregorianCalendar(2015,11,18).getTime());
		mainStorage.departGuestFromHotelRoom(hr1);
		mainStorage.settleGuestToHotelRoom(gue3, hr1, new GregorianCalendar(2015,11,18).getTime(),
				new GregorianCalendar(2015,11,19).getTime());
		mainStorage.departGuestFromHotelRoom(hr1);
		mainStorage.settleGuestToHotelRoom(gue2, hr1, new GregorianCalendar(2015,11,19).getTime(),
				new GregorianCalendar(2015,11,20).getTime());
		mainStorage.departGuestFromHotelRoom(hr1);
		mainStorage.settleGuestToHotelRoom(gue7, hr1,new GregorianCalendar(2015,11,21).getTime(),
				new GregorianCalendar(2015,11,22).getTime());
		mainStorage.departGuestFromHotelRoom(hr1);
		System.out.println("///////////////////////last 3 guest of room 101");
		// show last 3 guests of room hr1
		mainStorage.showLast3GuestOfHotelRoom(hr1);

		// show detail of hotel room
		mainStorage.showDetailOfHotelRoom(hr1);

		// testing change status
		System.out.println("///////////////////////Change status");
		mainStorage.changeStatus(hr1);
		mainStorage.showDetailOfHotelRoom(hr1);
		mainStorage.changeStatus(hr1);
		mainStorage.showDetailOfHotelRoom(hr1);

		mainStorage.changePriceOfHotelRoom(hr1, 80);
		mainStorage.showDetailOfHotelRoom(hr1);

		// adding service to guest
		mainStorage.addServiceToGuest(gue1, servs1);
		mainStorage.addServiceToGuest(gue1, servs2);
		mainStorage.addServiceToGuest(gue1, servs3);

		// show list of all services sorted by condition
		System.out.println("/////////////////sorted by price/////////");
		mainStorage.showListOfService(gue1, "price");
		System.out.println("/////////////////sorted by date/////////");
		mainStorage.showListOfService(gue1, "date");

		// show list of all rooms sorted by condition
		System.out.println("Rooms by price");
		mainStorage.showAllRooms("price", "");
		System.out.println("Rooms by sleepN");
		mainStorage.showAllRooms("sleepN", "");
		System.out.println("Rooms by starN");
		mainStorage.showAllRooms("star", "");

		// testing show list of all free rooms sorted by condition

		mainStorage.departGuestFromHotelRoom(hr1);
		mainStorage.departGuestFromHotelRoom(hr2);
		mainStorage.departGuestFromHotelRoom(hr3);
		mainStorage.departGuestFromHotelRoom(hr4);
		mainStorage.showAllGuests("alphabet");
		System.out.println("Free Rooms by price");
		mainStorage.showAllRooms("price", "free");
		System.out.println("free Rooms by sleepN");
		mainStorage.showAllRooms("sleepN", "free");
		System.out.println("free Rooms by starN");
		mainStorage.showAllRooms("star", "free");
		// hotel.settleGuestToHotelRoom(gue1, hr1, "15-12-2015", "18-12-2015");
		// hotel.settleGuestToHotelRoom(gue2, hr2, "16-12-2015", "25-12-2015");
		mainStorage.settleGuestToHotelRoom(gue3, hr2, new GregorianCalendar(2015,11,16).getTime(), 
				new GregorianCalendar(2015,11,25).getTime());
		mainStorage.settleGuestToHotelRoom(gue4, hr3, new GregorianCalendar(2015,11,15).getTime(),
				new GregorianCalendar(2015,11,24).getTime());
		mainStorage.settleGuestToHotelRoom(gue5, hr3, new GregorianCalendar(2015,11,15).getTime(),
				new GregorianCalendar(2015,11,24).getTime());
		mainStorage.settleGuestToHotelRoom(gue6, hr3, new GregorianCalendar(2015,11,15).getTime(),
				new GregorianCalendar(2015,11,24).getTime());
		mainStorage.settleGuestToHotelRoom(gue7, hr4, new GregorianCalendar(2015,11,17).getTime(),
				new GregorianCalendar(2015,11,19).getTime());
		System.out.println("free Rooms by price");
		mainStorage.showAllRooms("price", "free");
		mainStorage.showDetailOfHotelRoom(hr1);
		mainStorage.showDetailOfHotelRoom(hr2);
		mainStorage.showDetailOfHotelRoom(hr3);

		// testing show list of all free rooms sorted by condition
		mainStorage.showFreeRomsAfterDate("star", new GregorianCalendar(2015,11,24).getTime());

		

	//guestTxtWorker.writeGuests();
    // guestTxtWorker.readGuests();
		mainStorage.writeGuestToFile();
		mainStorage.readGuestFromFile();
	}

}
