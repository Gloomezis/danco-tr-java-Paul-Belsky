package com.danco.storages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.danco.comparators.HotelRoomPriceComparator;
import com.danco.comparators.HotelRoomSleepingNumberComparator;
import com.danco.comparators.HotelRoomStarComparator;
import com.danco.models.Guest;
import com.danco.models.HotelRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomStorage.
 */
public class HotelRoomStorage {

	/** The Constant DATE_FORMAT. */
	private static final  String DATE_FORMAT = "dd-MM-yyyy";
	
	/** The Constant IN_WORK. */
	private static final  String IN_WORK = "in work";
	
	/** The Constant NOT_SETLED. */
	private static final  String NOT_SETLED = "not setled";
	
	/** The Constant SORT_COND_PRICE. */
	private static final  String SORT_COND_PRICE = "price";
	
	/** The Constant SORT_COND_SLEEP_N. */
	private static final  String SORT_COND_SLEEP_N = "sleepN";
	
	/** The Constant SORT_COND_STAR. */
	private static final  String SORT_COND_STAR = "star";
	
	/** The Constant ROOM_PRINTER_FORMAT. */
	private static final  String ROOM_PRINTER_FORMAT = "room: %s  , sleeping numbers: %d,  stars category: %d,  price: %d";
	
	/** The Constant ROOM_DETAIL_FORMAT. */
	private static final  String ROOM_DETAIL_FORMAT = "room number: %s,  room price: %d , sleeping numbers: %d, stars category: %d , busy: %s , status: %s";
	
	/** The Constant LAST_3_GUEST_FORMAT. */
	private static final  String LAST_3_GUEST_FORMAT = "The last 3 guest of hotel room: %s \n";
	
	/** The Constant LAST_GUEST_FORMAT. */
	private static final  String LAST_GUEST_FORMAT = " Name : %s, arrive: %s , depart : %s \n";
	
	/** The Constant FREE_ROOM_NUMB_FORMAT. */
	private static final  String FREE_ROOM_NUMB_FORMAT = "free room: %d";
	
	/** The Constant HOTEL_ROOM_FORMAT. */
	private static final  String HOTEL_ROOM_FORMAT = "Hotel room: %s, price: %d \n";
	
	/** The Constant FREE. */
	private static final  String FREE = "free";

	/** The rooms. */
	List<HotelRoom> rooms = new ArrayList<HotelRoom>();

	/** The df. */
	DateFormat df = new SimpleDateFormat(DATE_FORMAT);


	
/**
 * Gets the hotel room by number.
 *
 * @param NumberOfRoom the number of room
 * @return the hotel room by number
 */
public HotelRoom getHotelRoomByNumber(String NumberOfRoom) {
		
		HotelRoom hr = null;
		for(HotelRoom hroom:rooms){
			if(hroom.getNumber().equals(NumberOfRoom)){
				hr=hroom;
			}
		}
		return hr;
	}
	
/**
 * Creates the hotel room.
 *
 * @param name the name
 * @param roomPrice the room price
 * @param sleepingNumbers the sleeping numbers
 * @param starCategory the star category
 * @return the hotel room
 */
public HotelRoom createHotelRoom(String name, int roomPrice, int sleepingNumbers,int starCategory){
	HotelRoom hotelRoom = new HotelRoom(name,roomPrice,sleepingNumbers,starCategory);
	return 	hotelRoom;
	
}
	
	/**
	 * Adds the rooms.
	 *
	 * @param room the room
	 */
	
	public void addRooms(HotelRoom room) {
		rooms.add(room);
	}

	/**
	 * Change price of hotel room.
	 *
	 * @param hotelRoom the hotel room
	 * @param roomPrice the room price
	 */
	
	public void changePriceOfHotelRoom(HotelRoom hotelRoom, int roomPrice) {
		hotelRoom.setRoomPrice(roomPrice);
	}

	/**
	 * Change status.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void changeStatus(HotelRoom hotelRoom) {

		if (hotelRoom.getStatys() == IN_WORK) {
			hotelRoom.setStatys(false);
		} else {
			hotelRoom.setStatys(true);

		}
	}

	/**
	 * Depart guest from hotel room.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void departGuestFromHotelRoom(HotelRoom hotelRoom) {
		for (Guest a : hotelRoom.getGuests()) {
			a.setNumberOfRoom(NOT_SETLED);
		}
		hotelRoom.getGuests().clear();
		hotelRoom.setBusy(false);
	}

	// TODO returnStatement
	/**
	 * Room printer.
	 *
	 * @param s the s
	 */
	
