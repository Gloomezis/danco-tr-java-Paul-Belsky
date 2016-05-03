package com.danco.gloomezis.dao;

import com.danco.dao.api.ISessionDAO;
import com.danco.model.Session;

public class SessionDAO implements ISessionDAO{

	@Override
	public Session getById(org.hibernate.Session session, int id)
			throws Exception {
		
		return (Session) session.get(Session.class, id);
	}

}
