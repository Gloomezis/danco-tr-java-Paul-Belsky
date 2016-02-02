package com.danco.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class PropertyManager.
 */
public class PropertyManager {

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(PropertyManager.class
			.getName());
	
	/** The properties. */
	private Properties properties = new Properties();
	
	/** The file input stream. */
	private FileInputStream fileInputStream;

	/** The property manger. */
	private static PropertyManager propertyManger;

	/**
	 * Gets the single instance of PropertyManager.
	 *
	 * @return single instance of PropertyManager
	 */
	public static PropertyManager getInstance() {
		if (propertyManger == null) {
			propertyManger = new PropertyManager();
		}
		return propertyManger;
	}

	/**
	 * Instantiates a new property manager.
	 */
	private PropertyManager() {

		File file = new File("properties.txt"); try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			LOG1.error("Exception", e);
		}

		try {
			fileInputStream = new FileInputStream(file);
			properties.load(fileInputStream);

		} catch (Exception e) {
			LOG1.error("Exception", e);
		} finally {
			if (fileInputStream != null) {
			}
			try {
				fileInputStream.close();
			} catch (IOException e) {
				LOG1.error("Exception", e);
			}
		}

	}

	/**
	 * Gets the data file name.
	 *
	 * @return the data file name
	 */
	public String getSerialiseFileName() {
		String fileName = properties.getProperty("dataFileName");
		return fileName;

	}
	
	/**
	 * Gets the status change property.
	 *
	 * @return the status change property
	 */
	public boolean getStatusChangeProperty() {
		String StatusChangeProperty = properties.getProperty("StatusChange");
		return Boolean.parseBoolean(StatusChangeProperty);

	}
	
	/**
	 * Gets the guest history size property.
	 *
	 * @return the guest history size property
	 */
	public int getGuestHistorySizeProperty() {
		String GuestHistorySizeProperty = properties.getProperty("GuestHistorySize");
		return Integer.parseInt(GuestHistorySizeProperty);
		

	}
	
	public String getDependencyInjectionPropertyFile(){
	String fileName = properties.getProperty("dependencyInjectionPropertyFileName");
	return fileName;

}
	
	
}
