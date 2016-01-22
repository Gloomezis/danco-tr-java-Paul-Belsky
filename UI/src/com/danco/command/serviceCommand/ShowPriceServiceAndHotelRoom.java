package com.danco.command.serviceCommand;

import com.danco.command.Command;
import com.danco.controller.MainController;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowPriceServiceAndHotelRoom.
 */
public class ShowPriceServiceAndHotelRoom implements Command {

	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {

		MainController.getInstance().showPriceServiceAndHotelRoom();
	}

}
