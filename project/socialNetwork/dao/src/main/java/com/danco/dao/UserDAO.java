package com.danco.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IUserDAO;
import com.danco.model.User;

@Repository("userDao")
public class UserDAO   implements IUserDAO {
	
	@Autowired
    private SessionFactory sf;

 
	@Override
	public void create( User user) {
		sf.getCurrentSession().save(user);
	}

	@Override
	public void update( User user) {
		sf.getCurrentSession().update(user);
	}
	@Override
	public void delete( User user) {
		sf.getCurrentSession().delete(user);
	} 
	

	@Override
	public User getById(int idModel)  {
	return	(User) sf.getCurrentSession().createQuery("from user c where c.id ="+idModel);
	    
	}

	
	@Override
	public List<User> getList()  {
	
	    @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) sf.getCurrentSession()
                .createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;
	   
	}

	@Override
	public User getByLogin(String login) {
		Criteria cr = sf.getCurrentSession().createCriteria(User.class);
		cr.add(Restrictions.like("login", login));
		return (User) cr.uniqueResult();
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
