package com.danco.command.guestCommand;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowAllGuestNumber.
 */
public class ShowAllGuestNumber implements Command {

	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "0" + ";" + "showAllGuestNumber"
			+ ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Mesage ";

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ShowAllGuestNumber.class
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

		try {
			
			Processing processing = Processing.getInstance();
			
			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL);

			System.out.println(MESSAGE + processing.dataProcessing(str));
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}

	}

}
