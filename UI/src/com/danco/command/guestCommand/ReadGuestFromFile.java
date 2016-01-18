package com.danco.command.guestCommand;

import com.danco.command.Command;
import com.danco.serviñe.GuestService;

// TODO: Auto-generated Javadoc
/**
 * The Class ReadGuestFromFile.
 */
public class ReadGuestFromFile implements Command {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {

		GuestService.getInstance().readGuestFromFile();
	}

}
