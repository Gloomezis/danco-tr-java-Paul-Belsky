package com.danco.ui;

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
		System.out.println(SEPARATOR);

		while (navigator.navigate() == true) {
			System.out.println(SEPARATOR);

		}

	}

}
