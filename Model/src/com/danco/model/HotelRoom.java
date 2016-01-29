package com.danco.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.danco.anotation.Printable;
import com.danco.anotation.PrintableObject;
import com.danco.anotation.PrintableRef;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoom.
 */
@PrintableObject(name ="Hotel room")
public class HotelRoom implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "dd-MM-yyyy";

	/** The df. */
	private DateFormat df = new SimpleDateFormat(DATE_FORMAT);

	/** The Constant IN_WORK. */
	private static final String IN_WORK = "in work";

	/** The Constant UNDER_REPAIR. */
	private static final String UNDER_REPAIR = "under repair/serviced";

	/** The guests. */
	private List<Guest> guests = new ArrayList<Guest>();

	/** The number. */
	@Printable(name = "Hotel room number", order = 1)
	private String number;

	/** The room price. */
	@Printable(name = "room price", order = 2)
	private int roomPrice;

	/** The sleeping numbers. */
	@Printable(name = "Sleeping numbers", order = 3)
	private int sleepingNumbers;

	/** The star category. */
	@Printable(name = "Star category", order = 4)
	private int starCategory;

	/** The busy. */
	@Printable(name = "Busy", order = 5)
	private boolean busy=false;

	/** The date of arrival. */
	@Printable(name = "Date of arrive", order = 6)
	private Date dateOfArrival = new Date();

	/** The date of departure. */
	@Printable(name = "Date of depart", order = 7)
	private Date dateOfDeparture = new Date();

	/** The guest history. */
	@PrintableRef(name= "Guest history",isDetailedView = false,order=8)
	private LinkedList<Guest> guestHistory = new LinkedList<Guest>();

	/** The statys. */
	@Printable(name = "Status", order = 1)
	private boolean statys = true;

	/**
	 * Instantiates a new hotel room.
	 *
	 * @param number
	 *            the number
	 * @param roomPrice
	 *            the room price
	 * @param sleepingNumbers
	 *            the sleeping numbers
	 * @param starCategory
	 *            the star category
	 */
	public HotelRoom(String number, int roomPrice, int sleepingNumbers,
			int starCategory) {
		super();
		this.number = number;
		this.roomPrice = roomPrice;
		this.sleepingNumbers = sleepingNumbers;
		this.starCategory = starCategory;
	}

	/**
	 * Gets the guests.
	 *
	 * @return the guests
	 */

	public List<Guest> getGuests() {
		return guests;
	}

	/**
	 * Sets the guests.
	 *
	 * @param guest
	 *            the new guests
	 */

	public void setGuests(Guest guest) {
		int a = guests.size();
		if (a < sleepingNumbers) {
			guests.add(guest);
			setGuestHistory(guest);
		}
		else{ System.out.println("No free place");}
		
	}

	public void clearGuest() {
		guests.removeAll(guests);
		busy = false;
	}

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number
	 *            the new number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Gets the room price.
	 *
	 * @return the room price
	 */
	public int getRoomPrice() {
		return roomPrice;
	}

	/**
	 * Sets the room price.
	 *
	 * @param roomPrice
	 *            the new room price
	 */
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	/**
	 * Gets the sleeping numbers.
	 *
	 * @return the sleeping numbers
	 */
	public int getSleepingNumbers() {
		return sleepingNumbers;
	}

	/**
	 * Sets the sleeping numbers.
	 *
	 * @param sleepingNumbers
	 *            the new sleeping numbers
	 */
	public void setSleepingNumbers(int sleepingNumbers) {
		this.sleepingNumbers = sleepingNumbers;
	}

	/**
	 * Gets the star category.
	 *
	 * @return the star category
	 */
	public int getStarCategory() {
		return starCategory;
	}

	/**
	 * Sets the star category.
	 *
	 * @param starCategory
	 *            the new star category
	 */
	public void setStarCategory(int starCategory) {
		this.starCategory = starCategory;
	}

	/**
	 * Gets the busy.
	 *
	 * @return the busy
	 */
	public boolean getBusy() {
		return busy;
	}

	/**
	 * Sets the busy.
	 *
	 * @param busy
	 *            the new busy
	 */
	public void setBusy(boolean busy) {
		this.busy = busy;
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
	 * Sets the date of arrival.
	 *
	 * @param dateOfArrival
	 *            the new date of arrival
	 */
	public void setDateOfArrival(Date dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	/**
	 * Gets the date of departure.
	 *
	 * @return the date of departure
	 */
	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	/**
	 * Sets the date of departure.
	 *
	 * @param dateOfDeparture
	 *            the new date of departure
	 */
	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	/**
	 * Gets the guest history.
	 *
	 * @return the guest history
	 */

	public LinkedList<Guest> getGuestHistory() {
		return guestHistory;
	}

	/**
	 * Sets the guest history.
	 *
	 * @param guest
	 *            the new guest history
	 */

	public void setGuestHistory(Guest guest) {

		///int guestHistorySizeProperty = PropertyManager.getInstance().getGuestHistorySizeProperty();
		int a = guestHistory.size();
		if (a < 3) {
			guestHistory.addFirst(guest);
		} else {
			guestHistory.removeLast();
			guestHistory.addFirst(guest);
		}
	}

	/**
	 * Gets the statys.
	 *
	 * @return the statys
	 */
	public String getStatys() {
		String st;
		if (statys == false) {
			st = UNDER_REPAIR;
		} else {
			st = IN_WORK;

		}
		return st;
	}

	/**
	 * Sets the statys.
	 *
	 * @param statys
	 *            the new statys
	 */
	public void setStatys(boolean statys) {

		this.statys = statys;
	}

	public String toString() {

		return (new StringBuilder(50).append(number).append(",")
				.append(roomPrice).append(",").append(sleepingNumbers)
				.append(",").append(starCategory).append(",").append(busy)
				.append(",").append(df.format(dateOfArrival)).append(",")
				.append(df.format(dateOfDeparture)).append(",").append(statys)
				.toString());
	}

	public HotelRoom clone() throws CloneNotSupportedException {
		return (HotelRoom) super.clone();

	}

}
