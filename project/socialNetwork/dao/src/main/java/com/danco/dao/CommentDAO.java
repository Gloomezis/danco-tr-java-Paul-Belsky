package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.ICommentDAO;
import com.danco.api.dao.util.ResultBuilder;
import com.danco.dao.util.HibernateGenericResultBuilder;
import com.danco.model.Comment;
import com.danco.model.Post;

@Repository
public class CommentDAO extends BaseDAO<Comment> implements ICommentDAO {

	public CommentDAO() {
		super(Comment.class);
		System.out.println("Comment dao created");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getListByPostId(int id) {
		Criteria criteria = sf.getCurrentSession()
				.createCriteria(Comment.class);
		List<Comment> commentList = (List<Comment>) criteria
				.createCriteria("post", JoinType.RIGHT_OUTER_JOIN)
				.add(Restrictions.eq("id", id)).list();
		return commentList;
	}

	
	@Override
	public List<Comment> getListByPostIdPagination(int id, int startPostId,
			int pageSize) throws Exception {
		Criteria criteria = sf.getCurrentSession()
				.createCriteria(Comment.class);
	//	List<Comment> commentList = (List<Comment>) criteria
	//			.createCriteria("post", JoinType.RIGHT_OUTER_JOIN)
	//			.add(Restrictions.eq("id", id)).setFirstResult(startPostId)
	//			.setMaxResults(pageSize).addOrder(Order.asc("timeCreation"))
	//			.list();
		criteria.createCriteria("post", JoinType.LEFT_OUTER_JOIN)
				.add(Restrictions.eq("id", id));
		List<Comment> commentList = (List<Comment>) new HibernateGenericResultBuilder<Comment>(
				criteria).withOffset(startPostId).withLimit(pageSize)
				.orderedBy("timeCreation").result();
		
		return commentList;
	}

	@Override
	public int getmessageCountByPostId(int id) throws Exception {
		Criteria criteria = sf.getCurrentSession()
				.createCriteria(Comment.class);
		criteria.createCriteria("post", JoinType.RIGHT_OUTER_JOIN)
				.add(Restrictions.eq("id", id))
				.setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();

		return count.intValue();
	}

}
