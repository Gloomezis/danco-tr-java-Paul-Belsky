package com.danco.command.hotelRoomCommand;

import com.danco.command.Command;
import com.danco.controller.MainController;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowDetailOfHotelRoom.
 */
public class ShowDetailOfHotelRoom implements Command {
	
	

	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {

		
		MainController.getInstance().showDetailOfHotelRoom();
	}

}
