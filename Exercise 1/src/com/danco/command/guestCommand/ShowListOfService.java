package com.danco.command.guestCommand;

import com.danco.command.Command;
import com.danco.command.InputManager;
import com.danco.gloomezis.MainStorage;
import com.danco.models.Guest;
import com.danco.servises.GuestService;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowListOfService.
 */
public class ShowListOfService implements Command{

	/** The Constant GUEST_INPUT_MESSAGE. */
	private static final  String GUEST_INPUT_MESSAGE="Enter Guest Name";
	
	/** The Constant SORT_INPUT_MESSAGE. */
	private static final  String SORT_INPUT_MESSAGE="Enter room sort condition : date/price";
	
	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {
		
		System.out.println(GUEST_INPUT_MESSAGE);   
	
		String userInputGuestName = InputManager.getInstance().userInputString();
		Guest g =MainStorage.getInstance().getGuestByName(userInputGuestName);
	
		System.out.println(SORT_INPUT_MESSAGE);   
	
		String userInputSortCondition = InputManager.getInstance().userInputString();
		
		GuestService.getInstance().showListOfService(g, userInputSortCondition);
	}

}
