package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IPostDAO;
import com.danco.dao.util.HibernateGenericResultBuilder;
import com.danco.model.Post;

@Repository
public class PostDAO extends BaseDAO<Post> implements IPostDAO {

	public PostDAO() {
		super(Post.class);
		System.out.println("Post dao created");
	}

	
	@Override
	public List<Post> getListByUserId(int id, int startPostId, int pageSize)
			throws Exception {
		Criteria criteria = sf.getCurrentSession().createCriteria(Post.class);
		criteria.createCriteria("creator", JoinType.RIGHT_OUTER_JOIN).add(
				Restrictions.eq("id", id));
		
		// HibernateGenericResultBuilder<Post> critBuilder = new
		// HibernateGenericResultBuilder<Post>(criteria);
		List<Post> postList = (List<Post>) new HibernateGenericResultBuilder<Post>(
				criteria).withOffset(startPostId).withLimit(pageSize)
				.orderedBy("timeCreation").result();
		return postList;
	}

	@Override
	public int getPostCountByUserId(int id) throws Exception {
		Criteria criteria = sf.getCurrentSession().createCriteria(Post.class);
		criteria.createCriteria("creator", JoinType.LEFT_OUTER_JOIN).add(
				Restrictions.eq("creator.id", id)).setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();
		
		return count.intValue();
	}

}
