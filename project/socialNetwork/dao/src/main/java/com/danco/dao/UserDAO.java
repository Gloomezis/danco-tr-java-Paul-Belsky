package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IUserDAO;
import com.danco.api.exception.MyException;
import com.danco.model.User;


/**
 * The Class UserDAO.
 */
@Repository
public class UserDAO extends BaseDAO<User> implements IUserDAO {

	/** The Constant U2. */
	private static final String U2 = "u";
	
	/** The Constant IM_ID. */
	private static final String IM_ID = "im.id";
	
	/** The Constant FRIENDS. */
	private static final String FRIENDS = "friends";
	
	/** The Constant IM. */
	private static final String IM = "im";
	
	/** The Constant PASSWORD. */
	private static final String PASSWORD = "password";
	
	/** The Constant USERNAME. */
	private static final String USERNAME = "username";
	
	/** The Constant STRING. */
	private static final String STRING = "%";
	
	/** The Constant UD_FIRST_NAME. */
	private static final String UD_FIRST_NAME = "ud.firstName";
	
	/** The Constant UD. */
	private static final String UD = "ud";
	
	/** The Constant USER_DETAILS. */
	private static final String USER_DETAILS = "userDetails";
	
	/** The Constant UNCHECKED. */
	private static final String UNCHECKED = "unchecked";
	
	/** The Constant USER_DAO_CREATED. */
	private static final String USER_DAO_CREATED = "user dao created";

	/**
	 * Instantiates a new user DAO.
	 */
	public UserDAO() {
		super(User.class);
		System.out.println(USER_DAO_CREATED);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IUserDAO#searchByName(java.lang.String)
	 */
	@SuppressWarnings(UNCHECKED)
	@Override
	public List<User> searchByName(String name) throws MyException {
		Criteria criteria = sf.getCurrentSession().createCriteria(User.class);
		List<User> userList = (List<User>) criteria
				.createAlias(USER_DETAILS, UD)
				.add(Restrictions.like(UD_FIRST_NAME, name + STRING)).list();
		return userList;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IUserDAO#gerByCredentials(java.lang.String, java.lang.String)
	 */
	@Override
	public User gerByCredentials(String username, String password)
			throws MyException {

		Criteria cr = sf.getCurrentSession().createCriteria(User.class);
		cr.add(Restrictions.eq(USERNAME, username))
				.add(Restrictions.eq(PASSWORD, password))
				.setFetchMode(USER_DETAILS, FetchMode.JOIN);
		User u = (User) cr.uniqueResult();
		return u;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IUserDAO#getByUsername(java.lang.String)
	 */
	@Override
	public User getByUsername(String username) throws MyException {
		Criteria cr = sf.getCurrentSession().createCriteria(User.class);
		User user = (User) cr.add(Restrictions.eq(USERNAME, username))
				.uniqueResult();
		return user;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IUserDAO#getMeWithFriendList(int)
	 */
	@Override
	public User getMeWithFriendList(int i) throws MyException {
		Criteria cr = sf.getCurrentSession().createCriteria(User.class, IM);
		cr.add(Restrictions.eq(IM_ID, i));
		cr.setFetchMode(FRIENDS, FetchMode.JOIN).createAlias(FRIENDS, U2);
		User u = (User) cr.uniqueResult();
		return u;
	}

}
