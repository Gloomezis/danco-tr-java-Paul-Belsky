package com.danco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.danco.api.dao.IMessageDAO;
import com.danco.api.service.IMessageService;
import com.danco.model.Message;

@Service
public class MessageService extends BaseService<Message> implements IMessageService {

	@Autowired
	private IMessageDAO dao;

	

	public MessageService() {
		System.out.println("Message service created");
	}

	
}
