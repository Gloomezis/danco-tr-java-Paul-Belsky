package com.danco.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

import com.danco.properties.PropertyManager;
import com.danco.storages.MainStorage;

// TODO: Auto-generated Javadoc
/**
 * The Class Serialization.
 */
public class Serialization {
	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(Serialization.class.getName());

	/**
	 * Serial to file.
	 */
	public void serialToFile(MainStorage serializeMainStorage) {
		
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(PropertyManager.getInstance().getSerialiseFileName()))) {
			out.writeObject(serializeMainStorage);
			out.close();
		} catch (IOException e) {
			LOG1.error(EXCEPTION, e);

		}
	}

	/**
	 * Serial from file.
	 * 
	 * @return
	 */
	public MainStorage serialFromFile() {
		MainStorage mainStorage = null;
		try (ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(PropertyManager.getInstance().getSerialiseFileName()))) {
			mainStorage = (MainStorage) in.readObject();
			in.close();

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}
		return mainStorage;
	}
}
