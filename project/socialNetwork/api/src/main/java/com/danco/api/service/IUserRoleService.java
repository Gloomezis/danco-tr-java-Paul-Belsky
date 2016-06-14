package com.danco.api.service;

import java.util.List;

import com.danco.model.UserRole;

public interface IUserRoleService {

	public abstract void create(UserRole userRole)throws Exception;

	public abstract void update(UserRole userRole)throws Exception;

	public abstract void delete(UserRole userRole)throws Exception;

	public abstract UserRole getById(int idModel)throws Exception;

	public abstract List<UserRole> getList()throws Exception;

}