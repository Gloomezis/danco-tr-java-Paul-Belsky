package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IUserDAO;
import com.danco.api.service.IUserService;
import com.danco.model.User;


@Service("userService")
public class UserService implements IUserService<User>{
	
	@Autowired
    private IUserDAO dao;
	
	
	
    @Override
    @Transactional
    public void create(User user) {
        dao.create(user);
    }
	
	
    @Override
    @Transactional
	public void update(User user) {
		dao.update(user);
	}

	
    @Override
    @Transactional
    public void delete(User user) {
		dao.delete(user);
	} 
	
    @Override
    @Transactional
	public User getById(int idModel){
		return dao.getById(idModel);
	}

	
	@Override
	@Transactional
	public List<User> getList() {
		return dao.getList();
	}


	@Override
	public User getByLogin(String login) {
		return dao.getByLogin(login);
	}


	@Override
	public boolean isUserExist(User user) {
		return getByLogin(user.getLogin())!=null;
	}

	
}
