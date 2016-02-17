package com.danco.ui;

import java.util.ArrayList;
import java.util.List;

import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class Menu.
 */
public class Menu implements IMenu {

	/** The title. */
	private String title;

	/** The menu items. */
	private List<IMenu> menuItems;

	/** The parent. */
	private Menu parent;
	
	

	/**
	 * Instantiates a new menu.
	 *
	 * @param title the title
	 * @param parent the parent
	 */
	public Menu(String title, Menu parent) {
		this.title = title;
		this.parent = parent;
	}

	/**
	 * Gets the menu items.
	 *
	 * @return the menu items
	 */
	public List<IMenu> getMenuItems() {
		if (menuItems == null) {
			menuItems = new ArrayList<IMenu>();
		}
		return menuItems;
	}

	/**
	 * Sets the menu items.
	 *
	 * @param menuItems the new menu items
	 */
	public void setMenuItems(List<IMenu> menuItems) {
		this.menuItems = menuItems;
	}

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public Menu getParent() {
		return parent;
	}

	/**
	 * Sets the parent.
	 *
	 * @param parent the new parent
	 */
	public void setParent(Menu parent) {
		this.parent = parent;
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
		int index = 1;
		for (IMenu menuItem : getMenuItems()) {
			if (menuItem instanceof MenuItems) {
				PrintUtil.printString(index + " " + menuItem.getTitle());
			} else {
				PrintUtil.printString(index + ">>>" + menuItem.getTitle());
			}
			index++;
		}
	}

}
