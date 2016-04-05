/*
 * 
 */
package com.danco.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.controller.api.IImportExportCsvController;
import com.danco.controller.api.IMainController;
import com.danco.model.Guest;
import com.danco.model.HotelRoom;
import com.danco.model.Orders;
import com.danco.model.Service;
import com.danco.util.ConnectionUtil;
import com.danco.util.ConnectorFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class MainController.
 */
public class MainController implements IMainController {

	/** The guest service. */
	private GuestController guestController = new GuestController();
	
	/** The guest service. */
	private HotelRoomController hotelRoomController = new HotelRoomController();

	/** The service controller. */
	private ServiceController serviceController = new ServiceController();

	/** The orders controller. */
	private OrdersController ordersController = new OrdersController();

	/** The import export csv controller. */
	private IImportExportCsvController importExportCsvController = new ImportExportCsvController();

	/** The Constant GUEST_FORMAT. */
	private static final String GUEST_FORMAT = "id: %d, Guest: %s , \n";

	/** The Constant SERVICE_FORMAT. */
	private static final String SERVICE_FORMAT = "service : %s, price: %d \n";

	/** The Constant ROOM_PRINTER_FORMAT. */
	private static final String ROOM_PRINTER_FORMAT = "room: %s  , sleeping numbers: %d,  stars category: %d,  price: %d , busy :%s,status %s \n";

	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	/** The LO g1. */
	private final Logger LOG1 = Logger
			.getLogger(MainController.class.getName());

