package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IGroupDAO;
import com.danco.model.Group;
import com.danco.model.Post;

@Repository 
public class GroupDAO extends BaseDAO<Group> implements IGroupDAO {

	
	
		
	   
		
	    public GroupDAO() {
			 super(Group.class);
			System.out.println("Group dao created");
		}

		

		@SuppressWarnings("unchecked")
		@Override
		public List<Group> searchByTitle(String title) {
			Criteria criteria = sf.getCurrentSession().createCriteria(Group.class);
			return (List<Group>) criteria.add(Restrictions.like("title", "%"+title+"%")).list();
		}



		@SuppressWarnings("unchecked")
		@Override
		public List<Group> getListByUserId(int id) {
			Criteria criteria = sf.getCurrentSession().createCriteria(Group.class);
			List<Group> groupList = (List<Group>) criteria.createCriteria("members", JoinType.RIGHT_OUTER_JOIN)
					.add(Restrictions.eq("id", id)).list();
			return groupList;
		} 

	   
		
}
