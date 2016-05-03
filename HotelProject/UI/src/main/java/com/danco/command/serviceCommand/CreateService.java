package com.danco.command.serviceCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;

// TODO: Auto-generated Javadoc
/**
 * The Class AddServices.
 */
public class CreateService implements Command {
	
	/** The Constant PRICE_INPUT_MESSAGE. */
	private static final String ORDER_INPUT_MESSAGE = "Enter order id";
	
	/** The Constant SERVICES_INPUT_MESSAGE. */
	private static final String SERVICES_INPUT_MESSAGE = "Enter service name";
	
	/** The Constant PRICE_INPUT_MESSAGE. */
	private static final String PRICE_INPUT_MESSAGE = "Enter service price";
	
	
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "3" + ";" + "createService" + ";";
	
	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = ";";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "Message ";

	/** The LO g1. */
	private final Logger LOG1 = Logger
			.getLogger(CreateService.class.getName());
	
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

			System.out.println(ORDER_INPUT_MESSAGE);
			String orderInputId = reader.readLine();
			
			System.out.println(SERVICES_INPUT_MESSAGE);
			String userInputServiceName = reader.readLine();

			System.out.println(PRICE_INPUT_MESSAGE);
			String userInputPrice = reader.readLine();
			
			

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(orderInputId).append(SEPARATOR).
			append(userInputServiceName).append(SEPARATOR)
					.append(userInputPrice);
			Processing processing = Processing.getInstance();
			System.out.println(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}

	}

}
