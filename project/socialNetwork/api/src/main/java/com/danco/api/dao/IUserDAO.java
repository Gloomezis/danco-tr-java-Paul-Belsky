package com.danco.api.dao;

import java.util.List;

import com.danco.model.User;

public interface IUserDAO extends IDAO<User> {

	

	@Override
	public default void create(User user)throws Exception {
		
		IDAO.super.create(user);
	}

	@Override
	public default void delete(User user) throws Exception {
		
		IDAO.super.delete(user);
	}

	@Override
	public default void update(User user)  throws Exception{
		
		IDAO.super.update(user);
	}

	@Override
	public User getById(int idUser) throws Exception;

	
	
	public List<User> getList()throws Exception;

	public  User getByLogin(String login)throws Exception;

	public User getByLoginAndPassword(String login,String password)throws Exception;

	

}