	public void roomPrinter(HotelRoom s) {
		System.out.println(String.format(ROOM_PRINTER_FORMAT,
				s.getNumber(), s.getSleepingNumbers(), s.getStarCategory(),
				s.getRoomPrice()));

	}

	// TODO returnStatement
	
	/**
	 * Room printer all or free.
	 *
	 * @param free the free
	 */
	
	public void roomPrinterAllOrFree(String free) {
		if (FREE.equals(free)) {
			for (HotelRoom s : rooms) {
				if (!s.getBusy()) {
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

	/**
	 * Sets the date of arrival.
	 *
	 * @param dateOfArrival the date of arrival
	 * @param hotelRoom the hotel room
	 */
	
	public void setDateOfArrival(Date dateOfArrival, HotelRoom hotelRoom) {

		
		hotelRoom.setDateOfArrival(dateOfArrival);

	}

	/**
	 * Sets the date of departure.
	 *
	 * @param dateOfDeparture the date of departure
	 * @param hotelRoom the hotel room
	 */
	
	public void setDateOfDeparture(Date dateOfDeparture, HotelRoom hotelRoom) {

		
		hotelRoom.setDateOfDeparture(dateOfDeparture);
		
	}

	/**
	 * Settle guest to hotel room.
	 *
	 * @param guest the guest
	 * @param hotelRoom the hotel room
	 * @param dateOfArrival the date of arrival
	 * @param dateOfDeparture the date of departure
	 */
	
	public void settleGuestToHotelRoom(Guest guest, HotelRoom hotelRoom,
			Date dateOfArrival, Date dateOfDeparture) {
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
	/**
	 * Show all rooms.
	 *
	 * @param sortCondition the sort condition
	 * @param free the free
	 */
	
	public void showAllRooms(String sortCondition, String free) {
		sortRooms(sortCondition);
		roomPrinterAllOrFree(free);
	}

	// TODO returnStatement
	/**
	 * Show detail of hotel room.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void showDetailOfHotelRoom(HotelRoom hotelRoom) {
		System.out.println(String.format(ROOM_DETAIL_FORMAT,
				hotelRoom.getNumber(), hotelRoom.getRoomPrice(),
				hotelRoom.getSleepingNumbers(), hotelRoom.getStarCategory(),
				hotelRoom.getBusy(), hotelRoom.getStatys()));

	}

	// TODO returnStatement
	
	/**
	 * Show free roms after date.
	 *
	 * @param sortCondition the sort condition
	 * @param date the date
	 */
	
	public void showFreeRomsAfterDate(String sortCondition, Date date) {
		sortRooms(sortCondition);

		Date Pdate = null;
		Date Qdate = null;
		for (HotelRoom s : rooms) {
			
				Pdate = date;
				Qdate = s.getDateOfDeparture();
			
			if (Pdate.compareTo(Qdate) > 0) {
				roomPrinter(s);
			}
		}
	}

	// TODO returnStatement
	/**
	 * Show last3 guest of hotel room.
	 *
	 * @param hotelRoom the hotel room
	 */
	
	public void showLast3GuestOfHotelRoom(HotelRoom hotelRoom) {
		LinkedList<Guest> g = hotelRoom.getGuestHistory();
		StringBuilder sb = new StringBuilder(500).append(String.format(LAST_3_GUEST_FORMAT,
				hotelRoom.getNumber()));

		for (Guest a : g) {
			sb.append(String.format(LAST_GUEST_FORMAT, a.getName(),
					df.format(a.getDateOfArrive()),
					df.format(a.getDateOfDeparture())));

		}
		System.out.println(sb);
	}

	// TODO returnStatement
	/**
	 * Show number of free hotel rooms.
	 */
	
	public void showNumberOfFreeHotelRooms() {
		int n = 0;
		for (HotelRoom a : rooms) {
			if (a.getBusy() == false) {
				n++;
			}
		}
		System.out.println(String.format(
				FREE_ROOM_NUMB_FORMAT, n));
	}

	// TODO returnStatement
	/**
	 * Show price hotel room.
	 */
	
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
	
	/**
	 * Sort rooms.
	 *
	 * @param sortCondition the sort condition
	 */
	
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
			break;
		default:
			break;
		}

	}

}
