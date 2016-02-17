package com.danco.command.guestCommand;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;
import com.danco.util.InputManager;
import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class AddServiceToGuest.
 */
public class AddServiceToGuest implements Command {
	
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(AddServiceToGuest.class.getName());
	
	/** The Constant GUEST_INPUT_MESSAGE. */
	private static final String GUEST_INPUT_MESSAGE = "Enter Guest Name";
	
	/** The Constant SERVICE_INPUT_MESSAGE. */
	private static final String SERVICE_INPUT_MESSAGE = "Enter Service Name";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "2" + ";" + "addServiceToGuest"
			+ ";";
	
	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message \n";
	
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

			System.out.println(GUEST_INPUT_MESSAGE);
			String userInputGuestName = InputManager.userInputString();

			System.out.println(SERVICE_INPUT_MESSAGE);
			String userInputService = InputManager.userInputString();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputGuestName).append(SEPARATOR)
					.append(userInputService);

			PrintUtil.printString(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}

	}
}
