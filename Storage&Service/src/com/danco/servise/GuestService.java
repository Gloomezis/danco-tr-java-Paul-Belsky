package com.danco.servise;

import java.util.List;

import org.apache.log4j.Logger;

import com.danco.model.Guest;
import com.danco.model.Service;
import com.danco.servise.api.IGuestService;
import com.danco.storages.MainStorage;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestService.
 */
public class GuestService implements  IGuestService{

	/** The main storage. */
	private MainStorage mainStorage = MainStorage.getInstance();

	private final Logger LOG1 = Logger.getLogger(GuestService.class.getName());

	//private static GuestService instance;
	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";
	
	
	/**
	 * Instantiates a new guest service.
	 */
//	public GuestService() {
//	}
	//public static GuestService getInstance() {
	//	if (instance == null) {
	//		instance = new GuestService();
	//	}
	//	return instance;
	//}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService#createGuest(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService1#createGuest(java.lang.String)
	 */
	
	@Override
	public Guest createGuest(String name) {

		try {
			return mainStorage.createGuest(name);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			return null;
		}

	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService#getGuestByName(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService1#getGuestByName(java.lang.String)
	 */
	
	@Override
	public Guest getGuestByName(String NameOfGuest) {

		try {
			return mainStorage.getGuestByName(NameOfGuest);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			return null;
		}

	}

	

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService#addGuest(com.danco.model.Guest)
	 */
	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService1#addGuest(com.danco.model.Guest)
	 */
	
	@Override
	public void addGuest(Guest guest) {
		try {
			mainStorage.addGuest(guest);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService#showAllGuestNumber()
	 */

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService1#showAllGuestNumber()
	 */
	
	@Override
	public int showAllGuestNumber() {
		try {
			return mainStorage.showAllGuestNumber();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService#showSummToPaidGuest(com.danco.model.Guest)
	 */

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService1#showSummToPaidGuest(com.danco.model.Guest)
	 */
	
	@Override
	public int showSummToPaidGuest(Guest guest) {
		try {
			return mainStorage.showSummToPaidGuest(guest);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService#showAllGuests(java.lang.String)
	 */

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService1#showAllGuests(java.lang.String)
	 */
	
	@Override
	public List<Guest>   showAllGuests(String a) {
		try {
			return	mainStorage.showAllGuests(a);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			//thinking
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService#showListOfService(com.danco.model.Guest, java.lang.String)
	 */

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService1#showListOfService(com.danco.model.Guest, java.lang.String)
	 */
	
	@Override
	public List<Service> showListOfService(Guest guest, String sortCondition) {
		try {
		return	mainStorage.showListOfService(guest, sortCondition);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
        return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService#addServiceToGuest(com.danco.model.Guest, com.danco.model.Service)
	 */

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService1#addServiceToGuest(com.danco.model.Guest, com.danco.model.Service)
	 */
	@Override

	public void addServiceToGuest(Guest guest, Service service) {
		try {

			mainStorage.addServiceToGuest(guest, service);

		} catch (Exception e) {
			// nullpointexc
			LOG1.error(EXCEPTION, e);

		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService#getAllGuests()
	 */

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IGuestService1#getAllGuests()
	 */
	
	@Override
	public List<Guest> getAllGuests() {
		List<Guest> guest = null;
		try {
			guest = mainStorage.getAllGuests();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}
		return guest;
	}
}
