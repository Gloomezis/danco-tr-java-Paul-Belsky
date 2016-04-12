package com.danco.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoom.
 */
@Entity
@Table(name="hotel_room")
public class HotelRoom extends BaseModel implements Cloneable, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	@Id
    @Column(name= "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The number. */
	@Column(name="number")
	private String number;

	/** The room price. */
	@Column(name="room_price")
	private int roomPrice;

	/** The sleeping number. */
	@Column(name="sleeping_number")
	private int sleepingNumber;

	/** The star category. */
	@Column(name="star_category")
	private int starCategory;

	/** The busy. */
	@Column(name="busy")
	private boolean busy;

	/** The status. */
	@Column(name="status")
	private boolean status = true;

	/**
	 * Instantiates a new hotel room.
	 */
	public HotelRoom() {

	}
	
	/**
	 * Instantiates a new hotel room.
	 *
	 * @param number the number
	 * @param roomPrice the room price
	 * @param sleepingNumbers the sleeping numbers
	 * @param starCategory the star category
	 */
	public HotelRoom(String number, int roomPrice, int sleepingNumbers,
			int starCategory) {

		this.number = number;
		this.roomPrice = roomPrice;
		this.sleepingNumber = sleepingNumbers;
		this.starCategory = starCategory;
	}

	/**
	 * Instantiates a new hotel room.
	 *
	 * @param id the id
	 * @param number the number
	 * @param roomPrice the room price
	 * @param sleepingNumbers the sleeping numbers
	 * @param starCategory the star category
	 */
	public HotelRoom(int id, String number, int roomPrice, int sleepingNumbers,
			int starCategory) {

		this.id=id;
		this.number = number;
		this.roomPrice = roomPrice;
		this.sleepingNumber = sleepingNumbers;
		this.starCategory = starCategory;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public HotelRoom clone() throws CloneNotSupportedException {
		return (HotelRoom) super.clone();

	}

	/* (non-Javadoc)
	 * @see com.danco.model.BaseModel#getId()
	 */
	@Override
	public int getId() {

		return id;
	}

	/* (non-Javadoc)
	 * @see com.danco.model.BaseModel#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;

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
	 * @param number the new number
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
	 * @param roomPrice the new room price
	 */
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	/**
	 * Gets the sleeping number.
	 *
	 * @return the sleeping number
	 */
	public int getSleepingNumber() {
		return sleepingNumber;
	}

	/**
	 * Sets the sleeping number.
	 *
	 * @param sleepingNumber the new sleeping number
	 */
	public void setSleepingNumber(int sleepingNumber) {
		this.sleepingNumber = sleepingNumber;
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
	 * @param starCategory the new star category
	 */
	public void setStarCategory(int starCategory) {
		this.starCategory = starCategory;
	}

	/**
	 * Checks if is busy.
	 *
	 * @return true, if is busy
	 */
	public boolean isBusy() {
		return busy;
	}

	/**
	 * Sets the busy.
	 *
	 * @param busy the new busy
	 */
	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	/**
	 * Checks if is status.
	 *
	 * @return true, if is status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

}
