/*
 * 
 */
package com.danco.anotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class PrintableAnalizer.
 */
public class PrintableAnalizer implements IPrintableAnalizer {

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(PrintableAnalizer.class
			.getName());

	/** The Constant NEW_LINE. */
	private static final String NEW_LINE = "\n";

	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	/** The Constant IS_DETAILED_ONLY. */
	private static final String IS_DETAILED_ONLY = "isDetailedOnly";

	/** The Constant IS_DETAILED_VIEW. */
	private static final String IS_DETAILED_VIEW = "isDetailedView";

	/** The Constant IS_RECURSIVE. */
	private static final String IS_RECURSIVE = "isRecursive";

	/** The Constant NO_ANOTATION. */
	private static final String NO_ANOTATION = "no annotation";

	/** The Constant PRINTABLE_ANOTATION_PRESENT. */
	private static final String PRINTABLE_ANOTATION_PRESENT = "Printable annotaton  - ";

	/** The Constant PRINTABLE_REF_ANOTATION_PRESENT. */
	private static final String PRINTABLE_REF_ANOTATION_PRESENT = "Printable ref annotation  - ";

	/** The Constant ANOTADED_CLASS_NAME. */
	private static final String ANOTADED_CLASS_NAME = "class annotated ; name  -  ";

	/**
	 * Analize entity and print.
	 *
	 * @param obj the obj
	 * @param detailed the detailed
	 * @return the string
	 */

	private String analizeEntityAndPrint(Object obj, boolean detailed) {
		StringBuilder sb = new StringBuilder(500);
		Class<?> c = obj.getClass();
		boolean detailedView = detailed;

		boolean printable = false;
		boolean printableRef = false;

		if (!c.isAnnotationPresent(PrintableObject.class)) {

			sb.append(NO_ANOTATION + NEW_LINE);
			return null; // TODO test
		} else {
			sb.append(ANOTADED_CLASS_NAME
					+ c.getAnnotation(PrintableObject.class) + NEW_LINE);
		}

		Field[] fields = obj.getClass().getDeclaredFields();

		List<FieldSortOrder> list = new ArrayList<>();

		for (Field field : fields) {
			if (field.isAnnotationPresent(Printable.class)) {
				list.add(new FieldSortOrder(field, field.getAnnotation(
						Printable.class).order()));
			} else if (field.isAnnotationPresent(PrintableRef.class)) {
				list.add(new FieldSortOrder(field, field.getAnnotation(
						PrintableRef.class).order()));
			}
		}

		Comparator<FieldSortOrder> comparator = new Comparator<FieldSortOrder>() {

			@Override
			public int compare(FieldSortOrder o1, FieldSortOrder o2) {

				return Integer.compare(o1.getOrder(), o2.getOrder());
			}

		};

		Collections.sort(list, comparator);

		for (FieldSortOrder fieldSortOrder : list) {
			Field fd = fieldSortOrder.getField();

			fd.setAccessible(true);

			if (fd.isAnnotationPresent(Printable.class)) {
				printable = true;

				final Annotation an = fd.getAnnotation(Printable.class);

				// Comment to hide field meta info
				// sb.append(an + NEW_LINE);
				final Class<?> type = an.annotationType();
				Method m = null;
				try {
					m = type.getMethod(IS_DETAILED_ONLY);
				} catch (Exception e) {
					LOG1.error(EXCEPTION, e);
				}
				final boolean rp;
				try {
					rp = (boolean) m.invoke(an);
					if (detailedView == true) {

						sb.append(showFieldParameter(fd, obj));
					}
					if (detailedView == false && rp == false) {

						sb.append(showFieldParameter(fd, obj));
					}

				} catch (Exception e) {

					LOG1.error(EXCEPTION, e);
				}

			}
			if (fd.isAnnotationPresent(PrintableRef.class)) {
				printableRef = true;

				final Annotation an = fd.getAnnotation(PrintableRef.class);
				// Comment to hide field meta info
				// sb.append(an + NEW_LINE);
				final Class<?> type = an.annotationType();

				Method m = null;
				try {
					m = type.getMethod(IS_DETAILED_VIEW);
				} catch (Exception e) {
					LOG1.error(EXCEPTION, e);
				}

				final boolean isDetailed;
				try {
					isDetailed = (boolean) m.invoke(an);
					if (detailedView == true && isDetailed == true) {

						sb.append(showFieldParameter(fd, obj));

					}
				} catch (Exception e) {

					LOG1.error(EXCEPTION, e);
				}

				Method met2 = null;
				try {
					met2 = type.getMethod(IS_RECURSIVE);
				} catch (Exception e) {
					LOG1.error(EXCEPTION, e);
				}
				final boolean isRec;
				try {
					isRec = (boolean) met2.invoke(an);

					if (isRec == true) {
						List<?> a = (List<?>) fd.get(obj);
						for (Object object : a) {
							sb.append(analizeEntityAndPrint(object,
									detailedView) + NEW_LINE);
						}
					}

				} catch (Exception e) {
					LOG1.error(EXCEPTION, e);
				}

			}
			if (printable && printableRef) {
				break;
			}
			//TODO TEST
			fd.setAccessible(false);
		}
		sb.append(PRINTABLE_ANOTATION_PRESENT + printable + ";"
				+ PRINTABLE_REF_ANOTATION_PRESENT + printableRef + NEW_LINE);
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.anotation.IPrintableAnalizer#printDetaildeView(java.lang.Object
	 * )
	 */
	@Override
	public String printDetaildeView(Object obj) {
		boolean detailed = true;
		String info = analizeEntityAndPrint(obj, detailed);
		return info;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.anotation.IPrintableAnalizer#printShortView(java.lang.Object)
	 */
	@Override
	public String printShortView(Object obj) {
		boolean detailed = false;
		String info = analizeEntityAndPrint(obj, detailed);
		return info;
	}

	/**
	 * Show field parameter.
	 *
	 * @param fd
	 *            the fd
	 * @param obj
	 *            the obj
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	private String showFieldParameter(Field fd, Object obj) throws Exception {
		return (Modifier.toString(fd.getModifiers()) + " "
				+ fd.getType().getSimpleName() + " " + fd.getName() + " = "
				+ fd.get(obj).toString() + ";" + NEW_LINE);

	}
}
