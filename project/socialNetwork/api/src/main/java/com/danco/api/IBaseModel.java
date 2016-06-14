package com.danco.api;


/**
 * The Interface IBaseModel.
 */
public interface IBaseModel {

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId();

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id);
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	public int hashCode();
	
	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	boolean equals(Object obj);
	
	
}
