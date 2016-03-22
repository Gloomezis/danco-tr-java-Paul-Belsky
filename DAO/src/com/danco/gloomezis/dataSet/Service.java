package com.danco.gloomezis.dataSet;


// TODO: Auto-generated Javadoc
/**
 * The Class Service.
 */

public class Service extends BaseModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	private int orderId ;

	/** The name of service. */
	
	private String nameOfService;

	/** The price. */
	
	private int price;
	
	private boolean paid = false;

	/**
	 * Instantiates a new service.
	 *
	 * @param price
	 *            the price
	 * @param nameOfService
	 *            the name of service
	 */
	public Service(int orderId, String nameOfService, int price) {
		super.setId(-1); 
		this.orderId=orderId;
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
	public Service(int id,int orderId, String nameOfService, int price, boolean paid) {
		super.setId(id);
		this.orderId=orderId;
		this.price = price;
		this.nameOfService = nameOfService;
		this.paid=paid;

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

	public int getOrderId() {
		return orderId;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

}
