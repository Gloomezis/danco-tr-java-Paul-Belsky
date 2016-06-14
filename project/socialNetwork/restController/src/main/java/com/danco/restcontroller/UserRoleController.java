package com.danco.restcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.danco.api.service.IUserRoleService;

public class UserRoleController {

private IUserRoleService service;
	
	@Required
	@Autowired
	public void setService(IUserRoleService service) {
		this.service = service;
	}

	
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	private static final String EXCEPTION = "Exception";

    
	
	public UserRoleController() {
		System.out.println("Created user role controller");
	}

}
