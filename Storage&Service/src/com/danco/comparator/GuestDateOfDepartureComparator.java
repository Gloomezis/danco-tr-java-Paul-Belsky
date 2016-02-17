package com.danco.comparator;

import java.util.Comparator;
import java.util.Date;

import com.danco.model.Guest;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestDateOfDepartureComparator.
 */
public class GuestDateOfDepartureComparator implements Comparator<Guest> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Guest p, Guest q) {

		Date pDate = p.getDateOfDeparture();
		Date qDate = q.getDateOfDeparture();

		return pDate.compareTo(qDate);
	}
}
