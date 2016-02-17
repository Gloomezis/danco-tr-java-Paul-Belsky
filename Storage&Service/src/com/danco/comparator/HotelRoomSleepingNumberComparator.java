package com.danco.comparator;

import java.util.Comparator;

import com.danco.model.HotelRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomSleepingNumberComparator.
 */
public class HotelRoomSleepingNumberComparator implements Comparator<HotelRoom> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(HotelRoom hotelRoom1, HotelRoom hotelRoom2) {

		int sleepNumbers1 = hotelRoom1.getSleepingNumbers();
		int sleepNumbers2 = hotelRoom2.getSleepingNumbers();

		if (sleepNumbers1 > sleepNumbers2) {
			return 1;
		} else if (sleepNumbers1 < sleepNumbers2) {
			return -1;
		}
		return 0;

	}
}
