package com.danco.api.service;

import java.util.List;


import com.danco.model.User;

public interface IUserService extends IService<User> {

	public List<User> searchByName(String name);

	public User getByCredentials(String username,String password);

	public User getByUsername(String username);

	public boolean isUserExist(User user) throws Exception;

}
