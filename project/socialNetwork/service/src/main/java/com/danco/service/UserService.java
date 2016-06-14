package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IUserDAO;
import com.danco.api.service.IUserService;
import com.danco.model.User;


@Service
public class UserService implements IUserService{
	
	
    private IUserDAO dao;
	

	
	@Required
	@Autowired
	public void setDao(IUserDAO dao) {
		this.dao = dao;
	}

	
	public UserService() {
		System.out.println("User service created");
	} 
    
    @Override
    
    public void create(User user)throws Exception {
        dao.create(user);
    }
	
	
    
    @Override
    @Transactional 
	public void update(User user) throws Exception{
		dao.update(user);
	}

	
    @Override
    @Transactional 
    public void delete(User user) throws Exception{
		dao.delete(user);
	} 
	
    @Override
    @Transactional 
	public User getById(int idModel)throws Exception{
		return dao.getById(idModel);
	}

	
	@Override
	@Transactional 
	public List<User> getList()throws Exception {
		return dao.getList();
	}


	@Override
	@Transactional 
	public User getByLogin(String login) throws Exception{
		return dao.getByLogin(login);
	}


	@Override
	public boolean isUserExist(User user) throws Exception{
		return getByLogin(user.getLogin())!=null;
	}


	@Override
	@Transactional 
	public User getByLoginAndPassword(String login, String password)
			throws Exception {
		
		return dao.getByLoginAndPassword(login,password);
	}

	
}
