package com.danco.command.hotelRoomCommand;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;
import com.danco.util.InputManager;
import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ChangeStatus.
 */
public class ChangeStatus implements Command {
	
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ChangeStatus.class.getName());
	
	/** The Constant HOTEL_ROOM_INPUT_MESSAGE. */
	private static final String HOTEL_ROOM_INPUT_MESSAGE = "Enter hotel room number";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "1" + ";" + "changeStatus" + ";";
	
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

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputHotelRoomName);
			
			Processing processing = Processing.getInstance();

			PrintUtil.printString(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}

	}

}
