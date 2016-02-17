package com.danco.controller;

import com.danco.anotation.IPrintableAnalizer;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Guest;
import com.danco.model.HotelRoom;
import com.danco.model.Service;
import com.danco.servise.api.IGuestService;
import com.danco.servise.api.IHotelRoomService;
import com.danco.servise.api.IServiceService;

// TODO: Auto-generated Javadoc
/**
 * The Class AnotationController.
 */
public class AnotationController {

	/** The printable analizer. */
	private IPrintableAnalizer printableAnalizer = (IPrintableAnalizer) DependencyInjectionManager
			.getClassInstance(IPrintableAnalizer.class);

	/** The guest service. */
	private IGuestService guestService = (IGuestService) DependencyInjectionManager
			.getClassInstance(IGuestService.class);

	/** The hotel room service. */
	private IHotelRoomService hotelRoomService = (IHotelRoomService) DependencyInjectionManager
			.getClassInstance(IHotelRoomService.class);

	/** The service service. */
	private IServiceService serviceService = (IServiceService) DependencyInjectionManager
			.getClassInstance(IServiceService.class);

	/**
	 * Show guest reflected object info detailed.
	 */
	public String showGuestReflectedObjectInfoDetailed(String userInputGuestName) {

		Guest g = guestService.getGuestByName(userInputGuestName);

		return printableAnalizer.printDetaildeView(g);
	}

	/**
	 * Show guest reflected object info short.
	 */
	public String showGuestReflectedObjectInfoShort(String userInputGuestName) {

		Guest g = guestService.getGuestByName(userInputGuestName);

		return printableAnalizer.printShortView(g);
	}

	/**
	 * Show hotel room reflected object info detailed.
	 */
	public String showHotelRoomReflectedObjectInfoDetailed(
			String userInputHotelRoomNumber) {

		HotelRoom hr = hotelRoomService
				.getHotelRoomByNumber(userInputHotelRoomNumber);

		return printableAnalizer.printDetaildeView(hr);
	}

	/**
	 * Show hotel room reflected object info short.
	 */
	public String showHotelRoomReflectedObjectInfoShort(
			String userInputHotelRoomNumber) {

		HotelRoom hr = hotelRoomService
				.getHotelRoomByNumber(userInputHotelRoomNumber);

		return printableAnalizer.printShortView(hr);
	}

	/**
	 * Show service reflected object info detailed.
	 */
	public String showServiceReflectedObjectInfoDetailed(
			String userInputServiceName) {

		Service serv = serviceService.getServiceByName(userInputServiceName);

		return printableAnalizer.printDetaildeView(serv);
	}

	/**
	 * Show service reflected object info short.
	 *
	 * @param userInputServiceName
	 *            the user input service name
	 * @return the string
	 */
	public String showServiceReflectedObjectInfoShort(
			String userInputServiceName) {

		Service serv = serviceService.getServiceByName(userInputServiceName);

		return printableAnalizer.printShortView(serv);
	}

}
