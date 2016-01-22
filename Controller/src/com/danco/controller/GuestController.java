package com.danco.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.danco.model.Guest;
import com.danco.model.Service;
import com.danco.serviñe.GuestService;
import com.danco.serviñe.ServiceService;
import com.danco.util.InputManager;
import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestController.
 */
public class GuestController {

	/** The main storage. */
	private GuestService guestService = GuestService.getInstance();

	private PrintUtil printUtil = new PrintUtil();

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

	//** The Constant WRONG_SORT_CONDITION. */
	//private static final String WRONG_SORT_CONDITION = "wrong sorted condition";


	/**
	 * Adds the guest.
	 *
	 * @param guest
	 *            the guest
	 */
	public void addGuest() {

		printUtil.printString(GUEST_INPUT_MESSAGE);

		String userInputGuestName = InputManager.getInstance().userInputString();
		Guest g = GuestService.getInstance().createGuest(userInputGuestName);

		guestService.addGuest(g);
	}

	/**
	 * Show all guest number.
	 */

	public void showAllGuestNumber() {
		int number = guestService.showAllGuestNumber();
		printUtil.printString(String.format(ALL_GUEST_NUMB_FORMAT, number));
	}

	/**
	 * Show summ to paid guest.
	 *
	 * @param guest
	 *            the guest
	 */

	public void showSummToPaidGuest() {

		printUtil.printString(GUEST_INPUT_MESSAGE);

		String userInputGuestName = InputManager.getInstance().userInputString();
		Guest g = GuestService.getInstance().getGuestByName(userInputGuestName);

		int summ = guestService.showSummToPaidGuest(g);

		printUtil.printString(String.format(SUMM_TO_PAID_FORMAT, summ));
	}

	/**
	 * Show all guests.
	 *
	 * @param a
	 *            the a
	 */

	public void showAllGuests() {
		printUtil.printString(SORT_INPUT_MESSAGE);
		StringBuilder sb = new StringBuilder(500);
		String userInputSortCondition = InputManager.getInstance().userInputString();
		List<Guest> allSortedGuests = guestService.showAllGuests(userInputSortCondition);

		// TODO ïðîâåðêà âîçâðàòà íóëÿ
		//if (allSortedGuests.isEmpty()) {
		//	sb.append(WRONG_SORT_CONDITION);
		//} else {
			for (Guest s : allSortedGuests) {
				sb.append(String.format(GUEST_FORMAT, s.getName(), s.getNumberOfRoom(),
						DF.format(s.getDateOfDeparture())));
			}
			printUtil.printString(sb.toString());
		//}
	}

	/**
	 * Show list of service.
	 *
	 * @param guest
	 *            the guest
	 * @param sortCondition
	 *            the sort condition
	 */

	public void showListOfService() {
		StringBuilder sb = new StringBuilder(500);
       sb.append("");
		printUtil.printString(GUEST_INPUT_MESSAGE);

		String userInputGuestName = InputManager.getInstance().userInputString();
		Guest g = GuestService.getInstance().getGuestByName(userInputGuestName);

		printUtil.printString(SORT_INPUT_MESSAGE1);

		String userInputSortCondition = InputManager.getInstance().userInputString();

		List<Service> sortedListOfService = guestService.showListOfService(g, userInputSortCondition);

		printUtil.printString(g.getName() + ":");
		//System.out.println(WRONG_SORT_CONDITION);
		//if (sortedListOfService.isEmpty()) {
		//	sb.append(WRONG_SORT_CONDITION);
		//} else {

			for (Service c : sortedListOfService) {
				sb.append(String.format(SERVICE_FORMAT, c.getNameOfService(), c.getPrice(), DF.format(c.getDate())));
			}
	//	}
	}

	/**
	 * Adds the service to guest.
	 *
	 * @param guest
	 *            the guest
	 * @param service
	 *            the service
	 */

	public void addServiceToGuest() {

		printUtil.printString(GUEST_INPUT_MESSAGE);
		String userInputGuest = InputManager.getInstance().userInputString();
		Guest g = GuestService.getInstance().getGuestByName(userInputGuest);

		printUtil.printString(SERVICE_INPUT_MESSAGE);
		String userInputService = InputManager.getInstance().userInputString();
		Service s = ServiceService.getInstance().getServiceByName(userInputService);

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
