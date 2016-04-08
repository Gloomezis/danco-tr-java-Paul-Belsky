package com.danco.dao.api;

import java.util.List;

import org.hibernate.Session;

import com.danco.model.Guest;

// TODO: Auto-generated Javadoc
/**
 * The Interface IGuestDAO.
 */
public interface IGuestDAO extends IDAO<Guest>{

	
	
	/**
	 * Gets the list.
	 *
	 * @param session the session
	 * @param sortCondition the sort condition
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Guest> getList(Session session, String sortCondition)throws Exception; 
	
	/**
	 * Gets the all guest number.
	 *
	 * @param session the session
	 * @return the all guest number
	 * @throws Exception the exception
	 */
	public int getAllGuestNumber(Session session) throws Exception;
	
	



	
	
	
	
	
	
	
}
	
	