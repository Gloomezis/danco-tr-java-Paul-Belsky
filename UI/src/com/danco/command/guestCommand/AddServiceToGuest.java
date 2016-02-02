package com.danco.command.guestCommand;

import com.danco.command.Command;
import com.danco.controller.api.IMainController;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;

// TODO: Auto-generated Javadoc
/**
 * The Class AddServiceToGuest.
 */
public class AddServiceToGuest implements Command {

	IMainController mainController =(IMainController)DependencyInjectionManager.getClassInstance(IMainController.class);
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.command.Command#execute()
	 */
	@Override
	public void execute() {
	
		mainController.addServiceToGuest();
	}

}
