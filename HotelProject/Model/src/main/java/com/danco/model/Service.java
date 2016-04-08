package com.danco.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Service.
 */

@Entity
@Table(name="service")
public class Service extends BaseModel implements  Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
    @Column(name= "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The name. */
	@Column(name="name")
	private String name;
	
	/** The price. */
	@Column(name="price")
	private int price;

	/** The paid. */
	@Column(name="paid")
	private boolean paid;
	
	/** The order. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orders_id") 
	private Orders order;

	/**
	 * Instantiates a new service.
	 *
	 * @param name the name
	 * @param price the price
	 */
	public Service(

	String name, int price) {
		this.setId(-1);
		this.price = price;
		this.name = name;

	}

	/**
	 * Instantiates a new service.
	 *
	 * @param id the id
	 * @param name the name
	 * @param price the price
	 * @param paid the paid
	 */
	public Service(int id, String name, int price, boolean paid) {
		this.setId(id);
		this.price = price;
		this.name = name;
		this.paid = paid;

	}

	/**
	 * Instantiates a new service.
	 */
	public Service() {

	}

	/* (non-Javadoc)
	 * @see com.danco.model.BaseModel#getId()
	 */
	@Override
	public int getId() {

		return id;
	}

	/* (non-Javadoc)
	 * @see com.danco.model.BaseModel#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;

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
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * Checks if is paid.
	 *
	 * @return true, if is paid
	 */
	public boolean isPaid() {
		return paid;
	}

	/**
	 * Sets the paid.
	 *
	 * @param paid the new paid
	 */
	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	/**
	 * Gets the order.
	 *
	 * @return the order
	 */
	public Orders getOrder() {
		return order;
	}

	/**
	 * Sets the order.
	 *
	 * @param order the new order
	 */
	public void setOrder(Orders order) {
		this.order = order;
	}

}
