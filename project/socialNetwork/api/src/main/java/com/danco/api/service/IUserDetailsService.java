package com.danco.api.service;

import java.util.List;

import com.danco.model.UserDetails;

public interface IUserDetailsService {

	public abstract void create(UserDetails userDetails)throws Exception;

	public abstract void update(UserDetails userDetails)throws Exception;

	public abstract void delete(UserDetails userDetails)throws Exception;

	public abstract UserDetails getById(int idModel)throws Exception;

	public abstract List<UserDetails> getList()throws Exception;

}