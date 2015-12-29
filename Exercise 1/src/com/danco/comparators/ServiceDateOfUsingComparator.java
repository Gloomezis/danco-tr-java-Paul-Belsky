package com.danco.comparators;

import java.util.Comparator;
import java.util.Date;

import com.danco.models.Service;

public class ServiceDateOfUsingComparator implements Comparator<Service> {

	

	public int compare(Service p, Service q) {

		
		Date Pdate = p.getDate();
		Date Qdate = q.getDate();
		
		return Pdate.compareTo(Qdate);
	}

}
