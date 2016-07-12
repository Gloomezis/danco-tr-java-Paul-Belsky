package com.danco.dao;

import org.springframework.stereotype.Repository;

import com.danco.api.dao.IUserDetailsDAO;
import com.danco.model.UserDetails;


/**
 * The Class UserDetailsDAO.
 */
@Repository
public class UserDetailsDAO extends BaseDAO<UserDetails> implements
		IUserDetailsDAO {

	/** The Constant USER_DETAIL_DAO_CREATED. */
	private static final String USER_DETAIL_DAO_CREATED = "UserDetail dao created";

	/**
	 * Instantiates a new user details DAO.
	 */
	public UserDetailsDAO() {
		super(UserDetails.class);
		System.out.println(USER_DETAIL_DAO_CREATED);
	}

}
