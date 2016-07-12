package com.danco.api.service;

import java.util.HashMap;

import com.danco.api.exception.MyException;
import com.danco.model.User;


/**
 * The Interface IUserService.
 */
public interface IUserService extends IService<User> {

	/**
	 * Search by name.
	 *
	 * @param name the name
	 * @return the hash map
	 * @throws MyException the my exception
	 */
	public HashMap<String, Object> searchByName(String name) throws MyException;

	/**
	 * Gets the by credentials.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the by credentials
	 * @throws MyException the my exception
	 */
	public User getByCredentials(String username, String password)
			throws MyException;

}
