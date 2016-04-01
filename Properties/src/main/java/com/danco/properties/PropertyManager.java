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
	
	
	/** The Constant PROPERTY_FIELD_DEPENDENCY_INJ_PROP_FILE_NAME. */
	private static final String PROPERTY_FIELD_DEPENDENCY_INJ_PROP_FILE_NAME="dependencyInjectionPropertyFileName";
	
	/** The Constant PROPERTY_FIELD_DEPENDENCY_INJ_PROP_FILE_NAME. */
	private static final String JDBC_URL="jdbcURL";
	
	private static final String JDBC_DRIVER="jdbcDriver";
	
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
	 * Gets the dependency injection property file.
	 *
	 * @return the dependency injection property file
	 */
	public String getDependencyInjectionPropertyFile() {
		String fileName = properties.getProperty(PROPERTY_FIELD_DEPENDENCY_INJ_PROP_FILE_NAME);
		//String fileName = "dependencyInjectionProperty.txt";
		return fileName;

	}
	
	public String getJDBCSettings() {
		String jdbcURL = properties.getProperty(JDBC_URL);
		return jdbcURL;

	} 
	
	public String getJDBCDriver() {
		String jdbcDriver = properties.getProperty(JDBC_DRIVER);
		return jdbcDriver;

	} 

}
