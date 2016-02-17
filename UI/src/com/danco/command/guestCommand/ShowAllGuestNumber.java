package com.danco.command.guestCommand;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;
import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowAllGuestNumber.
 */
public class ShowAllGuestNumber implements Command {
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ShowAllGuestNumber.class.getName());

	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "0" + ";" + "showAllGuestNumber"
			+ ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Mesage \n";
	
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
			
			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL);

			PrintUtil.printString(MESSAGE + processing.dataProcessing(str));
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}

	}

}
