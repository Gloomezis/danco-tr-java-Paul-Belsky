package com.danco.storages;

import java.util.ArrayList;
import java.util.Collections;

import com.danco.comparators.ServicePriceComparator;
import com.danco.models.Service;

public class ServiceStorage {

	private final String SERVICE_FORMAT = "Service: %s , price: %d \n";

	// singleton
	private static ServiceStorage instance;

	public static ServiceStorage getInstance() {
		if (instance == null) {
			instance = new ServiceStorage();
		}
		return instance;
	}

	ArrayList<Service> servises = new ArrayList<Service>();

	private ServiceStorage() {
	}

	// +Add service to array servises
	public void addServices(Service service) {
		servises.add(service);
	}

	// +change price of selected service
	public void changePriceOfService(Service service, int price) {
		service.setPrice(price);
	}

	// TODO returnStatement
	// + sorted by price
	public void showPriceServices() {
		Collections.sort(servises, new ServicePriceComparator());
		StringBuilder sb = new StringBuilder(40);
		for (Service s : servises) {
			sb.append(String.format(SERVICE_FORMAT, s.getNameOfService(),
					s.getPrice()));

		}
		System.out.println(sb);
	}
}
