package com.danco.command.ImportExportCSVCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomReadCsvFile.
 */
public class HotelRoomReadCsvFile implements Command {

	/** The Constant HOTEL_ROOM_INPUT_MESAGE_READ. */
	private static final String HOTEL_ROOM_INPUT_MESAGE_READ = "Write CSV file name/path(*.csv) to read hotel room";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "1" + ";" + "hotelRoomReadCsvFile"
			+ ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message ";

	/** The LO g1. */
	private final Logger LOG1 = Logger
			.getLogger(HotelRoomReadCsvFile.class.getName());
	
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

			System.out.println(HOTEL_ROOM_INPUT_MESAGE_READ);
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
