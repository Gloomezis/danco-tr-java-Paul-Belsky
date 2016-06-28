package com.danco.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_details")
public class UserDetails extends BaseModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idUser_details")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "date_of_birth")
	@Temporal(value = TemporalType.DATE)
	private Date dateOfBirth;

	@Column(name = "gender")
	private String gender;

	@Column(name = "phone_number")
	private int phoneNumber;

	@Column(name="email")
	private String email;
	
	
	@JsonIgnore
	@OneToOne(mappedBy = "userDetails",fetch = FetchType.LAZY)
	private User user; 
	
	
	


	@OneToOne()
	@JoinColumn(name = "location_id")
	private Location location;
	
	public UserDetails(){
		
	}


	public UserDetails(int id, String lastName, String firstName,
			Date dateOdBirth, String gender, int phoneNumber, User user,
			Location location) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOdBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.user = user;
		this.location = location;
	}

	public UserDetails(String lastName, String firstName, Date dateOdBirth,
			String gender, int phoneNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOdBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
