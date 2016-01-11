package com.danco.gloomezis;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionLogger.
 */
public class ExceptionLogger {

	/**
	 * The Enum EXTYPE.
	 */
	private enum EXTYPE {
		
		/** The error. */
		ERROR, 
        /** The info. */
        INFO, 
        /** The warning. */
        WARNING
	}

	/** The logger. */
	private static Logger logger;

	/**
	 * Log.
	 *
	 * @param message the message
	 * @param msgtype the msgtype
	 */
	private static void log(String message, EXTYPE msgtype) {

		boolean append = true;
		try {
			FileHandler fh = new FileHandler("messages.log", append);
			fh.setFormatter(new Formatter() {

				@Override
				public String format(LogRecord rec) {
					StringBuffer buf = new StringBuffer(10000);
					buf.append(new java.util.Date());
					buf.append(' ');
					buf.append(rec.getLevel());
					buf.append(' ');
					buf.append(formatMessage(rec));

					buf.append('\n');
					return buf.toString();
				}
			});
			logger = Logger.getLogger("messages");
			logger.addHandler(fh);

			switch (msgtype) {
			case WARNING:
				logger.warning(message);
				break;
			case ERROR:
				logger.severe(message);
				break;
			case INFO:
				logger.info(message);
				break;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Log ex.
	 *
	 * @param e the e
	 */
	public static synchronized void logEx(Exception e) {
		
		String f = null;
		StringBuilder sb = new StringBuilder(200);
		sb.append("\n");
		for (StackTraceElement element : e.getStackTrace()) {
			sb.append(element.toString());
			sb.append("\n");
			f = sb.toString();
		}

		log("Error message :" + e.getMessage() + e + f, EXTYPE.ERROR);
		e.printStackTrace();
		log("cause :" + e.getCause(), EXTYPE.INFO);

	}

}