package com.danco.gloomezis.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.danco.dao.api.IUserDAO;
import com.danco.model.User;
public class UserDAO implements IUserDAO {

	@Override
	public User getById(Session session, int id) throws Exception {
		return (User) session.get(User.class, id);
	}
	@Override
	public User getUserByLogin(Session session, String login)
			throws Exception {
		Criteria crit = session.createCriteria(User.class);
		User userFromBase = (User) crit.add(Restrictions.eq("login", login)).uniqueResult();
		return userFromBase;
	}
	
	@Override
	public User getUser(Session session, String login, String pwd)
			throws Exception {
		Criteria crit = session.createCriteria(User.class);
		User userFromBase = (User) crit.add(Restrictions.eq("login", login)).add(Restrictions.eq("password", pwd)).uniqueResult();
		return userFromBase;
	}

	
}
