package com.danco.gloomezis.dataSet;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Service.
 */

public class ServiceDataSet implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private int id;

	/** The name of service. */
	
	private String nameOfService;

	/** The price. */
	
	private int price;

	/**
	 * Instantiates a new service.
	 *
	 * @param price
	 *            the price
	 * @param nameOfService
	 *            the name of service
	 */
	public ServiceDataSet(int price, String nameOfService) {
		this.id = -1;
		this.price = price;
		this.nameOfService = nameOfService;

	}

	/**
	 * Instantiates a new service data set.
	 *
	 * @param id
	 *            the id
	 * @param price
	 *            the price
	 * @param nameOfService
	 *            the name of service
	 */
	public ServiceDataSet(int id, int price, String nameOfService) {
		this.id = id;
		this.price = price;
		this.nameOfService = nameOfService;

	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
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
	 * Gets the price.
	 *
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
}
