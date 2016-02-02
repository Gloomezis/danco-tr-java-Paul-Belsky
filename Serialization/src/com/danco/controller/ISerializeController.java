package com.danco.controller;

import com.danco.storages.MainStorage;





public interface ISerializeController {

	/**
	 * Serial to file.
	 */
	public void serialToFile(MainStorage serializeMainStorage);

	/**
	 * Serial from file.
	 */
	public MainStorage serialFromFile();

}