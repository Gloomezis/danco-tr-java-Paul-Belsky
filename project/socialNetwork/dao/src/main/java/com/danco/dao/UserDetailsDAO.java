package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IUserDetailsDAO;
import com.danco.model.UserDetails;

@Repository
@ComponentScan("com.danco.dao")  
public class UserDetailsDAO implements IUserDetailsDAO {

	
	
		
	    private SessionFactory sf;
		
	    public UserDetailsDAO() {
			System.out.println("UserDetail dao created");
		} 

	    @Required
		@Autowired 
		public void setSf(SessionFactory sf) {
			this.sf = sf;
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IUserDetailDAO#create(com.danco.model.UserDetails)
		 */
		@Override
		public void create(UserDetails userDetails) throws Exception{
			sf.getCurrentSession().save(userDetails);
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IUserDetailDAO#update(com.danco.model.UserDetails)
		 */
		@Override
		public void update(UserDetails userDetails) throws Exception{
			sf.getCurrentSession().update(userDetails);
		}
		
		/* (non-Javadoc)
		 * @see com.danco.dao.IUserDetailDAO#delete(com.danco.model.UserDetails)
		 */
		@Override
		public void delete(UserDetails userDetails) throws Exception{
			sf.getCurrentSession().delete(userDetails);
		} 
		

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IUserDetailDAO#getById(int)
		 */
		@Override
		public UserDetails getById(int idUserDetails) throws Exception {
		return	(UserDetails) sf.getCurrentSession().get(UserDetails.class, idUserDetails);
				
		    
		}

		
		
		/* (non-Javadoc)
		 * @see com.danco.dao.IUserDetailDAO#getList()
		 */
		@Override
		public List<UserDetails> getList() throws Exception {
		
		    @SuppressWarnings("unchecked")
	        List<UserDetails> listUserDetails = (List<UserDetails>) sf.getCurrentSession()
	                .createCriteria(UserDetails.class)
	                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        return listUserDetails;
		   
		}
}
