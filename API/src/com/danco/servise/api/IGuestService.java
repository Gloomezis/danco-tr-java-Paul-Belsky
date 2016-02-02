package com.danco.servise.api;

import java.util.List;

import com.danco.model.Guest;
import com.danco.model.Service;

public interface IGuestService {

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService#createGuest(java.lang.String)
	 */
	public Guest createGuest(String name);

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService#getGuestByName(java.lang.String)
	 */
	public Guest getGuestByName(String NameOfGuest);

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService#addGuest(com.danco.model.Guest)
	 */
	public void addGuest(Guest guest);

	public int showAllGuestNumber();

	public int showSummToPaidGuest(Guest guest);

	public List<Guest> showAllGuests(String a);

	public List<Service> showListOfService(Guest guest, String sortCondition);

	public void addServiceToGuest(Guest guest, Service service);

	public List<Guest> getAllGuests();

}