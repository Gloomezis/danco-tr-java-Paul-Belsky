package com.danco.dao.api;

import org.hibernate.Session;

import com.danco.model.User;

public interface IUserDAO  extends IDAO<User>{

	User getUser(Session session, String user, String pwd) throws Exception;

}
