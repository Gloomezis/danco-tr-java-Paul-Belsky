package com.danco.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class Navigator.
 */
public class Navigator {

	/** The Constant LOG1. */
	private final static Logger LOG1 = Logger.getLogger(Navigator.class
			.getName());
	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	/** The Constant NUMBER_NOT_EXIST. */
	public static final String NUMBER_NOT_EXIST = "Number not exist";

	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = "-----------------";

	/** The reader. */
	private BufferedReader reader = new BufferedReader(new InputStreamReader(
			System.in));

	/** The current menu. */
	private Menu currentMenu;

	
	
	

	/**
	 * Instantiates a new navigator.
	 *
	 * @param processing the processing
	 */
	public Navigator() {
		
		currentMenu =  new Builder().getRootMenu();

	}

	/**
	 * Prints the menu.
	 */
	public void printMenu() {
		if (currentMenu != null) {
			currentMenu.doAction();
		}
	}

	/**
	 * Navigate.
	 *
	 * @return true, if successful
	 */
	public boolean navigate() {
		int inputNumber = inputNumber();
		if (inputNumber <= 0 || inputNumber > currentMenu.getMenuItems().size()) {
			System.out.println(NUMBER_NOT_EXIST);
			return true;
		}

		if (inputNumber == currentMenu.getMenuItems().size()) {
			if (currentMenu.getParent() != null) {
				currentMenu = currentMenu.getParent();
				currentMenu.doAction();

			} else {

				return false;
			}
			return true;
		}

		IMenu selectedMenuItem = currentMenu.getMenuItems()
				.get(inputNumber - 1);
		if (selectedMenuItem instanceof Menu) {
			currentMenu = (Menu) selectedMenuItem;

		}
		selectedMenuItem.doAction();
		if (selectedMenuItem instanceof MenuItems) {
			System.out.println(SEPARATOR);
			printMenu();

		}
		return true;
	}

	/**
	 * Input number.
	 *
	 * @return the int
	 */
	public int inputNumber() {
		int inputNumber = -1;

		try {
			inputNumber = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException | IOException e) {
			LOG1.error(EXCEPTION, e);
		}
		return inputNumber;
	}

}
