package com.danco.servises;

import com.danco.gloomezis.MainStorage;
import com.danco.models.Service;

public class ServiceService {

	MainStorage mainStorage = MainStorage.getInstance();

	// +Add service to array servises
	public void addServices(Service service) {
		mainStorage.addServices(service);

	}

	// +sorted by price
	public void showPriceServices() {
		mainStorage.showPriceServiceAndHotelRoom();

	}

	// +change price of service
	public void changePriceOfService(Service service, int price) {
		mainStorage.changePriceOfService(service, price);
	}
}
