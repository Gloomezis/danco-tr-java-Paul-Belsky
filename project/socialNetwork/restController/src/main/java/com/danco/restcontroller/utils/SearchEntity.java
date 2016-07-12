package com.danco.restcontroller.utils;


/**
 * The Class SearchEntity.
 */
public class SearchEntity {
	
	/** The param. */
	// this entity walk over UTF encoding.Russian words dond looked like %В%D
	String param;

	/**
	 * Instantiates a new search entity.
	 *
	 * @param param the param
	 */
	public SearchEntity(String param) {
		super();
		this.param = param;
	}

	/**
	 * Instantiates a new search entity.
	 */
	public SearchEntity() {
	}

	/**
	 * Gets the param.
	 *
	 * @return the param
	 */
	public String getParam() {
		return param;
	}

	/**
	 * Sets the param.
	 *
	 * @param param the new param
	 */
	public void setParam(String param) {
		this.param = param;
	}

}
