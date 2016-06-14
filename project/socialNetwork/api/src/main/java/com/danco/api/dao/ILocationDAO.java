package com.danco.api.dao;

import java.util.List;








import com.danco.model.Location;


public interface ILocationDAO extends IDAO<Location>{


	@Override
	public default void create(Location location) throws Exception{
		
		IDAO.super.create(location);
	}

	@Override
	public default void delete(Location location)  throws Exception{
		
		IDAO.super.delete(location);
	}

	@Override
	public default void update(Location location) throws Exception {
		
		IDAO.super.update(location);
	}

	@Override
	public Location getById(int idLocation) throws Exception;

	
	
	public List<Location> getList()throws Exception;

}