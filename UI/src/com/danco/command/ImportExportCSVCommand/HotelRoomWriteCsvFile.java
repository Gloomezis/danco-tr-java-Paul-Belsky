package com.danco.command.ImportExportCSVCommand;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;
import com.danco.util.InputManager;
import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomWriteCsvFile.
 */
public class HotelRoomWriteCsvFile implements Command {
	
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(HotelRoomWriteCsvFile.class.getName());
	
	
	/** The Constant HOTEL_ROOM_INPUT_MESAGE_WRITE. */
	private static final String HOTEL_ROOM_INPUT_MESAGE_WRITE = "Write CSV file name/path(*.csv) to hotel room";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "1" + ";" + "hotelRoomWriteCsvFile"
			+ ";";
	
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
		// TODO Auto-generated method stub

		
		try {

			System.out.println(HOTEL_ROOM_INPUT_MESAGE_WRITE);
			String userInputFileName = InputManager.userInputString();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputFileName);
			Processing processing = Processing.getInstance();
			PrintUtil.printString(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}
	}

}
