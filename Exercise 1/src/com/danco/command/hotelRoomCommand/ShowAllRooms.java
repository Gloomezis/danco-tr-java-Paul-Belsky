package com.danco.command.hotelRoomCommand;

import com.danco.command.Command;
import com.danco.command.InputManager;
import com.danco.servises.HotelRoomService;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowAllRooms.
 */
public class ShowAllRooms implements Command {
	
	/** The Constant SORT_INPUT_MESSAGE. */
	private static final  String SORT_INPUT_MESSAGE="Enter room sort condition : price/sleepN/star";
	
	/** The Constant FREE. */
	private static final  String FREE = "";

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
