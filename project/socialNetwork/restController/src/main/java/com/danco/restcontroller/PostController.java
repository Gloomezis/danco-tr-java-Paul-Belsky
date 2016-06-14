package com.danco.restcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.danco.api.service.IGroupService;
import com.danco.api.service.IPostService;

public class PostController {

private IPostService service;
	
	@Required
	@Autowired
	public void setService(IPostService service) {
		this.service = service;
	}

	
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	private static final String EXCEPTION = "Exception";

    
	
	public PostController() {
		System.out.println("Created post controller");
	}

}
