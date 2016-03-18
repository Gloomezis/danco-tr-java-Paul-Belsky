package com.danco.gloomezis.dataSet;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Guest.
 */

public class GuestDataSet implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private int id;

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
	public GuestDataSet(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Instantiates a new guest data set.
	 *
	 * @param name
	 *            the name
	 */
	public GuestDataSet(String name) {
		this.id = -1;
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

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}
