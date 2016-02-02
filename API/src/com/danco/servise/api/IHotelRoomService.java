package com.danco.servise.api;

import java.util.Date;
import java.util.List;

import com.danco.model.Guest;
import com.danco.model.HotelRoom;

public interface IHotelRoomService {

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
	 */
	public HotelRoom createHotelRoom(String name, int roomPrice,
			int sleepingNumbers, int starCategory);

	/**
	 * Gets the hotel room by number.
	 *
	 * @param NumberOfRoom
	 *            the number of room
	 * @return the hotel room by number
	 */
	public HotelRoom getHotelRoomByNumber(String NumberOfRoom);

	/**
	 * Show all roms.
	 *
	 * @param sortCondition
	 *            the sort condition
	 * @param free
	 *            the free
	 */

	public List<HotelRoom> showAllRooms(String sortCondition, String free);

	/**
	 * Show free roms after date.
	 *
	 * @param sortCondition
	 *            the sort condition
	 * @param date
	 *            the date
	 */

	public List<HotelRoom> showFreeRomsAfterDate(String sortCondition, Date date);

	/**
	 * Show number of free hotel rooms.
	 */

	public int showNumberOfFreeHotelRooms();

	/**
	 * Show last3 guest of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 */

	public List<Guest> showLast3GuestOfHotelRoom(HotelRoom hotelRoom);

	/**
	 * Show detail of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 */

	public String showDetailOfHotelRoom(HotelRoom hotelRoom);

	/**
	 * Settle guest to hotel room.
	 *
	 * @param guest
	 *            the guest
	 * @param hotelRoom
	 *            the hotel room
	 * @param dateOfArrive
	 *            the date of arrive
	 * @param dateOfDeparture
	 *            the date of departure
	 */

	public void settleGuestToHotelRoom(Guest guest, HotelRoom hotelRoom,
			Date dateOfArrive, Date dateOfDeparture);

	/**
	 * Depart guest from hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 */

	public void departGuestFromHotelRoom(HotelRoom hotelRoom);

	/**
	 * Change status.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 */

	public void changeStatus(HotelRoom hotelRoom);

	/**
	 * Adds the rooms.
	 *
	 * @param room
	 *            the room
	 */

	public void addRooms(HotelRoom room);

	/**
	 * Change price of hotel room.
	 *
	 * @param hotelRoom
	 *            the hotel room
	 * @param roomPrice
	 *            the room price
	 */

	public void changePriceOfHotelRoom(HotelRoom hotelRoom, int roomPrice);

	/**
	 * Show price services.
	 */

	public List<HotelRoom> showPriceHotelRoom();

	/**
	 * Clone.
	 *
	 * @param room
	 *            the room
	 * @return the hotel room
	 * @throws CloneNotSupportedException
	 *             the clone not supported exception
	 */
	public HotelRoom cloneHotelRoom(HotelRoom room);

	public List<HotelRoom> getRooms();

}