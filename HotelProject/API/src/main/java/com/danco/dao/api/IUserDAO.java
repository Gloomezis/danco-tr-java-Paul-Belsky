package com.danco.dao.api;

import org.hibernate.Session;

import com.danco.model.User;

public interface IUserDAO  extends IDAO<User>{

	User getUserByLogin(Session session, String user) throws Exception;

	User getUser(Session session, String login, String pwd)throws Exception;

}
