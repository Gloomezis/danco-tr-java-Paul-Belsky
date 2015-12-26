package com.danco.comparators;

import java.util.Comparator;

import com.danco.models.HotelRoom;

public class HotelRoomSleepingNumberComparator implements Comparator<HotelRoom> {

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
