package com.danco.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.danco.dao.api.IServiceDAO;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceController.
 */
public class ServiceController {

	/** The service service. */
	private IServiceDAO serviceDAO = (IServiceDAO) DependencyInjectionManager
			.getClassInstance(IServiceDAO.class);

	/**
	 * Creates the.
	 *
	 * @param con the con
	 * @param service the service
	 * @return the int
	 * @throws SQLException the SQL exception
	 */
	public int create(Connection con, Service service) throws SQLException {

		return serviceDAO.create(con, service);

	}

	/**
	 * Update paid.
	 *
	 * @param con the con
	 * @param userInputOrderId the user input order id
	 * @return the int
	 * @throws SQLException the SQL exception
	 */
	public int updatePaid(Connection con, String userInputOrderId)
			throws SQLException {

		return serviceDAO.updatePaid(con, userInputOrderId);

	}

	/**
	 * Gets the price service.
	 *
	 * @param con the con
	 * @return the price service
	 * @throws SQLException the SQL exception
	 */
	public List<String> getPriceService(Connection con) throws SQLException {

		return serviceDAO.getPriceService(con);

	}

	/**
	 * Read by name.
	 *
	 * @param con the con
	 * @param userInputServiceName the user input service name
	 * @return the service
	 * @throws SQLException the SQL exception
	 */
	public Service readByName(Connection con, String userInputServiceName)
			throws SQLException {

		return serviceDAO.readByName(con, userInputServiceName);

	}

	/**
	 * Update price.
	 *
	 * @param con the con
	 * @param id the id
	 * @param price the price
	 * @return the int
	 * @throws SQLException the SQL exception
	 */
	public int updatePrice(Connection con, int id, int price)
			throws SQLException {

		return serviceDAO.updatePrice(con, id, price);

	}

}
