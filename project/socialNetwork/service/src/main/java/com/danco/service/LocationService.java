package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.ILocationDAO;
import com.danco.api.service.ILocationService;
import com.danco.model.Location;

@Service
public class LocationService implements ILocationService {

	private ILocationDAO dao;

	@Required
	@Autowired
	public void setDao(ILocationDAO dao) {
		this.dao = dao;
	}

	public LocationService() {
		System.out.println("Location service cereated");
	}

	/* (non-Javadoc)
	 * @see com.danco.service.ILocationService#create(com.danco.model.Location)
	 */
	@Override
	public void create(Location location) throws Exception{
		dao.create(location);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.ILocationService#update(com.danco.model.Location)
	 */
	@Override
	@Transactional
	public void update(Location location)throws Exception {
		dao.update(location);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.ILocationService#delete(com.danco.model.Location)
	 */
	@Override
	@Transactional
	public void delete(Location location)throws Exception {
		dao.delete(location);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.ILocationService#getById(int)
	 */
	@Override
	@Transactional
	public Location getById(int idModel)throws Exception {
		return dao.getById(idModel);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.ILocationService#getList()
	 */
	@Override
	@Transactional
	public List<Location> getList() throws Exception{
		return dao.getList();
	}
}
