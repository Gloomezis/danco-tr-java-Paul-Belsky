package com.danco.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Service.
 */
public class Service {
	
	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "dd-MM-yyyy";
	
	/** The df. */
	private DateFormat df = new SimpleDateFormat(DATE_FORMAT);

	/** The price. */
	private int price;
	
	/** The name of service. */
	private String nameOfService;
	
	/** The date of using service. */
	private Date dateOfUsingService = new Date();

	/**
	 * Instantiates a new service.
	 *
	 * @param price the price
	 * @param nameOfService the name of service
	 */
	public Service(int price, String nameOfService) {

		this.price = price;
		this.nameOfService = nameOfService;

	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Gets the name of service.
	 *
	 * @return the name of service
	 */
	public String getNameOfService() {
		return nameOfService;
	}

	/**
	 * Sets the name of service.
	 *
	 * @param nameOfService the new name of service
	 */
	public void setNameOfService(String nameOfService) {
		this.nameOfService = nameOfService;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return dateOfUsingService;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.dateOfUsingService = date;
	}
	
	
	public String toString() {

		return (new StringBuilder().append(price)
				.append(",")
				.append(nameOfService)
				.append(",")
				.append(df.format(dateOfUsingService))
				.toString());
	}

}
