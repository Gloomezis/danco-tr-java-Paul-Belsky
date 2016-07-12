package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IFriendshipDAO;
import com.danco.api.exception.MyException;
import com.danco.model.Friendship;


/**
 * The Class FriendshipDAO.
 */
@Repository
public class FriendshipDAO extends BaseDAO<Friendship> implements
		IFriendshipDAO {

	/** The Constant F. */
	private static final String F = "f";
	
	/** The Constant UNCHECKED2. */
	private static final String UNCHECKED2 = "unchecked";
	
	/** The Constant U_ID. */
	private static final String U_ID = "u.id";
	
	/** The Constant F_ID. */
	private static final String F_ID = "f.id";
	
	/** The Constant GETTED_ENTITY_COUNT. */
	private static final String GETTED_ENTITY_COUNT = "Getted entity count :";
	
	/** The Constant FRIEND. */
	private static final String FRIEND = "friend";
	
	/** The Constant U. */
	private static final String U = "u";
	
	/** The Constant FRIENSHIP_DAO_CREATED. */
	private static final String FRIENSHIP_DAO_CREATED = "Frienship dao created";
	
	/** The Constant USER. */
	private static final String USER = "user";

	/**
	 * Instantiates a new friendship DAO.
	 */
	public FriendshipDAO() {
		super(Friendship.class);
		System.out.println(FRIENSHIP_DAO_CREATED);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IFriendshipDAO#getByBothId(int, int)
	 */
	@Override
	public Friendship getByBothId(int myId, int friendId) throws MyException {

		Criteria criteria = sf.getCurrentSession().createCriteria(
				Friendship.class);
		criteria.setFetchMode(USER, FetchMode.JOIN).createAlias(USER, U);
		criteria.setFetchMode(FRIEND, FetchMode.JOIN).createAlias(FRIEND,
				F);
		criteria.add(Restrictions.and(Restrictions.eq(U_ID, myId),
				Restrictions.eq(F_ID, friendId)));
		Friendship fr = (Friendship) criteria.uniqueResult();
		System.out.println(GETTED_ENTITY_COUNT);
		return fr;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IFriendshipDAO#getFollowersCount(int)
	 */
	@Override
	public int getFollowersCount(int id) throws MyException {
		Criteria criteria = sf.getCurrentSession().createCriteria(
				Friendship.class);
		criteria.createAlias(USER, U);
		criteria.add(Restrictions.eq(U_ID, id)).setProjection(
				Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();
		return count.intValue();
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IFriendshipDAO#getMyFollowers(int, int, int)
	 */
	@SuppressWarnings(UNCHECKED2)
	@Override
	public List<Friendship> getMyFollowers(int id, int startFollowersId,
			int pageSize) throws MyException {
		Criteria criteria = sf.getCurrentSession().createCriteria(
				Friendship.class);
		criteria.setFirstResult(startFollowersId);
		criteria.setMaxResults(pageSize);
		criteria.createAlias(USER, U);
		criteria.setFetchMode(FRIEND, FetchMode.JOIN).createAlias(FRIEND,
				F);
		criteria.add(Restrictions.eq(U_ID, id));
		List<Friendship> fr = (List<Friendship>) criteria.list();
		System.out.println(GETTED_ENTITY_COUNT);
		return fr;

	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IFriendshipDAO#getFollowingsCount(int)
	 */
	@Override
	public int getFollowingsCount(int id) throws MyException {
		Criteria criteria = sf.getCurrentSession().createCriteria(
				Friendship.class);
		criteria.createAlias(FRIEND, F);
		criteria.add(Restrictions.eq(F_ID, id)).setProjection(
				Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();
		return count.intValue();
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IFriendshipDAO#getMyFollowings(int, int, int)
	 */
	@SuppressWarnings(UNCHECKED2)
	@Override
	public List<Friendship> getMyFollowings(int id, int startFollowingsId,
			int pageSize) throws MyException {
		Criteria criteria = sf.getCurrentSession().createCriteria(
				Friendship.class);
		criteria.setFirstResult(startFollowingsId);
		criteria.setMaxResults(pageSize);
		criteria.createAlias(FRIEND, F);
		criteria.setFetchMode(USER, FetchMode.JOIN).createAlias(USER, U);
		criteria.add(Restrictions.eq(F_ID, id));
		List<Friendship> fr = (List<Friendship>) criteria.list();
		System.out.println(GETTED_ENTITY_COUNT);
		return fr;
	}

}
