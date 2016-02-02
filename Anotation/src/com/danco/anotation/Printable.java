package com.danco.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO: Auto-generated Javadoc
/**
 * The Interface Printable.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Printable {
	
	/**
	 * Name.
	 *
	 * @return the string
	 */
	String name();

	/**
	 * Checks if is detailed only.
	 *
	 * @return true, if is detailed only
	 */
	boolean isDetailedOnly() default true;

	/**
	 * Order.
	 *
	 * @return the int
	 */
	int order();
}
