package com.danco.command.guestCommand;

import com.danco.command.Command;
import com.danco.controller.MainController;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowAllGuests.
 */
public class ShowAllGuests implements Command {
	
	
	
	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {

		
		MainController.getInstance().showAllGuests();
	}

}
