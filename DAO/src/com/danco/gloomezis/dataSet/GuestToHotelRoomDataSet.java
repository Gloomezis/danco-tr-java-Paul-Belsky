package com.danco.gloomezis.dataSet;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestToHotelRoomDataSet.
 */
public class GuestToHotelRoomDataSet {

	/** The guest to hotel room id. */
	private int guestToHotelRoomId;

	/** The guest id. */
	private int guestId;

	/** The hotel room id. */
	private int hotelRoomId;

	/** The date of arrival. */
	private Date dateOfArrival;

	/** The date of departure. */
	private Date dateOfDeparture;

	/**
	 * Instantiates a new guest to hotel room data set.
	 *
	 * @param guestToHotelRoomId
	 *            the guest to hotel room id
	 * @param guestId
	 *            the guest id
	 * @param hotelRoomId
	 *            the hotel room id
	 * @param dateOfArrival
	 *            the date of arrival
	 * @param dateOfDeparture
	 *            the date of departure
	 */
	public GuestToHotelRoomDataSet(int guestToHotelRoomId, int guestId,
			int hotelRoomId, Date dateOfArrival, Date dateOfDeparture) {
		super();
		this.guestToHotelRoomId = guestToHotelRoomId;
		this.guestId = guestId;
		this.hotelRoomId = hotelRoomId;
		this.dateOfArrival = dateOfArrival;
		this.dateOfDeparture = dateOfDeparture;
	}

	/**
	 * Instantiates a new guest to hotel room data set.
	 *
	 * @param guestId
	 *            the guest id
	 * @param hotelRoomId
	 *            the hotel room id
	 * @param dateOfArrival
	 *            the date of arrival
	 * @param dateOfDeparture
	 *            the date of departure
	 */
	public GuestToHotelRoomDataSet(int guestId, int hotelRoomId,
			Date dateOfArrival, Date dateOfDeparture) {
		super();
		this.guestToHotelRoomId = -1;
		this.guestId = guestId;
		this.hotelRoomId = hotelRoomId;
		this.dateOfArrival = dateOfArrival;
		this.dateOfDeparture = dateOfDeparture;
	}

	/**
	 * Gets the guest to hotel room id.
	 *
	 * @return the guest to hotel room id
	 */
	public int getGuestToHotelRoomId() {
		return guestToHotelRoomId;
	}

	/**
	 * Gets the guest id.
	 *
	 * @return the guest id
	 */
	public int getGuestId() {
		return guestId;
	}

	/**
	 * Gets the hotel room id.
	 *
	 * @return the hotel room id
	 */
	public int getHotelRoomId() {
		return hotelRoomId;
	}

	/**
	 * Gets the date of arrival.
	 *
	 * @return the date of arrival
	 */
	public Date getDateOfArrival() {
		return dateOfArrival;
	}

	/**
	 * Gets the date of departure.
	 *
	 * @return the date of departure
	 */
	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}
}
