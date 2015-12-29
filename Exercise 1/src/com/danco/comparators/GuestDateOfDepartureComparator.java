package com.danco.comparators;

import java.util.Comparator;
import java.util.Date;

import com.danco.models.Guest;

public class GuestDateOfDepartureComparator implements Comparator<Guest> {

	

	public int compare(Guest p, Guest q) {

		
		Date Pdate = p.getDateOfDeparture();
		Date Qdate = q.getDateOfDeparture();


		return Pdate.compareTo(Qdate);
	}
}
