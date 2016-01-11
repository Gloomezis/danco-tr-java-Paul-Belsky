package com.danco.command.hotelRoomCommand;

import com.danco.command.Command;
import com.danco.servises.HotelRoomService;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowNumberOfFreeHotelRooms.
 */
public class ShowNumberOfFreeHotelRooms implements Command {

	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {
		
		HotelRoomService.getInstance().showNumberOfFreeHotelRooms();
	}

}
