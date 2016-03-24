/*
 * 
 */
package com.danco.model;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestToHotelRoomDataSet.
 */
public class Orders extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The guest id. */
	private int guestId;

	/** The hotel room id. */
	private int hotelRoomId;

	/** The date of arrival. */
	private Date dateOfArrival;

	/** The date of departure. */
	private Date dateOfDeparture;
	
	private boolean paid = false;

	/**
	 * Instantiates a new guest to hotel room data set.
	 * @param guestId
	 *            the guest id
	 * @param hotelRoomId
	 *            the hotel room id
	 * @param dateOfArrival
	 *            the date of arrival
	 * @param dateOfDeparture
	 *            the date of departure
	 * @param orderId 
	 */
	public Orders(int id, int guestId,
			int hotelRoomId, Date dateOfArrival, Date dateOfDeparture, boolean paid) {
		super();
		super.setId(id);
		this.guestId = guestId;
		this.hotelRoomId = hotelRoomId;
		this.dateOfArrival = dateOfArrival;
		this.dateOfDeparture = dateOfDeparture;
		this.paid=paid;
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
	public Orders(int guestId, int hotelRoomId,
			Date dateOfArrival, Date dateOfDeparture) {
		super();
		super.setId( -1);
		this.guestId = guestId;
		this.hotelRoomId = hotelRoomId;
		this.dateOfArrival = dateOfArrival;
		this.dateOfDeparture = dateOfDeparture;
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

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	
}
