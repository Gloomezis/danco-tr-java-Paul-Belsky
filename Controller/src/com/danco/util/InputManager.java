package com.danco.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class InputManager.
 */
public class InputManager {

	/** The Constant INPUT_ERROR. */
	public final static String INPUT_ERROR = "Input  error";

	/** The instance. */
	// singleton
	private static InputManager instance;

	/** The LOG1. */
	final Logger LOG1 = Logger.getLogger(InputManager.class.getName());

	/** The input. */
	private Scanner input;

	/**
	 * Instantiates a new main storage.
	 */
	private InputManager() {

	}

	/**
	 * Gets the single instance of MainStorage.
	 *
	 * @return single instance of MainStorage
	 */
	public static InputManager getInstance() {
		if (instance == null) {
			instance = new InputManager();
		}
		return instance;
	}

	/**
	 * User input string.
	 *
	 * @return the string
	 */
	public String userInputString() {
		String userInputString;
		input = new Scanner(System.in);
		userInputString = input.nextLine();
		return userInputString;

	}

	/**
	 * User input int.
	 *
	 * @return the int
	 */
	public int userInputInt() {

		int userInputInt = 0;
		try {
			input = new Scanner(System.in);
			userInputInt = input.nextInt();
		} catch (Exception e) {
			LOG1.error(INPUT_ERROR, e);
		}
		return userInputInt;
	}

	/**
	 * User input date.
	 *
	 * @return the date
	 */
	public Date userInputDate() {
		Date date = null;
		try {
			input = new Scanner(System.in);
			String userInputDate = "";
			userInputDate = input.nextLine();
			String[] dateMassArrive = userInputDate.split("-");
			date = new GregorianCalendar(Integer.parseInt(dateMassArrive[0]), Integer.parseInt(dateMassArrive[1]),
					Integer.parseInt(dateMassArrive[2])).getTime();
		} catch (Exception e) {
			LOG1.error(INPUT_ERROR, e);
		}
		return date;

	}
}