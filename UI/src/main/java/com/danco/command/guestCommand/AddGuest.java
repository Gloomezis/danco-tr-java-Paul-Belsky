package com.danco.command.guestCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;

// TODO: Auto-generated Javadoc
/**
 * The Class AddGuest.
 */
public class AddGuest implements Command {


	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(AddGuest.class.getName());
	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	/** The Constant GUEST_INPUT_MESSAGE. */
	private static final String GUEST_INPUT_MESSAGE = "Enter Guest Name";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "1" + ";" + "addGuest" + ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message ";


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

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputGuestName);

			System.out.println(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}

	}
}
