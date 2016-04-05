package com.danco.command.serviceCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;

// TODO: Auto-generated Javadoc
/**
 * The Class ChangePriceOfService.
 */
public class ChangePriceOfService implements Command {

	/** The Constant SERVICES_INPUT_MESSAGE. */
	private static final String SERVICES_INPUT_MESSAGE = "Enter service name";

	/** The Constant PRICE_INPUT_MESSAGE1. */
	private static final String PRICE_INPUT_MESSAGE1 = "Enter new price";

	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "2ext" + ";" + "changePriceOfService"
			+ ";";

	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = ";";

	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message ";

	/** The LO g1. */
	private final Logger LOG1 = Logger
			.getLogger(ChangePriceOfService.class.getName());

	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		try {

			System.out.println(SERVICES_INPUT_MESSAGE);
			String userInputServiceName = reader.readLine();

			System.out.println(PRICE_INPUT_MESSAGE1);
			String userInputPrice = reader.readLine();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputServiceName).append(SEPARATOR)
					.append(userInputPrice);
			Processing processing = Processing.getInstance();
			System.out.println(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}

	}

}
