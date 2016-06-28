package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IDialogMessageDAO;
import com.danco.model.Dialog;
import com.danco.model.DialogMessage;

@Repository
public class DialogMessageDAO extends BaseDAO<DialogMessage> implements IDialogMessageDAO {

	
	
		
	   
		
	    public DialogMessageDAO() {
			 super(DialogMessage.class);
			System.out.println("DialogMessage dao created");
		}
	    
	    
	    @SuppressWarnings("unchecked")
		@Override
		public List<DialogMessage> getListByDialogId(int id) throws Exception {
			Criteria criteria = sf.getCurrentSession().createCriteria(DialogMessage.class);
			List<DialogMessage> dialogMessageList = (List<DialogMessage>) criteria.createCriteria("dialog", JoinType.RIGHT_OUTER_JOIN)
					.add(Restrictions.eq("id", id)).list();
			return dialogMessageList;
		}    
	    
	    
	    
	    
	    
	    
	    

}
