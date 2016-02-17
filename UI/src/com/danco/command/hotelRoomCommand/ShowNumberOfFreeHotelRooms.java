package com.danco.command.hotelRoomCommand;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;
import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowNumberOfFreeHotelRooms.
 */
public class ShowNumberOfFreeHotelRooms implements Command {
	
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ShowNumberOfFreeHotelRooms.class.getName());
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "0" + ";"
			+ "showNumberOfFreeHotelRooms" + ";";
	
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

		try {

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL);

			Processing processing = Processing.getInstance();
			PrintUtil.printString(MESSAGE + processing.dataProcessing(str));
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}

	}

}
