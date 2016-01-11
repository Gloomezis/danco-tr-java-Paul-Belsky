package com.danco.servises;

import com.danco.gloomezis.MainStorage;
import com.danco.models.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceService.
 */
public class ServiceService {

	/** The main storage. */
	MainStorage mainStorage = MainStorage.getInstance();
	
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
		mainStorage.changePriceOfService(service, price);
	}
	
	
}
