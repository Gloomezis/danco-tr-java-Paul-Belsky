package com.danco.api.dao;

import java.util.List;

import com.danco.model.User;

public interface IUserDAO extends IDAO<User> {

	

	@Override
	public default void create(User user) {
		
		IDAO.super.create(user);
	}

	@Override
	public default void delete(User user)  {
		
		IDAO.super.delete(user);
	}

	@Override
	public default void update(User user)  {
		
		IDAO.super.update(user);
	}

	@Override
	public User getById(int idModel) ;

	
	
	public List<User> getList();

	public  User getByLogin(String login);

	

}
