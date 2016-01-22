package com.danco.storages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.danco.comparator.HotelRoomPriceComparator;
import com.danco.comparator.HotelRoomSleepingNumberComparator;
import com.danco.comparator.HotelRoomStarComparator;
import com.danco.model.Guest;
import com.danco.model.HotelRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomStorage.
 */
public class HotelRoomStorage implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant IN_WORK. */
	private static final String IN_WORK = "in work";

	/** The Constant NOT_SETLED. */
	private static final String NOT_SETLED = "not setled";

	/** The Constant SORT_COND_PRICE. */
	private static final String SORT_COND_PRICE = "price";

	/** The Constant SORT_COND_SLEEP_N. */
	private static final String SORT_COND_SLEEP_N = "sleepN";

	/** The Constant SORT_COND_STAR. */
	private static final String SORT_COND_STAR = "star";

	/** The Constant ROOM_DETAIL_FORMAT. */
	private static final String ROOM_DETAIL_FORMAT = "room number: %s,  room price: %d , sleeping numbers: %d, stars category: %d , busy: %s , status: %s";

	/** The Constant FREE. */
	private static final String FREE = "free";

	/** The rooms. */
	private List<HotelRoom> rooms = new ArrayList<HotelRoom>();

	/** The rooms for sort. */
	private List<HotelRoom> roomsForSort;



	/**
	 * Gets the hotel room by number.
	 *
	 * @param NumberOfRoom
	 *            the number of room
	 * @return the hotel room by number
	 * @throws Exception
	 *             the exception
	 */
	public HotelRoom getHotelRoomByNumber(String NumberOfRoom) throws Exception {

		HotelRoom hr = null;
		for (HotelRoom hroom : rooms) {
			if (hroom.getNumber().equals(NumberOfRoom)) {
				hr = hroom;
			}
		}
		return hr;
	}

	/**
	 * Creates the hotel room.
	 *
	 * @param name
	 *            the name
	 * @param roomPrice
	 *            the room price
	 * @param sleepingNumbers
	 *            the sleeping numbers
	 * @param starCategory
	 *            the star category
	 * @return the hotel room
	 * @throws Exception
	 *             the exception
	 */
	public HotelRoom createHotelRoom(String name, int roomPrice, int sleepingNumbers, int starCategory)
			throws Exception {
		HotelRoom hotelRoom = new HotelRoom(name, roomPrice, sleepingNumbers, starCategory);
		return hotelRoom;

	}

	/**
	 * Adds the rooms.
	 *
	 * @param room
	 *            the room
	 * @throws Exception
	 *             the exception
	 */

	public void addRooms(HotelRoom room) throws Exception {
		rooms.add(room);
	}

	/**
	 * Change price of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 * @param roomPrice
	 *            the room price
	 * @throws Exception
	 *             the exception
	 */

	public void changePriceOfHotelRoom(HotelRoom hotelRoom, int roomPrice) throws Exception {
		hotelRoom.setRoomPrice(roomPrice);
	}

	/**
	 * Change status.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 * @throws Exception
	 *             the exception
	 */

	public void changeStatus(HotelRoom hotelRoom) throws Exception {
	

		if (hotelRoom.getStatys() == IN_WORK) {
			hotelRoom.setStatys(false);
		} else {
			hotelRoom.setStatys(true);
		}
		
	}

	/**
	 * Depart guest from hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 * @throws Exception
	 *             the exception
	 */

	public void departGuestFromHotelRoom(HotelRoom hotelRoom) throws Exception {
		for (Guest a : hotelRoom.getGuests()) {
			a.setNumberOfRoom(NOT_SETLED);
		}
		hotelRoom.clearGuest();
		hotelRoom.setBusy(false);
	}

	/**
	 * Sets the date of arrival.
	 *
	 * @param dateOfArrival
	 *            the date of arrival
	 * @param hotelRoom
	 *            the hotel room
	 * @throws Exception
	 *             the exception
	 */

	public void setDateOfArrival(Date dateOfArrival, HotelRoom hotelRoom) throws Exception {

		hotelRoom.setDateOfArrival(dateOfArrival);

	}

	/**
	 * Sets the date of departure.
	 *
	 * @param dateOfDeparture
	 *            the date of departure
	 * @param hotelRoom
	 *            the hotel room
	 * @throws Exception
	 *             the exception
	 */

	public void setDateOfDeparture(Date dateOfDeparture, HotelRoom hotelRoom) throws Exception {

		hotelRoom.setDateOfDeparture(dateOfDeparture);

	}

	/**
	 * Settle guest to hotel room.
	 *
	 * @param guest
	 *            the guest
	 * @param hotelRoom
	 *            the hotel room
	 * @param dateOfArrival
	 *            the date of arrival
	 * @param dateOfDeparture
	 *            the date of departure
	 * @throws Exception
	 *             the exception
	 */

	public void settleGuestToHotelRoom(Guest guest, HotelRoom hotelRoom, Date dateOfArrival, Date dateOfDeparture)
			throws Exception {
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
	 * @param sortCondition
	 *            the sort condition
	 * @param free
	 *            the free
	 * @throws Exception
	 *             the exception
	 */

	public List<HotelRoom> showAllRooms(String sortCondition, String free) throws Exception {
		roomsForSort = new ArrayList<HotelRoom>(rooms);
		sortRooms(sortCondition);

		List<HotelRoom> selecter = new ArrayList<HotelRoom>();
		if (FREE.equals(free)) {
			for (HotelRoom s : roomsForSort) {
				if (!s.getBusy()) {
					selecter.add(s);
				}
			}
			return selecter;
		}
		return roomsForSort;
	}

	// TODO returnStatement
	/**
	 * Show detail of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 * @throws Exception
	 *             the exception
	 */

	public String showDetailOfHotelRoom(HotelRoom hotelRoom) throws Exception {

		String detail = String.format(ROOM_DETAIL_FORMAT, hotelRoom.getNumber(), hotelRoom.getRoomPrice(),
				hotelRoom.getSleepingNumbers(), hotelRoom.getStarCategory(), hotelRoom.getBusy(),
				hotelRoom.getStatys());
		return detail;

	}

	// TODO returnStatement

	/**
	 * Show free roms after date.
	 *
	 * @param sortCondition
	 *            the sort condition
	 * @param date
	 *            the date
	 * @throws Exception
	 *             the exception
	 */

	public List<HotelRoom> showFreeRomsAfterDate(String sortCondition, Date date) throws Exception {
		roomsForSort = new ArrayList<HotelRoom>(rooms);
		sortRooms(sortCondition);
		List<HotelRoom> selecter = new ArrayList<HotelRoom>();

		Date pDate = null;
		Date qDate = null;
		for (HotelRoom s : roomsForSort) {

			pDate = date;
			qDate = s.getDateOfDeparture();

			if (pDate.compareTo(qDate) > 0) {
				selecter.add(s);

			}
		}
		return selecter;
	}

	// TODO returnStatement
	/**
	 * Show last3 guest of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 * @throws Exception
	 *             the exception
	 */

	public List<Guest> showLast3GuestOfHotelRoom(HotelRoom hotelRoom) throws Exception {
		LinkedList<Guest> g = hotelRoom.getGuestHistory();
		return g;
	}

	// TODO returnStatement
	/**
	 * Show number of free hotel rooms.
	 *
	 * @throws Exception
	 *             the exception
	 */

	public int showNumberOfFreeHotelRooms() throws Exception {
		int n = 0;
		for (HotelRoom a : rooms) {
			if (a.getBusy() == false) {
				n++;
			}
		}
		return n;
	}

	// TODO returnStatement
	/**
	 * Show price hotel room.
	 *
	 * @throws Exception
	 *             the exception
	 */

	public List<HotelRoom> showPriceHotelRoom() throws Exception {
		roomsForSort = new ArrayList<HotelRoom>(rooms);
		Collections.sort(roomsForSort, new HotelRoomPriceComparator());
		return roomsForSort;

	}

	// TODO returnStatement

	/**
	 * Sort rooms.
	 *
	 * @param sortCondition
	 *            the sort condition
	 * @throws Exception
	 *             the exception
	 */

	public void sortRooms(String sortCondition) throws Exception {
		switch (sortCondition) {
		case SORT_COND_PRICE:
			Collections.sort(roomsForSort, new HotelRoomPriceComparator());
			break;
		case SORT_COND_SLEEP_N:
			Collections.sort(roomsForSort, new HotelRoomSleepingNumberComparator());
			break;
		case SORT_COND_STAR:
			Collections.sort(roomsForSort, new HotelRoomStarComparator());
			break;
		default:
			break;
		}

	}

	/**
	 * Clone.
	 *
	 * @param room
	 *            the room
	 * @return the hotel room
	 * @throws CloneNotSupportedException
	 *             the clone not supported exception
	 */
	public HotelRoom cloneHotelRoom(HotelRoom room) throws CloneNotSupportedException {
		return room.clone();

	}

}
