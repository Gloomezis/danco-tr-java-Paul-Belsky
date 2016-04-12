package com.danco.gloomezis.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.danco.dao.api.IHotelRoomDAO;
import com.danco.model.HotelRoom;


// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomDAO.
 */
public class HotelRoomDAO implements  IHotelRoomDAO {

	/**
	 * Instantiates a new hotel room dao.
	 */
	public HotelRoomDAO() {

	}

	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IHotelRoomDAO#getById(org.hibernate.Session, int)
	 */
	@Override
	public HotelRoom getById(Session session, int id) throws Exception {
		return (HotelRoom) session.get(HotelRoom.class, id);
	}

	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IHotelRoomDAO#getList(org.hibernate.Session, java.lang.String, java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<HotelRoom> getList(Session session, Boolean free, String sortCondition)
			throws Exception {
		Criteria crit = session.createCriteria(HotelRoom.class);
		List<HotelRoom> roomList = null;
		if (free) {
			roomList = (List<HotelRoom>) crit.add(Restrictions.eq("busy", true))
					.addOrder(Order.asc(sortCondition)).list();
		} else {
			roomList = (List<HotelRoom>) crit.addOrder(Order.asc(sortCondition)).list();
		}
		return roomList;
	} 
	
	
	
    /* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IHotelRoomDAO#getNumberFreeHotelRooms(org.hibernate.Session)
	 */
    
	@Override
	public int getNumberFreeHotelRooms(Session session) throws Exception {
		int count=((Long) session.createCriteria(HotelRoom.class).add(Restrictions.eq("busy", true)).setProjection(Projections.rowCount()).uniqueResult()).intValue();
		return count;	
	}
	
	
    /* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IHotelRoomDAO#getPriceHotelRoom(org.hibernate.Session)
	 */
    @Override
	@SuppressWarnings("unchecked")
	public List<String> getPriceHotelRoom(Session session) throws Exception{
		
		Criteria crit= session.createCriteria(HotelRoom.class);
		crit.setProjection(Projections.projectionList().add(Projections.property("number")).add(Projections.property("roomPrice")));
		List<String> result = new ArrayList<String>();
		crit.addOrder(Order.desc("price"));
		 List<Object[]> rows = crit.list(); 
		    for (Object[] row : rows) {
		       result.add("Hotel room : "+row[0] + " ,price: " + row[1]);
		    }
	
		return result;
	}
	

}
