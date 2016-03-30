package com.danco.model;


// TODO: Auto-generated Javadoc
/**
 * The Class Service.
 */

public class Service extends BaseModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
//	private int orderId ;

	/** The name of service. */
	
	private String name;

	/** The price. */
	
	private int price;
	
	private boolean paid ;
	
	private Orders order;

	/**
	 * Instantiates a new service.
	 *
	 * @param price
	 *            the price
	 * @param nameOfService
	 *            the name of service
	 */
	public Service(
		//	int orderId,
			String name, int price) {
		super.setId(-1); 
	//	this.orderId=orderId;
		this.price = price;
		this.name = name;

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
	public Service(int id, String name, int price, boolean paid) {
		super.setId(id);
		this.price = price;
		this.name = name;
		this.paid=paid;
		

	}

	

	/**
	 * Gets the name of service.
	 *
	 * @return the name of service
	 */
	public String getName() {
		return name;
	}



	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	//public int getOrderId() {
	//	return orderId;
	//}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

}
