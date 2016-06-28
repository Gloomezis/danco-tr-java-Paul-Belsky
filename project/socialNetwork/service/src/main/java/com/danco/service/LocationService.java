package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.ILocationDAO;
import com.danco.api.service.ILocationService;
import com.danco.model.DialogMessage;
import com.danco.model.Location;

@Service
public class LocationService extends BaseService<Location> implements ILocationService {
	
	@Autowired
	private ILocationDAO dao;

	
	public LocationService() {
		System.out.println("Location service created");
	}
	

	
}
