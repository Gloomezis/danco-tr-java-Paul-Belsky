package com.danco.command.hotelRoomCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;

// TODO: Auto-generated Javadoc
/**
 * The Class SettleGuestToHotelRoom.
 */
public class SettleGuestToHotelRoom implements Command {

	/** The Constant GUEST_INPUT_MESSAGE. */
	private static final String GUEST_INPUT_MESSAGE = "Enter guest id";
	
	/** The Constant HOTEL_ROOM_INPUT_MESSAGE. */
	private static final String HOTEL_ROOM_INPUT_MESSAGE = "Enter hotel room id";
	
	/** The Constant DATE_ARRIVE_INPUT_MESSAGE. */
	private static final String DATE_ARRIVE_INPUT_MESSAGE = "Enter date of Arrive / year-month-day  :  yyyy-MM-dd";
	
	/** The Constant DATE_DEPARTURE_INPUT_MESSAGE. */
	private static final String DATE_DEPARTURE_INPUT_MESSAGE = "Enter date of Departure / year-month-day  :  yyyy-MM-dd";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "4ext" + ";"
			+ "settleGuestToHotelRoom" + ";";
	
	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message ";

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(SettleGuestToHotelRoom.class
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

			System.out.println(GUEST_INPUT_MESSAGE);
			String userInputGuestName = reader.readLine();

			System.out.println(HOTEL_ROOM_INPUT_MESSAGE);
			String userInputHotelRoomNumber = reader.readLine();

			System.out.println(DATE_ARRIVE_INPUT_MESSAGE);
			String userinpitDateOfArrive = reader.readLine();

			System.out.println(DATE_DEPARTURE_INPUT_MESSAGE);
			String userInputDateOfDeparture = reader.readLine();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputGuestName).append(SEPARATOR)
					.append(userInputHotelRoomNumber).append(SEPARATOR)
					.append(userinpitDateOfArrive).append(SEPARATOR)
					.append(userInputDateOfDeparture);

			Processing processing = Processing.getInstance();
			System.out.println(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}
	}

}
