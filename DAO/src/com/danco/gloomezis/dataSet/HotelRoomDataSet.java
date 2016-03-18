package com.danco.gloomezis.dataSet;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoom.
 */

public class HotelRoomDataSet implements Serializable, Cloneable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant IN_WORK. */
	private static final String IN_WORK = "in work";

	/** The Constant UNDER_REPAIR. */
	private static final String UNDER_REPAIR = "under repair/serviced";

	/** The id. */
	private int id;

	/** The number. */

	private String number;

	/** The room price. */

	private int roomPrice;

	/** The sleeping numbers. */

	private int sleepingNumbers;

	/** The star category. */

	private int starCategory;

	/** The busy. */

	private boolean busy = false;

	/** The statys. */

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
	public HotelRoomDataSet(String number, int roomPrice, int sleepingNumbers,
			int starCategory) {
		super();
		this.id=-1;
		this.number = number;
		this.roomPrice = roomPrice;
		this.sleepingNumbers = sleepingNumbers;
		this.starCategory = starCategory;
	}
	
	/**
	 * Instantiates a new hotel room data set.
	 *
	 * @param id the id
	 * @param number the number
	 * @param roomPrice the room price
	 * @param sleepingNumbers the sleeping numbers
	 * @param starCategory the star category
	 */
	public HotelRoomDataSet(int id,String number, int roomPrice, int sleepingNumbers,
			int starCategory) {
		super();
		this.id=id;
		this.number = number;
		this.roomPrice = roomPrice;
		this.sleepingNumbers = sleepingNumbers;
		this.starCategory = starCategory;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
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
	 * Gets the room price.
	 *
	 * @return the room price
	 */
	public int getRoomPrice() {
		return roomPrice;
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
	 * Gets the star category.
	 *
	 * @return the star category
	 */
	public int getStarCategory() {
		return starCategory;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	public HotelRoomDataSet clone() throws CloneNotSupportedException {
		return (HotelRoomDataSet) super.clone();

	}

}
