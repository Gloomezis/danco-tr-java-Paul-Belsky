package com.danco.dao.api;

import java.util.List;

import org.hibernate.Session;

import com.danco.model.HotelRoom;


// TODO: Auto-generated Javadoc
/**
 * The Interface IHotelRoomDAO.
 */
public interface IHotelRoomDAO extends IDAO<HotelRoom>{
	
	
	
	/**
	 * Gets the number free hotel rooms.
	 *
	 * @param session the session
	 * @return the number free hotel rooms
	 * @throws Exception the exception
	 */
	public int getNumberFreeHotelRooms(Session session)throws Exception;

	

	/**
	 * Gets the price hotel room.
	 *
	 * @param session the session
	 * @return the price hotel room
	 * @throws Exception the exception
	 */
	public List<String> getPriceHotelRoom(Session session)throws Exception;

	
	List<HotelRoom> getList(Session session, Boolean free, String sortCondition)
			throws Exception;

	

	
	
	
	
	
	
	
	
	
	
	
	
	


}