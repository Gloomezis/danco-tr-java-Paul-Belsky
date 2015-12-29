package com.danco.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Guest {

	private String DATE_FORMAT = "dd-MM-yyyy";
	DateFormat df = new SimpleDateFormat(DATE_FORMAT);

	private String name;
	private Date dateOfDeparture = new Date(00-00-0000);
	private Date dateOfArrive = new Date(00-00-0000);
	private String numberOfRoom = "not setled";
	private int summToPaid = 0;
	private ArrayList<Service> services = new ArrayList<Service>();

	String a;

	public Guest(String name) {

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public Date getDateOfArrive() {
		return dateOfArrive;
	}

	public void setDateOfArrive(Date dateOfArrive) {
		this.dateOfArrive = dateOfArrive;
	}

	public String getNumberOfRoom() {
		return numberOfRoom;
	}

	public void setNumberOfRoom(String numberOfRoom) {
		this.numberOfRoom = numberOfRoom;
	}

	public int getSummToPaid() {
		return summToPaid;
	}

	public void setSummToPaid(int summToPaid) {
		this.summToPaid = summToPaid;
	}

	public ArrayList<Service> getServises() {
		return services;

	}

	// add service to arrat servises
	public void setServices(Service service) {
		services.add(service);
	}

	public String toString() {

		return (new StringBuilder(name + "," + df.format(dateOfArrive) + ","
				+ df.format(dateOfDeparture) + "," + numberOfRoom + ","
				+ summToPaid).toString());

	}
}
