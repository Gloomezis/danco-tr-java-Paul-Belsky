import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {

	public void addGuest() throws RemoteException;

	/**
	 * Show all guest number.
	 */
	public void showAllGuestNumber() throws RemoteException;

	/**
	 * Show summ to paid guest.
	 */
	public void showSummToPaidGuest() throws RemoteException;

	/**
	 * Show all guests.
	 */
	public void showAllGuests() throws RemoteException;

	/**
	 * Show list of service.
	 */
	public void showListOfService() throws RemoteException;

	/**
	 * Adds the service to guest.
	 */
	public void addServiceToGuest() throws RemoteException;

	/**
	 * Gets the all guests.
	 *
	 * @return the all guests
	 */
	public void getAllGuests() throws RemoteException;

	/**
	 * Show all rooms.
	 */
	public void showAllRooms() throws RemoteException;

	/**
	 * Show all free rooms.
	 */
	public void showAllFreeRooms() throws RemoteException;

	/**
	 * Show free roms after date.
	 */
	public void showFreeRomsAfterDate() throws RemoteException;

	/**
	 * Show number of free hotel rooms.
	 */
	public void showNumberOfFreeHotelRooms() throws RemoteException;

	/**
	 * Show last3 guest of hotel room.
	 */
	public void showLast3GuestOfHotelRoom() throws RemoteException;

	/**
	 * Show detail of hotel room.
	 */
	public void showDetailOfHotelRoom() throws RemoteException;

	/**
	 * Settle guest to hotel room.
	 */
	public void settleGuestToHotelRoom() throws RemoteException;

	/**
	 * Depart guest from hotel room.
	 */
	public void departGuestFromHotelRoom() throws RemoteException;

	/**
	 * Change status.
	 */
	public void changeStatus() throws RemoteException;

	/**
	 * Adds the rooms.
	 */
	public void addRooms() throws RemoteException;

	/**
	 * Change price of hotel room.
	 */
	public void changePriceOfHotelRoom() throws RemoteException;

	/**
	 * Clone hotel room.
	 */
	public void cloneHotelRoom() throws RemoteException;

	/**
	 * Adds the services.
	 */
	public void addServices() throws RemoteException;

	/**
	 * Show price service and hotel room.
	 */
	public void showPriceServiceAndHotelRoom() throws RemoteException;

	/**
	 * Change price of service.
	 */
	public void changePriceOfService() throws RemoteException;

	/**
	 * Guest read csv file.
	 */
	public void guestReadCsvFile() throws RemoteException;

	/**
	 * Guest write csv file.
	 */
	public void guestWriteCsvFile() throws RemoteException;

	/**
	 * Hotel room read csv file.
	 */
	public void hotelRoomReadCsvFile() throws RemoteException;

	/**
	 * Hotel room write csv file.
	 */
	public void hotelRoomWriteCsvFile() throws RemoteException;

	/**
	 * Service read csv file.
	 */
	public void serviceReadCsvFile() throws RemoteException;

	/**
	 * Service write csv file.
	 */
	public void serviceWriteCsvFile() throws RemoteException;

	/**
	 * Show guest reflected object info detailed.
	 */
	public void showGuestReflectedObjectInfoDetailed() throws RemoteException;

	/**
	 * Show guest reflected object info short.
	 */
	public void showGuestReflectedObjectInfoShort() throws RemoteException;

	/**
	 * Show hotel room reflected object info detailed.
	 */
	public void showHotelRoomReflectedObjectInfoDetailed() throws RemoteException;

	/**
	 * Show hotel room reflected object info short.
	 */
	public void showHotelRoomReflectedObjectInfoShort() throws RemoteException;

	/**
	 * Show service reflected object info detailed.
	 */
	public void showServiceReflectedObjectInfoDetailed() throws RemoteException;

	/**
	 * Show service reflected object info short.
	 */
	public void showServiceReflectedObjectInfoShort() throws RemoteException;

}
