package com.danco.anotation;

import java.lang.reflect.Field;

// TODO: Auto-generated Javadoc
/**
 * The Class FieldSortOrder.
 */
public class FieldSortOrder {

	/** The field. */
	private Field field;

	/** The order. */
	private int order;

	/**
	 * Instantiates a new field sort order.
	 *
	 * @param field the field
	 * @param order the order
	 */
	public FieldSortOrder(Field field, int order) {
		this.field = field;
		this.order = order;
	}

	/**
	 * Gets the field.
	 *
	 * @return the field
	 */
	public Field getField() {
		return field;
	}

	/**
	 * Sets the field.
	 *
	 * @param field the new field
	 */
	public void setField(Field field) {
		this.field = field;
	}

	/**
	 * Gets the order.
	 *
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * Sets the order.
	 *
	 * @param order the new order
	 */
	public void setOrder(int order) {
		this.order = order;
	}

}
