package com.danco.controller;

import com.danco.storages.MainStorage;
import com.danco.util.Serialization;

// TODO: Auto-generated Javadoc
/**
 * The Class SerializeController.
 */
public class SerializeController implements ISerializeController {

	/** The serialization. */
	private Serialization serialization = new Serialization();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.ISerializeController#serialToFile(com.danco.storages
	 * .MainStorage)
	 */
	@Override
	public void serialToFile(MainStorage serializeMainStorage) {
		serialization.serialToFile(serializeMainStorage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.ISerializeController#serialFromFile()
	 */
	@Override
	public MainStorage serialFromFile() {
		return serialization.serialFromFile();
	}

}
