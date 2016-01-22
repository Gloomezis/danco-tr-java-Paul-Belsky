package com.danco.controller;

import com.danco.storages.MainStorage;
import com.danco.util.Serialization;



// TODO: Auto-generated Javadoc
/**
 * The Class SerializeController.
 */
public class SerializeController {
	
	/** The instance. */
	private static SerializeController instance;
	
	/** The serialization. */
	private Serialization serialization = new Serialization();
	
	/**
	 * Instantiates a new serialize controller.
	 */
	private SerializeController(){}
	
	/**
	 * Gets the single instance of SerializeController.
	 *
	 * @return single instance of SerializeController
	 */
	public static SerializeController getInstance(){
		if(instance == null){
			instance = new SerializeController();
		}
		return instance;
	}
	
	/**
	 * Serial to file.
	 */
	public void serialToFile(){
		serialization.serialToFile();
	}
	
	/**
	 * Serial from file.
	 */
	public MainStorage serialFromFile(){
		return serialization.serialFromFile();
	}

}
