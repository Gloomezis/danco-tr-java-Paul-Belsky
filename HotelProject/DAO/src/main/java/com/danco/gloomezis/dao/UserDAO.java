package com.danco.gloomezis.dao;

import org.hibernate.Session;



import com.danco.dao.api.IUserDAO;
import com.danco.model.User;

public class UserDAO implements IUserDAO{

	@Override
	public User getById(Session session, int id) throws Exception {
		return (User) session.get(User.class, id);
	}

}
