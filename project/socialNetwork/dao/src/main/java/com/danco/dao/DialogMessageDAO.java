package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;








import com.danco.api.dao.IDialogMessageDAO;
import com.danco.model.DialogMessage;

@Repository
@ComponentScan("com.danco.dao")  
public class DialogMessageDAO implements IDialogMessageDAO {

	
	
		
	    private SessionFactory sf;
		
	    public DialogMessageDAO() {
			System.out.println("DialogMessage dao created");
		} 

	    @Required
		@Autowired 
		public void setSf(SessionFactory sf) {
			this.sf = sf;
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IDialogMessage#create(com.danco.model.DialogMessage)
		 */
		@Override
		public void create(DialogMessage dialogMessage) throws Exception{
			sf.getCurrentSession().save(dialogMessage);
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IDialogMessage#update(com.danco.model.DialogMessage)
		 */
		@Override
		public void update( DialogMessage dialogMessage) throws Exception{
			sf.getCurrentSession().update(dialogMessage);
		}
		
		/* (non-Javadoc)
		 * @see com.danco.dao.IDialogMessage#delete(com.danco.model.DialogMessage)
		 */
		@Override
		public void delete(DialogMessage dialogMessage) throws Exception{
			sf.getCurrentSession().delete(dialogMessage);
		} 
		

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IDialogMessage#getById(int)
		 */
		@Override
		public DialogMessage getById(int idDialogMessage) throws Exception{
		return	(DialogMessage) sf.getCurrentSession().get(DialogMessage.class, idDialogMessage);
				
		    
		}

		
		
		/* (non-Javadoc)
		 * @see com.danco.dao.IDialogMessage#getList()
		 */
		@Override
		public List<DialogMessage> getList()  throws Exception{
		
		    @SuppressWarnings("unchecked")
	        List<DialogMessage> listDialogMessage = (List<DialogMessage>) sf.getCurrentSession()
	                .createCriteria(DialogMessage.class)
	                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        return listDialogMessage;
		   
		}
}
