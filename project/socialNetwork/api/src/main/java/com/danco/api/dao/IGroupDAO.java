package com.danco.api.dao;

import java.util.List;








import com.danco.model.Group;


public interface IGroupDAO extends IDAO<Group>{


	@Override
	public default void create(Group group) throws Exception{
		
		IDAO.super.create(group);
	}

	@Override
	public default void delete(Group group)  throws Exception{
		
		IDAO.super.delete(group);
	}

	@Override
	public default void update(Group group)  throws Exception{
		
		IDAO.super.update(group);
	}

	@Override
	public Group getById(int idGroup) throws Exception;

	
	
	public List<Group> getList()throws Exception;

	

}