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
	@Column(name="login")
	private String login;
	
	
	/** The name. */
	@Column(name="password")
	private String password;
	
	public User() {
		
	}
	
   
	
	public User(String name,  String password) {
		super();
		this.login = name;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
