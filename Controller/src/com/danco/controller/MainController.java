package com.danco.controller;

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
	private IImportExportCsvController importExportCsvController = (IImportExportCsvController)DependencyInjectionManager.getClassInstance(IImportExportCsvController.class); 

	/** The instance. */
	//private static IMainController instance;
    //private MainController(){
    //    }
	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#addGuest()
	 */
	//public static IMainController getInstance() {
	//	if (instance == null) {
	//		instance = new MainController();
	//	}
	//	return instance;
	//}


	@Override
	public void addGuest() {
		guestController.addGuest();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showAllGuestNumber()
	 */
	@Override
	public void showAllGuestNumber() {
		guestController.showAllGuestNumber();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showSummToPaidGuest()
	 */
	@Override
	public void showSummToPaidGuest() {
		guestController.showSummToPaidGuest();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showAllGuests()
	 */
	@Override
	public void showAllGuests() {
		guestController.showAllGuests();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showListOfService()
	 */
	@Override
	public void showListOfService() {
		guestController.showListOfService();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#addServiceToGuest()
	 */
	@Override
	public void addServiceToGuest() {
		guestController.addServiceToGuest();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#getAllGuests()
	 */


	@Override
	public void getAllGuests() {
		guestController.getAllGuests();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showAllRooms()
	 */


	@Override
	public void showAllRooms() {
		hotelRoomController.showAllRooms();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showAllFreeRooms()
	 */
	@Override
	public void showAllFreeRooms() {
		hotelRoomController.showAllFreeRooms();

	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showFreeRomsAfterDate()
	 */

	
	@Override
	public void showFreeRomsAfterDate() {
		hotelRoomController.showFreeRomsAfterDate();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showNumberOfFreeHotelRooms()
	 */

	
	@Override
	public void showNumberOfFreeHotelRooms() {
		hotelRoomController.showNumberOfFreeHotelRooms();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showLast3GuestOfHotelRoom()
	 */

	
	@Override
	public void showLast3GuestOfHotelRoom() {
		hotelRoomController.showLast3GuestOfHotelRoom();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showDetailOfHotelRoom()
	 */

	
	@Override
	public void showDetailOfHotelRoom() {
		hotelRoomController.showDetailOfHotelRoom();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#settleGuestToHotelRoom()
	 */


	@Override
	public void settleGuestToHotelRoom() {
		hotelRoomController.settleGuestToHotelRoom();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#departGuestFromHotelRoom()
	 */


	@Override
	public void departGuestFromHotelRoom() {
		hotelRoomController.departGuestFromHotelRoom();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#changeStatus()
	 */

	
	@Override
	public void changeStatus() {
		hotelRoomController.changeStatus();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#addRooms()
	 */

	
	@Override
	public void addRooms() {
		hotelRoomController.addRooms();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#changePriceOfHotelRoom()
	 */

	
	@Override
	public void changePriceOfHotelRoom() {
		hotelRoomController.changePriceOfHotelRoom();
	}


	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#cloneHotelRoom()
	 */
	@Override
	public void cloneHotelRoom() {
		hotelRoomController.cloneHotelRoom();

	}


	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#addServices()
	 */
	
	@Override
	public void addServices() {
		serviceController.addServices();
	}



	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showPriceServiceAndHotelRoom()
	 */
	
	@Override
	public void showPriceServiceAndHotelRoom() {
		serviceController.showPriceService();
		hotelRoomController.showPriceHotelRoom();

	}



	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#changePriceOfService()
	 */
	
	@Override
	public void changePriceOfService() {
		serviceController.changePriceOfService();

	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#guestReadCsvFile()
	 */
	
	@Override
	public void guestReadCsvFile() {
		importExportCsvController.guestReadCsvFile();

	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#guestWriteCsvFile()
	 */
	
	@Override
	public void guestWriteCsvFile() {
		importExportCsvController.guestWriteCsvFile();
	}

	
	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#hotelRoomReadCsvFile()
	 */
	@Override
	public void hotelRoomReadCsvFile() {
		importExportCsvController.hotelRoomReadCsvFile();

	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#hotelRoomWriteCsvFile()
	 */
	
	@Override
	public void hotelRoomWriteCsvFile() {
		importExportCsvController.hotelRoomWriteCsvFile();

	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#serviceReadCsvFile()
	 */
	
	@Override
	public void serviceReadCsvFile() {
		importExportCsvController.serviceReadCsvFile();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#serviceWriteCsvFile()
	 */
	@Override
	public void serviceWriteCsvFile() {
		importExportCsvController.serviceWriteCsvFile();

	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showGuestReflectedObjectInfoDetailed()
	 */
	@Override
	public void showGuestReflectedObjectInfoDetailed(){
		anotationController.showGuestReflectedObjectInfoDetailed();
	}
	
	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showGuestReflectedObjectInfoShort()
	 */
	@Override
	public void showGuestReflectedObjectInfoShort(){
		anotationController.showGuestReflectedObjectInfoShort();
	}
	
	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showHotelRoomReflectedObjectInfoDetailed()
	 */
	@Override
	public void showHotelRoomReflectedObjectInfoDetailed(){
		anotationController.showHotelRoomReflectedObjectInfoDetailed();
	}
	
	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showHotelRoomReflectedObjectInfoShort()
	 */
	@Override
	public void showHotelRoomReflectedObjectInfoShort(){
		anotationController.showHotelRoomReflectedObjectInfoShort();
	}
	
	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showServiceReflectedObjectInfoDetailed()
	 */
	@Override
	public void showServiceReflectedObjectInfoDetailed(){
		anotationController.showServiceReflectedObjectInfoDetailed();
	}
	
	/* (non-Javadoc)
	 * @see com.danco.controller.IMainController#showServiceReflectedObjectInfoShort()
	 */
	@Override
	public void showServiceReflectedObjectInfoShort(){
		anotationController.showServiceReflectedObjectInfoShort();
	}
}
