package com.danco.comparators;

import java.util.Comparator;

import com.danco.models.Guest;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestNameComparator.
 */
public class GuestNameComparator implements Comparator<Guest> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Guest guest1, Guest guest2) {
		return guest1.getName().compareTo(guest2.getName());

	}

}
