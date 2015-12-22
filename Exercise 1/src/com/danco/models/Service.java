package com.danco.models;

public class Service {

	private int price;
	private String nameOfService;
	private String dateOfUsingService = "not used";

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

	public String getDate() {
		return dateOfUsingService;
	}

	public void setDate(String date) {
		this.dateOfUsingService = date;
	}

}
