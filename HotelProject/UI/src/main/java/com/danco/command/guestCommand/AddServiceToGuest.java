package com.danco.command.guestCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;

// TODO: Auto-generated Javadoc
/**
 * The Class AddServiceToGuest.
 */
public class AddServiceToGuest implements Command {
	
	/** The Constant GUEST_INPUT_MESSAGE. */
	private static final String GUEST_INPUT_MESSAGE = "Enter Guest id";
	
	/** The Constant SERVICE_INPUT_MESSAGE. */
	private static final String SERVICE_INPUT_MESSAGE = "Enter Service id";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "2" + ";" + "addService"
			+ ";";
	
	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message ";

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(AddServiceToGuest.class
			.getName());
	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	



	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		try {

			Processing processing = Processing.getInstance();

			System.out.println(GUEST_INPUT_MESSAGE);
			String userInputGuestName = reader.readLine();

			System.out.println(SERVICE_INPUT_MESSAGE);
			String userInputService = reader.readLine();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputGuestName).append(SEPARATOR)
					.append(userInputService);

			System.out.println(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}

	}
}
