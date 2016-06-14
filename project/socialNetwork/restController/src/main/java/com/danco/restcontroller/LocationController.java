package com.danco.restcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.danco.api.service.ILocationService;

public class LocationController {
	
private ILocationService service;
	
	@Required
	@Autowired
	public void setService(ILocationService service) {
		this.service = service;
	}

	
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	private static final String EXCEPTION = "Exception";

    
	
	public LocationController() {
		System.out.println("Created location controller");
	}


}
