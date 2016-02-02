package com.danco.utils;

import java.util.Date;

public interface IInputManager {

	/**
	 * User input string.
	 *
	 * @return the string
	 */
	public String userInputString();

	/**
	 * User input int.
	 *
	 * @return the int
	 */
	public int userInputInt();

	/**
	 * User input date.
	 *
	 * @return the date
	 */
	public Date userInputDate();

}