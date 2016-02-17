/*
 * 
 */
package com.danco.command.hotelRoomCommand;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;
import com.danco.util.InputManager;
import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowFreeRomsAfterDate.
 */
public class ShowFreeRomsAfterDate implements Command {
	
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ShowFreeRomsAfterDate.class.getName());
	
	/** The Constant SORT_INPUT_MESSAGE. */
	private static final String SORT_INPUT_MESSAGE = "Enter room sort condition : price/sleepN/star";
	
	/** The Constant DATE_INPUT_MESSAGE. */
	private static final String DATE_INPUT_MESSAGE = "Enter date / year-month-day  :  yyyy-MM-dd";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "2ext2" + ";"
			+ "showFreeRomsAfterDate" + ";";
	
	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = ";";
	
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

			System.out.println(SORT_INPUT_MESSAGE);
			String userInputSortCondition = InputManager.userInputString();

			System.out.println(DATE_INPUT_MESSAGE);
			String date = InputManager.userInputString();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputSortCondition)
					.append(SEPARATOR).append(date);
			
			Processing processing = Processing.getInstance();

			PrintUtil.printString(MESSAGE + processing.dataProcessing(str));
			

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}
	}

}
