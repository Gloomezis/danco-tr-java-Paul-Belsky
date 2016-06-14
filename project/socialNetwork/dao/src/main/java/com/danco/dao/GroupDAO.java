package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;








import com.danco.api.dao.IGroupDAO;
import com.danco.model.Group;

@Repository
@ComponentScan("com.danco.dao")  
public class GroupDAO implements IGroupDAO {

	
	
		
	    private SessionFactory sf;
		
	    public GroupDAO() {
			System.out.println("Group dao created");
		} 

	    @Required
		@Autowired 
		public void setSf(SessionFactory sf) {
			this.sf = sf;
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IGroupDAO#create(com.danco.model.Group)
		 */
		@Override
		public void create(Group group) throws Exception{
			sf.getCurrentSession().save(group);
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IGroupDAO#update(com.danco.model.Group)
		 */
		@Override
		public void update(Group group) throws Exception{
			sf.getCurrentSession().update(group);
		}
		
		/* (non-Javadoc)
		 * @see com.danco.dao.IGroupDAO#delete(com.danco.model.Group)
		 */
		@Override
		public void delete(Group group) throws Exception{
			sf.getCurrentSession().delete(group);
		} 
		

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IGroupDAO#getById(int)
		 */
		@Override
		public Group getById(int idGroup)  throws Exception{
		return	(Group) sf.getCurrentSession().get(Group.class, idGroup);
				
		    
		}

		
		
		/* (non-Javadoc)
		 * @see com.danco.dao.IGroupDAO#getList()
		 */
		@Override
		public List<Group> getList()  throws Exception{
		
		    @SuppressWarnings("unchecked")
	        List<Group> listGroup = (List<Group>) sf.getCurrentSession()
	                .createCriteria(Group.class)
	                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        return listGroup;
		   
		}
}
