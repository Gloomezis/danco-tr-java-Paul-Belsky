package com.danco.gloomezis;

import com.danco.models.Guest;
import com.danco.models.HotelRoom;
import com.danco.models.Service;



public class Main {

	public static void main(String[] args) {

		/*
		 * final String FILE_PATH_GUESTS = "src/src/files/guests.txt";
		 * TextFileWorker fwGuest = new TextFileWorker(FILE_PATH_GUESTS);
		 * 
		 * final String FILE_PATH_HOTELROOMS = "src/src/files/hotelRooms.txt";
		 * TextFileWorker fwHotelRoms = new
		 * TextFileWorker(FILE_PATH_HOTELROOMS);
		 * 
		 * final String FILE_PATH_SERVICES = "src/src/files/services.txt";
		 * TextFileWorker fwServices = new TextFileWorker(FILE_PATH_SERVICES);
		 */
		// ñreating hotel
		Hotel hotel = Hotel.getInstance();

		// creating hotel rooms
		HotelRoom hr1 = new HotelRoom("101", 100, 1, 5);
		HotelRoom hr2 = new HotelRoom("102", 50, 2, 4);
		HotelRoom hr3 = new HotelRoom("201", 75, 3, 3);
		HotelRoom hr4 = new HotelRoom("301", 200, 1, 5);
		// creating guests
		Guest gue1 = new Guest("Paul");

		Guest gue2 = new Guest("Linda");
		Guest gue3 = new Guest("Archie");
		Guest gue4 = new Guest("Serinity");
		Guest gue5 = new Guest("Nobel");
		Guest gue6 = new Guest("Andrea");
		Guest gue7 = new Guest("Stephany");
		// creating servises
		Service servs1 = new Service(10, "Diner");
		Service servs2 = new Service(5, "Cleaning room");
		Service servs3 = new Service(8, "Parking");

		// adding service
		hotel.addServices(servs1);
		hotel.addServices(servs2);
		hotel.addServices(servs3);
		// adding rooms
		hotel.addRooms(hr1);
		hotel.addRooms(hr2);
		hotel.addRooms(hr3);
		hotel.addRooms(hr4);
		// test showing service and rooms sorted by category and price
		hotel.showPriceServiceAndHotelRoom();

		hotel.addAllGuests(gue1);
		hotel.addAllGuests(gue2);
		hotel.addAllGuests(gue3);
		hotel.addAllGuests(gue4);
		hotel.addAllGuests(gue5);
		hotel.addAllGuests(gue6);
		hotel.addAllGuests(gue7);

		// settle all guest to rooms
		hotel.settleGuestToHotelRoom(gue1, hr1, "15-12-2015", "18-12-2015");
		hotel.settleGuestToHotelRoom(gue2, hr2, "16-12-2015", "25-12-2015");
		hotel.settleGuestToHotelRoom(gue3, hr2, "16-12-2015", "25-12-2015");
		hotel.settleGuestToHotelRoom(gue4, hr3, "15-12-2015", "24-12-2015");
		hotel.settleGuestToHotelRoom(gue5, hr3, "15-12-2015", "24-12-2015");
		hotel.settleGuestToHotelRoom(gue6, hr3, "15-12-2015", "24-12-2015");
		hotel.settleGuestToHotelRoom(gue7, hr4, "17-12-2015", "19-12-2015");

		// settle a guest to room (2 not settle because have no space in room
		hotel.settleGuestToHotelRoom(gue2, hr1, "16-12-2015", "25-12-2015");

		// test showing list of guest and his rooms sorted by alphabet
		hotel.showAllGuests("alphabet");
		System.out.println("//////////////////////////////////////////////");
		hotel.showAllGuests("date");

		// testing showing a free rooms
		hotel.showNumberOfFreeHoterRoom();
		hotel.departGuestFromHotelRoom(hr1);
		hotel.showNumberOfFreeHoterRoom();

		// show number of all guests
		hotel.showAllGuestNumber();

		// show summ to paid guest(name)
		hotel.showSummToPaidGuest(gue1);

		// departure guest gue1 from hotel room hr1
		hotel.departGuestFromHotelRoom(hr1);

		// testing room history
		hotel.settleGuestToHotelRoom(gue3, hr1, "16-12-2015", "16-12-2015");
		hotel.departGuestFromHotelRoom(hr1);
		hotel.settleGuestToHotelRoom(gue2, hr1, "16-12-2015", "17-12-2015");
		hotel.departGuestFromHotelRoom(hr1);
		hotel.settleGuestToHotelRoom(gue4, hr1, "17-12-2015", "18-12-2015");
		hotel.departGuestFromHotelRoom(hr1);
		hotel.settleGuestToHotelRoom(gue3, hr1, "18-12-2015", "19-12-2015");
		hotel.departGuestFromHotelRoom(hr1);
		hotel.settleGuestToHotelRoom(gue2, hr1, "19-12-2015", "20-12-2015");
		hotel.departGuestFromHotelRoom(hr1);
		hotel.settleGuestToHotelRoom(gue7, hr1, "21-12-2015", "22-12-2015");
		hotel.departGuestFromHotelRoom(hr1);

		// show last 3 guests of room hr1
		hotel.showLast3GuestOfHotelRoom(hr1);

		// show detail of hotel room
		hotel.showDetailOfHotelRoom(hr1);

		// testing change status
		hotel.changeStatus(hr1);
		hotel.showDetailOfHotelRoom(hr1);
		hotel.changeStatus(hr1);
		hotel.showDetailOfHotelRoom(hr1);

		hotel.changePriceOfHotelRoom(hr1, 80);
		hotel.showDetailOfHotelRoom(hr1);

		// adding service to guest
		hotel.addServiceToGuest(gue1, servs1);
		hotel.addServiceToGuest(gue1, servs2);
		hotel.addServiceToGuest(gue1, servs3);

		// show list of all services sorted by condition
		hotel.showListOfService(gue1, "price");
		hotel.showListOfService(gue1, "date");

		// show list of all rooms sorted by condition
		System.out.println("Rooms by price");
		hotel.showAllRoms("price", "");
		System.out.println("Rooms by sleepN");
		hotel.showAllRoms("sleepN", "");
		System.out.println("Rooms by starN");
		hotel.showAllRoms("star", "");

		// testing show list of all free rooms sorted by condition

		hotel.departGuestFromHotelRoom(hr1);
		hotel.departGuestFromHotelRoom(hr2);
		hotel.departGuestFromHotelRoom(hr3);
		hotel.departGuestFromHotelRoom(hr4);
		hotel.showAllGuests("alphabet");
		System.out.println("Rooms by price");
		hotel.showAllRoms("price", "free");
		System.out.println("Rooms by sleepN");
		hotel.showAllRoms("sleepN", "free");
		System.out.println("Rooms by starN");
		hotel.showAllRoms("star", "free");
		// hotel.settleGuestToHotelRoom(gue1, hr1, "15-12-2015", "18-12-2015");
		// hotel.settleGuestToHotelRoom(gue2, hr2, "16-12-2015", "25-12-2015");
		hotel.settleGuestToHotelRoom(gue3, hr2, "16-12-2015", "25-12-2015");
		hotel.settleGuestToHotelRoom(gue4, hr3, "15-12-2015", "24-12-2015");
		hotel.settleGuestToHotelRoom(gue5, hr3, "15-12-2015", "24-12-2015");
		hotel.settleGuestToHotelRoom(gue6, hr3, "15-12-2015", "24-12-2015");
		hotel.settleGuestToHotelRoom(gue7, hr4, "17-12-2015", "19-12-2015");
		System.out.println("Rooms by price");
		hotel.showAllRoms("price", "free");
		hotel.showDetailOfHotelRoom(hr1);
		hotel.showDetailOfHotelRoom(hr2);
		hotel.showDetailOfHotelRoom(hr3);

		// testing show list of all free rooms sorted by condition
		hotel.showFreeRomsAfterDate("star", "24-12-2015");
		/*
		 * // writing guests to file String[] b = new String[10];
		 * ArrayList<Guest> a; int i = 0; for (Guest g : a =
		 * hotel.getAllGuests()) { b[i] = g.toString() + " "; i++; }
		 * fwGuest.writeToFile(b);
		 * 
		 * // reading guest from file String[] c = new String[7]; c =
		 * fwGuest.readFromFile(); String[] e = new String[0]; for (String b1 :
		 * c) { e = b1.split(","); String name =e[0]; String dateOfDeparture1 =
		 * e[1]; String dateOfArrive = e[2]; String numberOfRoom = e[3]; String
		 * summToPaid = e[4]; System.out.println( name + " " + dateOfDeparture1
		 * + " " + dateOfArrive + " " + numberOfRoom + " " + summToPaid);
		 * 
		 * }
		 */
	}

}
