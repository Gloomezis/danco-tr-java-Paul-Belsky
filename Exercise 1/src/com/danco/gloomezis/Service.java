package com.danco.gloomezis;

import java.sql.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Service {
int price;
String nameOfService;
//TODO date type
Date dateOfUsingService;
public Service(int price, String nameOfService) {
	
	this.price = price;
	this.nameOfService = nameOfService;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getNameOfService() {
	return nameOfService;
}
public void setNameOfService(String nameOfService) {
	this.nameOfService = nameOfService;
}
public Date getDate() {
	return dateOfUsingService;
}
public void setDate(Date date) {
	this.dateOfUsingService = date;
}

}
