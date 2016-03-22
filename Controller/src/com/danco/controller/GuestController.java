package com.danco.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Guest;
import com.danco.model.Service;
import com.danco.servise.api.IGuestService;
import com.danco.servise.api.IServiceService;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestController.
 */
public class GuestController {

	/** The guest service. */
	private IGuestService guestService = (IGuestService) DependencyInjectionManager
			.getClassInstance(IGuestService.class);

	/** The service service. */
	private IServiceService serviceService = (IServiceService) DependencyInjectionManager
			.getClassInstance(IServiceService.class);

	/** The Constant ALL_GUEST_NUMB_FORMAT. */
	private static final String ALL_GUEST_NUMB_FORMAT = "All guest number is: %d";

	/** The Constant SUMM_TO_PAID_FORMAT. */
	private static final String SUMM_TO_PAID_FORMAT = "Summ to paid is: %d";

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "dd-MM-yyyy";

	/** The Constant DF. */
	private static final DateFormat DF = new SimpleDateFormat(DATE_FORMAT);

	/** The Constant GUEST_FORMAT. */
	private static final String GUEST_FORMAT = "Guest: %s , room: %s , date of departure: %s \n";

	/** The Constant SERVICE_FORMAT. */
	private static final String SERVICE_FORMAT = "service : %s, price: %d, date: %s \n";

	/**
	 * Adds the guest.
	 *
	 * @param userInputGuestName the user input guest name
	 */
	public void addGuest(String userInputGuestName) {

		Guest g = guestService.createGuest(userInputGuestName);

		guestService.addGuest(g);
	}

	/**
	 * Show all guest number.
	 *
	 * @return the string
	 */

	public String showAllGuestNumber() {
		int number = guestService.showAllGuestNumber();
		return String.format(ALL_GUEST_NUMB_FORMAT, number);
	}

	/**
	 * Show summ to paid guest.
	 *
	 * @param userInputGuestName the user input guest name
	 * @return the string
	 */

	public String showSummToPaidGuest(String userInputGuestName) {

		Guest g = guestService.getGuestByName(userInputGuestName);

		int summ = guestService.showSummToPaidGuest(g);

		return String.format(SUMM_TO_PAID_FORMAT, summ);
	}

	/**
	 * Show all guests.
	 *
	 * @param userInputSortCondition the user input sort condition
	 * @return the string
	 */

	public String showAllGuests(String userInputSortCondition) {

		StringBuilder sb = new StringBuilder(500);

		List<Guest> allSortedGuests = guestService
				.showAllGuests(userInputSortCondition);

		for (Guest s : allSortedGuests) {
			sb.append(String.format(GUEST_FORMAT, s.getName(),
					s.getNumberOfRoom(), DF.format(s.getDateOfDeparture())));
		}
		return sb.toString();
		// }
	}

	/**
	 * Show list of service.
	 *
	 * @param userInputGuestName the user input guest name
	 * @param userInputSortCondition the user input sort condition
	 * @return the string
	 */

	public String showListOfService(String userInputGuestName,
			String userInputSortCondition) {
		StringBuilder sb = new StringBuilder(500);
		sb.append("");

		Guest g = guestService.getGuestByName(userInputGuestName);

		List<Service> sortedListOfService = guestService.showListOfService(g,
				userInputSortCondition);

		sb.append(g.getName() + ":" + "\n");
	
		for (Service c : sortedListOfService) {
			sb.append(String.format(SERVICE_FORMAT, c.getNameOfService(),
					c.getPrice(), DF.format(c.getDate())));
		}
		// }
		return sb.toString();
	}

	/**
	 * Adds the service to guest.
	 *
	 * @param userInputGuestName the user input guest name
	 * @param userInputService the user input service
	 */
	public void addServiceToGuest(String userInputGuestName,
			String userInputService) {
		
		Guest g = guestService.getGuestByName(userInputGuestName);
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
