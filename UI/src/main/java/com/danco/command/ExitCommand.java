package com.danco.command;

// TODO: Auto-generated Javadoc
/**
 * The Class ExitCommand.
 */
public class ExitCommand implements Command {

	/** The Constant EXIT_MESSAGE. */
	private static final String EXIT_MESSAGE = "Exit programm...";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.command.Command#execute()
	 */
	public void execute() {
		System.out.println(EXIT_MESSAGE);
	}
}
