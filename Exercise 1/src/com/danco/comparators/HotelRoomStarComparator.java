package com.danco.comparators;

import java.util.Comparator;

import com.danco.models.HotelRoom;

public class HotelRoomStarComparator implements Comparator<HotelRoom> {

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
