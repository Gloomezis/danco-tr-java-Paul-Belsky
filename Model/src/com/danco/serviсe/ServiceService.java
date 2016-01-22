package com.danco.servi�e;

import java.util.List;

import org.apache.log4j.Logger;

import com.danco.model.Service;
import com.danco.storages.MainStorage;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceService.
 */
public class ServiceService {

	/** The main storage. */
	private MainStorage mainStorage = MainStorage.getInstance();

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ServiceService.class.getName());

	/** The instance. */
	private static ServiceService instance;

	/**
	 * Gets the single instance of ServiceService.
	 *
	 * @return single instance of ServiceService
	 */
	public static ServiceService getInstance() {
		if (instance == null) {
			instance = new ServiceService();
		}
		return instance;
	}

	/**
	 * Instantiates a new service service.
	 */
	private ServiceService() {

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
	public Service createService(String nameOfService, int price) {

		try {
			return mainStorage.createService(nameOfService, price);
		} catch (Exception e) {
			LOG1.error("Exception", e);
			return null;
		}

	}

	/**
	 * Gets the service by name.
	 *
	 * @param nameOfService
	 *            the name of service
	 * @return the service by name
	 */
	public Service getServiceByName(String nameOfService) {

		try {
			return mainStorage.getServiceByName(nameOfService);
		} catch (Exception e) {
			LOG1.error("Exception", e);
			return null;
		}

	}

	/**
	 * Adds the services.
	 *
	 * @param service
	 *            the service
	 */

	public void addServices(Service service) {
		try {
			mainStorage.addServices(service);
		} catch (Exception e) {
			LOG1.error("Exception", e);
		}
	}

	/**
	 * Show price services.
	 */

	public  List<Service> showPriceService() {
		try {
			return mainStorage.showPriceService();
		} catch (Exception e) {
			LOG1.error("Exception", e);
			return null;
		}
	}

	/**
	 * Change price of service.
	 *
	 * @param service
	 *            the service
	 * @param price
	 *            the price
	 */

	public void changePriceOfService(Service service, int price) {
		try {
			 mainStorage.changePriceOfService(service, price);
		} catch (Exception e) {
			LOG1.error("Wrong service name", e);
			
		}
	}

}
