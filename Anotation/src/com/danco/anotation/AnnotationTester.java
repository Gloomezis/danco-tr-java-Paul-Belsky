package com.danco.anotation;

import com.danco.model.Guest;
import com.danco.model.HotelRoom;
import com.danco.model.Service;

public class AnnotationTester {

	public static void main(String[] args) {
		
		//    убрать зависимость от модуля модель
		Guest guest = new Guest("Pegi");
		HotelRoom hotelRoom = new HotelRoom("1000", 10, 5, 1);
	    Service service = new Service(99, "Diner");
	    PrintableAnalizer printableAnalizer = new PrintableAnalizer();
	    printableAnalizer.analizeEntityAndPrint(guest);
	    printableAnalizer.analizeEntityAndPrint(hotelRoom);
	    printableAnalizer.analizeEntityAndPrint(service);

	}

}
