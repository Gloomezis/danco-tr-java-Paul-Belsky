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



@Entity
@Table(name="guest")
public class Guest implements IBaseModel, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="name")
	private String name;
	
	@OneToMany(targetEntity = Orders.class, mappedBy = "guest",fetch = FetchType.LAZY)
	private List<Orders> orders;
	
	
	public Guest() {
		
	}

	public Guest(int id, String name) {
		this.setId(id);
		this.name = name;
		this.orders = new ArrayList<Orders>();
	}

	public Guest(String name) {
		this.setId(-1);
		this.name = name;
		this.orders = new ArrayList<Orders>();
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;

	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

}
