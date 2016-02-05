package com.danco.anotation;

public interface IPrintableAnalizer {

	/**
	 * Prints the detailde view.
	 *
	 * @param obj
	 *            the obj
	 * @return the string
	 */
	public String printDetaildeView(Object obj);

	/**
	 * Prints the short view.
	 *
	 * @param obj
	 *            the obj
	 * @return the string
	 */
	public String printShortView(Object obj);

}