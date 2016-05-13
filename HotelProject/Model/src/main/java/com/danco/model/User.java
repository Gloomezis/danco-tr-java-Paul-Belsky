package com.danco.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User extends BaseModel implements  Serializable{

	private static final long serialVersionUID = 1L;

	
	
	@Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The name. */
	@Column(name="name")
	private String name;
	
	
	/** The name. */
	@Column(name="password")
	private String password;
	
	public User() {
		
	}
	
   
	
	public User(String name,  String password) {
		super();
		this.name = name;
		
		this.password = password;
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


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
