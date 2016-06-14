package com.danco.api.service;

import java.util.List;

import com.danco.model.Message;

public interface IMessageService {

	public abstract void create(Message message)throws Exception;

	public abstract void update(Message message)throws Exception;

	public abstract void delete(Message message)throws Exception;

	public abstract Message getById(int idModel)throws Exception;

	public abstract List<Message> getList()throws Exception;

}