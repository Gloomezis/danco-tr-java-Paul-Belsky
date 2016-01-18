package com.danco.storages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.danco.comparator.ServicePriceComparator;
import com.danco.model.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceStorage.
 */
public class ServiceStorage {

	/** The Constant SERVICE_FORMAT. */
	private final static String SERVICE_FORMAT = "Service: %s , price: %d \n";

	/** The servises. */
	List<Service> servises = new ArrayList<Service>();

	/**
	 * Gets the service by name.
	 *
	 * @param nameOfService the name of service
	 * @return the service by name
	 */
	public Service getServiceByName(String nameOfService) {

		Service s = null;
		for (Service serv : servises) {
			if (serv.getNameOfService().equals(nameOfService)) {
				s = serv;
			}
		}
		return s;
	}
	
	
	
	/**
	 * Creates the service.
	 *
	 * @param nameOfService the name of service
	 * @param price the price
	 * @return the service
	 */
	public Service createService(String nameOfService, int price){
		Service service = new Service(price, nameOfService);
		return 	service;
		
	}

	/**
	 * Adds the services.
	 *
	 * @param service
	 *            the service
	 */

	public void addServices(Service service) {
		servises.add(service);
	}

	/**
	 * Change price of service.
	 *
	 * @param service
	 *            the service
	 * @param price
	 *            the price
	 */

	public void changePriceOfService(Service service, int price) throws NullPointerException {
		service.setPrice(price);
	}

	// TODO returnStatement
	/**
	 * Show price services.
	 */

	public void showPriceServices() {
		
		List<Service> servisesForSort = new ArrayList<Service>(servises);
		
		Collections.sort(servisesForSort, new ServicePriceComparator());
		StringBuilder sb = new StringBuilder(40);
		for (Service s : servisesForSort) {
			sb.append(String.format(SERVICE_FORMAT, s.getNameOfService(), s.getPrice()));

		}
		System.out.println(sb);
	}
}
