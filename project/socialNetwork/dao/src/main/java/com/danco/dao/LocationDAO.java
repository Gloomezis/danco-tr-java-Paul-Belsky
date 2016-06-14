package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;








import com.danco.api.dao.ILocationDAO;
import com.danco.model.Location;

@Repository
@ComponentScan("com.danco.dao")  
public class LocationDAO implements ILocationDAO {

	
	
		
	    private SessionFactory sf;
		
	    public LocationDAO() {
			System.out.println("Location dao created");
		} 

	    @Required
		@Autowired 
		public void setSf(SessionFactory sf) {
			this.sf = sf;
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.ILocationDAO#create(com.danco.model.Location)
		 */
		@Override
		public void create(Location location) throws Exception{
			sf.getCurrentSession().save(location);
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.ILocationDAO#update(com.danco.model.Location)
		 */
		@Override
		public void update(Location location) throws Exception{
			sf.getCurrentSession().update(location);
		}
		
		/* (non-Javadoc)
		 * @see com.danco.dao.ILocationDAO#delete(com.danco.model.Location)
		 */
		@Override
		public void delete(Location location) throws Exception{
			sf.getCurrentSession().delete(location);
		} 
		

		
		/* (non-Javadoc)
		 * @see com.danco.dao.ILocationDAO#getById(int)
		 */
		@Override
		public Location getById(int idLocation)  throws Exception{
		return	(Location) sf.getCurrentSession().get(Location.class, idLocation);
				
		    
		}

		
		
		/* (non-Javadoc)
		 * @see com.danco.dao.ILocationDAO#getList()
		 */
		@Override
		public List<Location> getList()  throws Exception{
		
		    @SuppressWarnings("unchecked")
	        List<Location> listLocation = (List<Location>) sf.getCurrentSession()
	                .createCriteria(Location.class)
	                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        return listLocation;
		   
		}
}
