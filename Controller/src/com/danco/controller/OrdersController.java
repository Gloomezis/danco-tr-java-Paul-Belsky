package com.danco.controller;

import java.sql.Connection;
import java.sql.SQLException;

import com.danco.dao.api.IOrdersDAO;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Orders;


// TODO: Auto-generated Javadoc
/**
 * The Class OrdersController.
 */
public class OrdersController  {
	
	/** The service service. */
	private IOrdersDAO ordersDAO = (IOrdersDAO) DependencyInjectionManager
			.getClassInstance(IOrdersDAO.class);
	

	
	/**
	 * Gets the summ to departure.
	 *
	 * @param con the con
	 * @param userInputGuestName the user input guest name
	 * @return the summ to departure
	 * @throws SQLException the SQL exception
	 */
	public int getSummToDeparture(Connection con,String userInputGuestName) throws SQLException {
		
			return ordersDAO.getSummToDeparture(con, userInputGuestName);
			
	}
	
	
	/**
	 * Creates the.
	 *
	 * @param con the con
	 * @param orders the orders
	 * @return the int
	 * @throws SQLException the SQL exception
	 */
	public int create(Connection con, Orders orders) throws SQLException {

		return ordersDAO.create(con, orders);

	}
	
	
	/**
	 * Update paid.
	 *
	 * @param con the con
	 * @param id the id
	 * @return the int
	 * @throws SQLException the SQL exception
	 */
	public int updatePaid(Connection con, String id) throws SQLException {

		return ordersDAO.updatePaid(con, id);

	}
	
	
	
}
