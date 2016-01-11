package com.danco.command.serviceCommand;

import com.danco.command.Command;
import com.danco.command.InputManager;
import com.danco.gloomezis.MainStorage;
import com.danco.models.Service;
import com.danco.servises.ServiceService;

// TODO: Auto-generated Javadoc
/**
 * The Class AddServices.
 */
public class AddServices implements Command {

	/** The Constant SERVICES_INPUT_MESSAGE. */
	private static final  String SERVICES_INPUT_MESSAGE="Enter service name";
	
	/** The Constant PRICE_INPUT_MESSAGE. */
	private static final  String PRICE_INPUT_MESSAGE="Enter service price";
	
	
	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {

		System.out.println(SERVICES_INPUT_MESSAGE);
		String userInputServiceName = InputManager.getInstance().userInputString();

		System.out.println(PRICE_INPUT_MESSAGE);
		int userInputPrice = InputManager.getInstance().userInputInt();

		Service service = MainStorage.getInstance().createService(userInputServiceName, userInputPrice);
		ServiceService.getInstance().addServices(service);

	}

}
