package com.danco.command.guestCommand;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;
import com.danco.util.InputManager;
import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowListOfService.
 */
public class ShowListOfService implements Command {
	
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ShowListOfService.class.getName());

	/** The Constant GUEST_INPUT_MESSAGE. */
	private static final String GUEST_INPUT_MESSAGE = "Enter Guest Name";
	
	/** The Constant SORT_INPUT_MESSAGE1. */
	private static final String SORT_INPUT_MESSAGE1 = "Enter room sort condition : date/price";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "2" + ";" + "showListOfService"
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
/*
			int serverPort = 6969;
			Socket socket = new Socket(InetAddress.getLocalHost(), serverPort);
			Processing processing = new Processing(socket);
			*/
			Processing processing = Processing.getInstance();

			System.out.println(GUEST_INPUT_MESSAGE);
			String userInputGuestName = InputManager.userInputString();

			System.out.println(SORT_INPUT_MESSAGE1);
			String userInputSortCondition = InputManager.userInputString();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputGuestName).append(SEPARATOR)
					.append(userInputSortCondition);

			PrintUtil.printString(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}

	}

}
