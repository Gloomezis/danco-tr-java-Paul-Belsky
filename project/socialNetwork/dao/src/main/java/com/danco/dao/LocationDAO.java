package com.danco.dao;

import org.springframework.stereotype.Repository;

import com.danco.api.dao.ILocationDAO;
import com.danco.model.Location;


/**
 * The Class LocationDAO.
 */
@Repository
public class LocationDAO extends BaseDAO<Location> implements ILocationDAO {

	/** The Constant LOCATION_DAO_CREATED. */
	private static final String LOCATION_DAO_CREATED = "Location dao created";

	/**
	 * Instantiates a new location DAO.
	 */
	public LocationDAO() {
		super(Location.class);
		System.out.println(LOCATION_DAO_CREATED);
	}

}
