package com.danco.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotel_room")
public class HotelRoom implements Cloneable, Serializable, IBaseModel {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name= "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="number")
	private String number;

	@Column(name="room_price")
	private int roomPrice;

	@Column(name="sleeping_number")
	private int sleepingNumber;

	@Column(name="star_category")
	private int starCategory;

	@Column(name="busy")
	private boolean busy;

	@Column(name="status")
	private boolean status = true;

	public HotelRoom() {

	}
	
	public HotelRoom(String number, int roomPrice, int sleepingNumbers,
			int starCategory) {

		this.setId(-1);
		this.number = number;
		this.roomPrice = roomPrice;
		this.sleepingNumber = sleepingNumbers;
		this.starCategory = starCategory;
	}

	public HotelRoom(int id, String number, int roomPrice, int sleepingNumbers,
			int starCategory) {

		this.setId(id);
		this.number = number;
		this.roomPrice = roomPrice;
		this.sleepingNumber = sleepingNumbers;
		this.starCategory = starCategory;
	}

	public HotelRoom clone() throws CloneNotSupportedException {
		return (HotelRoom) super.clone();

	}

	@Override
	public int getId() {

		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;

	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getSleepingNumber() {
		return sleepingNumber;
	}

	public void setSleepingNumber(int sleepingNumber) {
		this.sleepingNumber = sleepingNumber;
	}

	public int getStarCategory() {
		return starCategory;
	}

	public void setStarCategory(int starCategory) {
		this.starCategory = starCategory;
	}

	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
