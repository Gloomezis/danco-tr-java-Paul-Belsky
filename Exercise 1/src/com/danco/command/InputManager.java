package com.danco.command;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class InputManager.
 */
public class InputManager {

	/** The instance. */
	// singleton
	private static InputManager instance;

	/** The input. */
	private  Scanner input;

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

		int userInputInt;
		input = new Scanner(System.in);
		userInputInt = input.nextInt();
		return userInputInt;
	}

	/**
	 * User input date.
	 *
	 * @return the date
	 */
	public  Date userInputDate() {
		input = new Scanner(System.in);
		Date date = null;
		String userInputDate = "";
		userInputDate = input.nextLine();
		String[] dateMassArrive = userInputDate.split("-");
		date = new GregorianCalendar(Integer.parseInt(dateMassArrive[0]), Integer.parseInt(dateMassArrive[1]),
				Integer.parseInt(dateMassArrive[2])).getTime();
		return date;

	}
}
