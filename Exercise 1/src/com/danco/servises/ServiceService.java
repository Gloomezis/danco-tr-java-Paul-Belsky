package com.danco.servises;



import com.danco.models.Service;
import com.danco.storages.ServiceStorage;

public class ServiceService {

	// singleton
	private static volatile ServiceService instance;

	private ServiceService() {
	}

	public static ServiceService getInstance() {
		if (instance == null) {
			synchronized (ServiceService.class) {
				if (instance == null) {
					instance = new ServiceService();
				}

			}
		}
		return instance;
	}

	ServiceStorage serviceStorage = ServiceStorage.getInstance();

	// +Add service to array servises
	public void addServices(Service service) {
		serviceStorage.addServices(service);
		;
	}
	// +sorted by price
	public void showPriceServices() {
		serviceStorage.showPriceServices();
	}

	// +change price of service
	public void changePriceOfService(Service service, int price) {
		serviceStorage.changePriceOfService(service, price);
	}
}
