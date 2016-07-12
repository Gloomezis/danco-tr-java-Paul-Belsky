package com.danco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The Class Location.
 */
@Entity
@Table(name = Location.LOCATION)
public class Location extends BaseModel {

	/** The Constant CITY2. */
	private static final String CITY2 = "city";
	
	/** The Constant STATE2. */
	private static final String STATE2 = "state";
	
	/** The Constant COUNTRY2. */
	private static final String COUNTRY2 = "country";
	
	/** The Constant ID_LOCATION. */
	private static final String ID_LOCATION = "idLocation";
	
	/** The Constant LOCATION. */
	static final String LOCATION = "location";
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = ID_LOCATION)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The country. */
	@Column(name = COUNTRY2)
	private String country;

	/** The state. */
	@Column(name = STATE2)
	private String state;

	/** The city. */
	@Column(name = CITY2)
	private String city;

	/**
	 * Instantiates a new location.
	 */
	public Location() {
	}

	/**
	 * Instantiates a new location.
	 *
	 * @param id the id
	 * @param country the country
	 * @param state the state
	 * @param city the city
	 */
	public Location(int id, String country, String state, String city) {
		this.id = id;
		this.country = country;
		this.state = state;
		this.city = city;
	}

	/**
	 * Instantiates a new location.
	 *
	 * @param country the country
	 * @param state the state
	 * @param city the city
	 */
	public Location(String country, String state, String city) {
		this.country = country;
		this.state = state;
		this.city = city;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
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
}
