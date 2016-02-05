package com.danco.controller;

import java.util.List;

import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Service;
import com.danco.servise.api.IServiceService;
import com.danco.utils.IInputManager;
import com.danco.utils.IPrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceController.
 */
public class ServiceController {
	
	/** The input manager. */
	private IInputManager inputManager = (IInputManager)DependencyInjectionManager.getClassInstance(IInputManager.class);

	/** The service service. */
	private IServiceService serviceService = (IServiceService)DependencyInjectionManager.getClassInstance(IServiceService.class);

	/** The print util. */
	private IPrintUtil printUtil = (IPrintUtil)DependencyInjectionManager.getClassInstance(IPrintUtil.class);

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
	 */

	public void addServices() {

		printUtil.printString(SERVICES_INPUT_MESSAGE);
		String userInputServiceName = inputManager.userInputString();

		printUtil.printString(PRICE_INPUT_MESSAGE);
		int userInputPrice = inputManager.userInputInt();

		Service service = serviceService.createService(userInputServiceName, userInputPrice);

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
	 */

	public void changePriceOfService() {

		printUtil.printString(SERVICES_INPUT_MESSAGE);

		String userInputServiceName = inputManager.userInputString();

		printUtil.printString(PRICE_INPUT_MESSAGE1);

		int userInputPrice = inputManager.userInputInt();

		Service serv = serviceService.getServiceByName(userInputServiceName);

		serviceService.changePriceOfService(serv, userInputPrice);

	}

}
