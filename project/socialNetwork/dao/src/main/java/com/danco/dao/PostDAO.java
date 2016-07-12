package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IPostDAO;
import com.danco.api.exception.MyException;
import com.danco.model.Post;


/**
 * The Class PostDAO.
 */
@Repository
public class PostDAO extends BaseDAO<Post> implements IPostDAO {

	/** The Constant K_ID. */
	private static final String K_ID = "k.id";
	
	/** The Constant K. */
	private static final String K = "k";
	
	/** The Constant U_FRIEND. */
	private static final String U_FRIEND = "u.friend";
	
	/** The Constant U. */
	private static final String U = "u";
	
	/** The Constant C_SUBSCRIBERS. */
	private static final String C_SUBSCRIBERS = "c.subscribers";
	
	/** The Constant C. */
	private static final String C = "c";
	
	/** The Constant B. */
	private static final String B = "b";
	
	/** The Constant B_ID. */
	private static final String B_ID = "b.id";
	
	/** The Constant CREATOR. */
	private static final String CREATOR = "creator";
	
	/** The Constant ID. */
	private static final String ID = "id";
	
	/** The Constant UNCHECKED. */
	private static final String UNCHECKED = "unchecked";
	
	/** The Constant POST_DAO_CREATED. */
	private static final String POST_DAO_CREATED = "Post dao created";

	/**
	 * Instantiates a new post DAO.
	 */
	public PostDAO() {
		super(Post.class);
		System.out.println(POST_DAO_CREATED);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IPostDAO#getListByUserId(int, int, int)
	 */
	@SuppressWarnings(UNCHECKED)
	@Override
	public List<Post> getListByUserId(int id, int startPostId, int pageSize)
			throws MyException {
		Criteria criteria = sf.getCurrentSession().createCriteria(Post.class);
		criteria.addOrder(Order.desc(ID));
		criteria.setFirstResult(startPostId);
		criteria.setMaxResults(pageSize);
		criteria.setFetchMode(CREATOR, FetchMode.JOIN).createAlias(CREATOR,
				B);
		criteria.add(Restrictions.eq(B_ID, id));
		List<Post> postList = (List<Post>) criteria.list();
		return postList;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IPostDAO#getPostCountByUserId(int)
	 */
	@Override
	public int getPostCountByUserId(int id) throws MyException {
		Criteria criteria = sf.getCurrentSession().createCriteria(Post.class);
		criteria.createCriteria(CREATOR, JoinType.LEFT_OUTER_JOIN)
				.add(Restrictions.eq(ID, id))
				.setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();
		return count.intValue();
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IPostDAO#getNewsPostList(int, int, int)
	 */
	@SuppressWarnings(UNCHECKED)
	@Override
	public List<Post> getNewsPostList(int id, int startPostId, int pageSize)
			throws MyException {
		Criteria criteria = sf.getCurrentSession().createCriteria(Post.class);
		criteria.setFirstResult(startPostId);
		criteria.setMaxResults(pageSize);
		criteria.createAlias(CREATOR, C);
		criteria.createAlias(C_SUBSCRIBERS, U);
		criteria.createAlias(U_FRIEND, K);
		criteria.add(Restrictions.eq(K_ID, id));
		criteria.addOrder(Order.desc(ID));
		List<Post> postList = (List<Post>) criteria.list();
		return postList;
	}

}
