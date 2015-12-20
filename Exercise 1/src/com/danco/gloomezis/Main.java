package com.danco.gloomezis;

import com.danco.models.Guest;
import com.danco.models.HotelRoom;
import com.danco.models.Service;
import com.danco.servises.GuestService;
import com.danco.servises.HotelRoomService;
import com.danco.servises.ServiceService;
import com.danco.training.*;

public class Main {

	public static void main(String[] args) {

		final String FILE_PATH_GUESTS = "src/src/files/guests.txt";
		TextFileWorker fwGuest = new TextFileWorker(FILE_PATH_GUESTS);

		final String FILE_PATH_HOTELROOMS = "src/src/files/hotelRooms.txt";
		TextFileWorker fwHotelRoms = new TextFileWorker(FILE_PATH_HOTELROOMS);

		final String FILE_PATH_SERVICES = "src/src/files/services.txt";
		TextFileWorker fwServices = new TextFileWorker(FILE_PATH_SERVICES);
		
		

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
		hotel.AddServices(servs1);
		hotel.AddServices(servs2);
		hotel.AddServices(servs3);
		// adding rooms
		hotel.AddRooms(hr1);
		hotel.AddRooms(hr2);
		hotel.AddRooms(hr3);
		hotel.AddRooms(hr4);
		// test showing service and rooms sorted by category and price
		hotel.showPriceServiceAndHotelRoom();

		hotel.AddAllGuests(gue1);
		hotel.AddAllGuests(gue2);
		hotel.AddAllGuests(gue3);
		hotel.AddAllGuests(gue4);
		hotel.AddAllGuests(gue5);
		hotel.AddAllGuests(gue6);
		hotel.AddAllGuests(gue7);

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
		hotel.getAllGuests("alphabet");
		System.out.println("//////////////////////////////////////////////////////////");
		hotel.getAllGuests("date");

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

	}

}
