package com.danco.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="handling")
public class Handling extends BaseModel implements  Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name= "time")
	@Temporal(value=TemporalType.DATE)
	private Date time;
	
	
	@Column(name="resources")
	private String resources;
	
	
	
	

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id") 
	private User user;
	
	
	public Handling() {
	}
	
	

	public Handling(Date time, String resources,User user) {
		super();
		this.time = time;
		this.resources = resources;
		this.user = user;
	}



	@Override
	public int getId() {
		
		return id;
	}

	@Override
	public void setId(int id) {
		this.id=id;
		
	}



	public Date getTime() {
		return time;
	}



	public void setTime(Date time) {
		this.time = time;
	}



	public String getResources() {
		return resources;
	}



	public void setResources(String resources) {
		this.resources = resources;
	}




	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	
	

}
