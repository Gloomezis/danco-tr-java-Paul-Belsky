/*
 * 
 */
package com.danco.server;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

import com.danco.controller.api.IMainController;

// TODO: Auto-generated Javadoc
/**
 * The Class CommanDProcessor.
 */
public class CommanDProcessor {

	/** The Constant LOG1. */
	private final static Logger LOG1 = Logger.getLogger(CommanDProcessor.class
			.getName());
	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";
	
	/** The Constant SPLIT. */
	// input 1.String
	private static final String SPLIT = "-";
	
	/** The Constant SPLIT_2. */
	// input 1.String
	private static final String SPLIT_2 = ";";

	/** The Constant ONE_OPTION. */
	// input 1.String
	private static final String ONE_OPTION = "1";

	/** The Constant TWO_OPTION. */
	// input 1.String 2.String
	private static final String TWO_OPTION = "2";

	/** The Constant TWO_EXT_OPTION. */
	// input 1.String 2.Int
	private static final String TWO_EXT_OPTION = "2ext";

	/** The Constant TWO_EXT_ALTERNATIVE_OPTION. */
	// input 1.String 2.Date
	private static final String TWO_EXT_ALTERNATIVE_OPTION = "2ext2";

	/** The Constant FOUR_OPTION. */
	// input 1.String 2.Int 3.Int 4.Int
	private static final String FOUR_OPTION = "4";

	/** The Constant FOUR_EXT_OPTION. */
	// input 1.String 2.String 3.Date 4.Date
	private static final String FOUR_EXT_OPTION = "4ext";

	/** The Constant SIX_OPTION. */
	// input for clone with all midify 1.String 2.String 3.String 4.Int 5.Int
	// 6.Int
	private static final String SIX_OPTION = "6";

	/** The main controller. */
	private IMainController mainController;

	/**
	 * Instantiates a new comman d processor.
	 *
	 * @param mainController the main controller
	 */
	public CommanDProcessor(IMainController mainController) {
		this.mainController = mainController;
	}

	/**
	 * Parses the string to object.
	 *
	 * @param str the str
	 * @return the object
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object parseStringToObject(String str) {

		String[] arrayStr = str.split(SPLIT_2);
		String type = arrayStr[0];
		String nameMetod = arrayStr[1];
		Object rezult = new Object();

		try {
			Class cl = this.mainController.getClass();
			Class[] paramTypes = new Class[] {};
			Object[] args = new Object[] {};

			switch (type) {
			case ONE_OPTION:
				paramTypes = new Class[] { String.class };
				args = new Object[] { arrayStr[2] };
				break;
			case TWO_OPTION:
				paramTypes = new Class[] { String.class, String.class };
				args = new Object[] { arrayStr[2], arrayStr[3] };
				break;
			case TWO_EXT_OPTION:
				paramTypes = new Class[] { String.class, int.class };
				args = new Object[] { arrayStr[2],
						Integer.parseInt(arrayStr[3]) };
				break;

			case TWO_EXT_ALTERNATIVE_OPTION:
				paramTypes = new Class[] { String.class, Date.class };
				args = new Object[] { arrayStr[2], dateFromString(arrayStr[3]) };
				break;

			case FOUR_OPTION:
				paramTypes = new Class[] { String.class, int.class, int.class,
						int.class };
				args = new Object[] { arrayStr[2],
						Integer.parseInt(arrayStr[3]),
						Integer.parseInt(arrayStr[4]),
						Integer.parseInt(arrayStr[5]) };
				break;

			case FOUR_EXT_OPTION:
				paramTypes = new Class[] { String.class, String.class,
						Date.class, Date.class };
				args = new Object[] { arrayStr[2], arrayStr[3],
						dateFromString(arrayStr[4]),
						dateFromString(arrayStr[5]) };
			
				break;

			case SIX_OPTION:
				paramTypes = new Class[] { String.class, String.class,
						String.class, int.class, int.class, int.class };
				args = new Object[] { arrayStr[2], arrayStr[3], arrayStr[4],
						Integer.parseInt(arrayStr[5]),
						Integer.parseInt(arrayStr[6]),
						Integer.parseInt(arrayStr[7]) };
				break;

			default:
				break;
			}
			Method m = cl.getMethod(nameMetod, paramTypes);
			rezult = m.invoke(this.mainController, args);

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}
		return rezult;
	}

	/**
	 * Date from string.
	 *
	 * @param str the str
	 * @return the date
	 */
	public Date dateFromString(String str) {
		Date date = null;
		String[] dateMassArrive = str.split(SPLIT);
		date = new GregorianCalendar(Integer.parseInt(dateMassArrive[0]),
				Integer.parseInt(dateMassArrive[1]),
				Integer.parseInt(dateMassArrive[2])).getTime();
		return date;

	}
}