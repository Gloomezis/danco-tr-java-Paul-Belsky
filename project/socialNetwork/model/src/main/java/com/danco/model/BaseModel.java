package com.danco.model;

import java.io.Serializable;


/**
 * The Class BaseModel.
 */
public abstract class BaseModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new base model.
	 */
	public BaseModel() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public abstract int getId();

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public abstract void setId(int id);

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (getId() != 0) ? (this.getClass().hashCode() + getId()) : super
				.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		return (other instanceof BaseModel) && (getId() != 0) ? getId() == (((BaseModel) other)
				.getId()) : (other == this);
	}

}
