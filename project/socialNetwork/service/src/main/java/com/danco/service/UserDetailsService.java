package com.danco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danco.api.dao.IUserDetailsDAO;
import com.danco.api.service.IUserDetailsService;
import com.danco.model.UserDetails;


/**
 * The Class UserDetailsService.
 */
@Service
public class UserDetailsService extends BaseService<UserDetails> implements
		IUserDetailsService {

	/** The Constant USER_DETAIL_SERVICE_CREATED. */
	private static final String USER_DETAIL_SERVICE_CREATED = "User detail service created";
	
	/** The dao. */
	@Autowired
	private IUserDetailsDAO dao;

	/**
	 * Instantiates a new user details service.
	 */
	public UserDetailsService() {
		System.out.println(USER_DETAIL_SERVICE_CREATED);
	}

}
