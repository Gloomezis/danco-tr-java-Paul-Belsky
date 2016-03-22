package com.danco.gloomezis.dataSet;


// TODO: Auto-generated Javadoc
/**
 * The Class Guest.
 */

public class Guest  extends BaseModel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	
	/** The name. */

	private String name;

	/**
	 * Instantiates a new guest.
	 *
	 * @param id
	 *            the id
	 * @param name
	 *            the name
	 */
	public Guest(int id, String name) {
		super.setId(id);
		this.name = name;
	}

	/**
	 * Instantiates a new guest data set.
	 *
	 * @param name
	 *            the name
	 */
	public Guest(String name) {
		super.setId(-1);
		this.name = name;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	

}
