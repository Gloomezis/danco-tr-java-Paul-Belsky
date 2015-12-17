package com.danco.gloomezis;

import java.util.ArrayList;
import java.sql.Date;

public class Guest {

String name;
Date dateOfDeparture;
String numberOfRoom;
int summToPaid;
ArrayList<Service> servises;

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
public void setServises(ArrayList<Service> servises) {
	this.servises = servises;
}



}
