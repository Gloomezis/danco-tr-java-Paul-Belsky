package com.danco.storages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

import com.danco.comparators.HotelRoomPriceComparator;
import com.danco.comparators.HotelRoomSleepingNumberComparator;
import com.danco.comparators.HotelRoomStarComparator;
import com.danco.models.Guest;
import com.danco.models.HotelRoom;

public class HotelRoomStorage {

	private final String DATE_FORMAT = "dd-MM-yyyy";
	private final String IN_WORK = "in work";
	private final String UNDER_REPAIR = "under repair/serviced";
	private final String NOT_SETLED = "not setled";
	private final String SORT_COND_PRICE = "price";
	private final String SORT_COND_SLEEP_N = "sleepN";
	private final String SORT_COND_STAR = "star";
	private final String ROOM_PRINTER_FORMAT = "room: %s  , sleeping numbers: %d,  stars category: %d,  price: %d";
	private final String ROOM_DETAIL_FORMAT = "room number: %s,  room price: %d , sleeping numbers: %d, stars category: %d , busy: %s , status: %s";
	private final String LAST_3_GUEST_FORMAT = "The last 3 guest of hotel room: %s \n";
	private final String LAST_GUEST_FORMAT = " Name : %s, arrive: %s , depart : %s \n";
	private final String FREE_ROOM_NUMB_FORMAT = "free room: %d";
	private final String HOTEL_ROOM_FORMAT = "Hotel room: %s, price: %d \n";
	private final String FREE = "free";

	ArrayList<HotelRoom> rooms = new ArrayList<HotelRoom>();

	DateFormat df = new SimpleDateFormat(DATE_FORMAT);

	// singleton
	private static HotelRoomStorage instance;

	public static HotelRoomStorage getInstance() {
		if (instance == null) {
			instance = new HotelRoomStorage();
		}

		return instance;
	}

	private HotelRoomStorage() {
	}

	// +Add room to array rooms
	public void addRooms(HotelRoom room) {
		rooms.add(room);
	}

	// + change room price of selected room
	public void changePriceOfHotelRoom(HotelRoom hotelRoom, int roomPrice) {
		hotelRoom.setRoomPrice(roomPrice);
	}

	// + change status selected hotel room
	public void changeStatus(HotelRoom hotelRoom) {

		if (hotelRoom.getStatys() == IN_WORK) {
			hotelRoom.setStatys(UNDER_REPAIR);
		} else {
			hotelRoom.setStatys(IN_WORK);

		}
	}

	// + depart all guest from hotel number
	public void departGuestFromHotelRoom(HotelRoom hotelRoom) {
		for (Guest a : hotelRoom.getGuests()) {
			a.setNumberOfRoom(NOT_SETLED);
		}
		hotelRoom.getGuests().clear();
		hotelRoom.setBusy(false);
	}

	// TODO returnStatement
	// + print rooms inroomPrinterAllOrFree method
	public void roomPrinter(HotelRoom s) {
		System.out.println(new StringBuilder(String.format(ROOM_PRINTER_FORMAT,
				s.getNumber(), s.getSleepingNumbers(), s.getStarCategory(),
				s.getRoomPrice())));

	}

