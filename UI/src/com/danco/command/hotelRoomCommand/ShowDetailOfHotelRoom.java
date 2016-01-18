package com.danco.command.hotelRoomCommand;

import com.danco.command.Command;
import com.danco.command.InputManager;
import com.danco.gloomezis.MainStorage;
import com.danco.model.HotelRoom;
import com.danco.serviñe.HotelRoomService;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowDetailOfHotelRoom.
 */
public class ShowDetailOfHotelRoom implements Command {
	
	/** The Constant HOTEL_ROOM_INPUT_MESSAGE. */
	private static final  String HOTEL_ROOM_INPUT_MESSAGE="Enter hotel room number";

	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {

		System.out.println(HOTEL_ROOM_INPUT_MESSAGE);

		String userInputHotelRoomNumber = InputManager.getInstance().userInputString();
		HotelRoom hr = MainStorage.getInstance().getHotelRoomByNumber(userInputHotelRoomNumber);
		HotelRoomService.getInstance().showDetailOfHotelRoom(hr);
	}

}
