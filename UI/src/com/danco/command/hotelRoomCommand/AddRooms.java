package com.danco.command.hotelRoomCommand;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;
import com.danco.util.InputManager;
import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class AddRooms.
 */
public class AddRooms implements Command {
	
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(AddRooms.class.getName());
	
	/** The Constant HOTEL_ROOM_INPUT_MESSAGE. */
	private static final String HOTEL_ROOM_INPUT_MESSAGE = "Enter hotel room number";
	
	/** The Constant PRICE_INPUT_MESSAGE. */
	private static final String PRICE_INPUT_MESSAGE = "Write room price";
	
	/** The Constant SLEEPING_NUMBERS_INPUT_MESSAGE. */
	private static final String SLEEPING_NUMBERS_INPUT_MESSAGE = "Write sleeping numbers";
	
	/** The Constant STAR_CATEGORY_INPUT_MESSAGE. */
	private static final String STAR_CATEGORY_INPUT_MESSAGE = "Write star category";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "4" + ";" + "addRooms" + ";";
	
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

			System.out.println(HOTEL_ROOM_INPUT_MESSAGE);
			String userInputHotelRoomName = InputManager.userInputString();

			System.out.println(PRICE_INPUT_MESSAGE);
			String userInputRoomPrice = InputManager.userInputString();

			System.out.println(SLEEPING_NUMBERS_INPUT_MESSAGE);
			String userInputSleepingNumbers = InputManager.userInputString();

			System.out.println(STAR_CATEGORY_INPUT_MESSAGE);
			String userInputStarCategory = InputManager.userInputString();
			
			Processing processing = Processing.getInstance();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputHotelRoomName)
					.append(SEPARATOR).append(userInputRoomPrice)
					.append(SEPARATOR).append(userInputSleepingNumbers)
					.append(SEPARATOR).append(userInputStarCategory);

			PrintUtil.printString(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}

	}

}
