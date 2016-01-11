package com.danco.command.guestCommand;

import com.danco.command.Command;
import com.danco.command.InputManager;
import com.danco.servises.GuestService;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowAllGuests.
 */
public class ShowAllGuests implements Command {
	
	/** The Constant SORT_INPUT_MESSAGE. */
	private static final  String SORT_INPUT_MESSAGE="Enter room sort condition : alphabet/date";
	
	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {

		System.out.println(SORT_INPUT_MESSAGE);

		String userInputSortCondition = InputManager.getInstance().userInputString();
		GuestService.getInstance().showAllGuests(userInputSortCondition);
	}

}
