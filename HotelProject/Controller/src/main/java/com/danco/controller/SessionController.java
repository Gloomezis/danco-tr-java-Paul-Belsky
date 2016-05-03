package com.danco.controller;



import com.danco.dao.api.ISessionDAO;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;

public class SessionController {
	
	

	
	private ISessionDAO sessionDAO = (ISessionDAO) DependencyInjectionManager
			.getClassInstance(ISessionDAO.class);

	
	public void createSession(org.hibernate.Session session, com.danco.model.Session g) throws Exception {

		sessionDAO.create(session, g);

	}

	
	public void deleteSession(org.hibernate.Session session, com.danco.model.Session g) throws Exception {

		sessionDAO.delete(session, g);

	}

	
	public void updateSession(org.hibernate.Session session, com.danco.model.Session g) throws Exception {

		sessionDAO.update(session, g);

	}

	
	public com.danco.model.Session getSessionById(org.hibernate.Session session, int id) throws Exception {

		return (com.danco.model.Session) sessionDAO.getById(session, id);

	}
	
}
