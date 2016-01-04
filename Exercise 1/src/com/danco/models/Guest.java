package com.danco.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Guest.
 */
public class Guest {

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "dd-MM-yyyy";
	
	/** The df. */
	private DateFormat df = new SimpleDateFormat(DATE_FORMAT);

	/** The name. */
	private String name;
	
	/** The date of departure. */
	private Date dateOfDeparture = new Date();
	
	/** The date of arrive. */
	private Date dateOfArrive = new Date();
	
	/** The number of room. */
	private String numberOfRoom = "not setled";
	
	/** The summ to paid. */
	private int summToPaid = 0;
	
	/** The services. */
	private List<Service> services = new ArrayList<Service>();

	/** The a. */
	String a;

	/**
	 * Instantiates a new guest.
	 *
	 * @param name the name
	 */
	public Guest(String name) {

		this.name = name;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @param dateOfDeparture the new date of departure
	 */
	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	/**
	 * Gets the date of arrive.
	 *
	 * @return the date of arrive
	 */
	public Date getDateOfArrive() {
		return dateOfArrive;
	}

	/**
	 * Sets the date of arrive.
	 *
	 * @param dateOfArrive the new date of arrive
	 */
	public void setDateOfArrive(Date dateOfArrive) {
		this.dateOfArrive = dateOfArrive;
	}

	/**
	 * Gets the number of room.
	 *
	 * @return the number of room
	 */
	public String getNumberOfRoom() {
		return numberOfRoom;
	}

	/**
	 * Sets the number of room.
	 *
	 * @param numberOfRoom the new number of room
	 */
	public void setNumberOfRoom(String numberOfRoom) {
		this.numberOfRoom = numberOfRoom;
	}

	/**
	 * Gets the summ to paid.
	 *
	 * @return the summ to paid
	 */
	public int getSummToPaid() {
		return summToPaid;
	}

	/**
	 * Sets the summ to paid.
	 *
	 * @param summToPaid the new summ to paid
	 */
	public void setSummToPaid(int summToPaid) {
		this.summToPaid = summToPaid;
	}

	/**
	 * Gets the servises.
	 *
	 * @return the servises
	 */
	public List<Service> getServises() {
		return services;

	}

	/**
	 * Sets the services.
	 *
	 * @param service the new services
	 */
	
	public void setServices(Service service) {
		services.add(service);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		return (new StringBuilder(name).append(",")
				.append(df.format(dateOfArrive))
				.append(",")
				.append(df.format(dateOfDeparture))
				.append(",")
				.append(numberOfRoom)
				.append(",")
				.append(summToPaid).toString());

	}
}
