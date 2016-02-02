package com.danco.servise.api;

import java.util.List;

import com.danco.model.Service;

public interface IServiceService {

	/**
	 * Creates the service.
	 *
	 * @param nameOfService
	 *            the name of service
	 * @param price
	 *            the price
	 * @return the service
	 */
	public Service createService(String nameOfService, int price);

	/**
	 * Gets the service by name.
	 *
	 * @param nameOfService
	 *            the name of service
	 * @return the service by name
	 */
	public Service getServiceByName(String nameOfService);

	/**
	 * Adds the services.
	 *
	 * @param service
	 *            the service
	 */

	public void addServices(Service service);

	/**
	 * Show price services.
	 */

	public List<Service> showPriceService();

	/**
	 * Change price of service.
	 *
	 * @param service
	 *            the service
	 * @param price
	 *            the price
	 */

	public void changePriceOfService(Service service, int price);

	/**
	 * Gets the servises.
	 *
	 * @return the servises
	 */
	public List<Service> getServises();

}