package com.danco.command.hotelRoomCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowAllFreeRooms.
 */
public class ShowAllFreeRooms implements Command {

	/** The Constant SORT_INPUT_MESSAGE. */
	private static final String SORT_INPUT_MESSAGE = "Enter room sort condition : room_price/sleeping_number/star_category";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "1" + ";" + "showAllFreeRooms" + ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message ";

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ShowAllFreeRooms.class
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

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputSortCondition);
			
			Processing processing = Processing.getInstance();
			System.out.println(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}
	}

}
