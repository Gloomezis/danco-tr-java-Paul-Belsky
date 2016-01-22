package com.danco.command.hotelRoomCommand;

import com.danco.command.Command;
import com.danco.controller.MainController;

// TODO: Auto-generated Javadoc
/**
 * The Class CloneHotelRoom.
 */
public class CloneHotelRoom implements Command{

	

	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	
	/**
	 * Execute.
	 */
	public void execute() {

		
		MainController.getInstance().cloneHotelRoom();
	}
	
	
	
	
}
