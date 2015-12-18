package com.danco.gloomezis;

import java.sql.Date;
import java.util.ArrayList;

//for get method mb use only printLn to console overwriting return tupe

public class Hotel {
ArrayList<HotelRoom> rooms = new ArrayList<HotelRoom>();
ArrayList<Service> servises= new ArrayList<Service>();
ArrayList<HotelRoom> freeRooms= new ArrayList<HotelRoom>();
ArrayList<Guest> allGuests= new ArrayList<Guest>();

//TODO get array of Hotel rooms (Sorted by price/sleeping numbers/star category)
public ArrayList<HotelRoom> getRooms() {
	return rooms;
}
// Add room to array rooms
public void setRooms(HotelRoom room) {
	rooms.add(room);
}

//TODO  get array of servises  
public ArrayList<Service> getServises() {
	return servises;
}

// Add service to array servises
public void setServices(Service service) {
	servises.add(service);
}

//TODO Get free rooms (Sorted by price/sleeping numbers/star category)
public ArrayList<HotelRoom> getFreeRooms() {
	return freeRooms;
}

//TODO Add room to array free rooms( or change stastys of room )
public void setFreeRooms(HotelRoom room) {
	freeRooms.add(room);
}

// TODO Get all free rooms (Sorted by alphabet/by date dapartyre)
public ArrayList<Guest> getAllGuests() {
	return allGuests;
}

//add guest to array Guest
public void setAllGuests(Guest guest) {
	allGuests.add(guest);
}

// show number of all guest
public void showAllGuestNumber(){
	System.out.println("All guest number is:"+allGuests.size());
}

//show number of free rooms
public void showFreeRoomsNumber(){
	System.out.println("All free hotel rooms number is: "+freeRooms.size());
}

//TODO show list of hotel rooms that will  free after date
public void showFreeRoomsAfterDate(Date date){
	
}

// show summ to paid selected guest
public void showSummToPaidGuest(Guest guest){
	System.out.println("Summ to paid is: "+guest.summToPaid);
}

//TODO show last 3 guest of hotel room
public void showLast3GuestOfHotelRoom(HotelRoom hotelRoom){
	hotelRoom.getGuestHistory();
}
//TODO sorted by price
public void showPriceServiceAndHotelRoom(){
	
}
//TODO
public void showDetailOfHotelRoom(HotelRoom  hotelRoom){
	
}
}
