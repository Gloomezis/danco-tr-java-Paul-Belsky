/*
 * 
 */
package com.danco.command.hotelRoomCommand;

import java.util.Date;

import com.danco.command.Command;
import com.danco.command.InputManager;
import com.danco.servises.HotelRoomService;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowFreeRomsAfterDate.
 */
public class ShowFreeRomsAfterDate implements Command {
	
	/** The Constant SORT_INPUT_MESSAGE. */
	private static final  String SORT_INPUT_MESSAGE="Enter room sort condition : price/sleepN/star";
	
	/** The Constant DATE_INPUT_MESSAGE. */
	private static final  String DATE_INPUT_MESSAGE="Enter date / year-month-day  :  yyyy-MM-dd";
	
	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {
		
		

		System.out.println(SORT_INPUT_MESSAGE);
		String userInputSortCondition = InputManager.getInstance().userInputString();

		System.out.println(DATE_INPUT_MESSAGE);
		Date date = InputManager.getInstance().userInputDate();

		HotelRoomService.getInstance().showFreeRomsAfterDate(userInputSortCondition, date);
	}

}
