package com.danco.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IUserDAO;
import com.danco.model.User;


@Repository
@ComponentScan("com.danco.dao")  
public class UserDAO   implements IUserDAO {
	
	
    private SessionFactory sf;
	
    public UserDAO() {
		System.out.println("user dao created");
	} 

    @Required
	@Autowired 
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void create( User user) throws Exception{
		sf.getCurrentSession().save(user);
	}

	@Override
	public void update( User user) throws Exception{
		sf.getCurrentSession().update(user);
	}
	@Override
	public void delete( User user) throws Exception{
		sf.getCurrentSession().delete(user);
	} 
	

	@Override
	public User getById(int idUser)  throws Exception{
	return	(User) sf.getCurrentSession().get(User.class, idUser);
			
	    
	}

	
	@Override
	public List<User> getList()  throws Exception{
	
	    @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) sf.getCurrentSession()
                .createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;
	   
	}

	@Override
	public User getByLogin(String login) throws Exception{
		Criteria cr = sf.getCurrentSession().createCriteria(User.class);
		cr.add(Restrictions.eq("login", login));
		return (User) cr.uniqueResult();
		
	}

	@Override
	public User getByLoginAndPassword(String login, String password)
			throws Exception {
		Criteria cr = sf.getCurrentSession().createCriteria(User.class);
		cr.add(Restrictions.eq("login", login));
		cr.add(Restrictions.eq("password", password));
		return (User) cr.uniqueResult();
	}

}
