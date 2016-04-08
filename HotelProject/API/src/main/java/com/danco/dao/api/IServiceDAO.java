package com.danco.dao.api;

import java.util.List;

import org.hibernate.Session;

import com.danco.model.Service;

// TODO: Auto-generated Javadoc
/**
 * The Interface IServiceDAO.
 */
public interface IServiceDAO extends IDAO<Service>{

	
	/**
	 * Gets the list.
	 *
	 * @param session the session
	 * @param sortCondition the sort condition
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Service> getList(Session session, String sortCondition)throws Exception;

	/**
	 * Gets the guest them services.
	 *
	 * @param session the session
	 * @param idGuest the id guest
	 * @return the guest them services
	 * @throws Exception the exception
	 */
	public List<Service> getGuestThemServices(Session session, int idGuest)throws Exception;

	/**
	 * Gets the sum service for guest.
	 *
	 * @param session the session
	 * @param idGuest the id guest
	 * @return the sum service for guest
	 * @throws Exception the exception
	 */
	public int getSumServiceForGuest(Session session, int idGuest)throws Exception;

	/**
	 * Gets the price service.
	 *
	 * @param session the session
	 * @return the price service
	 * @throws Exception the exception
	 */
	public List<String> getPriceService(Session session)throws Exception; 
	
	
}