package com.danco.command.hotelRoomCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartGuestFromHotelRoom.
 */
public class DepartGuestFromHotelRoom implements Command {

	/** The Constant HOTEL_ROOM_INPUT_MESSAGE. */
	private static final String GUEST_ID_INPUT_MESSAGE = "Enter guest id";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "1" + ";"
			+ "departGuestFromHotelRoom" + ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message ";

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(DepartGuestFromHotelRoom.class
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

			System.out.println(GUEST_ID_INPUT_MESSAGE);
			String userInputGuestId = reader.readLine();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputGuestId);

			Processing processing = Processing.getInstance();
			System.out.println(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}
	}

}
