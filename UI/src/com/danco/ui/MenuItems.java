package com.danco.ui;

import com.danco.command.Command;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuItems.
 */
public class MenuItems implements IMenu {

	/** The title. */
	private String title;

	/** The command. */
	private Command command;

	/**
	 * Instantiates a new menu items.
	 *
	 * @param title the title
	 */
	public MenuItems(String title) {
		this.title = title;
	}

	/**
	 * Instantiates a new menu items.
	 *
	 * @param title the title
	 * @param command the command
	 */
	public MenuItems(String title, Command command) {
		this.command = command;
		this.title = title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMenu#getTitle()
	 */
	public String getTitle() {
		return title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMenu#doAction()
	 */
	public void doAction() {
		if (command != null) {
			command.execute();

		}

	}

}
