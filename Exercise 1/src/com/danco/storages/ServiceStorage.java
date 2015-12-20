package com.danco.storages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.danco.models.Guest;
import com.danco.models.Service;

public class ServiceStorage {

	ArrayList<Service> servises = new ArrayList<Service>();

	// singleton
	private static volatile ServiceStorage instance;

	private ServiceStorage() {
	}

	public static ServiceStorage getInstance() {
		if (instance == null) {
			synchronized (ServiceStorage.class) {
				if (instance == null) {
					instance = new ServiceStorage();
				}

			}
		}
		return instance;
	}

	// +Add service to array servises
	public void AddServices(Service service) {
		servises.add(service);
	}

	// + sorted by price
	public void showPriceServices() {
		Collections.sort(servises, new PriceCompare());
		for (Service s : servises) {
			System.out.println("Service: " + s.getNameOfService() + " , price: " + s.getPrice());

		}
	}

	// +change price of selected service
	public void changePriceOfService(Service service, int price) {
		service.setPrice(price);

	}

	/////////////////
	/// Comparators///
	/////////////////

	// comparator by name
	class PriceCompare implements Comparator<Service> {

		@Override
		public int compare(Service service1, Service service2) {

			int price1 = service1.getPrice();
			int price2 = service2.getPrice();

			if (price1 > price2) {
				return 1;
			} else if (price1 < price2) {
				return -1;
			}
			return 0;

		}
	}

}
