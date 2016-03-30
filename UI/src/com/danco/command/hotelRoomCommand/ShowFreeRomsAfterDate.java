/*
 * 
 */
package com.danco.command.hotelRoomCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowFreeRomsAfterDate.
 */
public class ShowFreeRomsAfterDate implements Command {
	
	/** The Constant SORT_INPUT_MESSAGE. */
	private static final String SORT_INPUT_MESSAGE = "Enter room sort condition : room_price/sleeping_number/star_category";
	
	/** The Constant DATE_INPUT_MESSAGE. */
	private static final String DATE_INPUT_MESSAGE = "Enter date / year-month-day  :  yyyy-MM-dd";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "2ext2" + ";"
			+ "showFreeRomsAfterDate" + ";";
	
	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message ";

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ShowFreeRomsAfterDate.class
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

			System.out.println(SORT_INPUT_MESSAGE);
			String userInputSortCondition = reader.readLine();

			System.out.println(DATE_INPUT_MESSAGE);
			String date = reader.readLine();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputSortCondition)
					.append(SEPARATOR).append(date);
			
			Processing processing = Processing.getInstance();

			System.out.println(MESSAGE + processing.dataProcessing(str));
			

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}
	}

}
