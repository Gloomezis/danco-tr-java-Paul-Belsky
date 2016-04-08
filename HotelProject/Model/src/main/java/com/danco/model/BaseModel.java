package com.danco.model;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseModel.
 */
public abstract class BaseModel {

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
	public abstract int getId() ;

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public abstract void setId(int id) ;


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (getId() != 0) ? (this.getClass().hashCode() + getId()) : super.hashCode();

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
