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
@Table(name="session")
public class Session extends BaseModel implements  Serializable{

	
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
	
	
	
	
	
	@Column(name="login")
	private boolean login;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id") 
	private User user;
	
	
	public Session() {
	}
	
	

	public Session(Date time, String resources, boolean login,
			User user) {
		super();
		this.time = time;
		this.resources = resources;
		this.login = login;
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



	public boolean isLogin() {
		return login;
	}



	public void setLogin(boolean login) {
		this.login = login;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	
	

}
