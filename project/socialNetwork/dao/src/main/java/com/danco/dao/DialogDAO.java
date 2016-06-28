package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IDialogDAO;
import com.danco.model.Dialog;
 

@Repository 
public class DialogDAO extends BaseDAO<Dialog> implements IDialogDAO {

	 public DialogDAO() {
		 super(Dialog.class);
			System.out.println("Dialog dao created");
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dialog> getListByGroupId(int id) throws Exception {
		Criteria criteria = sf.getCurrentSession().createCriteria(Dialog.class);
		List<Dialog> dialogList = (List<Dialog>) criteria.createCriteria("group", JoinType.RIGHT_OUTER_JOIN)
				.add(Restrictions.eq("id", id)).list();
		return dialogList;
	} 

		
}
