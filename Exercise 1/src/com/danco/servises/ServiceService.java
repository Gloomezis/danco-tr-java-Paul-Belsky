package com.danco.servises;

import java.util.ArrayList;

import com.danco.models.Service;
import com.danco.storages.ServiceStorage;

public class ServiceService {
	
	
	//singleton
		private static volatile ServiceService instance;
		
		private  ServiceService() {}
		public static ServiceService getInstance(){
			if (instance ==null){
				synchronized (ServiceService.class) {
					if(instance == null){
						instance = new ServiceService();
					}
					
				}
			}
			return instance;
		}
		

	ServiceStorage serviceStorage = ServiceStorage.getInstance();
	
	//TODO  get array of servises  
		public ArrayList<Service> getServises() {
			return serviceStorage.getServises();
		}

		// Add service to array servises
		public void setServices(Service service) {
			serviceStorage.getServises().add(service);
		}
		
		public void showPriceServices() {
			serviceStorage.showPriceService();
		}
}
