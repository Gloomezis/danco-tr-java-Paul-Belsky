package com.danco.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idUser_role")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "role")
	private String role;

	public UserRole() {
	}

	public UserRole(int id, String role) {
		this.id = id;
		this.role = role;
	}

	public UserRole(String role) {
		this.role = role;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;

	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
