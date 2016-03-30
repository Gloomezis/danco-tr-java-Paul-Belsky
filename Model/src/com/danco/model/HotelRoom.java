package com.danco.model;


// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoom.
 */

public class HotelRoom extends BaseModel implements Cloneable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The number. */

	private String number;

	/** The room price. */

	private int roomPrice;

	/** The sleeping numbers. */

	private int sleepingNumber;

	/** The star category. */

	private int starCategory;

	/** The busy. */

	private boolean busy ;

	/** The status. */

	private boolean status = true;
	
	
	
	

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
		super.setId(-1);
		this.number = number;
		this.roomPrice = roomPrice;
		this.sleepingNumber = sleepingNumbers;
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
	public HotelRoom(int id,String number, int roomPrice, int sleepingNumbers,
			int starCategory) {
		super();
		super.setId(id);
		this.number = number;
		this.roomPrice = roomPrice;
		this.sleepingNumber = sleepingNumbers;
		this.starCategory = starCategory;
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
	public int getSleepingNumber() {
		return sleepingNumber;
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
	 * Gets the status.
	 *
	 * @return the status
	 */
	public boolean getStatus() {
		
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	public HotelRoom clone() throws CloneNotSupportedException {
		return (HotelRoom) super.clone();

	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
