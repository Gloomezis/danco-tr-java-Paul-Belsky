package com.danco.restcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.danco.api.service.IDialogService;

public class DialogController {
	
private IDialogService service;
	
	@Required
	@Autowired
	public void setService(IDialogService service) {
		this.service = service;
	}

	
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	private static final String EXCEPTION = "Exception";

    
	
	public DialogController() {
		System.out.println("Created dialog controller");
	}

}
