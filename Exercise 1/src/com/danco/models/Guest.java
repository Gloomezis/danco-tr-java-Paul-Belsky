package com.danco.models;

import java.util.ArrayList;
import java.util.Date;

public class Guest {

private String name;
private String dateOfDeparture;
private String dateOfArrive;
private String numberOfRoom;
private int summToPaid;
private ArrayList<Service> servises;

public Guest(String name) {
	
	this.name = name;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDateOfDeparture() {
	return  dateOfDeparture;
}

public String getDateOfArrive() {
	return dateOfArrive;
}

public void setDateOfArrive(String dateOfArrive) {
	this.dateOfArrive = dateOfArrive;
}

public void setDateOfDeparture(String dateOfDeparture) {
	this.dateOfDeparture = dateOfDeparture;
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
	return servises;
}

//add service to arrat servises
public void setServises(Service servise) {
	servises.add(servise);
}



}