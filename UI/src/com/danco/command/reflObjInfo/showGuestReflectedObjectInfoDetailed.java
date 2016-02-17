package com.danco.command.reflObjInfo;

import org.apache.log4j.Logger;

import com.danco.command.Command;
import com.danco.ui.Processing;
import com.danco.util.InputManager;
import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class showGuestReflectedObjectInfoDetailed.
 */
public class showGuestReflectedObjectInfoDetailed implements Command {
	
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(showGuestReflectedObjectInfoDetailed.class.getName());
	
	/** The Constant GUEST_INPUT_MESSAGE. */
	private static final String GUEST_INPUT_MESSAGE = "Enter Guest Name";
	
	/** The Constant PROTOCOL. */
	private static final String PROTOCOL = "1" + ";"
			+ "showGuestReflectedObjectInfoDetailed" + ";";
	
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

			System.out.println(GUEST_INPUT_MESSAGE);
			String userInputGuestName = InputManager.userInputString();

			StringBuilder str = new StringBuilder();
			str.append(PROTOCOL).append(userInputGuestName);
			Processing processing = Processing.getInstance();
			PrintUtil.printString(MESSAGE + processing.dataProcessing(str));

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}

	}

}
