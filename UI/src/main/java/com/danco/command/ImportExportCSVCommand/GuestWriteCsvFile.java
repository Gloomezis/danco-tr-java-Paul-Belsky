package com.danco.command.ImportExportCSVCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestWriteCsvFile.
 */
public class GuestWriteCsvFile implements Command {
	
	/** The Constant GUEST_INPUT_MESAGE_WRITE. */
	private static final String GUEST_INPUT_MESAGE_WRITE = "Write CSV file name/path(*.csv) to write guest";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "1" + ";" + "guestWriteCsvFile"
			+ ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message ";

	/** The LO g1. */
	private final Logger LOG1 = Logger
			.getLogger(GuestWriteCsvFile.class.getName());
	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	

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

			System.out.println(GUEST_INPUT_MESAGE_WRITE);
			String userInputFileName = reader.readLine();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputFileName);
			Processing processing = Processing.getInstance();
			System.out.println(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}
	}

}
