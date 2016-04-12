package com.danco.controller;

import java.util.List;

import org.hibernate.Session;

import com.danco.dao.api.IHotelRoomDAO;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.HotelRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomController.
 */
public class HotelRoomController {

	/** The hotel room dao. */
	private IHotelRoomDAO hotelRoomDAO = (IHotelRoomDAO) DependencyInjectionManager
			.getClassInstance(IHotelRoomDAO.class);

	
	/**
	 * Creates the hotel room.
	 *
	 * @param session the session
	 * @param hr the hr
	 * @throws Exception the exception
	 */
	public void createHotelRoom(Session session, HotelRoom hr) throws Exception {
		 hotelRoomDAO.create(session, hr);
	}
	

	/**
	 * Delete hotel room.
	 *
	 * @param session the session
	 * @param hr the hr
	 * @throws Exception the exception
	 */
	public void deleteHotelRoom(Session session, HotelRoom hr) throws Exception {

		hotelRoomDAO.delete(session, hr);

	}

	/**
	 * Update hotel room.
	 *
	 * @param session the session
	 * @param hr the hr
	 * @throws Exception the exception
	 */
	public void updateHotelRoom(Session session, HotelRoom hr) throws Exception {

		hotelRoomDAO.update(session, hr);

	}

	/**
	 * Gets the hotel room by id.
	 *
	 * @param session the session
	 * @param id the id
	 * @return the hotel room by id
	 * @throws Exception the exception
	 */
	public HotelRoom getHotelRoomById(Session session, int id) throws Exception {

		return hotelRoomDAO.getById(session, id);

	}
	
	/**
	 * Gets the hotel room list.
	 *
	 * @param session the session
	 * @param free the free
	 * @param sortCondition the sort condition
	 * @return the hotel room list
	 * @throws Exception the exception
	 */
	public List<HotelRoom> getHotelRoomList(Session session, boolean free, String sortCondition)throws Exception{
		return hotelRoomDAO.getList(session, free, sortCondition);
	}; 
	
	
	/**
	 * Gets the number free hotel rooms.
	 *
	 * @param session the session
	 * @return the number free hotel rooms
	 * @throws Exception the exception
	 */
	public int getNumberFreeHotelRooms(Session session) throws Exception {
		return hotelRoomDAO.getNumberFreeHotelRooms(session);
	}
	
	
	/**
	 * Gets the price hotel room.
	 *
	 * @param session the session
	 * @return the price hotel room
	 * @throws Exception the exception
	 */
	public List<String> getPriceHotelRoom(Session session) throws Exception {

		return hotelRoomDAO.getPriceHotelRoom(session);

	}
	
	
}
