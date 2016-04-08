package com.danco.gloomezis.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
	public List<HotelRoom> getList(Session session, String free, String sortCondition)
			throws Exception {
		Criteria crit = session.createCriteria(HotelRoom.class);
		List<HotelRoom> roomList = null;
		if (free.isEmpty()) {
			roomList = (List<HotelRoom>) crit.addOrder(Order.asc(sortCondition)).list();
		} else {
			roomList = (List<HotelRoom>) crit.add(Restrictions.eq("busy", 1))
					.addOrder(Order.asc(sortCondition)).list();
		}
		return roomList;
	} 
	
	
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IHotelRoomDAO#getFreeListAfterDate(org.hibernate.Session, java.lang.String, java.util.Date)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<HotelRoom> getFreeListAfterDate(Session session,
			String SortCondition, Date date)
			throws Exception {
		Criteria crit = session.createCriteria(HotelRoom.class);
		List<HotelRoom> roomList = null;
		
			roomList = (List<HotelRoom>) crit.add(Restrictions.lt("date_departure",date)).addOrder(Order.asc(SortCondition)).list();
		
		return roomList;
	} 
	
	
    /* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IHotelRoomDAO#getNumberFreeHotelRooms(org.hibernate.Session)
	 */
    
	@Override
	public int getNumberFreeHotelRooms(Session session) throws Exception {
		//Integer count = (Integer) session.createQuery("select count(*) from hotel_room as room where room.busy:=1").uniqueResult();
		Integer count=(Integer) session.createCriteria(HotelRoom.class).add(Restrictions.eq("busy", 1).ignoreCase()).setProjection(Projections.rowCount()).uniqueResult();
		return count;
		
	}
	
	
    /* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IHotelRoomDAO#getPriceHotelRoom(org.hibernate.Session)
	 */
    @Override
	@SuppressWarnings("unchecked")
	public List<String> getPriceHotelRoom(Session session) throws Exception{
		String hql="SELECT hr.number, hr.price from hotel_room as hr ORDER by hr.price DESC";
		Query query =session.createQuery(hql);
		@SuppressWarnings("rawtypes")
		List list = query.list();
		return list;
	}
	

}
