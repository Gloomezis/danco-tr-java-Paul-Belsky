package com.danco.api.dao;

import java.util.List;

import com.danco.api.exception.MyException;
import com.danco.model.User;


/**
 * The Interface IUserDAO.
 */
public interface IUserDAO extends IDAO<User> {

	/**
	 * Search by name.
	 *
	 * @param name the name
	 * @return the list
	 * @throws MyException the my exception
	 */
	public List<User> searchByName(String name) throws MyException;

	/**
	 * Ger by credentials.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the user
	 * @throws MyException the my exception
	 */
	public User gerByCredentials(String username, String password)
			throws MyException;

	/**
	 * Gets the by username.
	 *
	 * @param username the username
	 * @return the by username
	 * @throws MyException the my exception
	 */
	public User getByUsername(String username) throws MyException;

	/**
	 * Gets the me with friend list.
	 *
	 * @param i the i
	 * @return the me with friend list
	 * @throws MyException the my exception
	 */
	public User getMeWithFriendList(int i) throws MyException;

}
