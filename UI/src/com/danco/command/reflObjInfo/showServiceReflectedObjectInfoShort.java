package com.danco.command.reflObjInfo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;

// TODO: Auto-generated Javadoc
/**
 * The Class showServiceReflectedObjectInfoShort.
 */
public class showServiceReflectedObjectInfoShort implements Command {

	/** The Constant SERVICES_INPUT_MESSAGE. */
	private static final String SERVICES_INPUT_MESSAGE = "Enter service name";

	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "1" + ";"
			+ "showServiceReflectedObjectInfoShort" + ";";

	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message ";

	/** The LO g1. */
	private final Logger LOG1 = Logger
			.getLogger(showServiceReflectedObjectInfoShort.class.getName());

	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	

	/** The main controller. */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {

			System.out.println(SERVICES_INPUT_MESSAGE);
			String userInputServiceName = reader.readLine();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputServiceName);
			Processing processing = Processing.getInstance();
			System.out.println(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}
	}
}
