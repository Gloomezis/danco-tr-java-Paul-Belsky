package com.danco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.danco.api.dao.IUserDetailsDAO;
import com.danco.api.service.IUserDetailsService;
import com.danco.model.UserDetails;

@Service
public class UserDetailsService extends BaseService<UserDetails> implements IUserDetailsService {

	@Autowired
	private IUserDetailsDAO dao;

	

	public UserDetailsService() {
		System.out.println("User detail service created");
	}



}
