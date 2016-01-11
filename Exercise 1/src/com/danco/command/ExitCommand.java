package com.danco.command;

import com.danco.gloomezis.MainStorage;

// TODO: Auto-generated Javadoc
/**
 * The Class ExitCommand.
 */
public class ExitCommand implements Command {

	private static final  String EXIT_MESSAGE="Exit programm...";
	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	public void execute() {
		System.out.println(EXIT_MESSAGE);
		MainStorage.getInstance().exitProgram();
		
	}

}
