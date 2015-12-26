package com.danco.comparators;

import java.util.Comparator;

import com.danco.models.HotelRoom;

public class HotelRoomPriceComparator implements Comparator<HotelRoom> {

	@Override
	public int compare(HotelRoom hotelRoom1, HotelRoom hotelRoom2) {

		int price1 = hotelRoom1.getRoomPrice();
		int price2 = hotelRoom2.getRoomPrice();

		if (price1 > price2) {
			return 1;
		} else if (price1 < price2) {
			return -1;
		}
		return 0;

	}
}
