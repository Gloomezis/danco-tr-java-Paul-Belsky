package com.danco.command.guestCommand;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;
import com.danco.util.InputManager;
import com.danco.util.PrintUtil;

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
	private static final String MESSAGE = "Message \n ";


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
			
			String userInputGuestName=InputManager.userInputString();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputGuestName);

			PrintUtil.printString(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}

	}
}
