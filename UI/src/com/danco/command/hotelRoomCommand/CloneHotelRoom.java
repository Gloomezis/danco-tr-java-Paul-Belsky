package com.danco.command.hotelRoomCommand;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;
import com.danco.util.InputManager;
import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class CloneHotelRoom.
 */
public class CloneHotelRoom implements Command {
	
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(CloneHotelRoom.class.getName());
	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	/** The Constant HOTEL_ROOM_INPUT_MESSAGE. */
	private static final String HOTEL_ROOM_INPUT_MESSAGE = "Enter hotel room number";
	
	/** The Constant NEW_HOTEL_ROOM_INPUT_MESSAGE. */
	private static final String NEW_HOTEL_ROOM_INPUT_MESSAGE = "Enter new room number";
	
	/** The Constant MODIFY_QUESTION. */
	private static final String MODIFY_QUESTION = "Modify? YES/NO";
	
	/** The Constant PRICE_INPUT_MESSAGE. */
	private static final String PRICE_INPUT_MESSAGE = "Write room price";
	
	/** The Constant SLEEPING_NUMBERS_INPUT_MESSAGE. */
	private static final String SLEEPING_NUMBERS_INPUT_MESSAGE = "Write sleeping numbers";
	
	/** The Constant STAR_CATEGORY_INPUT_MESSAGE. */
	private static final String STAR_CATEGORY_INPUT_MESSAGE = "Write star category";
	
	/** The Constant NOT_INPUTED. */
	private static final String NOT_INPUTED = "1";
	
	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = ";";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "6" + ";" + "cloneHotelRoom" + ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message \n";


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.command.Command#execute()
	 */

	/**
	 * Execute.
	 */
	public void execute() {

		
		try {
			
			StringBuilder str = new StringBuilder();

			System.out.println(HOTEL_ROOM_INPUT_MESSAGE);
			String userInputHotelRoomName = InputManager.userInputString();

			System.out.println(NEW_HOTEL_ROOM_INPUT_MESSAGE);
			String userInputHotelRoomNumberModify = InputManager.userInputString();

			System.out.println(MODIFY_QUESTION);
			String modify = InputManager.userInputString();

			if ("YES".equals(modify)) {

				System.out.println(PRICE_INPUT_MESSAGE);
				String roomPriceModify = InputManager.userInputString();

				System.out.println(SLEEPING_NUMBERS_INPUT_MESSAGE);
				String sleepingNumberModify = InputManager.userInputString();

				System.out.println(STAR_CATEGORY_INPUT_MESSAGE);
				String starModify = InputManager.userInputString();

				str.append(PROTOCOL).append(userInputHotelRoomName)
						.append(SEPARATOR)
						.append(userInputHotelRoomNumberModify)
						.append(SEPARATOR).append(modify).append(SEPARATOR)
						.append(roomPriceModify).append(SEPARATOR)
						.append(sleepingNumberModify).append(SEPARATOR)
						.append(starModify);

			} else {

				str.append(PROTOCOL).append(userInputHotelRoomName)
						.append(SEPARATOR)
						.append(userInputHotelRoomNumberModify)
						.append(SEPARATOR).append(modify).append(SEPARATOR)
						.append(NOT_INPUTED).append(SEPARATOR)
						.append(NOT_INPUTED).append(SEPARATOR)
						.append(NOT_INPUTED);

			}
			Processing processing = Processing.getInstance();
			
			PrintUtil.printString(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}
	}

}
