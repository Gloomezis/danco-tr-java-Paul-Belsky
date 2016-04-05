package com.danco.command.serviceCommand;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowPriceServiceAndHotelRoom.
 */
public class ShowPriceServiceAndHotelRoom implements Command {

	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "0" + ";"
			+ "showPriceServiceAndHotelRoom" + ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message ";

	/** The LO g1. */
	private final Logger LOG1 = Logger
			.getLogger(ShowPriceServiceAndHotelRoom.class.getName());
	
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
			System.out.println(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}
	}

}
