package com.danco.command.serviceCommand;

import com.danco.command.Command;
import com.danco.command.InputManager;
import com.danco.gloomezis.MainStorage;
import com.danco.model.Service;
import com.danco.serviñe.ServiceService;

// TODO: Auto-generated Javadoc
/**
 * The Class ChangePriceOfService.
 */
public class ChangePriceOfService implements Command {
	
	/** The Constant SERVICES_INPUT_MESSAGE. */
	private static final  String SERVICES_INPUT_MESSAGE="Enter service name";
	
	/** The Constant PRICE_INPUT_MESSAGE. */
	private static final  String PRICE_INPUT_MESSAGE="Enter new price";

	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {

		System.out.println(SERVICES_INPUT_MESSAGE);

		String userInputServiceName = InputManager.getInstance().userInputString();

		System.out.println(PRICE_INPUT_MESSAGE);

		int userInputPrice = InputManager.getInstance().userInputInt();

		Service serv = MainStorage.getInstance().getServiceByName(userInputServiceName);
		ServiceService.getInstance().changePriceOfService(serv, userInputPrice);
	}

}
