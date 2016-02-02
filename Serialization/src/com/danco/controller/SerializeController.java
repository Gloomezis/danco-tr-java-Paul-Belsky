package com.danco.controller;

import com.danco.storages.MainStorage;
import com.danco.util.Serialization;




// TODO: Auto-generated Javadoc
/**
 * The Class SerializeController.
 */
public class SerializeController implements ISerializeController {
	
	/** The instance. */
	//private static SerializeController instance;
	
	/** The serialization. */
	private Serialization serialization = new Serialization();
	
	/**
	 * Instantiates a new serialize controller.
	 */
	//private SerializeController(){}
	
	/**
	 * Gets the single instance of SerializeController.
	 *
	 * @return single instance of SerializeController
	 */
	//public static SerializeController getInstance(){
	//	if(instance == null){
	//		instance = new SerializeController();
	//	}
	//	return instance;
	//}
	
	/* (non-Javadoc)
	 * @see com.danco.controller.ISerializeController#serialToFile(com.danco.storages.MainStorage)
	 */
	@Override
	public void serialToFile(MainStorage serializeMainStorage){
		serialization.serialToFile(serializeMainStorage);
	}
	
	/* (non-Javadoc)
	 * @see com.danco.controller.ISerializeController#serialFromFile()
	 */
	@Override
	public MainStorage serialFromFile(){
		return serialization.serialFromFile();
	}

}
