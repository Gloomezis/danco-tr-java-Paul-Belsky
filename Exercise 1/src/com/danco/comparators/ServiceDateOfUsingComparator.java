package com.danco.comparators;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.danco.models.Service;

public class ServiceDateOfUsingComparator implements Comparator<Service> {

	private String DATE_FORMAT = "dd-MM-yyyy";

	public int compare(Service p, Service q) {

		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		Date Pdate = null;
		Date Qdate = null;
		try {
			Pdate = df.parse(p.getDate());
			Qdate = df.parse(q.getDate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Pdate.compareTo(Qdate);
	}

}
