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
 * The Class GuestToHotelRoomDataSet.
 */

@Entity
@Table(name="orders")
public class Orders implements IBaseModel,Serializable{


	private static final long serialVersionUID = 1L;
	
	
	@Id
    @Column(name= "id")
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToMany(targetEntity = Service.class, mappedBy = "orders",fetch = FetchType.LAZY)
	private List<Service> services;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "guest_id") 
	private Guest guest;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel_room_id") 
	private HotelRoom hotelRoom;

	@Column(name= "date_arrive")
	@Temporal(value=TemporalType.DATE)
	private Date dateArrive;

	@Column(name= "date_departure")
	@Temporal(value=TemporalType.DATE)
	private Date dateDeparture;
	
	@Column(name="paid")
	private boolean paid ;


	public Orders() {
		
	}
	
	public Orders(int id, 			
	HotelRoom hotelRoom, Date dateOfArrival, Date dateOfDeparture,boolean paid) {
		
		this.setId(id);
		
		this.hotelRoom = hotelRoom;
		this.dateArrive = dateOfArrival;
		this.dateDeparture = dateOfDeparture;
		this.paid=paid;
		this.services = new ArrayList<Service>()		;
	}

	
	public Orders(
			
			HotelRoom hotelRoom,Date dateOfArrival, Date dateOfDeparture) {
		
		this.setId(-1);
	    this.hotelRoom = hotelRoom;
		this.dateArrive = dateOfArrival;
		this.dateDeparture = dateOfDeparture;
		this.services = new ArrayList<Service>();
	}



	
	@Override
	public int getId() {
		
		return id;
	}

	@Override
	public void setId(int id) {
		this.id=id;
		
	}
	
	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public HotelRoom getHotelRoom() {
		return hotelRoom;
	}

	public void setHotelRoom(HotelRoom hotelRoom) {
		this.hotelRoom = hotelRoom;
	}

	public Date getDateArrive() {
		return dateArrive;
	}

	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}

	public Date getDateDeparture() {
		return dateDeparture;
	}

	public void setDateDeparture(Date dateDeparture) {
		this.dateDeparture = dateDeparture;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
}
