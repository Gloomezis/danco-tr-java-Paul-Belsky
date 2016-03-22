package com.danco.comparator;

import java.util.Comparator;
import java.util.Date;

import com.danco.model.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceDateOfUsingComparator.
 */
public class ServiceDateOfUsingComparator implements Comparator<Service> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Service p, Service q) {

		Date pDate = p.getDate();
		Date qDate = q.getDate();

		return pDate.compareTo(qDate);
	}

}
