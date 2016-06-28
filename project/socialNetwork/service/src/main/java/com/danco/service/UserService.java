package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IUserDAO;
import com.danco.api.service.IUserService;
import com.danco.model.Comment;
import com.danco.model.User;

@Service
public class UserService extends BaseService<User> implements IUserService {

	@Autowired
	private IUserDAO dao;

	public UserService() {
		System.out.println("User service created");
	}

	@Override
	@Transactional(readOnly = true,rollbackFor=Exception.class)
	public User getByUsername(String username) {
		try {
			return dao.getByUsername(username);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		
	//	User user = dao.getByUsername(username);
	//	if (null == user) {
	//		throw new UsernameNotFoundException("The user with name: "
	//				+ username + " was not found");
	//	}

	//	return user; 
		
		return null;
	}

	@Override
	@Transactional(readOnly = true,rollbackFor=Exception.class)
	public List<User> searchByName(String name) {
		try {
			return dao.searchByName(name);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	@Transactional//(readOnly = true,rollbackFor=Exception.class)
	public User getByCredentials(String username,String password) {
		User user = null;
		try {
			user = dao.gerByCredentials(username,password);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return user;

	}

	@Override
	public boolean isUserExist(User user)  {
		return getByUsername((user.getUsername())) != null;
	}

}