	// TODO returnStatement
	// + print rooms in showAllRooms method in change conditions (free room only
	// or all rooms)
	public void roomPrinterAllOrFree(String free) {
		if (free.equals(FREE)) {
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

	// +
	public void setDateOfArrival(String dateOfArrival, HotelRoom hotelRoom) {

		Date Pdate = null;
		try {
			Pdate = df.parse(dateOfArrival);
		} catch (Exception e) {
			e.printStackTrace();
		}
		hotelRoom.setDateOfArrival(Pdate);

	}

	// +
	public void setDateOfDeparture(String dateOfDeparture, HotelRoom hotelRoom) {

		Date Pdate = null;
		try {
			Pdate = df.parse(dateOfDeparture);
		} catch (Exception e) {
			e.printStackTrace();
		}
		hotelRoom.setDateOfDeparture(Pdate);
		;
	}

	// + settle guest to hotel room
	public void settleGuestToHotelRoom(Guest guest, HotelRoom hotelRoom,
			String dateOfArrival, String dateOfDeparture) {
		hotelRoom.setGuests(guest);

		setDateOfArrival(dateOfArrival, hotelRoom);
		setDateOfDeparture(dateOfDeparture, hotelRoom);

		guest.setNumberOfRoom(hotelRoom.getNumber());
		int a = hotelRoom.getGuests().size();
		if (a == hotelRoom.getSleepingNumbers()) {
			hotelRoom.setBusy(true);
		}
		guest.setSummToPaid(hotelRoom.getRoomPrice());
	}

	// TODO returnStatement
	// +show all rooms or free rooms sorted by condition
	public void showAllRooms(String sortCondition, String free) {
		sortRooms(sortCondition);
		roomPrinterAllOrFree(free);
	}

	// TODO returnStatement
	// + show detail selected hotel room
	public void showDetailOfHotelRoom(HotelRoom hotelRoom) {
		System.out.println(new StringBuilder(String.format(ROOM_DETAIL_FORMAT,
				hotelRoom.getNumber(), hotelRoom.getRoomPrice(),
				hotelRoom.getSleepingNumbers(), hotelRoom.getStarCategory(),
				hotelRoom.getBusy(), hotelRoom.getStatys())));

	}

	// TODO returnStatement
	// + show array of free Hotel rooms after date (Sorted by price/sleeping
	// numbers/star category)
	public void showFreeRomsAfterDate(String sortCondition, String date) {
		sortRooms(sortCondition);

		Date Pdate = null;
		Date Qdate = null;
		for (HotelRoom s : rooms) {
			try {
				Pdate = df.parse(date);
				Qdate = s.getDateOfDeparture();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (Pdate.compareTo(Qdate) > 0) {
				roomPrinter(s);
			}
		}
	}

	// TODO returnStatement
	// + show last 3 guest of hotel room
	public void showLast3GuestOfHotelRoom(HotelRoom hotelRoom) {
		LinkedList<Guest> g = hotelRoom.getGuestHistory();
		StringBuilder sb = new StringBuilder(String.format(LAST_3_GUEST_FORMAT,
				hotelRoom.getNumber()));

		for (Guest a : g) {
			sb.append(String.format(LAST_GUEST_FORMAT, a.getName(),
					df.format(a.getDateOfArrive()),
					df.format(a.getDateOfDeparture())));

		}
		System.out.println(sb);
	}

	// TODO returnStatement
	// + show number of all free rooms
	public void showNumberOfFreeHotelRooms() {
		int n = 0;
		for (HotelRoom a : rooms) {
			if (a.getBusy() == false) {
				n++;
			}
		}
		System.out.println(new StringBuilder(String.format(
				FREE_ROOM_NUMB_FORMAT, n)));
	}

	// TODO returnStatement
	// + show price hotel room sorted by price
	public void showPriceHotelRoom() {

		Collections.sort(rooms, new HotelRoomPriceComparator());
		StringBuilder sb = new StringBuilder(100);
		for (HotelRoom s : rooms) {
			sb.append(String.format(HOTEL_ROOM_FORMAT, s.getNumber(),
					s.getRoomPrice()));
		}
		System.out.println(sb);
	}

	// TODO returnStatement
	// + show array of Hotel rooms (Sorted by price/sleeping numbers/star
	// category)
	public void sortRooms(String sortCondition) {
		switch (sortCondition) {
		case SORT_COND_PRICE:
			Collections.sort(rooms, new HotelRoomPriceComparator());
			break;
		case SORT_COND_SLEEP_N:
			Collections.sort(rooms, new HotelRoomSleepingNumberComparator());
			break;
		case SORT_COND_STAR:
			Collections.sort(rooms, new HotelRoomStarComparator());
		default:
			break;
		}

	}

}
