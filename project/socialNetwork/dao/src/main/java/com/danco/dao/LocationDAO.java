package com.danco.dao;

import org.springframework.stereotype.Repository;

import com.danco.api.dao.ILocationDAO;
import com.danco.model.Location;

@Repository
public class LocationDAO extends BaseDAO<Location> implements ILocationDAO {

	

		
	    public LocationDAO() {
			 super(Location.class);
			System.out.println("Location dao created");
		} 

	  

		
		
}
