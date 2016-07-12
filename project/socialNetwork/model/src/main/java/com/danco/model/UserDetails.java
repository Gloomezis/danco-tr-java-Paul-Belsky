package com.danco.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The Class UserDetails.
 */
@Entity
@Table(name = UserDetails.USER_DETAILS)
public class UserDetails extends BaseModel {

	/** The Constant USER_DETAILS2. */
	private static final String USER_DETAILS2 = "userDetails";
	
	/** The Constant EMAIL2. */
	private static final String EMAIL2 = "email";
	
	/** The Constant GENDER2. */
	private static final String GENDER2 = "gender";
	
	/** The Constant FIRST_NAME. */
	private static final String FIRST_NAME = "first_name";
	
	/** The Constant LAST_NAME. */
	private static final String LAST_NAME = "last_name";
	
	/** The Constant USER_DETAILS. */
	static final String USER_DETAILS = "user_details";
	
	/** The Constant ID_USER_DETAILS. */
	private static final String ID_USER_DETAILS = "idUser_details";
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = ID_USER_DETAILS)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The last name. */
	@Column(name = LAST_NAME)
	private String lastName;

	/** The first name. */
	@Column(name = FIRST_NAME)
	private String firstName;

	/** The gender. */
	@Column(name = GENDER2)
	private String gender;

	/** The email. */
	@Column(name = EMAIL2)
	private String email;

	/** The user. */
	@JsonBackReference
	@OneToOne( mappedBy = USER_DETAILS2)
	private User user;

	/** The location. */
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "location_id")
	private Location location;

	/**
	 * Instantiates a new user details.
	 */
	public UserDetails() {
	}

	/**
	 * Instantiates a new user details.
	 *
	 * @param id the id
	 * @param lastName the last name
	 * @param firstName the first name
	 * @param dateOdBirth the date od birth
	 * @param gender the gender
	 * @param phoneNumber the phone number
	 * @param user the user
	 * @param location the location
	 */
	public UserDetails(int id, String lastName, String firstName,
			Date dateOdBirth, String gender, int phoneNumber, User user,
			Location location) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
		this.user = user;
		this.location = location;
	}

	/**
	 * Instantiates a new user details.
	 *
	 * @param lastName the last name
	 * @param firstName the first name
	 * @param dateOdBirth the date od birth
	 * @param gender the gender
	 * @param phoneNumber the phone number
	 */
	public UserDetails(String lastName, String firstName, Date dateOdBirth,
			String gender, int phoneNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(Location location) {
		this.location = location;
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
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
