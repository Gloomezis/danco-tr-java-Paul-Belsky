package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.ICommentDAO;
import com.danco.api.exception.MyException;
import com.danco.model.Comment;


/**
 * The Class CommentDAO.
 */
@Repository
public class CommentDAO extends BaseDAO<Comment> implements ICommentDAO {

	/** The Constant UNCHECKED. */
	private static final String UNCHECKED = "unchecked";
	
	/** The Constant POST. */
	private static final String POST = "post";
	
	/** The Constant COMMENT_DAO_CREATED. */
	private static final String COMMENT_DAO_CREATED = "Comment dao created";
	
	/** The Constant B. */
	private static final String B = "b";
	
	/** The Constant CREATOR. */
	private static final String CREATOR = "creator";
	
	/** The Constant ID2. */
	private static final String ID2 = "id";

	/**
	 * Instantiates a new comment DAO.
	 */
	public CommentDAO() {
		super(Comment.class);
		System.out.println(COMMENT_DAO_CREATED);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.ICommentDAO#getListByPostIdPagination(int, int, int)
	 */
	@SuppressWarnings(UNCHECKED)
	@Override
	public List<Comment> getListByPostIdPagination(int id, int startCommentId,
			int pageSize) throws MyException {
		Criteria criteria = sf.getCurrentSession()
				.createCriteria(Comment.class);
		criteria.setFirstResult(startCommentId);
		criteria.setMaxResults(pageSize);
		criteria.addOrder(Order.desc(ID2));
		criteria.setFetchMode(CREATOR, FetchMode.JOIN).createAlias(CREATOR,
				B);
		List<Comment> commentList = (List<Comment>) criteria
				.createCriteria(POST, JoinType.RIGHT_OUTER_JOIN)
				.add(Restrictions.eq(ID2, id)).list();
		return commentList;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.ICommentDAO#getmessageCountByPostId(int)
	 */
	@Override
	public int getmessageCountByPostId(int id) throws MyException {
		Criteria criteria = sf.getCurrentSession()
				.createCriteria(Comment.class);
		criteria.createCriteria(POST, JoinType.LEFT_OUTER_JOIN)
				.add(Restrictions.eq(ID2, id))
				.setProjection(Projections.rowCount());

		Long count = (Long) criteria.uniqueResult();
		System.out.println("Count " + count);
		return count.intValue();
	}

}
