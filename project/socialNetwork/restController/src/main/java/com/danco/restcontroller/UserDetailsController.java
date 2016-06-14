package com.danco.restcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.danco.api.service.IUserDetailsService;

public class UserDetailsController {

private IUserDetailsService service;
	
	@Required
	@Autowired
	public void setService(IUserDetailsService service) {
		this.service = service;
	}

	
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	private static final String EXCEPTION = "Exception";

    
	
	public UserDetailsController() {
		System.out.println("Created group controller");
	}

}
