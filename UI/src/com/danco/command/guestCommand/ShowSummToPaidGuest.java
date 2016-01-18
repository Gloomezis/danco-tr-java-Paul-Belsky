package com.danco.command.guestCommand;

import com.danco.command.Command;
import com.danco.command.InputManager;
import com.danco.gloomezis.MainStorage;
import com.danco.model.Guest;
import com.danco.serviñe.GuestService;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowSummToPaidGuest.
 */
public class ShowSummToPaidGuest implements Command {

	/** The Constant GUEST_INPUT_MESSAGE. */
	private static final  String GUEST_INPUT_MESSAGE="Enter Guest Name";
	
	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {

		System.out.println(GUEST_INPUT_MESSAGE);

		String userInputGuestName = InputManager.getInstance().userInputString();
		Guest g = MainStorage.getInstance().getGuestByName(userInputGuestName);
		GuestService.getInstance().showSummToPaidGuest(g);
	}

}
