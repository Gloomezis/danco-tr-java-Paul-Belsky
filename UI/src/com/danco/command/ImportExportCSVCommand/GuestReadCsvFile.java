package com.danco.command.ImportExportCSVCommand;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;
import com.danco.util.InputManager;
import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestReadCsvFile.
 */
public class GuestReadCsvFile implements Command {
	
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(GuestReadCsvFile.class.getName());
	
	/** The Constant GUEST_INPUT_MESAGE_READ. */
	private static final String GUEST_INPUT_MESAGE_READ = "Write CSV file name/path(*.csv) to read guest";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "1" + ";" + "guestReadCsvFile" + ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message  \n";
	
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

			System.out.println(GUEST_INPUT_MESAGE_READ);
			String userInputFileName =InputManager.userInputString();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputFileName);
			Processing processing = Processing.getInstance();
			PrintUtil.printString(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}

	}

}
