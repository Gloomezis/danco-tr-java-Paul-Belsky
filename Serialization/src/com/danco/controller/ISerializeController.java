package com.danco.controller;

import com.danco.storages.MainStorage;

// TODO: Auto-generated Javadoc
/**
 * The Interface ISerializeController.
 */
public interface ISerializeController {

	/**
	 * Serial to file.
	 *
	 * @param serializeMainStorage the serialize main storage
	 */
	public void serialToFile(MainStorage serializeMainStorage);

	/**
	 * Serial from file.
	 *
	 * @return the main storage
	 */
	public MainStorage serialFromFile();

}