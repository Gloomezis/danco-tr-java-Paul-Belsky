package com.danco.controller;

import java.util.List;

import org.hibernate.Session;

import com.danco.dao.api.IOrdersDAO;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Orders;

// TODO: Auto-generated Javadoc
/**
 * The Class OrdersController.
 */
public class OrdersController {

	/** The orders dao. */
	private IOrdersDAO ordersDAO = (IOrdersDAO) DependencyInjectionManager
			.getClassInstance(IOrdersDAO.class);

	/**
	 * Creates the orders.
	 *
	 * @param session the session
	 * @param order the order
	 * @throws Exception the exception
	 */
	public void createOrders(Session session, Orders order) throws Exception {

		ordersDAO.create(session, order);

	}

	/**
	 * Delete orders.
	 *
	 * @param session the session
	 * @param order the order
	 * @throws Exception the exception
	 */
	public void deleteOrders(Session session, Orders order) throws Exception {

		ordersDAO.delete(session, order);

	}

	/**
	 * Update orders.
	 *
	 * @param session the session
	 * @param order the order
	 * @throws Exception the exception
	 */
	public void updateOrders(Session session, Orders order) throws Exception {

		ordersDAO.update(session, order);

	}

	/**
	 * Gets the orders by id.
	 *
	 * @param session the session
	 * @param id the id
	 * @return the orders by id
	 * @throws Exception the exception
	 */
	public Orders getOrdersById(Session session, int id) throws Exception {

		return ordersDAO.getById(session, id);

	}

	/**
	 * Gets the orders list.
	 *
	 * @param session the session
	 * @param sortCondition the sort condition
	 * @return the orders list
	 * @throws Exception the exception
	 */
	public List<Orders> getOrdersList(Session session, String sortCondition)
			throws Exception {
		return ordersDAO.getList(session, sortCondition);
	}

	/**
	 * Gets the orders for id guest.
	 *
	 * @param session the session
	 * @param idGuest the id guest
	 * @return the orders for id guest
	 * @throws Exception the exception
	 */
	public Orders getOrdersForIdGuest(Session session, int idGuest)
			throws Exception {
		return ordersDAO.getOrdersForIdGuest(session, idGuest);
	}

	/**
	 * Gets the price order for guest.
	 *
	 * @param session the session
	 * @param idGuest the id guest
	 * @return the price order for guest
	 * @throws Exception the exception
	 */
	public int getPriceOrderForGuest(Session session, int idGuest)
			throws Exception {
		return ordersDAO.getPriceOrderForGuest(session, idGuest);
	}

}
