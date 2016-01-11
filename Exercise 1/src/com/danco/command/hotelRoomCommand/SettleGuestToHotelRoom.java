package com.danco.command.hotelRoomCommand;

import java.util.Date;

import com.danco.command.Command;
import com.danco.command.InputManager;
import com.danco.gloomezis.MainStorage;
import com.danco.models.Guest;
import com.danco.models.HotelRoom;
import com.danco.servises.HotelRoomService;

// TODO: Auto-generated Javadoc
/**
 * The Class SettleGuestToHotelRoom.
 */
public class SettleGuestToHotelRoom implements Command {

	/** The Constant GUEST_INPUT_MESSAGE. */
	private static final String GUEST_INPUT_MESSAGE = "Enter guest name";
	
	/** The Constant HOTEL_ROOM_INPUT_MESSAGE. */
	private static final  String HOTEL_ROOM_INPUT_MESSAGE="Enter hotel room number";
	
	/** The Constant DATE_ARRIVE_INPUT_MESSAGE. */
	private static final  String DATE_ARRIVE_INPUT_MESSAGE="Enter date of Arrive / year-month-day  :  yyyy-MM-dd";
	
	/** The Constant DATE_DEPARTURE_INPUT_MESSAGE. */
	private static final  String DATE_DEPARTURE_INPUT_MESSAGE="Enter date of Departure / year-month-day  :  yyyy-MM-dd";
	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {

		
		System.out.println(GUEST_INPUT_MESSAGE);
		String userInputGuestName = InputManager.getInstance().userInputString();
		Guest g = MainStorage.getInstance().getGuestByName(userInputGuestName);

		System.out.println(HOTEL_ROOM_INPUT_MESSAGE);
		String userInputHotelRoomNumber = InputManager.getInstance().userInputString();
		HotelRoom hr = MainStorage.getInstance().getHotelRoomByNumber(userInputHotelRoomNumber);

		System.out.println(DATE_ARRIVE_INPUT_MESSAGE);
		Date userinpitDateOfArrive = InputManager.getInstance().userInputDate();

		System.out.println(DATE_DEPARTURE_INPUT_MESSAGE);
		Date userInputDateOfDeparture = InputManager.getInstance().userInputDate();

		HotelRoomService.getInstance().settleGuestToHotelRoom(g, hr, userinpitDateOfArrive, userInputDateOfDeparture);
	}

}
