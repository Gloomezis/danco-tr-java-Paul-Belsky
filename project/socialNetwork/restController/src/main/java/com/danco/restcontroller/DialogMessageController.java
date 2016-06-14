package com.danco.restcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.danco.api.service.IDialogMessageService;

public class DialogMessageController {
	
private IDialogMessageService service;
	
	@Required
	@Autowired
	public void setService(IDialogMessageService service) {
		this.service = service;
	}

	
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	private static final String EXCEPTION = "Exception";

    
	
	public DialogMessageController() {
		System.out.println("Created message controller");
	}


}
