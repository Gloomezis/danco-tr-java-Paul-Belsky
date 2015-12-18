package com.danco.storages;

import java.util.ArrayList;
import java.util.LinkedList;

import com.danco.models.Guest;
import com.danco.models.HotelRoom;

public class HotelRoomStorage {
	
	ArrayList<HotelRoom> rooms = new ArrayList<HotelRoom>();
	
	//singleton
		private static volatile HotelRoomStorage instance;
		
		private  HotelRoomStorage() {}
		public static HotelRoomStorage getInstance(){
			if (instance ==null){
				synchronized (HotelRoomStorage.class) {
					if(instance == null){
						instance = new HotelRoomStorage();
					}
					
				}
			}
			return instance;
		}

	// TODO get array of Hotel rooms (Sorted by price/sleeping numbers/star
	// category)
	public ArrayList<HotelRoom> getRooms() {
		return rooms;
	}

	// Add room to array rooms
	public void setRooms(HotelRoom room) {
		rooms.add(room);
	}

	// TODO
	public void showDetailOfHotelRoom(HotelRoom hotelRoom) {
		hotelRoom.toString();

	}

	// settle guest to hotel room
	// TODO adding date of settle and date of departure
	public void settleGuestToHotelRoom(Guest guest, HotelRoom hotelRoom) {
		hotelRoom.setGuests(guest);

	}

	// depart all guest from hotel number
	public void departGuestFromHotelRoom(HotelRoom hotelRoom) {
		hotelRoom.getGuests().clear();
	}

	// show last 3 guest of hotel room
	public void showLast3GuestOfHotelRoom(HotelRoom hotelRoom) {
		LinkedList<Guest> g = hotelRoom.getGuestHistory();
		System.out.println("The last 3 guest of hotel room " + hotelRoom.getNumber() + " was:");
		for (Guest a : g) {
			System.out.println(a.getName() + " " + a.getDateOfDeparture());
		}
	}
	
	// TODO sorted by price
		public void showPriceHotelRoom() {

		}
}
