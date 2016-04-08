package com.danco.dao.api;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.danco.model.HotelRoom;


// TODO: Auto-generated Javadoc
/**
 * The Interface IHotelRoomDAO.
 */
public interface IHotelRoomDAO extends IDAO<HotelRoom>{
	
	
	/**
	 * Gets the list.
	 *
	 * @param session the session
	 * @param free the free
	 * @param sortCondition the sort condition
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<HotelRoom> getList(Session session, String free, String sortCondition)throws Exception; 
	
	/**
	 * Gets the number free hotel rooms.
	 *
	 * @param session the session
	 * @return the number free hotel rooms
	 * @throws Exception the exception
	 */
	public int getNumberFreeHotelRooms(Session session)throws Exception;

	/**
	 * Gets the free list after date.
	 *
	 * @param session the session
	 * @param SortCondition the sort condition
	 * @param date the date
	 * @return the free list after date
	 * @throws Exception the exception
	 */
	public List<HotelRoom> getFreeListAfterDate(Session session,
			String SortCondition, Date date)throws Exception ;

	/**
	 * Gets the price hotel room.
	 *
	 * @param session the session
	 * @return the price hotel room
	 * @throws Exception the exception
	 */
	public List<String> getPriceHotelRoom(Session session)throws Exception;

	

	
	
	
	
	
	
	
	
	
	
	
	
	


}