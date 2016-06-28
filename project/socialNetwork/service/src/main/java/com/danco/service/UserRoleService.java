package com.danco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.danco.api.dao.IUserRoleDAO;
import com.danco.api.service.IUserRoleService;
import com.danco.model.UserRole;

@Service
public class UserRoleService extends BaseService<UserRole> implements IUserRoleService {

	@Autowired
	private IUserRoleDAO dao;

	

	public UserRoleService() {
		System.out.println("User role service created");
	}




}
