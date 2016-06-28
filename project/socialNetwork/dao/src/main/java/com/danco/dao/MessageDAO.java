package com.danco.dao;

import org.springframework.stereotype.Repository;

import com.danco.api.dao.IMessageDAO;
import com.danco.model.Message;

@Repository 
public class MessageDAO extends BaseDAO<Message> implements IMessageDAO {

	
	
		
	  
		
	    public MessageDAO() {
			 super(Message.class);
			System.out.println("Location dao created");
		}

		

		
		
}