package com.danco.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.controller.api.IImportExportCsvController;
import com.danco.controller.api.IMainController;
import com.danco.dao.api.IGuestDAO;
import com.danco.dao.api.IHotelRoomDAO;
import com.danco.dao.api.IOrdersDAO;
import com.danco.dao.api.IServiceDAO;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
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
	private IGuestDAO guestDAO = (IGuestDAO) DependencyInjectionManager
			.getClassInstance(IGuestDAO.class);

	/** The service service. */
	private IServiceDAO serviceDAO = (IServiceDAO) DependencyInjectionManager
			.getClassInstance(IServiceDAO.class);

	/** The service service. */
	private IOrdersDAO ordersDAO = (IOrdersDAO) DependencyInjectionManager
			.getClassInstance(IOrdersDAO.class);

	/** The service service. */
	private IHotelRoomDAO hotelRoomDAO = (IHotelRoomDAO) DependencyInjectionManager
			.getClassInstance(IHotelRoomDAO.class);

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
			guestDAO.create(con, g);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			num = guestDAO.getAllGuestNumber(con);
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
			num = ordersDAO.getSummToDeparture(con, userInputGuestName);
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
			List<Guest> allSortedGuests = guestDAO.getAllSorted(con,
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
			List<Service> service = guestDAO.getGuestService(con,
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
			Service serv = new Service(userInputOrderId, userInputGuestName,
					userInputPrice);
			serviceDAO.create(con, serv);
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
			List<HotelRoom> rooms = hotelRoomDAO.getAllSorted(con,
					userInputSortCondition);
			for (HotelRoom s : rooms) {
				boolean busyB = s.getBusy();
				String busyS;
				if (busyB == true) {
					busyS = "busy";
				} else {
					busyS = "free";
				}
				boolean statusB = s.getStatus();
				String statusS;
				if (statusB == true) {
					statusS = "working";
				} else {
					statusS = "reparing";
				}
				sb.append(String.format(ROOM_PRINTER_FORMAT, s.getNumber(),
						s.getSleepingNumber(), s.getStarCategory(),
						s.getRoomPrice(), busyS, statusS));
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
			List<HotelRoom> rooms = hotelRoomDAO.getAllFreeSorted(con,
					userInputSortCondition);
			for (HotelRoom s : rooms) {
				boolean busyB = s.getBusy();
				String busyS;
				if (busyB == true) {
					busyS = "busy";
				} else {
					busyS = "free";
				}
				boolean statusB = s.getStatus();
				String statusS;

				if (statusB == true) {
					statusS = "working";
				} else {
					statusS = "reparing";
				}
				sb.append(String.format(ROOM_PRINTER_FORMAT, s.getNumber(),
						s.getSleepingNumber(), s.getStarCategory(),
						s.getRoomPrice(), busyS, statusS));
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
			List<HotelRoom> rooms = hotelRoomDAO.getFreeHotelRoomsAfterDate(
					con, userInputSortCondition, date);
			for (HotelRoom s : rooms) {
				boolean busyB = s.getBusy();
				String busyS;
				if (busyB == true) {
					busyS = "busy";
				} else {
					busyS = "free";
				}
				boolean statusB = s.getStatus();
				String statusS;
				if (statusB == true) {
					statusS = "working";
				} else {
					statusS = "reparing";
				}
				sb.append(String.format(ROOM_PRINTER_FORMAT, s.getNumber(),
						s.getSleepingNumber(), s.getStarCategory(),
						s.getRoomPrice(), busyS, statusS));
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
			n = hotelRoomDAO.getNumberFreeHotelRooms(con);
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
	 * @see com.danco.controller.IMainController#showLast3GuestOfHotelRoom()
	 */

	@Override
	public String showLast3GuestOfHotelRoom(String userInputHotelRoomNumber) {
		return null;

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
			HotelRoom s = hotelRoomDAO
					.readByName(con, userInputHotelRoomNumber);
			boolean busyB = s.getBusy();
			String busyS;
			if (busyB == true) {
				busyS = "busy";
			} else {
				busyS = "free";
			}
			boolean statusB = s.getStatus();
			String statusS;

			if (statusB == true) {
				statusS = "working";
			} else {
				statusS = "reparing";
			}
			info = (String.format(ROOM_PRINTER_FORMAT, s.getNumber(),
					s.getSleepingNumber(), s.getStarCategory(),
					s.getRoomPrice(), busyS, statusS));
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
			con.setAutoCommit(false);
			Guest g = guestDAO.readByName(con, userInputGuestName);
			HotelRoom hr = hotelRoomDAO.readByName(con,
					userInputHotelRoomNumber);

			Orders order = new Orders(g.getId(), hr.getId(),
					userinpitDateOfArrive, userInputDateOfDeparture);
			ordersDAO.create(con, order);
			connectionUtil.commitTransaction(con);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			connectionUtil.rollbackTransaction(con);
		} finally {
			connectionUtil.endTransaction(con);
			connectionUtil.closeConnection(con);
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
			ordersDAO.updatePaid(con, userInputOrderId);
			serviceDAO.updatePaid(con, userInputOrderId);
			connectionUtil.commitTransaction(con);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			connectionUtil.rollbackTransaction(con);

		} finally {
			connectionUtil.endTransaction(con);
			connectionUtil.closeConnection(con);
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
			Boolean statusG = hotelRoomDAO.getStatus(con,
					userInputHotelRoomName);
			if (statusG == false) {
				status = true;
			} else {
				status = false;
			}
			HotelRoom hr = hotelRoomDAO.readByName(con, userInputHotelRoomName);
			hotelRoomDAO.updateStatus(con, hr.getId(), status);
			connectionUtil.commitTransaction(con);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			connectionUtil.rollbackTransaction(con);
		} finally {
			connectionUtil.endTransaction(con);
			connectionUtil.closeConnection(con);
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
			hotelRoomDAO.create(con, hotelRoom);
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
			HotelRoom hotelRoom = hotelRoomDAO.readByName(con,
					userInputHotelRoomName);
			hotelRoomDAO
					.updatePrice(con, hotelRoom.getId(), userInputRoomPrice);
			connectionUtil.commitTransaction(con);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			connectionUtil.rollbackTransaction(con);
		} finally {
			connectionUtil.endTransaction(con);
			connectionUtil.closeConnection(con);
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
			List<String> listService = serviceDAO.getPriceService(con);
			List<String> listHotelRoom = hotelRoomDAO.getPriceHotelRoom(con);
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
		} finally {
			connectionUtil.endTransaction(con);
			connectionUtil.closeConnection(con);
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
			Service service = serviceDAO.readByName(con, userInputServiceName);
			serviceDAO.updatePrice(con, service.getId(), userInputPrice);
			connectionUtil.commitTransaction(con);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			connectionUtil.rollbackTransaction(con);	
		} finally {
			connectionUtil.endTransaction(con);
			connectionUtil.closeConnection(con);
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

}
