package com.danco.comparator;

import java.util.Comparator;

import com.danco.model.HotelRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomStarComparator.
 */
public class HotelRoomStarComparator implements Comparator<HotelRoom> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(HotelRoom hotelRoom1, HotelRoom hotelRoom2) {

		int star1 = hotelRoom1.getStarCategory();
		int star2 = hotelRoom2.getStarCategory();

		if (star1 > star2) {
			return 1;
		} else if (star1 < star2) {
			return -1;
		}
		return 0;

	}
}
