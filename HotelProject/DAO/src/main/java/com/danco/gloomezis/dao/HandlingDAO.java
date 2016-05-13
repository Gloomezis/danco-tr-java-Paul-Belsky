package com.danco.gloomezis.dao;

import org.hibernate.Session;

import com.danco.dao.api.IHandlingDAO;
import com.danco.model.Handling;

public class HandlingDAO implements IHandlingDAO{

	@Override
	public Handling getById(Session session, int id)
			throws Exception {
		
		return (Handling) session.get(Handling.class, id);
	}

}
