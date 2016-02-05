package com.danco.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Guest;
import com.danco.model.Service;
import com.danco.servise.api.IGuestService;
import com.danco.servise.api.IServiceService;
import com.danco.utils.IInputManager;
import com.danco.utils.IPrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestController.
 */
public class GuestController {

	/** The main storage. */
	private IGuestService guestService = (IGuestService)DependencyInjectionManager.getClassInstance(IGuestService.class);

	/** The print util. */
	private IPrintUtil printUtil = (IPrintUtil)DependencyInjectionManager.getClassInstance(IPrintUtil.class);
	
	/** The input manager. */
	private IInputManager inputManager = (IInputManager)DependencyInjectionManager.getClassInstance(IInputManager.class);
	
	/** The service service. */
	private IServiceService serviceService = (IServiceService)DependencyInjectionManager.getClassInstance(IServiceService.class);

	/** The Constant GUEST_INPUT_MESSAGE. */
	private static final String GUEST_INPUT_MESSAGE = "Enter Guest Name";

	/** The Constant SERVICE_INPUT_MESSAGE. */
	private static final String SERVICE_INPUT_MESSAGE = "Enter Service Name";

	/** The Constant SORT_INPUT_MESSAGE. */
	private static final String SORT_INPUT_MESSAGE = "Enter room sort condition : alphabet/date";

	/** The Constant SORT_INPUT_MESSAGE. */
	private static final String SORT_INPUT_MESSAGE1 = "Enter room sort condition : date/price";

	/** The Constant ALL_GUEST_NUMB_FORMAT. */
	private static final String ALL_GUEST_NUMB_FORMAT = "All guest number is: %d";

	/** The Constant SUMM_TO_PAID_FORMAT. */
	private static final String SUMM_TO_PAID_FORMAT = "Summ to paid is: %d";

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "dd-MM-yyyy";

	/** The df. */
	private static final DateFormat DF = new SimpleDateFormat(DATE_FORMAT);

	/** The Constant GUEST_FORMAT. */
	private static final String GUEST_FORMAT = "Guest: %s , room: %s , date of departure: %s \n";

	/** The Constant SERVICE_FORMAT. */
	private static final String SERVICE_FORMAT = "service : %s, price: %d, date: %s ";

	// ** The Constant WRONG_SORT_CONDITION. */
	// private static final String WRONG_SORT_CONDITION = "wrong sorted
	// condition";

	/**
	 * Adds the guest.
	 */
	public void addGuest() {

		printUtil.printString(GUEST_INPUT_MESSAGE);

		String userInputGuestName = inputManager.userInputString();
		Guest g = guestService.createGuest(userInputGuestName);

		guestService.addGuest(g);
	}
	
	
	
	
	
	
	

	/**
	 * Show all guest number.
	 * 
	 */
	

	public void showAllGuestNumber() {
		int number = guestService.showAllGuestNumber();
		printUtil.printString(String.format(ALL_GUEST_NUMB_FORMAT, number));
	}

	/**
	 * Show summ to paid guest.
	 */

	public void showSummToPaidGuest() {

		printUtil.printString(GUEST_INPUT_MESSAGE);

		String userInputGuestName = inputManager.userInputString();
		Guest g = guestService.getGuestByName(userInputGuestName);

		int summ = guestService.showSummToPaidGuest(g);

		printUtil.printString(String.format(SUMM_TO_PAID_FORMAT, summ));
	}

	/**
	 * Show all guests.
	 */

	public void showAllGuests() {
		printUtil.printString(SORT_INPUT_MESSAGE);
		StringBuilder sb = new StringBuilder(500);
		String userInputSortCondition = inputManager.userInputString();
		List<Guest> allSortedGuests = guestService.showAllGuests(userInputSortCondition);

		// TODO проверка возврата нуля
		// if (allSortedGuests.isEmpty()) {
		// sb.append(WRONG_SORT_CONDITION);
		// } else {
		for (Guest s : allSortedGuests) {
			sb.append(String.format(GUEST_FORMAT, s.getName(), s.getNumberOfRoom(), DF.format(s.getDateOfDeparture())));
		}
		printUtil.printString(sb.toString());
		// }
	}

	/**
	 * Show list of service.
	 */

	public void showListOfService() {
		StringBuilder sb = new StringBuilder(500);
		sb.append("");
		printUtil.printString(GUEST_INPUT_MESSAGE);

		String userInputGuestName = inputManager.userInputString();
		Guest g = guestService.getGuestByName(userInputGuestName);

		printUtil.printString(SORT_INPUT_MESSAGE1);

		String userInputSortCondition = inputManager.userInputString();

		List<Service> sortedListOfService = guestService.showListOfService(g, userInputSortCondition);

		printUtil.printString(g.getName() + ":");
		// System.out.println(WRONG_SORT_CONDITION);
		// if (sortedListOfService.isEmpty()) {
		// sb.append(WRONG_SORT_CONDITION);
		// } else {

		for (Service c : sortedListOfService) {
			sb.append(String.format(SERVICE_FORMAT, c.getNameOfService(), c.getPrice(), DF.format(c.getDate())));
		}
		// }
	}

	/**
	 * Adds the service to guest.
	 */

	public void addServiceToGuest() {

		printUtil.printString(GUEST_INPUT_MESSAGE);
		String userInputGuest = inputManager.userInputString();
		Guest g = guestService.getGuestByName(userInputGuest);

		printUtil.printString(SERVICE_INPUT_MESSAGE);
		String userInputService = inputManager.userInputString();
		Service s = serviceService.getServiceByName(userInputService);

		guestService.addServiceToGuest(g, s);

	}

	/**
	 * Gets the all guests.
	 *
	 * @return the all guests
	 */

	public void getAllGuests() {
		guestService.getAllGuests();
	}

}
