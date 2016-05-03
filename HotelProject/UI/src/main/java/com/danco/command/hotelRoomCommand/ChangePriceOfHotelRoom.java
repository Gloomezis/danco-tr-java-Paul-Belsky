package com.danco.command.hotelRoomCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;

// TODO: Auto-generated Javadoc
/**
 * The Class ChangePriceOfHotelRoom.
 */
public class ChangePriceOfHotelRoom implements Command {
	
	/** The Constant HOTEL_ROOM_INPUT_MESSAGE. */
	private static final String HOTEL_ROOM_INPUT_MESSAGE = "Enter hotel room id";
	
	/** The Constant PRICE_INPUT_MESSAGE1. */
	private static final String PRICE_INPUT_MESSAGE1 = "Enter new price of hotel room";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "2ext" + ";"
			+ "changePriceOfHotelRoom" + ";";
	
	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message ";

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ChangePriceOfHotelRoom.class
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

			System.out.println(HOTEL_ROOM_INPUT_MESSAGE);
			String userInputHotelRoomName = reader.readLine();

			System.out.println(PRICE_INPUT_MESSAGE1);
			String userInputRoomPrice = reader.readLine();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputHotelRoomName)
					.append(SEPARATOR).append(userInputRoomPrice);
			
			Processing processing = Processing.getInstance();

			System.out.println(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}

	}

}
