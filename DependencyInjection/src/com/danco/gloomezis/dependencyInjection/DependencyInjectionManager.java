package com.danco.gloomezis.dependencyInjection;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class DependencyInjectionManager.
 */
public class DependencyInjectionManager {

	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	/** The Constant LOG1. */
	private final static Logger LOG1 = Logger
			.getLogger(DependencyInjectionManager.class.getName());

	/** The objects. */
	private static Map<String, Object> objects = new HashMap<String, Object>();

	/**
	 * Gets the class instance.
	 *
	 * @param clazz
	 *            the clazz
	 * @return the class instance
	 */
	public static Object getClassInstance(Class<?> clazz) {
		Object obj = null;
		if (objects.containsKey(clazz.getName())) {

			obj = objects.get(clazz.getName());
		} else {
			String implClassName = DependencyInjectionPropertyManager
					.getInstance().getImplClassName(clazz.getName());
			try {
				Class<?> implClass = Class.forName(implClassName);
				obj = implClass.newInstance();
				objects.put(implClassName, obj);
			} catch (Exception e) {
				LOG1.error(EXCEPTION, e);
			}
		}
		return obj;
	}
}
