package com.danco.command.reflObjInfo;

import com.danco.command.Command;
import com.danco.controller.api.IMainController;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;

public class showGuestReflectedObjectInfoShort implements Command{
	IMainController mainController =(IMainController)DependencyInjectionManager.getClassInstance(IMainController.class);

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		mainController.showGuestReflectedObjectInfoShort();
	}
}
