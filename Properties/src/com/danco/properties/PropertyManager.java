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
	
	/** The Constant PROPERTY_FILE_NAME. */
	private static final String PROPERTY_FILE_NAME = "properties.txt";
	
	/** The Constant PROPERTY_FIELD_DATA_FILE_NAME. */
	private static final String PROPERTY_FIELD_DATA_FILE_NAME="dataFileName";
	
	/** The Constant PROPERTY_FIELD_STATUS_CHANGE. */
	private static final String PROPERTY_FIELD_STATUS_CHANGE="StatusChange";
	
	/** The Constant PROPERTY_FIELD_GUEST_HISTORY_SIZE. */
	private static final String PROPERTY_FIELD_GUEST_HISTORY_SIZE="GuestHistorySize";
	
	/** The Constant PROPERTY_FIELD_DEPENDENCY_INJ_PROP_FILE_NAME. */
	private static final String PROPERTY_FIELD_DEPENDENCY_INJ_PROP_FILE_NAME="dependencyInjectionPropertyFileName";
	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

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

		File file = new File(PROPERTY_FILE_NAME);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}

		try {
			fileInputStream = new FileInputStream(file);
			properties.load(fileInputStream);

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			if (fileInputStream != null) {
			}
			try {
				fileInputStream.close();
			} catch (IOException e) {
				LOG1.error(EXCEPTION, e);
			}
		}

	}

	/**
	 * Gets the serialise file name.
	 *
	 * @return the serialise file name
	 */
	public String getSerialiseFileName() {
		String fileName = properties.getProperty(PROPERTY_FIELD_DATA_FILE_NAME);
		return fileName;

	}

	/**
	 * Gets the status change property.
	 *
	 * @return the status change property
	 */
	public boolean getStatusChangeProperty() {
		String StatusChangeProperty = properties.getProperty(PROPERTY_FIELD_STATUS_CHANGE);
		return Boolean.parseBoolean(StatusChangeProperty);

	}

	/**
	 * Gets the guest history size property.
	 *
	 * @return the guest history size property
	 */
	public int getGuestHistorySizeProperty() {
		String GuestHistorySizeProperty = properties
				.getProperty(PROPERTY_FIELD_GUEST_HISTORY_SIZE);
		return Integer.parseInt(GuestHistorySizeProperty);

	}

	/**
	 * Gets the dependency injection property file.
	 *
	 * @return the dependency injection property file
	 */
	public String getDependencyInjectionPropertyFile() {
		String fileName = properties
				.getProperty(PROPERTY_FIELD_DEPENDENCY_INJ_PROP_FILE_NAME);
		return fileName;

	}

}
