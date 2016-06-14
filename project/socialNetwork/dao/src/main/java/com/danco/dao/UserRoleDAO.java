package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IUserRoleDAO;
import com.danco.model.UserRole;

@Repository
@ComponentScan("com.danco.dao")  
public class UserRoleDAO implements IUserRoleDAO {

	
	
		
	    private SessionFactory sf;
		
	    public UserRoleDAO() {
			System.out.println("UserRole dao created");
		} 

	    @Required
		@Autowired 
		public void setSf(SessionFactory sf) {
			this.sf = sf;
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IUserRoleDAO#create(com.danco.model.UserRole)
		 */
		@Override
		public void create(UserRole userRole) throws Exception{
			sf.getCurrentSession().save(userRole);
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IUserRoleDAO#update(com.danco.model.UserRole)
		 */
		@Override
		public void update(UserRole userRole) throws Exception{
			sf.getCurrentSession().update(userRole);
		}
		
		/* (non-Javadoc)
		 * @see com.danco.dao.IUserRoleDAO#delete(com.danco.model.UserRole)
		 */
		@Override
		public void delete(UserRole userRole) throws Exception{
			sf.getCurrentSession().delete(userRole);
		} 
		

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IUserRoleDAO#getById(int)
		 */
		@Override
		public UserRole getById(int idUserRole) throws Exception {
		return	(UserRole) sf.getCurrentSession().get(UserRole.class, idUserRole);
				
		    
		}

		
		
		/* (non-Javadoc)
		 * @see com.danco.dao.IUserRoleDAO#getList()
		 */
		@Override
		public List<UserRole> getList() throws Exception {
		
		    @SuppressWarnings("unchecked")
	        List<UserRole> listUserRole = (List<UserRole>) sf.getCurrentSession()
	                .createCriteria(UserRole.class)
	                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        return listUserRole;
		   
		}
}
