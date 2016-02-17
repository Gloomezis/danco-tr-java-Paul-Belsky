package com.danco.controller;

import java.util.List;

import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Service;
import com.danco.servise.api.IServiceService;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceController.
 */
public class ServiceController {

	/** The service service. */
	private IServiceService serviceService = (IServiceService) DependencyInjectionManager
			.getClassInstance(IServiceService.class);

	/** The Constant SERVICE_FORMAT. */
	private final static String SERVICE_FORMAT = "Service: %s , price: %d \n";

	/**
	 * Adds the services.
	 *
	 * @param userInputServiceName the user input service name
	 * @param userInputPrice the user input price
	 */

	public void addServices(String userInputServiceName, int userInputPrice) {

		Service service = serviceService.createService(userInputServiceName,
				userInputPrice);

		serviceService.addServices(service);
	}

	/**
	 * Show price service.
	 *
	 * @return the string
	 */

	public String showPriceService() {

		List<Service> sortedService = serviceService.showPriceService();
		StringBuilder sb = new StringBuilder(40);
		for (Service s : sortedService) {
			sb.append(String.format(SERVICE_FORMAT, s.getNameOfService(),
					s.getPrice()));
		}
		return sb.toString();

	}

	/**
	 * Change price of service.
	 *
	 * @param userInputServiceName the user input service name
	 * @param userInputPrice the user input price
	 */

	public synchronized void changePriceOfService(String userInputServiceName,
			int userInputPrice) {

		Service serv = serviceService.getServiceByName(userInputServiceName);

		serviceService.changePriceOfService(serv, userInputPrice);

	}

}
