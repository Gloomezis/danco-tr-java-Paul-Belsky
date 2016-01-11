package com.danco.command.guestCommand;

import com.danco.command.Command;
import com.danco.servises.GuestService;

// TODO: Auto-generated Javadoc
/**
 * The Class WriteGuestToFile.
 */
public class WriteGuestToFile implements Command {

	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {

		GuestService.getInstance().writeGuestToFile();
	}

}
