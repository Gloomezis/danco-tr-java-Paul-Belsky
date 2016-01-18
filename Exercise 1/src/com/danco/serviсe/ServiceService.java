package com.danco.serviñe;

import org.apache.log4j.Logger;

import com.danco.gloomezis.MainStorage;
import com.danco.model.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceService.
 */
public class ServiceService {

	/** The main storage. */
	MainStorage mainStorage = MainStorage.getInstance();
	final Logger LOG1=Logger.getLogger(ServiceService.class.getName());
	
private static ServiceService instance;
	
	
	public static ServiceService getInstance() {
		if (instance == null) {
			instance = new ServiceService();
		}
		return instance;
	}
	

	private  ServiceService() {
		
	}
	
	
	
	
	

	/**
	 * Adds the services.
	 *
	 * @param service the service
	 */
	
	public void addServices(Service service) {
		mainStorage.addServices(service);

	}

	/**
	 * Show price services.
	 */
	
	public void showPriceServiceAndHotelRoom() {
		mainStorage.showPriceServiceAndHotelRoom();

	}

	/**
	 * Change price of service.
	 *
	 * @param service the service
	 * @param price the price
	 */
	
	public void changePriceOfService(Service service, int price) {
		try {
		mainStorage.changePriceOfService(service, price);
		} catch (NullPointerException e) {
			LOG1.error("Wrong service name",e);
			
		}
	}
	
	
}
