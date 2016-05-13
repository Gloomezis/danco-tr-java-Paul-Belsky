package com.danco.controller;



import org.hibernate.Session;

import com.danco.dao.api.IHandlingDAO;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Handling;

public class HandlingController {
	
	

	
	private IHandlingDAO handlingDAO = (IHandlingDAO) DependencyInjectionManager
			.getClassInstance(IHandlingDAO.class);

	
	public void createSession(Session session, Handling h) throws Exception {

		handlingDAO.create(session, h);

	}

	
	public void deleteSession(Session session, Handling h) throws Exception {

		handlingDAO.delete(session, h);

	}

	
	public void updateSession(Session session, Handling h) throws Exception {

		handlingDAO.update(session, h);

	}

	
	public Handling getSessionById(Session session, int id) throws Exception {

		return (Handling) handlingDAO.getById(session, id);

	}
	
}
