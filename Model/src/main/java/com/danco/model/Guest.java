/*
 * 
 */
package com.danco.model;

import java.util.ArrayList;
import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class Guest.
 */

/**
 * @author Barton
 *
 */
public class Guest  extends BaseModel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	
	/** The name. */

	private String name;
	
	/** The orders. */
	private List<Orders> orders;

	/**
	 * Instantiates a new guest.
	 *
	 * @param id
	 *            the id
	 * @param name
	 *            the name
	 */
	public Guest(int id, String name) {
		super.setId(id);
		this.name = name;
		this.orders= new ArrayList<Orders>();
	}

	/**
	 * Instantiates a new guest data set.
	 *
	 * @param name
	 *            the name
	 */
	public Guest(String name) {
		super.setId(-1);
		this.name = name;
		this.orders= new ArrayList<Orders>();
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
 /**
  * Gets the orders.
  *
  * @return the orders
  */
 public List<Orders> getOrders() {
		return orders;
	}

	/**
	 * Sets the orders.
	 *
	 * @param ordersList the new orders
	 */
	public void setOrders(List<Orders> ordersList) {
		this.orders=ordersList;
	}

	

}
