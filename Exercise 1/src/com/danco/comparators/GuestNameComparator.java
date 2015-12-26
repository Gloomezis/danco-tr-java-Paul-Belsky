package com.danco.comparators;

import java.util.Comparator;

import com.danco.models.Guest;

public class GuestNameComparator implements Comparator<Guest> {

	@Override
	public int compare(Guest guest1, Guest guest2) {
		return guest1.getName().compareTo(guest2.getName());

	}

}
