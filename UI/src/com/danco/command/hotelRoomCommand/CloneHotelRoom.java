package com.danco.command.hotelRoomCommand;

import com.danco.command.Command;
import com.danco.controller.api.IMainController;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;

// TODO: Auto-generated Javadoc
/**
 * The Class CloneHotelRoom.
 */
public class CloneHotelRoom implements Command{

	
	IMainController mainController =(IMainController)DependencyInjectionManager.getClassInstance(IMainController.class);
	/* (non-Javadoc)
	 * @see com.danco.command.Command#execute()
	 */
	
	/**
	 * Execute.
	 */
	public void execute() {

		
		mainController.cloneHotelRoom();
	}
	
	
	
	
}
