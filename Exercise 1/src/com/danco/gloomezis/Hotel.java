package com.danco.gloomezis;

import java.sql.Date;
import java.util.ArrayList;

public class Hotel {
ArrayList<HotelRoom> rooms;
ArrayList<Service> servises;
ArrayList<HotelRoom> freeRooms;
ArrayList<Guest> allGuests;

//Sorted by price/sleeping numbers/star category
public ArrayList<HotelRoom> getRooms() {
	return rooms;
}
public void setRooms(ArrayList<HotelRoom> rooms) {
	this.rooms = rooms;
}
public ArrayList<Service> getServises() {
	return servises;
}
public void setServises(ArrayList<Service> servises) {
	this.servises = servises;
}

//Sorted by price/sleeping numbers/star category
public ArrayList<HotelRoom> getFreeRooms() {
	return freeRooms;
}
public void setFreeRooms(ArrayList<HotelRoom> freeRooms) {
	this.freeRooms = freeRooms;
}

//Sorted by alphabet/by date dapartyre
public ArrayList<Guest> getAllGuests() {
	return allGuests;
}
public void setAllGuests(ArrayList<Guest> allGuests) {
	this.allGuests = allGuests;
}

public void showAllGuestNumber(){
	
}
public void showFreeRoomsNumber(){
	
}
public void showFreeRoomsAfterDate(Date date){
	
}

public void showSummToPaidGuest(Guest guest){
	
}
public void showLast3GuestOfHotelRoom(HotelRoom hotelRoom){
	
}
//sorted by price
public void showPriceServiceAndHotelRoom(){
	
}
public void showDetailOfHotelRoom(HotelRoom  hotelRoom){
	
}
}
