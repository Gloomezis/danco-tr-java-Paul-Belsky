package com.danco.command.ImportExportCSVCommand;

import com.danco.command.Command;
import com.danco.controller.MainController;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceReadCsvFile.
 */
public class ServiceReadCsvFile implements Command{

	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		MainController.getInstance().serviceReadCsvFile();
		
	}

}