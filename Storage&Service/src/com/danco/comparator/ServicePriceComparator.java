package com.danco.comparator;

import java.util.Comparator;

import com.danco.model.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicePriceComparator.
 */
public class ServicePriceComparator implements Comparator<Service> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Service service1, Service service2) {

		int price1 = service1.getPrice();
		int price2 = service2.getPrice();

		if (price1 > price2) {
			return 1;
		} else if (price1 < price2) {
			return -1;
		}
		return 0;

	}
}
