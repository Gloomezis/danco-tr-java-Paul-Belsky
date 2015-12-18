package com.danco.gloomezis;

import com.danco.servises.GuestService;
import com.danco.servises.HotelRoomService;
import com.danco.servises.ServiceService;
import com.danco.storages.GuestStorage;

//for get method mb use only printLn to console overwriting return tupe

public class Hotel {
	
	
	GuestService guestService = GuestService.getInstance();
	HotelRoomService hotelRoomService=HotelRoomService.getInstance();
	ServiceService serviceService = ServiceService.getInstance();
			
	
	//singleton
		private static volatile Hotel instance;
		
		private  Hotel() {}
		public static Hotel getInstance(){
			if (instance ==null){
				synchronized (Hotel.class) {
					if(instance == null){
						instance = new Hotel();
					}
					
				}
			}
			return instance;
		}
			
		

	// TODO sorted by price and category
	public void showPriceServiceAndHotelRoom() {
		hotelRoomService.showPriceHotelRoom();
		serviceService.showPriceServices();

	}

}
