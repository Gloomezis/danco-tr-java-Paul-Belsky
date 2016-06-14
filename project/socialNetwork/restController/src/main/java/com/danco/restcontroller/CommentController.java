package com.danco.restcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.danco.api.service.ICommentService;


public class CommentController {
	
	private ICommentService service;
	
	@Required
	@Autowired
	public void setService(ICommentService service) {
		this.service = service;
	}

	
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	private static final String EXCEPTION = "Exception";

    
	
	public CommentController() {
		System.out.println("Created comment controller");
	}

}
