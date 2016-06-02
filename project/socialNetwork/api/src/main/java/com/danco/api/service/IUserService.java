package com.danco.api.service;

import java.util.List;

import com.danco.model.BaseModel;
import com.danco.model.User;

public interface IUserService <T extends BaseModel >{
	
	default void create(User user) {
		
	}

	default void update(User user){
	
	}
	
	default void delete(User user) {
		
	} 
	
	public User getById(int idModel) ;

	public List<User> getList();

	public boolean isUserExist(User user) ;
	
	public User getByLogin(String name);
    
}
