package com.danco.api.dao;

import java.util.List;


import com.danco.model.User;

public interface IUserDAO extends IDAO<User> {

	

	

	public List<User> searchByName(String name)throws Exception;

	public User gerByCredentials(String username,String password)throws Exception;

	public User getByUsername(String username) throws Exception;


	

}
