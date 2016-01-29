package com.danco.command.ImportExportCSVCommand;

import com.danco.command.Command;
import com.danco.controller.MainController;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestWriteCsvFile.
 */
public class GuestWriteCsvFile implements Command{

	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		MainController.getInstance().guestWriteCsvFile();
	}

}
