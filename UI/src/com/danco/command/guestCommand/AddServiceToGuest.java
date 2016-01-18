package com.danco.command.guestCommand;

import com.danco.command.Command;
import com.danco.command.InputManager;
import com.danco.gloomezis.MainStorage;
import com.danco.model.Guest;
import com.danco.model.Service;
import com.danco.serviñe.GuestService;

// TODO: Auto-generated Javadoc
/**
 * The Class AddServiceToGuest.
 */
public class AddServiceToGuest implements Command {
	
	/** The Constant GUEST_INPUT_MESSAGE. */
	private static final  String GUEST_INPUT_MESSAGE="Enter Guest Name";
	
	/** The Constant SERVICE_INPUT_MESSAGE. */
	private static final  String SERVICE_INPUT_MESSAGE="Enter Service Name";
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {
		System.out.println(GUEST_INPUT_MESSAGE);
		String userInputGuest = InputManager.getInstance().userInputString();
		Guest g = MainStorage.getInstance().getGuestByName(userInputGuest);

		System.out.println(SERVICE_INPUT_MESSAGE);
		String userInputService = InputManager.getInstance().userInputString();
		Service s = MainStorage.getInstance().getServiceByName(userInputService);

		GuestService.getInstance().addServiceToGuest(g, s);
	}

}
