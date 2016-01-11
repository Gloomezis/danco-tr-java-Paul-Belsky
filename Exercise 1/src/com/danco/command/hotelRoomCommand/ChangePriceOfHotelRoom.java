package com.danco.command.hotelRoomCommand;

import com.danco.command.Command;
import com.danco.command.InputManager;
import com.danco.gloomezis.MainStorage;
import com.danco.models.HotelRoom;
import com.danco.servises.HotelRoomService;

// TODO: Auto-generated Javadoc
/**
 * The Class ChangePriceOfHotelRoom.
 */
public class ChangePriceOfHotelRoom implements Command {
	
	/** The Constant HOTEL_ROOM_INPUT_MESSAGE. */
	private static final  String HOTEL_ROOM_INPUT_MESSAGE="Enter hotel room number";
	
	/** The Constant PRICE_INPUT_MESSAGE. */
	private static final  String PRICE_INPUT_MESSAGE="Enter new price of hotel room";

	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {

		System.out.println(HOTEL_ROOM_INPUT_MESSAGE);
		String userInputHotelRoomNumber = InputManager.getInstance().userInputString();
		HotelRoom hr = MainStorage.getInstance().getHotelRoomByNumber(userInputHotelRoomNumber);

		System.out.println(PRICE_INPUT_MESSAGE);
		int userInputRoomPrice = InputManager.getInstance().userInputInt();

		HotelRoomService.getInstance().changePriceOfHotelRoom(hr, userInputRoomPrice);

	}

}
