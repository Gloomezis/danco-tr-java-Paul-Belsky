package com.danco.command.ImportExportCSVCommand;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;
import com.danco.util.InputManager;
import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceReadCsvFile.
 */
public class ServiceReadCsvFile implements Command {
	
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ServiceReadCsvFile.class.getName());
	
	/** The Constant SERVICE_INPUT_MESAGE_READ. */
	private static final String SERVICE_INPUT_MESAGE_READ = "Write CSV file name/path(*.csv) to read service";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "1" + ";" + "serviceReadCsvFile"
			+ ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message  \n";

	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		try {

			System.out.println(SERVICE_INPUT_MESAGE_READ);
			String userInputFileName = InputManager.userInputString();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputFileName);
			Processing processing = Processing.getInstance();
			PrintUtil.printString(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}
	}

}
