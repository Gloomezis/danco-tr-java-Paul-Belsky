package com.danco.storages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.danco.comparator.ServicePriceComparator;
import com.danco.model.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceStorage.
 */
public class ServiceStorage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The servises. */
	private List<Service> services = new ArrayList<Service>();

	/**
	 * Gets the service by name.
	 *
	 * @param nameOfService
	 *            the name of service
	 * @return the service by name
	 */
	public Service getServiceByName(String nameOfService) throws Exception {

		Service s = null;
		for (Service serv : services) {
			if (serv.getNameOfService().equals(nameOfService)) {
				s = serv;
			}
		}
		return s;
	}

	/**
	 * Creates the service.
	 *
	 * @param nameOfService
	 *            the name of service
	 * @param price
	 *            the price
	 * @return the service
	 */
	public Service createService(String nameOfService, int price) throws Exception {
		Service service = new Service(price, nameOfService);
		return service;

	}

	/**
	 * Adds the services.
	 *
	 * @param service
	 *            the service
	 */

	public void addServices(Service service) throws Exception {
		services.add(service);
	}

	/**
	 * Change price of service.
	 *
	 * @param service
	 *            the service
	 * @param price
	 *            the price
	 */

	public void changePriceOfService(Service service, int price) throws Exception {
		service.setPrice(price);
	}

	// TODO returnStatement
	/**
	 * Show price services.
	 */

	public List<Service> showPriceServices() throws Exception {

		List<Service> servicesForSort = new ArrayList<Service>(services);

		Collections.sort(servicesForSort, new ServicePriceComparator());

		return servicesForSort;

	}

	public List<Service> getServises() {
		return services;
	}

	
	
}
