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

	}

}
