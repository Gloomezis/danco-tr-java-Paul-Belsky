package com.danco.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target(ElementType.FIELD )
@Retention(RetentionPolicy.RUNTIME)
public @interface PrintableRef {
	String name();
	boolean isDetailedView() default true; //true for collection , false for link
	boolean isRecursive() default false;
	int order();
	

}
