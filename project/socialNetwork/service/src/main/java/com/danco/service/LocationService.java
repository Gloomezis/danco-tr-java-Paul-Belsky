package com.danco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danco.api.dao.ILocationDAO;
import com.danco.api.service.ILocationService;
import com.danco.model.Location;


/**
 * The Class LocationService.
 */
@Service
public class LocationService extends BaseService<Location> implements
		ILocationService {

	/** The Constant LOCATION_SERVICE_CREATED. */
	private static final String LOCATION_SERVICE_CREATED = "Location service created";
	
	/** The dao. */
	@Autowired
	private ILocationDAO dao;

	/**
	 * Instantiates a new location service.
	 */
	public LocationService() {
		System.out.println(LOCATION_SERVICE_CREATED);
	}

}
