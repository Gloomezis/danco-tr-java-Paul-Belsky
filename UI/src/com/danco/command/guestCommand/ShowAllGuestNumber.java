package com.danco.command.guestCommand;

import com.danco.command.Command;
import com.danco.servi�e.GuestService;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowAllGuestNumber.
 */
public class ShowAllGuestNumber implements Command {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {

		GuestService.getInstance().showAllGuestNumber();
	}

}
