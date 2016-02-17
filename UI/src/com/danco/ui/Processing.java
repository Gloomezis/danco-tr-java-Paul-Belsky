package com.danco.ui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class Processing.
 */
public class Processing {

	/** The Constant LOG1. */
	private final static Logger LOG1 = Logger.getLogger(Processing.class
			.getName());

	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	/** The in. */
	private ObjectInputStream in;

	/** The out. */
	private ObjectOutputStream out;

	/**
	 * Instantiates a new processing.
	 */

	private Processing() {
	};

	/** The instance. */
	private static Processing instance;

	/**
	 * Gets the single instance of Processing.
	 *
	 * @return single instance of Processing
	 */
	public static Processing getInstance() {
		if (instance == null) {
			instance = new Processing();
		}
		return instance;
	}

	/**
	 * Initialize streams.
	 *
	 * @param socket the socket
	 */
	public void initializeStreams(Socket socket) {
		try {
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}

	}

	/**
	 * Data processing.
	 *
	 * @param str the str
	 * @return the object
	 */
	public Object dataProcessing(StringBuilder str) {
		Object object = new Object();
		try {
			out.writeObject(str);
			out.flush();
			object = in.readObject();

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			if (str == null) {
				PrintUtil.printString("ERROR SERVER");

			}
		}
		return object;
	}

	/**
	 * Processing close.
	 */
	public void processingClose() {
		try {
			out.close();
			in.close();
		} catch (IOException e) {
			LOG1.error(EXCEPTION, e);
		}

	}

}