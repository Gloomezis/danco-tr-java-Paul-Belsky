package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;








import com.danco.api.dao.IMessageDAO;
import com.danco.model.Message;

@Repository
@ComponentScan("com.danco.dao")  
public class MessageDAO implements IMessageDAO {

	
	
		
	    private SessionFactory sf;
		
	    public MessageDAO() {
			System.out.println("Location dao created");
		} 

	    @Required
		@Autowired 
		public void setSf(SessionFactory sf) {
			this.sf = sf;
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IMessageDAO#create(com.danco.model.Message)
		 */
		@Override
		public void create(Message message) throws Exception{
			sf.getCurrentSession().save(message);
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IMessageDAO#update(com.danco.model.Message)
		 */
		@Override
		public void update(Message message) throws Exception{
			sf.getCurrentSession().update(message);
		}
		
		/* (non-Javadoc)
		 * @see com.danco.dao.IMessageDAO#delete(com.danco.model.Message)
		 */
		@Override
		public void delete(Message message) throws Exception{
			sf.getCurrentSession().delete(message);
		} 
		

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IMessageDAO#getById(int)
		 */
		@Override
		public Message getById(int idMessage)  throws Exception{
		return	(Message) sf.getCurrentSession().get(Message.class, idMessage);
				
		    
		}

		
		
		/* (non-Javadoc)
		 * @see com.danco.dao.IMessageDAO#getList()
		 */
		@Override
		public List<Message> getList()  throws Exception{
		
		    @SuppressWarnings("unchecked")
	        List<Message> listMessage = (List<Message>) sf.getCurrentSession()
	                .createCriteria(Message.class)
	                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        return listMessage;
		   
		}
}