	/** The connection util. */
	private ConnectionUtil connectionUtil = ConnectionUtil.getInstance();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.api.IMainController#addGuest(java.lang.String)
	 */
	@Override
	public void addGuest(String userInputGuestName) {
		Connection con = connectionUtil.getConnection();
		Guest g = new Guest(userInputGuestName);
		try {
			guestController.create(con, g);
		} catch (SQLException e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showAllGuestNumber()
	 */
	@Override
	public String showAllGuestNumber() {
		Connection con = connectionUtil.getConnection();
		int num = 0;
		try {
			con = ConnectorFactory.getConnection();
			num = guestController.getAllGuestNumber(con);
		} catch (SQLException e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}
		return Integer.toString(num);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showSummToPaidGuest()
	 */
	@Override
	public String showSummToPaidGuest(String userInputGuestName) {
		Connection con = connectionUtil.getConnection();
		int num = 0;
		try {
			num = ordersController.getSummToDeparture(con, userInputGuestName);
		} catch (SQLException e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}
		return Integer.toString(num);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showAllGuests()
	 */
	@Override
	public String showAllGuests(String userInputSortCondition) {
		Connection con = connectionUtil.getConnection();
		StringBuilder sb = null;
		try {
			sb = new StringBuilder(500);
			List<Guest> allSortedGuests = guestController.getAllSorted(con,
					userInputSortCondition);
			for (Guest s : allSortedGuests) {
				sb.append(String.format(GUEST_FORMAT, s.getId(), s.getName()));
			}
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showListOfService()
	 */
	@Override
	public String showListOfService(String userInputGuestName,
			String userInputSortCondition) {
		Connection con = connectionUtil.getConnection();
		StringBuilder sb = null;
		try {
			List<Service> service = guestController.getGuestService(con,
					userInputGuestName);
			sb = new StringBuilder(500);
			sb.append("");
			sb.append(userInputGuestName + ":" + "\n");
			for (Service c : service) {
				sb.append(String.format(SERVICE_FORMAT, c.getName(),
						c.getPrice()));
			}
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#addServiceToGuest()
	 */
	@Override
	public void addService(int userInputOrderId, String userInputGuestName,
			int userInputPrice) {
		Connection con = connectionUtil.getConnection();
		try {
			Service serv = new Service(userInputGuestName,
					userInputPrice);
			serviceController.create(con, serv);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showAllRooms()
	 */

	@Override
	public String showAllRooms(String userInputSortCondition) {
		Connection con = connectionUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		try {
			List<HotelRoom> rooms = hotelRoomController.getAllSorted(con,
					userInputSortCondition);
			for (HotelRoom s : rooms) {
				
				sb.append(hotelRoomToString(s));
			}
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showAllFreeRooms()
	 */
	@Override
	public String showAllFreeRooms(String userInputSortCondition) {
		Connection con = connectionUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		try {
			List<HotelRoom> rooms = hotelRoomController.getAllFreeSorted(con,
					userInputSortCondition);
			for (HotelRoom s : rooms) {
				sb.append(hotelRoomToString(s));
			}
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showFreeRomsAfterDate()
	 */

	@Override
	public String showFreeRomsAfterDate(String userInputSortCondition, Date date) {
		Connection con = connectionUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		try {
			List<HotelRoom> rooms = hotelRoomController.getFreeHotelRoomsAfterDate(
					con, userInputSortCondition, date);
			for (HotelRoom s : rooms) {
				sb.append(hotelRoomToString(s));
			}
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showNumberOfFreeHotelRooms()
	 */

	@Override
	public String showNumberOfFreeHotelRooms() {
		Connection con = connectionUtil.getConnection();
		int n = 0;
		try {
			n = hotelRoomController.getNumberFreeHotelRooms(con);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}
		return Integer.toString(n);
	}

	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showDetailOfHotelRoom()
	 */

	@Override
	public String showDetailOfHotelRoom(String userInputHotelRoomNumber) {
		Connection con = connectionUtil.getConnection();
		String info = null;
		try {
			HotelRoom s = hotelRoomController
					.readByName(con, userInputHotelRoomNumber);
			
			info = (hotelRoomToString(s));
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}
		return info;

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
		Connection con = connectionUtil.getConnection();
		try {
			connectionUtil.beginTransaction(con);
			HotelRoom hr = hotelRoomController.readByName(con,
					userInputHotelRoomNumber);

			Orders order = new Orders( hr,
					userinpitDateOfArrive, userInputDateOfDeparture);
			order.setHotelRoom(hr);
			ordersController.create(con, order);
			connectionUtil.commitTransaction(con);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			connectionUtil.rollbackTransaction(con);
		} 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#departGuestFromHotelRoom()
	 */

	// TODO transation
	@Override
	public void departGuestFromHotelRoom(String userInputOrderId) {
		Connection con = connectionUtil.getConnection();
		try {
			connectionUtil.beginTransaction(con);
			
			ordersController.updatePaid(con, userInputOrderId);
			serviceController.updatePaid(con, userInputOrderId);
			
			connectionUtil.commitTransaction(con);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			connectionUtil.rollbackTransaction(con);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#changeStatus()
	 */
	// TODO transation
	@Override
	public void changeStatus(String userInputHotelRoomName) {
		Connection con = connectionUtil.getConnection();
		boolean status;
		try {
			connectionUtil.beginTransaction(con);
			Boolean statusG = hotelRoomController.getStatus(con,
					userInputHotelRoomName);
			
			status =statusG == false? true:false;
			
			HotelRoom hr = hotelRoomController.readByName(con, userInputHotelRoomName);
			hotelRoomController.updateStatus(con, hr.getId(), status);
			connectionUtil.commitTransaction(con);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			connectionUtil.rollbackTransaction(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#addRooms()
	 */

	@Override
	public void addRooms(String userInputHotelRoomName, int userInputRoomPrice,
			int userInputSleepingNumbers, int userInputStarCategory) {
		Connection con = connectionUtil.getConnection();
		try {
			HotelRoom hotelRoom = new HotelRoom(userInputHotelRoomName,
					userInputRoomPrice, userInputSleepingNumbers,
					userInputStarCategory);
			hotelRoomController.create(con, hotelRoom);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#changePriceOfHotelRoom()
	 */

	@Override
	public void changePriceOfHotelRoom(String userInputHotelRoomName,
			int userInputRoomPrice) {
		Connection con = connectionUtil.getConnection();
		try {
			connectionUtil.beginTransaction(con);
			HotelRoom hotelRoom = hotelRoomController.readByName(con,
					userInputHotelRoomName);
			hotelRoomController
					.updatePrice(con, hotelRoom.getId(), userInputRoomPrice);
			connectionUtil.commitTransaction(con);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			connectionUtil.rollbackTransaction(con);
		} 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#showPriceServiceAndHotelRoom()
	 */

	@Override
	public String showPriceServiceAndHotelRoom() {
		Connection con = connectionUtil.getConnection();
		StringBuilder sb = null;
		try {
			connectionUtil.beginTransaction(con);
			List<String> listService = serviceController.getPriceService(con);
			List<String> listHotelRoom = hotelRoomController.getPriceHotelRoom(con);
			sb = new StringBuilder();
			for (String a : listService) {
				sb.append(a);
				sb.append(" \n ");
			}
			for (String b : listHotelRoom) {
				sb.append(b);
				sb.append(" \n ");
			}
			connectionUtil.commitTransaction(con);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			connectionUtil.rollbackTransaction(con);
		} 
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#changePriceOfService()
	 */

	@Override
	public void changePriceOfService(String userInputServiceName,
			int userInputPrice) {
		Connection con = connectionUtil.getConnection();
		try {
			connectionUtil.beginTransaction(con);
			Service service = serviceController.readByName(con, userInputServiceName);
			serviceController.updatePrice(con, service.getId(), userInputPrice);
			connectionUtil.commitTransaction(con);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			connectionUtil.rollbackTransaction(con);	
		} 

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#guestReadCsvFile()
	 */

	@Override
	public String guestReadCsvFile(String userInputFileName) {
		Connection con = connectionUtil.getConnection();
		String str = " ";
	    try{
		 str =importExportCsvController.guestReadCsvFile(con,userInputFileName);
	    } catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}	
		return str;
				
   
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#guestWriteCsvFile()
	 */

	@Override
	public String guestWriteCsvFile(String userInputFileName) {
		Connection con = connectionUtil.getConnection();
		String str = " ";
	    try{
	    	str =importExportCsvController.guestWriteCsvFile(con,userInputFileName);
	    } catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}	
		return str;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#hotelRoomReadCsvFile()
	 */
	@Override
	public String hotelRoomReadCsvFile(String userInputFileName) {
		Connection con = connectionUtil.getConnection();
		String str = " ";
	    try{
	    	str =importExportCsvController
				.hotelRoomReadCsvFile(con,userInputFileName);
	    } catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}	
		return str;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#hotelRoomWriteCsvFile()
	 */

	@Override
	public String hotelRoomWriteCsvFile(String userInputFileName) {
		Connection con = connectionUtil.getConnection();
		String str = " ";
	    try{
	
	    	str =importExportCsvController
				.hotelRoomWriteCsvFile(con,userInputFileName);
	    } catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}	
		return str;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#serviceReadCsvFile()
	 */

	@Override
	public String serviceReadCsvFile(String userInputFileName) {
		Connection con = connectionUtil.getConnection();
		String str = " ";
	    try{
	    	str =importExportCsvController.serviceReadCsvFile(con,userInputFileName);
	    } catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}	
		return str;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IMainController#serviceWriteCsvFile()
	 */
	@Override
	public String serviceWriteCsvFile(String userInputFileName) {
		Connection con = connectionUtil.getConnection();
		String str = " ";
	    try{
	    	str =importExportCsvController.serviceWriteCsvFile(con,userInputFileName);
	    } catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		} finally {
			connectionUtil.closeConnection(con);
		}	
		return str;

	}
	
	/**
	 * Hotel room to string.
	 *
	 * @param hr the hr
	 * @return the string
	 */
	private String hotelRoomToString(HotelRoom hr){
		
		boolean busyB = hr.getBusy();
		String busyS=busyB==true? "busy":  "free";
		
		boolean statusB = hr.getStatus();
		String	statusS=statusB == true?"working":"reparing";
		
		String hrString =String.format(ROOM_PRINTER_FORMAT, hr.getNumber(),
				hr.getSleepingNumber(), hr.getStarCategory(),
				hr.getRoomPrice(), busyS, statusS);
		
		
		return hrString;
	}

}
