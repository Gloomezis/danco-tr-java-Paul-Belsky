package com.danco.command.guestCommand;

import com.danco.command.Command;
import com.danco.command.InputManager;
import com.danco.gloomezis.MainStorage;
import com.danco.model.Guest;
import com.danco.serviñe.GuestService;

// TODO: Auto-generated Javadoc
/**
 * The Class AddGuest.3
 */
public class AddGuest implements Command {
	
	/** The Constant GUEST_INPUT_MESSAGE. */
	private static final String GUEST_INPUT_MESSAGE = "Write name of guest";
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {

		System.out.println(GUEST_INPUT_MESSAGE);

		String userInputGuestName = InputManager.getInstance().userInputString();
		Guest g = MainStorage.getInstance().createGuest(userInputGuestName);
		GuestService.getInstance().addGuest(g);
	}
}
