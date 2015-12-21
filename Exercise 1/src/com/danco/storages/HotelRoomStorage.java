package com.danco.storages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;

import com.danco.models.Guest;
import com.danco.models.HotelRoom;

public class HotelRoomStorage {

	ArrayList<HotelRoom> rooms = new ArrayList<HotelRoom>();

	// singleton
	private static volatile HotelRoomStorage instance;

	private HotelRoomStorage() {
	}

	public static HotelRoomStorage getInstance() {
		if (instance == null) {
			synchronized (HotelRoomStorage.class) {
				if (instance == null) {
					instance = new HotelRoomStorage();
				}

			}
		}
		return instance;
	}

	// +show all rooms or free rooms sorted by condition
	public void showAllRooms(String sortCondition, String free) {
		sortRooms(sortCondition);
		roomPrinterAllOrFree(free);
	}

	// + show array of Hotel rooms (Sorted by price/sleeping numbers/star
	// category)
	public void sortRooms(String sortCondition) {
		switch (sortCondition) {
		case "price":
			Collections.sort(rooms, new PriceCompare());
			break;
		case "sleepN":
			Collections.sort(rooms, new SleepingNumbers());
			break;
		case "star":
			Collections.sort(rooms, new StarCompare());
		default:
			break;
		}

	}

	// + print rooms in showAllRooms method in change conditions (free room only
	// or all rooms)
	public void roomPrinterAllOrFree(String free) {
		if (free.equals("free")) {
			for (HotelRoom s : rooms) {
				if (s.getBusy() == false) {
					roomPrinter(s);
				} else {
				}
			}
		} else {
			for (HotelRoom s : rooms) {
				roomPrinter(s);
			}
		}
	}

	// + print rooms inroomPrinterAllOrFree method
	public void roomPrinter(HotelRoom s) {
		System.out.println("Room: " + s.getNumber() + " , sleeping numbers: " + s.getSleepingNumbers()
				+ " , stars category: " + s.getStarCategory() + " , price: " + s.getRoomPrice());

	}

	// + show array of free Hotel rooms after date (Sorted by price/sleeping
	// numbers/star category)
	public void showFreeRomsAfterDate(String sortCondition, String date) {
		sortRooms(sortCondition);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date Pdate = null;
		Date Qdate = null;
		for (HotelRoom s : rooms) {
			try {
				Pdate = df.parse(date);
				Qdate = df.parse(s.getDateOfDeparture());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (Pdate.compareTo(Qdate) > 0) {
				roomPrinter(s);
			}
		}
	}

	// + show number of all free rooms
	public void showNumberOfFreeHotelRooms() {
		int n = 0;
		for (HotelRoom a : rooms) {
			if (a.getBusy() == false) {
				n++;
			}

		}
		System.out.println("Free rooms: " + n);
	}

	// + show last 3 guest of hotel room
	public void showLast3GuestOfHotelRoom(HotelRoom hotelRoom) {
		LinkedList<Guest> g = hotelRoom.getGuestHistory();
		System.out.println("The last 3 guest of hotel room " + hotelRoom.getNumber() + " was:");
		for (Guest a : g) {
			System.out.println(a.getName() + " arrive " + a.getDateOfArrive() + " ,depart: " + a.getDateOfDeparture());
		}
	}

	// + show price hotel room sorted by price
	public void showPriceHotelRoom() {

		Collections.sort(rooms, new PriceCompare());
		for (HotelRoom s : rooms) {
			System.out.println("Hotel room: " + s.getNumber() + " , price: " + s.getRoomPrice());

		}

	}

	// + show detail selected hotel room
	public void showDetailOfHotelRoom(HotelRoom hotelRoom) {
		System.out.println("Room number: " + hotelRoom.getNumber() + "\n Room price:" + hotelRoom.getRoomPrice()
				+ "\n Sleeping numbers:" + hotelRoom.getSleepingNumbers() + "\n Star category: "
				+ hotelRoom.getStarCategory() + "\n busy: " + hotelRoom.getBusy() + "\n status:"
				+ hotelRoom.getStatys());
	}

	// + settle guest to hotel room
	public void settleGuestToHotelRoom(Guest guest, HotelRoom hotelRoom) {
		hotelRoom.setGuests(guest);
		guest.setNumberOfRoom(hotelRoom.getNumber());
		int a = hotelRoom.getGuests().size();
		if (a == hotelRoom.getSleepingNumbers()) {
			hotelRoom.setBusy(true);
		}
		guest.setSummToPaid(hotelRoom.getRoomPrice());
	}

	// + depart all guest from hotel number
	public void departGuestFromHotelRoom(HotelRoom hotelRoom) {
		for (Guest a : hotelRoom.getGuests()) {
			a.setNumberOfRoom("not setled");
		}
		hotelRoom.getGuests().clear();
		hotelRoom.setBusy(false);
	}

	// + change status selected hotel room
	public void changeStatus(HotelRoom hotelRoom) {

		if (hotelRoom.getStatys() == "in work") {
			hotelRoom.setStatys("under repair/serviced");
		} else {
			hotelRoom.setStatys("in work");

		}
	}

	// +Add room to array rooms
	public void setRooms(HotelRoom room) {
		rooms.add(room);
	}

	// + change room price of selected room
	public void changePriceOfHotelRoom(HotelRoom hotelRoom, int roomPrice) {
		hotelRoom.setRoomPrice(roomPrice);
	}

	// +
	public void setDateOfArrival(String dateOfArrival, HotelRoom hotelRoom) {
		hotelRoom.setDateOfArrival(dateOfArrival);
	}

	// +
	public void setDateOfDeparture(String dateOfDeparture, HotelRoom hotelRoom) {
		hotelRoom.setDateOfDeparture(dateOfDeparture);
	}

	// ///////////////
	// / Comparators///
	// ///////////////

	// comparator by name
	class PriceCompare implements Comparator<HotelRoom> {

		@Override
		public int compare(HotelRoom hotelRoom1, HotelRoom hotelRoom2) {

			int price1 = hotelRoom1.getRoomPrice();
			int price2 = hotelRoom2.getRoomPrice();

			if (price1 > price2) {
				return 1;
			} else if (price1 < price2) {
				return -1;
			}
			return 0;

		}
	}

	// comparator by StarCategory
	class StarCompare implements Comparator<HotelRoom> {

		@Override
		public int compare(HotelRoom hotelRoom1, HotelRoom hotelRoom2) {

			int star1 = hotelRoom1.getStarCategory();
			int star2 = hotelRoom2.getStarCategory();

			if (star1 > star2) {
				return 1;
			} else if (star1 < star2) {
				return -1;
			}
			return 0;

		}
	}

	// compare hotel rooms by date of departure
	public class DateOfDepartureCompare implements Comparator<HotelRoom> {

		public int compare(HotelRoom p, HotelRoom q) {

			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date Pdate = null;
			Date Qdate = null;
			try {
				Pdate = df.parse(p.getDateOfDeparture());
				Qdate = df.parse(q.getDateOfDeparture());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return Pdate.compareTo(Qdate);
		}
	}

	// TODO testing comparator by sleepNumbers
	class SleepingNumbers implements Comparator<HotelRoom> {

		@Override
		public int compare(HotelRoom hotelRoom1, HotelRoom hotelRoom2) {

			int sleepNumbers1 = hotelRoom1.getSleepingNumbers();
			int sleepNumbers2 = hotelRoom2.getSleepingNumbers();

			if (sleepNumbers1 > sleepNumbers2) {
				return 1;
			} else if (sleepNumbers1 < sleepNumbers2) {
				return -1;
			}
			return 0;

		}
	}
}
