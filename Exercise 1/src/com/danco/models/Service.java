package com.danco.models;

import java.util.Date;

public class Service {

	private int price;
	private String nameOfService;
	private Date dateOfUsingService = new Date(00-00-0000);

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
