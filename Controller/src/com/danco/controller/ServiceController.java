package com.danco.controller;

import java.util.List;

import com.danco.model.Service;
import com.danco.serviñe.ServiceService;
import com.danco.util.InputManager;
import com.danco.util.PrintUtil;

public class ServiceController {

	/** The hotel room service. */
	private ServiceService serviceService = ServiceService.getInstance();

	private PrintUtil printUtil = new PrintUtil();

	/** The Constant SERVICES_INPUT_MESSAGE. */
	private static final String SERVICES_INPUT_MESSAGE = "Enter service name";

	/** The Constant PRICE_INPUT_MESSAGE. */
	private static final String PRICE_INPUT_MESSAGE = "Enter service price";

	/** The Constant PRICE_INPUT_MESSAGE. */
	private static final String PRICE_INPUT_MESSAGE1 = "Enter new price";

	/** The Constant SERVICE_FORMAT. */
	private final static String SERVICE_FORMAT = "Service: %s , price: %d \n";

	/**
	 * Adds the services.
	 *
	 * @param service
	 *            the service
	 */

	public void addServices() {

		printUtil.printString(SERVICES_INPUT_MESSAGE);
		String userInputServiceName = InputManager.getInstance().userInputString();

		printUtil.printString(PRICE_INPUT_MESSAGE);
		int userInputPrice = InputManager.getInstance().userInputInt();

		Service service = ServiceService.getInstance().createService(userInputServiceName, userInputPrice);

		serviceService.addServices(service);
	}

	/**
	 * Show price services.
	 */

	public void showPriceService() {

		List<Service> sortedService = serviceService.showPriceService();
		StringBuilder sb = new StringBuilder(40);
		for (Service s : sortedService) {
			sb.append(String.format(SERVICE_FORMAT, s.getNameOfService(), s.getPrice()));

		}
		printUtil.printString(sb.toString());

	}

	/**
	 * Change price of service.
	 *
	 * @param service
	 *            the service
	 * @param price
	 *            the price
	 */

	public void changePriceOfService() {

		printUtil.printString(SERVICES_INPUT_MESSAGE);

		String userInputServiceName = InputManager.getInstance().userInputString();

		printUtil.printString(PRICE_INPUT_MESSAGE1);

		int userInputPrice = InputManager.getInstance().userInputInt();

		Service serv = ServiceService.getInstance().getServiceByName(userInputServiceName);

		serviceService.changePriceOfService(serv, userInputPrice);

	}

}
