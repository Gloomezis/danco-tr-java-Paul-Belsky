package com.danco.comparator;

import java.util.Comparator;

import com.danco.model.HotelRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomPriceComparator.
 */
public class HotelRoomPriceComparator implements Comparator<HotelRoom> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
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
