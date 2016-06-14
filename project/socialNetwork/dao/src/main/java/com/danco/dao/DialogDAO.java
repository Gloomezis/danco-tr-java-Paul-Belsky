package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;









import com.danco.api.dao.IDialogDAO;
import com.danco.model.Dialog;
 

@Repository
@ComponentScan("com.danco.dao")  
public class DialogDAO implements IDialogDAO {

	
	
		
	    private SessionFactory sf;
		
	    public DialogDAO() {
			System.out.println("Dialog dao created");
		} 

	    @Required
		@Autowired 
		public void setSf(SessionFactory sf) {
			this.sf = sf;
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IDialogDAO#create(com.danco.model.Dialog)
		 */
		@Override
		public void create(Dialog dialog) throws Exception{
			sf.getCurrentSession().save(dialog);
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IDialogDAO#update(com.danco.model.Dialog)
		 */
		@Override
		public void update( Dialog dialog) throws Exception{
			sf.getCurrentSession().update(dialog);
		}
		
		/* (non-Javadoc)
		 * @see com.danco.dao.IDialogDAO#delete(com.danco.model.Dialog)
		 */
		@Override
		public void delete( Dialog dialog) throws Exception{
			sf.getCurrentSession().delete(dialog);
		} 
		

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IDialogDAO#getById(int)
		 */
		@Override
		public Dialog getById(int idDialog)  throws Exception{
		return	(Dialog) sf.getCurrentSession().get(Dialog.class, idDialog);
				
		    
		}

		
		
		/* (non-Javadoc)
		 * @see com.danco.dao.IDialogDAO#getList()
		 */
		@Override
		public List<Dialog> getList()  throws Exception{
		
		    @SuppressWarnings("unchecked")
	        List<Dialog> listDialog = (List<Dialog>) sf.getCurrentSession()
	                .createCriteria(Dialog.class)
	                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        return listDialog;
		   
		}

		
}
