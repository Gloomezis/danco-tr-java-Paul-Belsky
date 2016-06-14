package com.danco.api.service;

import java.util.List;










import com.danco.model.User;

public interface IUserService {
	
	public void create(User user)throws Exception ;

	public void update(User user)throws Exception;
	
	public void delete(User user) throws Exception;
	
	public User getById(int idModel)throws Exception ;

	public List<User> getList()throws Exception;

	public boolean isUserExist(User user)throws Exception ;
	
	public User getByLogin(String name)throws Exception;

	public User getByLoginAndPassword(String login, String password)throws Exception;
    
}
