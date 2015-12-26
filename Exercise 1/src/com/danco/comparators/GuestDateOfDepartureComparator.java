package com.danco.comparators;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.danco.models.Guest;

public class GuestDateOfDepartureComparator implements Comparator<Guest> {
	
	private String DATE_FORMAT="dd-MM-yyyy";
	

		public int compare(Guest p, Guest q) {

			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			Date Pdate = null;
			Date Qdate = null;
			try {
				Pdate = df.parse(p.getDateOfDeparture());
				Qdate = df.parse(q.getDateOfDeparture());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return Pdate.compareTo(Qdate);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


