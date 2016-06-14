package com.danco.api.dao;

import java.util.List;








import com.danco.model.Message;


public interface IMessageDAO extends IDAO<Message>{


	@Override
	public default void create(Message message) throws Exception{
		
		IDAO.super.create(message);
	}

	@Override
	public default void delete(Message message) throws Exception {
		
		IDAO.super.delete(message);
	}

	@Override
	public default void update(Message message) throws Exception {
		
		IDAO.super.update(message);
	}

	@Override
	public Message getById(int idMessage) throws Exception;

	
	
	public List<Message> getList()throws Exception;

	
	

}