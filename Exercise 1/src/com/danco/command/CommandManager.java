package com.danco.command;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class CommandManager.
 */
public class CommandManager{

	/** The input. */
	private Scanner input;

	/**
	 * Gets the command.
	 *
	 * @return the command
	 */
	public String getCommand() {
		StringBuilder sb = new StringBuilder();
		input = new Scanner(System.in);
		String choose = "";
		System.out.println("Menu:");                
		System.out.println("Hello. Please input your selected menu command: "
				+ "\n 1 - command touched guests "
				+ "\n 2 - command touched hotel rooms"
				+ "\n 3 - command touched services \n");
		sb.append(input.nextLine());
		
		if(sb.toString().equals("1")){
			System.out.println("All commands selected menus 1:"
					+ "\n 1 - add guest "
					+ "\n 2 - add service to guest"
					+ "\n 3 - read guest from file"
					+ "\n 4 - show all guests number"
					+ "\n 5 - show all guests"
					+ "\n 6 - show list of services"
					+ "\n 7 - show summ to paid selected guest"
					+ "\n 8 - write guest to file"
					+ "\n 9 - back  NOT DONE"
					+ "\n 0 - exit "); 
		}
		if(sb.toString().equals("2")){
			System.out.println("All commands selected menus 2:"
					+ "\n 1 - add room "
					+ "\n 2 - change price of selected hotel room"
					+ "\n 3 - change status of selected hotel room"
					+ "\n 4 - depart guest from selected hotel room"
					+ "\n 5 - settle guest to selected hotel room"
					+ "\n 6 - show all free rooms"
					+ "\n 7 - show all rooms"
					+ "\n 8 - show detail of selected hotel room"
					+ "\n 9 - show free rooms after date"
					+ "\n 10 - show last 3 guest of hotel room"
					+ "\n 11 - show number of free hotel room"
					+ "\n 12 - show price service and hotel room"
					+ "\n 99 - back NOT DONE"
					+ "\n 0 - exit");  
		}
		if(sb.toString().equals("3")){
			System.out.println("All commands selected menus 3:"
					+ "\n 1 - add service "
					+ "\n 2 - change price of selected service"
					+ "\n 3 - show price service and hotel room"
					+ "\n 99 - back NOT DONE"
					+ "\n 0 - exit"); 
		}
		sb.append(" ");
		System.out.println("Hello. Please input command number");
		sb.append(input.nextLine());
		choose=sb.toString();
		return choose;
		
	}
	
	/**
	 * Gets the task.
	 *
	 * @return the task
	 */
	public void getTask() {
		while (true){
		String choose = "";
		choose = getCommand();
		CommandFactory.createCommand(choose);
		
		}
	
	}
}
