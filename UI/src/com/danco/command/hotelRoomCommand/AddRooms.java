package com.danco.command.hotelRoomCommand;

import com.danco.command.Command;
import com.danco.command.InputManager;
import com.danco.gloomezis.MainStorage;
import com.danco.model.HotelRoom;
import com.danco.serviñe.HotelRoomService;

// TODO: Auto-generated Javadoc
/**
 * The Class AddRooms.
 */
public class AddRooms implements Command {
	
	/** The Constant HOTEL_ROOM_INPUT_MESSAGE. */
	private static final  String HOTEL_ROOM_INPUT_MESSAGE="Write name of hotelRoom";
	
	/** The Constant PRICE_INPUT_MESSAGE. */
	private static final  String PRICE_INPUT_MESSAGE="Write room price";
	
	/** The Constant SLEEPING_NUMBERS_INPUT_MESSAGE. */
	private static final  String SLEEPING_NUMBERS_INPUT_MESSAGE="Write sleeping numbers";
	
	/** The Constant STAR_CATEGORY_INPUT_MESSAGE. */
	private static final  String STAR_CATEGORY_INPUT_MESSAGE="Write star category";

	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {

		System.out.println(HOTEL_ROOM_INPUT_MESSAGE);
		String userInputHotelRoomName = InputManager.getInstance().userInputString();

		System.out.println(PRICE_INPUT_MESSAGE);
		int userInputRoomPrice = InputManager.getInstance().userInputInt();

		System.out.println(SLEEPING_NUMBERS_INPUT_MESSAGE);
		int userInputSleepingNumbers = InputManager.getInstance().userInputInt();

		System.out.println(STAR_CATEGORY_INPUT_MESSAGE);
		int userInputStarCategory = InputManager.getInstance().userInputInt();

		HotelRoom hr = MainStorage.getInstance().createHotelRoom(userInputHotelRoomName, userInputRoomPrice,
				userInputSleepingNumbers, userInputStarCategory);
		HotelRoomService.getInstance().addRooms(hr);

	}

}
