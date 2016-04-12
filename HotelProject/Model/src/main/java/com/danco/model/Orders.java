/*
 * 
 */
package com.danco.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// TODO: Auto-generated Javadoc
/**
 * The Class Orders.
 */

@Entity
@Table(name="orders")
public class Orders extends BaseModel implements Serializable{


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	
	/** The id. */
	@Id
    @Column(name= "id")
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/** The services. */
	@OneToMany(targetEntity = Service.class, mappedBy = "order",fetch = FetchType.LAZY)
	private List<Service> services;
	
	/** The guest. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "guest_id") 
	private Guest guest;

	/** The hotel room. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel_room_id") 
	private HotelRoom hotelRoom;

	/** The date arrive. */
	@Column(name= "date_arrive")
	@Temporal(value=TemporalType.DATE)
	private Date dateArrive;

	/** The date departure. */
	@Column(name= "date_departure")
	@Temporal(value=TemporalType.DATE)
	private Date dateDeparture;
	
	/** The paid. */
	@Column(name="paid")
	private boolean paid ;


	/**
	 * Instantiates a new orders.
	 */
	public Orders() {
		
	}
	
	/**
	 * Instantiates a new orders.
	 *
	 * @param id the id
	 * @param hotelRoom the hotel room
	 * @param dateOfArrival the date of arrival
	 * @param dateOfDeparture the date of departure
	 * @param paid the paid
	 */
	public Orders(int id, 			
	HotelRoom hotelRoom, Date dateOfArrival, Date dateOfDeparture,boolean paid) {
		
		this.id=id;
		this.hotelRoom = hotelRoom;
		this.dateArrive = dateOfArrival;
		this.dateDeparture = dateOfDeparture;
		this.paid=paid;
		this.services = new ArrayList<Service>()		;
	}

	
	/**
	 * Instantiates a new orders.
	 *
	 * @param hotelRoom the hotel room
	 * @param dateOfArrival the date of arrival
	 * @param dateOfDeparture the date of departure
	 */
	public Orders(
			
			HotelRoom hotelRoom,Date dateOfArrival, Date dateOfDeparture) {
		
		
	    this.hotelRoom = hotelRoom;
		this.dateArrive = dateOfArrival;
		this.dateDeparture = dateOfDeparture;
		this.services = new ArrayList<Service>();
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
		this.id=id;
		
	}
	
	/**
	 * Gets the services.
	 *
	 * @return the services
	 */
	public List<Service> getServices() {
		return services;
	}

	/**
	 * Sets the services.
	 *
	 * @param services the new services
	 */
	public void setServices(List<Service> services) {
		this.services = services;
	}

	/**
	 * Gets the guest.
	 *
	 * @return the guest
	 */
	public Guest getGuest() {
		return guest;
	}

	/**
	 * Sets the guest.
	 *
	 * @param guest the new guest
	 */
	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	/**
	 * Gets the hotel room.
	 *
	 * @return the hotel room
	 */
	public HotelRoom getHotelRoom() {
		return hotelRoom;
	}

	/**
	 * Sets the hotel room.
	 *
	 * @param hotelRoom the new hotel room
	 */
	public void setHotelRoom(HotelRoom hotelRoom) {
		this.hotelRoom = hotelRoom;
	}

	/**
	 * Gets the date arrive.
	 *
	 * @return the date arrive
	 */
	public Date getDateArrive() {
		return dateArrive;
	}

	/**
	 * Sets the date arrive.
	 *
	 * @param dateArrive the new date arrive
	 */
	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}

	/**
	 * Gets the date departure.
	 *
	 * @return the date departure
	 */
	public Date getDateDeparture() {
		return dateDeparture;
	}

	/**
	 * Sets the date departure.
	 *
	 * @param dateDeparture the new date departure
	 */
	public void setDateDeparture(Date dateDeparture) {
		this.dateDeparture = dateDeparture;
	}

	/**
	 * Checks if is paid.
	 *
	 * @return true, if is paid
	 */
	public boolean isPaid() {
		return paid;
	}

	/**
	 * Sets the paid.
	 *
	 * @param paid the new paid
	 */
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
}
