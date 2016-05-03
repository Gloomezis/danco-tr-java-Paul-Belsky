/*
 * 
 */
package com.danco.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.danco.controller.api.IImportExportCsvController;
import com.danco.controller.api.IMainController;
import com.danco.model.Guest;
import com.danco.model.HotelRoom;
import com.danco.model.Orders;
import com.danco.model.Service;
import com.danco.model.User;
import com.danco.util.ConnectionFactoryHibernate;

// TODO: Auto-generated Javadoc
/**
 * The Class MainController.
 */
public class MainController implements IMainController {

	/** The guest controller. */
	private GuestController guestController = new GuestController();

	/** The hotel room controller. */
	private HotelRoomController hotelRoomController = new HotelRoomController();

	/** The service controller. */
	private ServiceController serviceController = new ServiceController();

	/** The orders controller. */
	private OrdersController ordersController = new OrdersController();

	/** The import export csv controller. */
	private IImportExportCsvController importExportCsvController = new ImportExportCsvController();
	
	private UserController userController = new UserController();
	
	private SessionController  sessionController = new SessionController();

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

	// <<<<<<<<<<GUEST >>>>>>>>>>>>

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#addGuest(java.lang.String)
	 */
	@Override
	public void addGuest(String userInputGuestName) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		try {
			Guest g = new Guest(userInputGuestName);
			session.beginTransaction();
			guestController.createGuest(session, g);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#showAllGuestNumber()
	 */
	@Override
	public String showAllGuestNumber() {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		int num = 0;
		try {
			num = guestController.getAllGuestNumber(session);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return Integer.toString(num);
	}

	

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#showAllGuests(java.lang.String)
	 */
	@Override
	public String showAllGuests(String userInputSortCondition) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		StringBuilder sb = null;
		try {
			sb = new StringBuilder(500);
			List<Guest> allSortedGuests = guestController.getGuestList(session,
					userInputSortCondition);
			for (Guest s : allSortedGuests) {
				sb.append(String.format(GUEST_FORMAT, s.getId(), s.getName()));
			}
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return sb.toString();
	}

	// <<<<<<<<<<SERVICE >>>>>>>>>>>>

	//TODO delete int userInputOrderId
	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#createService(int, java.lang.String, int)
	 */
	@Override
	public void createService(int userInputOrderId, String userInputServiceName,
			int userInputPrice) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		try {
			Service serv = new Service(userInputServiceName, userInputPrice);
			session.beginTransaction();
			serviceController.createService(session, serv);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#addService(int, int)
	 */
	@Override
	public void addService(String userInputGuestId, String userInputServiceId) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		try {
			session.beginTransaction();
			Orders order = ordersController.getOrdersForIdGuest(session,
					Integer.parseInt(userInputGuestId));
			Service service = serviceController.getServiceById(session,
					Integer.parseInt(userInputServiceId));
			service.setOrder(order);
			serviceController.updateService(session, service);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
	}

	// TODO string id to integer

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#showListOfServiceGuest(java.lang.String, java.lang.String)
	 */
	@Override
	public String showListOfServiceGuest(String idGuest,
			String userInputSortCondition) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		StringBuilder sb = null;
		try {
			List<Service> service = serviceController.getGuestThemServices(
					session, Integer.parseInt(idGuest));
			sb = new StringBuilder(500);
			sb.append("");
			sb.append(idGuest + ":" + "\n");
			for (Service c : service) {
				sb.append(String.format(SERVICE_FORMAT, c.getName(),
						c.getPrice()));
			}
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return sb.toString();
	}

	// TODO string to integer

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#changePriceOfService(java.lang.String, int)
	 */
	@Override
	public void changePriceOfService(String idService, int userInputPrice) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		try {
			session.beginTransaction();
			Service service = serviceController.getServiceById(session,
					Integer.parseInt(idService));
			service.setPrice(userInputPrice);
			serviceController.updateService(session, service);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}

	}


	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#showListOfService()
	 */
	@Override
	public String showListOfService() {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		StringBuilder sb = null;
		try {
			List<Service> service = serviceController.getServiceList(session,
					"name");
			sb = new StringBuilder(500);
			sb.append("");
			for (Service c : service) {
				sb.append(String.format(SERVICE_FORMAT, c.getName(),
						c.getPrice()));
			}
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return sb.toString();
	}

	// <<<<<<<<<<HOTEL ROOM >>>>>>>>>>>>

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#addRooms(java.lang.String, int, int, int)
	 */
	@Override
	public void addRooms(String userInputHotelRoomName, int userInputRoomPrice,
			int userInputSleepingNumbers, int userInputStarCategory) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		try {

			HotelRoom hotelRoom = new HotelRoom(userInputHotelRoomName,
					userInputRoomPrice, userInputSleepingNumbers,
					userInputStarCategory);
			session.beginTransaction();
			hotelRoomController.createHotelRoom(session, hotelRoom);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#showAllRooms(java.lang.String)
	 */
	@Override
	public String showAllRooms(String userInputSortCondition) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		StringBuilder sb = new StringBuilder();
		try {
			List<HotelRoom> rooms = hotelRoomController.getHotelRoomList(
					session, true, userInputSortCondition);
			for (HotelRoom s : rooms) {
				sb.append(hotelRoomToString(s));
			}
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#showAllFreeRooms(java.lang.String)
	 */
	@Override
	public String showAllFreeRooms(String userInputSortCondition) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		StringBuilder sb = new StringBuilder();
		try {
			List<HotelRoom> rooms = hotelRoomController.getHotelRoomList(
					session, true, userInputSortCondition);
			for (HotelRoom s : rooms) {
				sb.append(hotelRoomToString(s));
			}
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return sb.toString();
	}


	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#changeStatus(java.lang.String)
	 */
	@Override
	public void changeStatus(String idHotelRoom) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		boolean status;
		try {
			session.beginTransaction();
			HotelRoom hotelRoom = hotelRoomController.getHotelRoomById(session,
					Integer.parseInt(idHotelRoom));
			Boolean statusG = hotelRoom.isStatus();
			status = statusG == false ? true : false;
			hotelRoom.setStatus(status);
			hotelRoomController.updateHotelRoom(session, hotelRoom);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#showNumberOfFreeHotelRooms()
	 */
	@Override
	public String showNumberOfFreeHotelRooms() {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		int n = 0;
		try {
			n = hotelRoomController.getNumberFreeHotelRooms(session);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return Integer.toString(n);
	}

	// TODO id to integer
	

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#showDetailOfHotelRoom(java.lang.String)
	 */
	@Override
	public String showDetailOfHotelRoom(String idHotelRoom) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		String info = null;
		try {
			HotelRoom s = hotelRoomController.getHotelRoomById(session,
					Integer.parseInt(idHotelRoom));
			info = (hotelRoomToString(s));
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return info;

	}

	// TODO string to integer

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#changePriceOfHotelRoom(java.lang.String, int)
	 */
	@Override
	public void changePriceOfHotelRoom(String idHotelRoom,
			int userInputRoomPrice) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		try {
			session.beginTransaction();
			HotelRoom hotelRoom = hotelRoomController.getHotelRoomById(session,
					Integer.parseInt(idHotelRoom));
			hotelRoom.setRoomPrice(userInputRoomPrice);
			hotelRoomController.updateHotelRoom(session, hotelRoom);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#showPriceServiceAndHotelRoom()
	 */
	@Override
	public String showPriceServiceAndHotelRoom() {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		StringBuilder sb = null;
		try {
			List<String> listService = serviceController
					.getPriceService(session);
			List<String> listHotelRoom = hotelRoomController
					.getPriceHotelRoom(session);
			sb = new StringBuilder();
			for (String a : listService) {
				sb.append(a);
				sb.append(" \n ");
			}
			for (String b : listHotelRoom) {
				sb.append(b);
				sb.append(" \n ");
			}
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return sb.toString();
	}

	// TODO string to int
	

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#showSummToPaidGuest(java.lang.String)
	 */
	@Override
	public String showSummToPaidGuest(String idGuest) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		int num1 = 0;
		int num2 = 0;
		int numRez = 0;
		try {
			num1 = ordersController.getPriceOrderForGuest(session,
					Integer.parseInt(idGuest));
			num2 = serviceController.getSumServiceForGuest(session,
					Integer.parseInt(idGuest));
			numRez = num1 + num2;
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return Integer.toString(numRez);
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#guestReadCsvFile(java.lang.String)
	 */
	@Override
	public String guestReadCsvFile(String userInputFileName) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		String str = " ";
		try {
			session.beginTransaction();
			str = importExportCsvController.guestReadCsvFile(session,
					userInputFileName);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return str;

	}


	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#guestWriteCsvFile(java.lang.String)
	 */
	@Override
	public String guestWriteCsvFile(String userInputFileName) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		String str = " ";
		try {
			str = importExportCsvController.guestWriteCsvFile(session,
					userInputFileName);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return str;
	}


	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#hotelRoomReadCsvFile(java.lang.String)
	 */
	@Override
	public String hotelRoomReadCsvFile(String userInputFileName) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		String str = " ";
		try {
			session.beginTransaction();
			str = importExportCsvController.hotelRoomReadCsvFile(session,
					userInputFileName);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return str;
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#hotelRoomWriteCsvFile(java.lang.String)
	 */
	@Override
	public String hotelRoomWriteCsvFile(String userInputFileName) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		String str = " ";
		try {
			str = importExportCsvController.hotelRoomWriteCsvFile(session,
					userInputFileName);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return str;
	}


	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#serviceReadCsvFile(java.lang.String)
	 */
	@Override
	public String serviceReadCsvFile(String userInputFileName) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		String str = " ";
		try {
			session.beginTransaction();
			str = importExportCsvController.serviceReadCsvFile(session,
					userInputFileName);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return str;
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#serviceWriteCsvFile(java.lang.String)
	 */
	@Override
	public String serviceWriteCsvFile(String userInputFileName) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		String str = " ";
		try {
			str = importExportCsvController.serviceWriteCsvFile(session,
					userInputFileName);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return str;

	}

	/**
	 * Hotel room to string.
	 *
	 * @param hr the hr
	 * @return the string
	 */
	private String hotelRoomToString(HotelRoom hr) {

		boolean busyB = hr.isBusy();
		String busyS = busyB == true ? "busy" : "free";

		boolean statusB = hr.isStatus();
		String statusS = statusB == true ? "working" : "reparing";

		String hrString = String.format(ROOM_PRINTER_FORMAT, hr.getNumber(),
				hr.getSleepingNumber(), hr.getStarCategory(),
				hr.getRoomPrice(), busyS, statusS);

		return hrString;
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#settleGuestToHotelRoom(java.lang.String, java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public String settleGuestToHotelRoom(String idGuest, String idHotelRoom,
			Date userinpitDateOfArrive, Date userInputDateOfDeparture) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		String result = null;
		try {
			session.beginTransaction();
			HotelRoom hr = hotelRoomController.getHotelRoomById(session,
					Integer.parseInt(idHotelRoom));
			if (hr.isBusy() == true) {
				result = "not Free";
			} else {
				changeStatus(idHotelRoom);
				Guest guest = guestController.getGuestById(session,
						Integer.parseInt(idGuest));
				Orders order = new Orders(hr, userinpitDateOfArrive,
						userInputDateOfDeparture);
				order.setGuest(guest);
				ordersController.createOrders(session, order);
				result = "Settled";
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.api.IMainController#departGuestFromHotelRoom(java.lang.String)
	 */
	@Override
	public void departGuestFromHotelRoom(String idGuest) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		try {
			session.beginTransaction();
			Orders order = ordersController.getOrdersForIdGuest(session,
					Integer.parseInt(idGuest));
			order.setPaid(true);
			List<Service> services = order.getServices();
			for (Service s : services) {
				s.setPaid(true);
				serviceController.updateService(session, s);
			}
			ordersController.updateOrders(session, order);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
	
	}
	
	
	
	public void addUser(String userName,String userPass, String userMail) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		try {
			User u = new User();
			session.beginTransaction();
			userController.createUser(session, u);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
	}
	
	public void addSession(int userID,String resources, boolean login) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		try {
			
			session.beginTransaction();
			User u = userController.getUserById(session, userID);
			Date time = new Date();
			com.danco.model.Session s = new com.danco.model.Session(time, resources,login,
					u);
			sessionController.createSession(session, s);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
	}
	

}