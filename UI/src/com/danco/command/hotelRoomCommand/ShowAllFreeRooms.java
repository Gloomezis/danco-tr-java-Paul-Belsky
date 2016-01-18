package com.danco.command.hotelRoomCommand;

import com.danco.command.Command;
import com.danco.command.InputManager;
import com.danco.serviñe.HotelRoomService;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowAllFreeRooms.
 */
public class ShowAllFreeRooms implements Command {
	
	/** The Constant SORT_INPUT_MESSAGE. */
	private static final  String SORT_INPUT_MESSAGE="Enter room sort condition : price/sleepN/star";
	
	/** The Constant FREE. */
	private static final  String FREE = "free";

	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {


		System.out.println(SORT_INPUT_MESSAGE);

		String userInputSortCondition = InputManager.getInstance().userInputString();
		HotelRoomService.getInstance().showAllRooms(userInputSortCondition, FREE);
	}

}
