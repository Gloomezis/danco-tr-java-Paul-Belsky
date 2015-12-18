package com.danco.storages;

import java.util.ArrayList;

import com.danco.models.Service;

public class ServiceStorage {
	
	ArrayList<Service> servises= new ArrayList<Service>();
	
	//singleton
		private static volatile ServiceStorage instance;
		
		private  ServiceStorage() {}
		public static ServiceStorage getInstance(){
			if (instance ==null){
				synchronized (ServiceStorage.class) {
					if(instance == null){
						instance = new ServiceStorage();
					}
					
				}
			}
			return instance;
		}
	
	
	//TODO  get array of servises  
	public ArrayList<Service> getServises() {
		return servises;
	}

	// Add service to array servises
	public void setServices(Service service) {
		servises.add(service);
	}
	
	// TODO sorted by price
		public void showPriceService() {

		}

}
