/*
 * 
 */
package com.danco.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



// TODO: Auto-generated Javadoc
/**
 * The Class Guest.
 */
@Entity
@Table(name="guest")
public class Guest  extends BaseModel implements  Serializable {

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
	
	/** The orders. */
	@OneToMany(targetEntity = Orders.class, mappedBy = "guest",fetch = FetchType.LAZY)
	private List<Orders> orders;
	
	
	/**
	 * Instantiates a new guest.
	 */
	public Guest() {
		
	}

	/**
	 * Instantiates a new guest.
	 *
	 * @param id the id
	 * @param name the name
	 */
	public Guest(int id, String name) {
		this.id=id;
		this.name = name;
		this.orders = new ArrayList<Orders>();
	}

	/**
	 * Instantiates a new guest.
	 *
	 * @param name the name
	 */
	public Guest(String name) {
		
		this.name = name;
		this.orders = new ArrayList<Orders>();
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
	 * @param orders the new orders
	 */
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

}
