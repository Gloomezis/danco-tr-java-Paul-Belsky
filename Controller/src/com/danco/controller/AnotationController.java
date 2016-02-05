package com.danco.controller;

import com.danco.anotation.IPrintableAnalizer;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Guest;
import com.danco.model.HotelRoom;
import com.danco.model.Service;
import com.danco.servise.api.IGuestService;
import com.danco.servise.api.IHotelRoomService;
import com.danco.servise.api.IServiceService;
import com.danco.utils.IInputManager;
import com.danco.utils.IPrintUtil;

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
	
	/** The print util. */
	private IPrintUtil printUtil = (IPrintUtil)DependencyInjectionManager.getClassInstance(IPrintUtil.class);

	/** The input manager. */
	private IInputManager inputManager = (IInputManager)DependencyInjectionManager.getClassInstance(IInputManager.class);
	
	/** The Constant GUEST_INPUT_MESSAGE. */
	private static final String GUEST_INPUT_MESSAGE = "Enter Guest Name";
	
	/** The Constant HOTEL_ROOM_INPUT_MESSAGE. */
	private static final String HOTEL_ROOM_INPUT_MESSAGE = "Enter hotel room number";
	
	/** The Constant SERVICES_INPUT_MESSAGE. */
	private static final String SERVICES_INPUT_MESSAGE = "Enter service name";
	
	/**
	 * Show guest reflected object info detailed.
	 */
	public void showGuestReflectedObjectInfoDetailed() {
		printUtil.printString(GUEST_INPUT_MESSAGE);

		String userInputGuestName = inputManager.userInputString();
		Guest g = guestService.getGuestByName(userInputGuestName);
		
		
		printUtil.printString(printableAnalizer.printDetaildeView(g));
	}

	/**
	 * Show guest reflected object info short.
	 */
	public void showGuestReflectedObjectInfoShort() {
		printUtil.printString(GUEST_INPUT_MESSAGE);

		String userInputGuestName = inputManager.userInputString();
		Guest g = guestService.getGuestByName(userInputGuestName);
		
		printUtil.printString( printableAnalizer.printShortView(g));
	}

	/**
	 * Show hotel room reflected object info detailed.
	 */
	public void showHotelRoomReflectedObjectInfoDetailed() {
		
		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);

		String userInputHotelRoomNumber = inputManager.userInputString();
		
		HotelRoom hr = hotelRoomService.getHotelRoomByNumber(userInputHotelRoomNumber);
		
		printUtil.printString(printableAnalizer.printDetaildeView(hr));
	}

	/**
	 * Show hotel room reflected object info short.
	 */
	public void showHotelRoomReflectedObjectInfoShort() {
		
		printUtil.printString(HOTEL_ROOM_INPUT_MESSAGE);

		String userInputHotelRoomNumber = inputManager.userInputString();
		HotelRoom hr = hotelRoomService.getHotelRoomByNumber(userInputHotelRoomNumber);
		
		printUtil.printString(printableAnalizer.printShortView(hr));
	}

	/**
	 * Show service reflected object info detailed.
	 */
	public void showServiceReflectedObjectInfoDetailed() {
		
		printUtil.printString(SERVICES_INPUT_MESSAGE);

		String userInputServiceName = inputManager.userInputString();

		Service serv = serviceService.getServiceByName(userInputServiceName);
		
		printUtil.printString( printableAnalizer.printDetaildeView(serv));
	}

	/**
	 * Show service reflected object info short.
	 */
	public void showServiceReflectedObjectInfoShort() {
		
		printUtil.printString(SERVICES_INPUT_MESSAGE);

		String userInputServiceName = inputManager.userInputString();

		Service serv = serviceService.getServiceByName(userInputServiceName);
		printUtil.printString( printableAnalizer.printShortView(serv));
	}

}
