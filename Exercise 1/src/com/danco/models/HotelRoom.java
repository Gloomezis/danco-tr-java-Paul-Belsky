package com.danco.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class HotelRoom {
	private ArrayList<Guest> guests = new ArrayList<Guest>();
	private String number;
	private int roomPrice;
	private int sleepingNumbers;
	private int starCategory;
	private boolean busy;
	private Date dateOfArrival = new Date(00-00-0000);
	private Date dateOfDeparture = new Date(00-00-0000);
	private LinkedList<Guest> guestHistory = new LinkedList<Guest>();
	private String statys = "in work";

	public HotelRoom(String number, int roomPrice, int sleepingNumbers,
			int starCategory) {
		super();
		this.number = number;
		this.roomPrice = roomPrice;
		this.sleepingNumbers = sleepingNumbers;
		this.starCategory = starCategory;
	}

	// +using to depart guest
	public ArrayList<Guest> getGuests() {
		return guests;
	}

	// +add guest to room if it have free space and adding to the guestHistory
	public void setGuests(Guest guest) {
		int a = guests.size();
		if (a < sleepingNumbers) {
			guests.add(guest);
			setGuestHistory(guest);

		} else {
			System.out.println("no have free sleeping place");

		}
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

	public boolean getBusy() {
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

	// +show guest history with date of him arrival and departure
	public LinkedList<Guest> getGuestHistory() {
		return guestHistory;
	}

	// add guest to guesthistory (max numb=3)
	public void setGuestHistory(Guest guest) {
		int a = guestHistory.size();
		if (a < 3) {
			guestHistory.addFirst(guest);
		} else {
			guestHistory.removeLast();
			guestHistory.addFirst(guest);
		}
	}

	public String getStatys() {
		return statys;
	}

	public void setStatys(String statys) {
		this.statys = statys;
	}

}
