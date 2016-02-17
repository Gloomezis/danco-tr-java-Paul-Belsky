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


	/** The LOG1. */
	final static Logger LOG1 = Logger.getLogger(InputManager.class.getName());

	/** The input. */
	private static Scanner input;

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.util.IInputManager#userInputString()
	 */

	public static String userInputString() {
		String userInputString;
		input = new Scanner(System.in);
		userInputString = input.nextLine();
		input.close();
		return userInputString;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.util.IInputManager#userInputInt()
	 */

	/**
	 * User input int.
	 *
	 * @return the int
	 */
	public static int userInputInt() {

		int userInputInt = 0;
		try {
			input = new Scanner(System.in);
			userInputInt = input.nextInt();
		} catch (Exception e) {
			LOG1.error(INPUT_ERROR, e);
		}finally {
			input.close();
		}
		return userInputInt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.util.IInputManager#userInputDate()
	 */

	/**
	 * User input date.
	 *
	 * @return the date
	 */
	public static Date userInputDate() {
		Date date = null;
		try {
			input = new Scanner(System.in);
			String userInputDate = "";
			userInputDate = input.nextLine();
			String[] dateMassArrive = userInputDate.split("-");
			date = new GregorianCalendar(Integer.parseInt(dateMassArrive[0]),
					Integer.parseInt(dateMassArrive[1]),
					Integer.parseInt(dateMassArrive[2])).getTime();
		} catch (Exception e) {
			LOG1.error(INPUT_ERROR, e);
		}finally {
			input.close();
		}
		return date;

	}
}
