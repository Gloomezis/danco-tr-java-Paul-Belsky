package com.danco.command.guestCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowListOfService.
 */
public class ShowListOfService implements Command {

	/** The Constant GUEST_INPUT_MESSAGE. */
	private static final String GUEST_INPUT_MESSAGE = "Enter Guest id";
	
	/** The Constant SORT_INPUT_MESSAGE1. */
	private static final String SORT_INPUT_MESSAGE1 = "Enter room sort condition : name/price";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "2" + ";" + "showListOfServiceGuest"
			+ ";";
	
	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message ";

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ShowListOfService.class
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

			System.out.println(SORT_INPUT_MESSAGE1);
			String userInputSortCondition = reader.readLine();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputGuestName).append(SEPARATOR)
					.append(userInputSortCondition);

			System.out.println(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}

	}

}
