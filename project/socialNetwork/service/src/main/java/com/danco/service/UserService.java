package com.danco.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IUserDAO;
import com.danco.api.exception.MessageException;
import com.danco.api.exception.MyException;
import com.danco.api.service.IUserService;
import com.danco.model.User;


/**
 * The Class UserService.
 */
@Service
public class UserService extends BaseService<User> implements IUserService {

	/** The Constant RESPONSE_ENTITY. */
	private static final String RESPONSE_ENTITY = "responseEntity";
	
	/** The Constant USER_SERVICE_CREATED. */
	private static final String USER_SERVICE_CREATED = "User service created";
	
	/** The dao. */
	@Autowired
	private IUserDAO dao;

	/**
	 * Instantiates a new user service.
	 */
	public UserService() {
		System.out.println(USER_SERVICE_CREATED);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IUserService#searchByName(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	public HashMap<String, Object> searchByName(String name) throws MyException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		List<User> users = null;
		users = dao.searchByName(name);
		if (users.isEmpty()) {
			throw new MyException(MessageException.ITS_ALL);
		} else {
			res.put(RESPONSE_ENTITY, users);
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IUserService#getByCredentials(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	public User getByCredentials(String username, String password)
			throws MyException {
		User user=null;
		user= dao.gerByCredentials(username, password);
		if(user==null){
			throw new MyException(MessageException.NOT_CORRECT_PASS_OR_USERNAME);
		}
		return user;
	}
}
