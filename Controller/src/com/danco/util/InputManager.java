package com.danco.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.danco.utils.IInputManager;

// TODO: Auto-generated Javadoc
/**
 * The Class InputManager.
 */
public class InputManager implements IInputManager {

	/** The Constant INPUT_ERROR. */
	public final static String INPUT_ERROR = "Input  error";

	

	/** The LOG1. */
	final Logger LOG1 = Logger.getLogger(InputManager.class.getName());

	/** The input. */
	private Scanner input;
	
	
	/* (non-Javadoc)
	 * @see com.danco.util.IInputManager#userInputString()
	 */
	@Override
	public String userInputString() {
		String userInputString;
		input = new Scanner(System.in);
		userInputString = input.nextLine();
		return userInputString;

	}

	/* (non-Javadoc)
	 * @see com.danco.util.IInputManager#userInputInt()
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see com.danco.util.IInputManager#userInputDate()
	 */
	@Override
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
