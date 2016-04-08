package com.danco.dao.api;

import java.util.List;

import org.hibernate.Session;

import com.danco.model.Orders;

// TODO: Auto-generated Javadoc
/**
 * The Interface IOrdersDAO.
 */
public interface IOrdersDAO extends IDAO<Orders>{
	
	
	/**
	 * Gets the orders for id guest.
	 *
	 * @param session the session
	 * @param idGuest the id guest
	 * @return the orders for id guest
	 * @throws Exception the exception
	 */
	public Orders getOrdersForIdGuest(Session session, int idGuest)
			throws Exception;

	/**
	 * Gets the list.
	 *
	 * @param session the session
	 * @param sortCondition the sort condition
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Orders> getList(Session session, String sortCondition) throws Exception;

	/**
	 * Gets the price order for guest.
	 *
	 * @param session the session
	 * @param idGuest the id guest
	 * @return the price order for guest
	 * @throws Exception the exception
	 */
	public int getPriceOrderForGuest(Session session, int idGuest)throws Exception; 
	
	
	
	
	
	
	

}