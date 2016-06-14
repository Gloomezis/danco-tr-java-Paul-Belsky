package com.danco.api.dao;

import java.util.List;









import com.danco.model.UserRole;

public interface IUserRoleDAO extends IDAO<UserRole>{


	@Override
	public default void create(UserRole userRole) throws Exception{
		
		IDAO.super.create(userRole);
	}

	@Override
	public default void delete(UserRole userRole) throws Exception {
		
		IDAO.super.delete(userRole);
	}

	@Override
	public default void update(UserRole userRole) throws Exception {
		
		IDAO.super.update(userRole);
	}

	@Override
	public UserRole getById(int idModel) throws Exception;

	
	
	public List<UserRole> getList()throws Exception;


	
}