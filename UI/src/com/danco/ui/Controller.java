package com.danco.ui;

import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller {
	
	
	
	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = "-----------------";

	/** The navigator. */
	private Navigator navigator = new Navigator();

	
	/**
	 * Run.
	 */
	public void run() {

		navigator.printMenu();
		PrintUtil.printString(SEPARATOR);

		while (navigator.navigate() == true) {
			PrintUtil.printString(SEPARATOR);

		}

	}

}
