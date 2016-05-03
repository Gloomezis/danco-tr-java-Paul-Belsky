package com.danco.controller;

import org.hibernate.Session;


import com.danco.dao.api.IUserDAO;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.User;

public class UserController {
	
	

	private IUserDAO userDAO = (IUserDAO) DependencyInjectionManager
			.getClassInstance(IUserDAO.class);

	
	public void createUser(Session session, User user)
			throws Exception {

		userDAO.create(session, user);

	}

	
	public void deleteUser(Session session, User user)
			throws Exception {

		userDAO.delete(session, user);

	}

	
	public void updateUser(Session session, User user)
			throws Exception {

		userDAO.update(session, user);

	}

	
	public User getUserById(Session session, int id) throws Exception {

		return userDAO.getById(session, id);

	}

}
