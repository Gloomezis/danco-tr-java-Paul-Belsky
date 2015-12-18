package com.danco.gloomezis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.sql.Date;

public class HotelRoom {
ArrayList<Guest> guests;
String number;
int roomPrice;
int sleepingNumbers;
int starCategory;
boolean busy;
Date dateOfArrival;
Date dateOfDeparture;
LinkedList<Guest> guestHistory= new LinkedList<Guest>();
public HotelRoom(String number, int roomPrice, int sleepingNumbers, int starCategory) {
	super();
	this.number = number;
	this.roomPrice = roomPrice;
	this.sleepingNumbers = sleepingNumbers;
	this.starCategory = starCategory;
}
public ArrayList<Guest> getGuests() {
	return guests;
}
public void setGuests(ArrayList<Guest> guests) {
	this.guests = guests;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public int getRoomPrice() {
	return roomPrice;
}
public void setRoomPrice(int roomPrice) {
	this.roomPrice = roomPrice;
}
public int getSleepingNumbers() {
	return sleepingNumbers;
}
public void setSleepingNumbers(int sleepingNumbers) {
	this.sleepingNumbers = sleepingNumbers;
}
public int getStarCategory() {
	return starCategory;
}
public void setStarCategory(int starCategory) {
	this.starCategory = starCategory;
}
public boolean isBusy() {
	return busy;
}
public void setBusy(boolean busy) {
	this.busy = busy;
}
public Date getDateOfArrival() {
	return dateOfArrival;
}
public void setDateOfArrival(Date dateOfArrival) {
	this.dateOfArrival = dateOfArrival;
}
public Date getDateOfDeparture() {
	return dateOfDeparture;
}
public void setDateOfDeparture(Date dateOfDeparture) {
	this.dateOfDeparture = dateOfDeparture;
}
//TODO show guest history with date of him arrival and departure
public LinkedList<Guest> getGuestHistory() {
	return guestHistory;
}
//add guest to guesthistory (max numb=3)
public void setGuestHistory(Guest guest) {
	int a=guestHistory.size();
	if (a>=4){
		guestHistory.addFirst(guest);
	}else{
		guestHistory.removeLast();
		guestHistory.addFirst(guest);
	}
}





}
