/*
 * 
 */
package com.danco.gloomezis.dependencyInjection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.danco.properties.PropertyManager;

// TODO: Auto-generated Javadoc
/**
 * The Class DependencyInjectionPropertyManager.
 */
public class DependencyInjectionPropertyManager {
	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	/** The Constant LOG1. */
	private final static Logger LOG1 = Logger.getLogger(DependencyInjectionPropertyManager.class.getName());

	/** The config manager. */
	private static DependencyInjectionPropertyManager configManager;
	
	/** The properties. */
	private Properties properties;
	
	/** The file input stream. */
	private FileInputStream fileInputStream;
	
	
	/**
	 * Gets the single instance of DependencyInjectionPropertyManager.
	 *
	 * @return single instance of DependencyInjectionPropertyManager
	 */
	public static DependencyInjectionPropertyManager getInstance() {
		if (configManager == null) {
			configManager = new DependencyInjectionPropertyManager();
		}
		return configManager;
	}

	/**
	 * Instantiates a new dependency injection property manager.
	 */
	private DependencyInjectionPropertyManager() {
		properties = new Properties();
		File file = new File(PropertyManager.getInstance().getDependencyInjectionPropertyFile());

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
	 * Gets the impl class name.
	 *
	 * @param iName the i name
	 * @return the impl class name
	 */
	public String getImplClassName(String iName) {

		return properties.getProperty(iName);

	}

}
