package com.danco.servise;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.model.Guest;
import com.danco.model.HotelRoom;
import com.danco.servise.api.IHotelRoomService;
import com.danco.storages.MainStorage;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomService.
 */
public class HotelRoomService implements IHotelRoomService {

	/** The main storage. */
	private MainStorage mainStorage = MainStorage.getInstance();

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(HotelRoomService.class.getName());


	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";
	
	/** The instance. */
//	private static IHotelRoomService instance;

	/**
	 * Gets the single instance of HotelRoomService.
	 *
	 * @return single instance of HotelRoomService
	 */
//	public static IHotelRoomService getInstance() {
//		if (instance == null) {
//			instance = new HotelRoomService();
//		}
//		return instance;
//	}

	/**
	 * Instantiates a new hotel room service.
	 */
//	private HotelRoomService() {

//	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IHotelRoomService#createHotelRoom(java.lang.String, int, int, int)
	 */
	@Override
	public HotelRoom createHotelRoom(String name, int roomPrice, int sleepingNumbers, int starCategory) {

		try {
			return mainStorage.createHotelRoom(name, roomPrice, sleepingNumbers, starCategory);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IHotelRoomService#getHotelRoomByNumber(java.lang.String)
	 */
	@Override
	public HotelRoom getHotelRoomByNumber(String NumberOfRoom) {

		try {
			return mainStorage.getHotelRoomByNumber(NumberOfRoom);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IHotelRoomService#showAllRooms(java.lang.String, java.lang.String)
	 */

	@Override
	public List<HotelRoom> showAllRooms(String sortCondition, String free) {
		try {
			return mainStorage.showAllRooms(sortCondition, free);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IHotelRoomService#showFreeRomsAfterDate(java.lang.String, java.util.Date)
	 */

	@Override
	public List<HotelRoom> showFreeRomsAfterDate(String sortCondition, Date date) {
		try {
			return mainStorage.showFreeRomsAfterDate(sortCondition, date);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IHotelRoomService#showNumberOfFreeHotelRooms()
	 */

	@Override
	public int showNumberOfFreeHotelRooms() {
		try {
		return	mainStorage.showNumberOfFreeHotelRooms();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IHotelRoomService#showLast3GuestOfHotelRoom(com.danco.model.HotelRoom)
	 */

	@Override
	public List<Guest> showLast3GuestOfHotelRoom(HotelRoom hotelRoom) {
		try {
			return mainStorage.showLast3GuestOfHotelRoom(hotelRoom);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IHotelRoomService#showDetailOfHotelRoom(com.danco.model.HotelRoom)
	 */

	@Override
	public String showDetailOfHotelRoom(HotelRoom hotelRoom) {
		try {
			return mainStorage.showDetailOfHotelRoom(hotelRoom);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}
		return null;
		
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IHotelRoomService#settleGuestToHotelRoom(com.danco.model.Guest, com.danco.model.HotelRoom, java.util.Date, java.util.Date)
	 */

	@Override
	public void settleGuestToHotelRoom(Guest guest, HotelRoom hotelRoom, Date dateOfArrive, Date dateOfDeparture) {
		try {

			mainStorage.settleGuestToHotelRoom(guest, hotelRoom, dateOfArrive, dateOfDeparture);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}

	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IHotelRoomService#departGuestFromHotelRoom(com.danco.model.HotelRoom)
	 */

	@Override
	public void departGuestFromHotelRoom(HotelRoom hotelRoom) {
		try {
			mainStorage.departGuestFromHotelRoom(hotelRoom);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IHotelRoomService#changeStatus(com.danco.model.HotelRoom)
	 */

	@Override
	public void changeStatus(HotelRoom hotelRoom) {
		try {
			mainStorage.changeStatus(hotelRoom);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}

	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IHotelRoomService#addRooms(com.danco.model.HotelRoom)
	 */

	@Override
	public void addRooms(HotelRoom room) {
		try {
			mainStorage.addRooms(room);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IHotelRoomService#changePriceOfHotelRoom(com.danco.model.HotelRoom, int)
	 */

	@Override
	public void changePriceOfHotelRoom(HotelRoom hotelRoom, int roomPrice) {
		try {
			mainStorage.changePriceOfHotelRoom(hotelRoom, roomPrice);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IHotelRoomService#showPriceHotelRoom()
	 */

	@Override
	public List<HotelRoom> showPriceHotelRoom() {
		try {
			return mainStorage.showPriceHotelRoom();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IHotelRoomService#cloneHotelRoom(com.danco.model.HotelRoom)
	 */
	@Override
	public HotelRoom cloneHotelRoom(HotelRoom room) {
		try {
			return mainStorage.cloneHotelRoom(room);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.danco.serviñe.IHotelRoomService#getRooms()
	 */
	@Override
	public List<HotelRoom> getRooms() {
		try {
		return mainStorage.getRooms();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			return null;
		}
	}

}
