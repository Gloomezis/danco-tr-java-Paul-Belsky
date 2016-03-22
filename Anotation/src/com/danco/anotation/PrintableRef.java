package com.danco.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO: Auto-generated Javadoc
/**
 * The Interface PrintableRef.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrintableRef {

	/**
	 * Name.
	 *
	 * @return the string
	 */
	String name();

	/**
	 * Checks if is detailed view.
	 *
	 * @return true, if is detailed view
	 */
	boolean isDetailedView() default true; // true for collection , false for
											// link

	/**
	 * Checks if is recursive.
	 *
	 * @return true, if is recursive
	 */
	boolean isRecursive() default false;

	/**
	 * Order.
	 *
	 * @return the int
	 */
	int order();

}
