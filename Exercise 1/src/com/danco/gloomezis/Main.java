package com.danco.gloomezis;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// ñreating hotel		
Hotel hotel = new Hotel();
//creating hotel rooms
HotelRoom hr1 = new HotelRoom("101", 100, 1, 5);
HotelRoom hr2 = new HotelRoom("102", 50, 2, 4);
HotelRoom hr3 = new HotelRoom("201", 75, 3, 3);
HotelRoom hr4 = new HotelRoom("301", 200, 1, 5);
//creating guests
Guest gue1 = new Guest("Paul");
Guest gue2 = new Guest("Linda");
Guest gue3 = new Guest("Archie");
Guest gue4 = new Guest("Serinity");
Guest gue5 = new Guest("Nobel");
Guest gue6 = new Guest("Andrea");
Guest gue7 = new Guest("Stephany");
//creating servises
Service servs1 = new Service(10, "Diner");
Service servs2= new Service(5, "Cleaning room");
Service servs3= new Service(10, "Parking");

hotel.showAllGuestNumber();
hotel.showFreeRoomsNumber();
hotel.showSummToPaidGuest(gue1);

//settle a guest to room (2 not settle because have no space in room
hotel.settleGuestToHotelRoom(gue1,hr1);
hotel.settleGuestToHotelRoom(gue2,hr1);

//departe guest gue1 from hotel room hr1
hotel.departGuestFromHotelRoom(hr1);

//testing room history
hotel.settleGuestToHotelRoom(gue3,hr1);  
hotel.departGuestFromHotelRoom(hr1);
hotel.settleGuestToHotelRoom(gue2,hr1);
hotel.departGuestFromHotelRoom(hr1);
hotel.settleGuestToHotelRoom(gue4,hr1);
hotel.departGuestFromHotelRoom(hr1);
hotel.settleGuestToHotelRoom(gue3,hr1);  
hotel.departGuestFromHotelRoom(hr1);
hotel.settleGuestToHotelRoom(gue2,hr1);
hotel.departGuestFromHotelRoom(hr1);
hotel.settleGuestToHotelRoom(gue7,hr1);
hotel.departGuestFromHotelRoom(hr1);
//show last 3 guests of room hr1
hotel.showLast3GuestOfHotelRoom(hr1);
	}

}
