/*
 * 
 */
package com.danco.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;

import com.danco.controller.api.IImportExportCsvController;
import com.danco.controller.api.IMainController;
import com.danco.model.Guest;
import com.danco.model.Handling;
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

	private HandlingController handlingController = new HandlingController();

	/** The Constant ROOM_PRINTER_FORMAT. */
	private static final String ROOM_PRINTER_FORMAT = "room: %s  , sleeping numbers: %d,  stars category: %d,  price: %d , busy :%s,status %s \n";

	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	/** The LO g1. */
	private final Logger LOG1 = Logger
			.getLogger(MainController.class.getName());

	private static final String LOGER_PROPERTY_FILE_PATH = "log4j.properties";

	/*
	 * 
	 * private static IMainController instance;
	 * 
	 * 
	 * public static IMainController getInstance() { if (instance == null) {
	 * instance = new MainController(); } return instance; }
	 */

	public MainController() {
		PropertyConfigurator.configure(LOGER_PROPERTY_FILE_PATH);
	}

	// <<<<<<<<<<GUEST >>>>>>>>>>>>

	/*
	 * (non-Javadoc)
	 * 
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

	/*
	 * (non-Javadoc)
	 * 
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#showAllGuests(java.lang.String)
	 */
	@Override
	public List<Guest> showAllGuests(String userInputSortCondition) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		List<Guest> allSortedGuests = null;
		try {
			 allSortedGuests = guestController.getGuestList(session,
					userInputSortCondition);
			
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return  allSortedGuests;
	}

	// <<<<<<<<<<SERVICE >>>>>>>>>>>>

	// TODO delete int userInputOrderId
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.api.IMainController#createService(int,
	 * java.lang.String, int)
	 */
	@Override
	public void createService(int userInputOrderId,
			String userInputServiceName, int userInputPrice) {
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

	/*
	 * (non-Javadoc)
	 * 
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#showListOfServiceGuest(java.
	 * lang.String, java.lang.String)
	 */
	@Override
	public List<Service> showListOfServiceGuest(String idGuest,
			String userInputSortCondition) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		List<Service> service = null;
		try {
			 service = serviceController.getGuestThemServices(
					session, Integer.parseInt(idGuest));
			
			
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return service;
	}

	// TODO string to integer

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#changePriceOfService(java.lang
	 * .String, int)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.api.IMainController#showListOfService()
	 */
	@Override
	public List<Service> showListOfService() {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		List<Service> service = null;
		try {
			 service = serviceController.getServiceList(session,
					"name");
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return service;
	}

	// <<<<<<<<<<HOTEL ROOM >>>>>>>>>>>>

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.api.IMainController#addRooms(java.lang.String,
	 * int, int, int)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#showAllRooms(java.lang.String)
	 */
	@Override
	public List<String> showAllRooms(String userInputSortCondition) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		List<HotelRoom> rooms = null;
		List<String> results=new ArrayList<String>();
		try {
			 rooms = hotelRoomController.getHotelRoomList(
					session, true, userInputSortCondition);
			 for (HotelRoom s : rooms) {
				 results.add(hotelRoomToString(s));
				}

		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#showAllFreeRooms(java.lang.String
	 * )
	 */
	@Override
	public List<String> showAllFreeRooms(String userInputSortCondition) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		List<HotelRoom> rooms=null;
		List<String> results=new ArrayList<String>();
		try {
			 rooms = hotelRoomController.getHotelRoomList(
					session, true, userInputSortCondition);
			for (HotelRoom s : rooms) {
				results.add(hotelRoomToString(s));
			}
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#changeStatus(java.lang.String)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#showNumberOfFreeHotelRooms()
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#showDetailOfHotelRoom(java.lang
	 * .String)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#changePriceOfHotelRoom(java.
	 * lang.String, int)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#showPriceServiceAndHotelRoom()
	 */
	@Override
	public List<String> showPriceServiceAndHotelRoom() {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		List<String> result = new ArrayList<String>();
		try {
			List<String> listService = serviceController
					.getPriceService(session);
			List<String> listHotelRoom = hotelRoomController
					.getPriceHotelRoom(session);
			
			for (String a : listService) {
				result.add(a);
			}
			for (String b : listHotelRoom) {
				result.add(b);
			}
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return  result;
	}

	// TODO string to int

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#showSummToPaidGuest(java.lang
	 * .String)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#guestReadCsvFile(java.lang.String
	 * )
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#guestWriteCsvFile(java.lang.
	 * String)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#hotelRoomReadCsvFile(java.lang
	 * .String)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#hotelRoomWriteCsvFile(java.lang
	 * .String)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#serviceReadCsvFile(java.lang
	 * .String)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#serviceWriteCsvFile(java.lang
	 * .String)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.api.IMainController#departGuestFromHotelRoom(java
	 * .lang.String)
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

	public void addUser(String userLogin, String userPass) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		try {
			User u = new User(userLogin, userPass);
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

	public void addHandling(String userLogin, String resources) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		try {

			session.beginTransaction();
			User u = userController.getUserByLogin(session, userLogin);
			Date time = new Date();
			Handling h = new Handling(time, resources, u);
			handlingController.createSession(session, h);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
	}
	//login validation
	public User getUserByLogin(String login) {
		
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		User u = null;
		try {
			session.beginTransaction();
			u = userController.getUserByLogin(session, login);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return u;

	}
	
	
	public User getUser(String login, String pwd) {
		Session session = ConnectionFactoryHibernate.getOrInitSession();
		User u = null;
		try {
			session.beginTransaction();
			u = userController.getUser(session, login,pwd);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			session.getTransaction().rollback();
			ConnectionFactoryHibernate.destroy();
		} finally {
			session.close();
		}
		return u;
	}
	
	/**
	 * Hotel room to string.
	 *
	 * @param hr
	 *            the hr
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


}