package com.danco.controller;

import java.util.Date;

import com.danco.controller.api.IImportExportCsvController;
import com.danco.controller.api.IMainController;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;

// TODO: Auto-generated Javadoc
/**
 * The Class MainController.
 */
public class MainController implements IMainController {

	/** The hotel room controller. */
	private GuestController guestController = new GuestController();

	/** The hotel room controller. */
	private HotelRoomController hotelRoomController = new HotelRoomController();

	/** The service controller. */
	private ServiceController serviceController = new ServiceController();

	/** The anotation controller. */
	private AnotationController anotationController = new AnotationController();

	/** The import export csv controller. */
	private IImportExportCsvController importExportCsvController = (IImportExportCsvController) DependencyInjectionManager
			.getClassInstance(IImportExportCsvController.class);

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#addGuest(java.lang.String)
	 */
	@Override
	public void addGuest(String userInputGuestName) {
		guestController.addGuest(userInputGuestName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showAllGuestNumber()
	 */
	@Override
	public String showAllGuestNumber() {
		return guestController.showAllGuestNumber();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showSummToPaidGuest()
	 */
	@Override
	public String showSummToPaidGuest(String userInputGuestName) {
		return guestController.showSummToPaidGuest(userInputGuestName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showAllGuests()
	 */
	@Override
	public String showAllGuests(String userInputSortCondition) {
		return guestController.showAllGuests(userInputSortCondition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showListOfService()
	 */
	@Override
	public String showListOfService(String userInputGuestName,
			String userInputSortCondition) {
		return guestController.showListOfService(userInputGuestName,
				userInputSortCondition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#addServiceToGuest()
	 */
	@Override
	public void addServiceToGuest(String userInputGuestName,
			String userInputService) {
		guestController.addServiceToGuest(userInputGuestName, userInputService);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#getAllGuests()
	 */

	@Override
	public void getAllGuests() {
		guestController.getAllGuests();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showAllRooms()
	 */

	@Override
	public String showAllRooms(String userInputSortCondition) {
		return hotelRoomController.showAllRooms(userInputSortCondition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showAllFreeRooms()
	 */
	@Override
	public String showAllFreeRooms(String userInputSortCondition) {
		return hotelRoomController.showAllFreeRooms(userInputSortCondition);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showFreeRomsAfterDate()
	 */

	@Override
	public String showFreeRomsAfterDate(String userInputSortCondition, Date date) {
		return hotelRoomController.showFreeRomsAfterDate(
				userInputSortCondition, date);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showNumberOfFreeHotelRooms()
	 */

	@Override
	public String showNumberOfFreeHotelRooms() {
		return hotelRoomController.showNumberOfFreeHotelRooms();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showLast3GuestOfHotelRoom()
	 */

	@Override
	public String showLast3GuestOfHotelRoom(String userInputHotelRoomNumber) {
		return hotelRoomController
				.showLast3GuestOfHotelRoom(userInputHotelRoomNumber);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showDetailOfHotelRoom()
	 */

	@Override
	public String showDetailOfHotelRoom(String userInputHotelRoomNumber) {
		return hotelRoomController
				.showDetailOfHotelRoom(userInputHotelRoomNumber);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#settleGuestToHotelRoom()
	 */

	@Override
	public void settleGuestToHotelRoom(String userInputGuestName,
			String userInputHotelRoomNumber, Date userinpitDateOfArrive,
			Date userInputDateOfDeparture) {
		hotelRoomController.settleGuestToHotelRoom(userInputGuestName,
				userInputHotelRoomNumber, userinpitDateOfArrive,
				userInputDateOfDeparture);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#departGuestFromHotelRoom()
	 */

	@Override
	public void departGuestFromHotelRoom(String userInputHotelRoomName) {
		hotelRoomController.departGuestFromHotelRoom(userInputHotelRoomName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#changeStatus()
	 */

	@Override
	public void changeStatus(String userInputHotelRoomName) {
		hotelRoomController.changeStatus(userInputHotelRoomName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#addRooms()
	 */

	@Override
	public void addRooms(String userInputHotelRoomName, int userInputRoomPrice,
			int userInputSleepingNumbers, int userInputStarCategory) {
		hotelRoomController.addRooms(userInputHotelRoomName,
				userInputRoomPrice, userInputSleepingNumbers,
				userInputStarCategory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#changePriceOfHotelRoom()
	 */

	@Override
	public void changePriceOfHotelRoom(String userInputHotelRoomName,
			int userInputRoomPrice) {
		hotelRoomController.changePriceOfHotelRoom(userInputHotelRoomName,
				userInputRoomPrice);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#cloneHotelRoom()
	 */
	@Override
	public void cloneHotelRoom(String userInputHotelRoomName,
			String userInputHotelRoomNumberModify, String modify,
			int roomPriceModify, int sleepingNumberModify, int starModify) {
		hotelRoomController.cloneHotelRoom(userInputHotelRoomName,
				userInputHotelRoomNumberModify, modify, roomPriceModify,
				sleepingNumberModify, starModify);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#addServices()
	 */

	@Override
	public void addServices(String userInputServiceName, int userInputPrice) {
		serviceController.addServices(userInputServiceName, userInputPrice);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showPriceServiceAndHotelRoom()
	 */

	@Override
	public String showPriceServiceAndHotelRoom() {

		String s = serviceController.showPriceService()
				+ hotelRoomController.showPriceHotelRoom();
		return s;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#changePriceOfService()
	 */

	@Override
	public void changePriceOfService(String userInputServiceName,
			int userInputPrice) {
		serviceController.changePriceOfService(userInputServiceName,
				userInputPrice);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#guestReadCsvFile()
	 */

	@Override
	public String guestReadCsvFile(String userInputFileName) {
	return	importExportCsvController.guestReadCsvFile(userInputFileName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#guestWriteCsvFile()
	 */

	@Override
	public String guestWriteCsvFile(String userInputFileName) {
		return importExportCsvController.guestWriteCsvFile(userInputFileName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#hotelRoomReadCsvFile()
	 */
	@Override
	public String hotelRoomReadCsvFile(String userInputFileName) {
		return importExportCsvController.hotelRoomReadCsvFile(userInputFileName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#hotelRoomWriteCsvFile()
	 */

	@Override
	public String hotelRoomWriteCsvFile(String userInputFileName) {
		return importExportCsvController.hotelRoomWriteCsvFile(userInputFileName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#serviceReadCsvFile()
	 */

	@Override
	public String serviceReadCsvFile(String userInputFileName) {
		return importExportCsvController.serviceReadCsvFile(userInputFileName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#serviceWriteCsvFile()
	 */
	@Override
	public String  serviceWriteCsvFile(String userInputFileName) {
		return importExportCsvController.serviceWriteCsvFile(userInputFileName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.IMainController#showGuestReflectedObjectInfoDetailed
	 * ()
	 */
	@Override
	public String showGuestReflectedObjectInfoDetailed(String userInputGuestName) {
		return anotationController
				.showGuestReflectedObjectInfoDetailed(userInputGuestName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.IMainController#showGuestReflectedObjectInfoShort()
	 */
	@Override
	public String  showGuestReflectedObjectInfoShort(String userInputGuestName) {
		return anotationController
				.showGuestReflectedObjectInfoShort(userInputGuestName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.IMainController#showHotelRoomReflectedObjectInfoDetailed
	 * ()
	 */
	@Override
	public String showHotelRoomReflectedObjectInfoDetailed(
			String userInputHotelRoomNumber) {
		return anotationController
				.showHotelRoomReflectedObjectInfoDetailed(userInputHotelRoomNumber);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.IMainController#showHotelRoomReflectedObjectInfoShort
	 * ()
	 */
	@Override
	public String showHotelRoomReflectedObjectInfoShort(
			String userInputHotelRoomNumber) {
	return	anotationController
				.showHotelRoomReflectedObjectInfoShort(userInputHotelRoomNumber);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.IMainController#showServiceReflectedObjectInfoDetailed
	 * ()
	 */
	@Override
	public String showServiceReflectedObjectInfoDetailed(
			String userInputServiceName) {
		return anotationController
				.showServiceReflectedObjectInfoDetailed(userInputServiceName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.IMainController#showServiceReflectedObjectInfoShort
	 * ()
	 */
	@Override
	public String showServiceReflectedObjectInfoShort(String userInputServiceName) {
		return anotationController
				.showServiceReflectedObjectInfoShort(userInputServiceName);
	}
}
