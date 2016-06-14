package com.danco.api.dao;

import java.util.List;









import com.danco.model.UserDetails;

public interface IUserDetailsDAO extends IDAO<UserDetails>{


	@Override
	public default void create(UserDetails userDetails) throws Exception{
		
		IDAO.super.create(userDetails);
	}

	@Override
	public default void delete(UserDetails userDetails)  throws Exception{
		
		IDAO.super.delete(userDetails);
	}

	@Override
	public default void update(UserDetails userDetails) throws Exception {
		
		IDAO.super.update(userDetails);
	}

	@Override
	public UserDetails getById(int idUserDetails) throws Exception;

	
	
	public List<UserDetails> getList()throws Exception;


}