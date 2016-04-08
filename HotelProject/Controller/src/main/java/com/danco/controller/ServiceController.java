package com.danco.controller;

import java.util.List;

import org.hibernate.Session;

import com.danco.dao.api.IServiceDAO;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceController.
 */
public class ServiceController {

	/** The service dao. */
	private IServiceDAO serviceDAO = (IServiceDAO) DependencyInjectionManager
			.getClassInstance(IServiceDAO.class);

	/**
	 * Creates the service.
	 *
	 * @param session the session
	 * @param service the service
	 * @throws Exception the exception
	 */
	public void createService(Session session, Service service)
			throws Exception {

		serviceDAO.create(session, service);

	}

	/**
	 * Delete service.
	 *
	 * @param session the session
	 * @param service the service
	 * @throws Exception the exception
	 */
	public void deleteService(Session session, Service service)
			throws Exception {

		serviceDAO.delete(session, service);

	}

	/**
	 * Update service.
	 *
	 * @param session the session
	 * @param service the service
	 * @throws Exception the exception
	 */
	public void updateService(Session session, Service service)
			throws Exception {

		serviceDAO.update(session, service);

	}

	/**
	 * Gets the service by id.
	 *
	 * @param session the session
	 * @param id the id
	 * @return the service by id
	 * @throws Exception the exception
	 */
	public Service getServiceById(Session session, int id) throws Exception {

		return serviceDAO.getById(session, id);

	}

	/**
	 * Gets the service list.
	 *
	 * @param session the session
	 * @param sortCondition the sort condition
	 * @return the service list
	 * @throws Exception the exception
	 */
	public List<Service> getServiceList(Session session, String sortCondition)
			throws Exception {
		return serviceDAO.getList(session, sortCondition);
	}

	/**
	 * Gets the guest them services.
	 *
	 * @param session the session
	 * @param idGuest the id guest
	 * @return the guest them services
	 * @throws Exception the exception
	 */
	public List<Service> getGuestThemServices(Session session, int idGuest)
			throws Exception {
		return serviceDAO.getGuestThemServices(session, idGuest);
	}

	/**
	 * Gets the sum service for guest.
	 *
	 * @param session the session
	 * @param idGuest the id guest
	 * @return the sum service for guest
	 * @throws Exception the exception
	 */
	public int getSumServiceForGuest(Session session, int idGuest)
			throws Exception {
		return serviceDAO.getSumServiceForGuest(session, idGuest);
	}

	/**
	 * Gets the price service.
	 *
	 * @param session the session
	 * @return the price service
	 * @throws Exception the exception
	 */
	public List<String> getPriceService(Session session) throws Exception {

		return serviceDAO.getPriceService(session);

	}
	

}
