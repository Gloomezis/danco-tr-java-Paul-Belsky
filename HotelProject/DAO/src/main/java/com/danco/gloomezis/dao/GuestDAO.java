/*
 * 
 */
package com.danco.gloomezis.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.danco.dao.api.IGuestDAO;
import com.danco.model.Guest;

public class GuestDAO implements  IGuestDAO {

	/**
	 * Instantiates a new guest dao.
	 */
	public GuestDAO() {

	}

	

	
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IGuestDAO#getById(org.hibernate.Session, int)
	 */
	@Override
	public Guest getById(Session session, int id) throws Exception {
		return (Guest) session.get(Guest.class, id);
	}
	
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IGuestDAO#getList(org.hibernate.Session, java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Guest> getList(Session session, String sortCondition) throws Exception {
		Criteria crit = session.createCriteria(Guest.class);
		List<Guest> guestList = (List<Guest>) crit.addOrder(Order.asc(sortCondition)).list();
		return guestList;
	} 
	
	
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IGuestDAO#getAllGuestNumber(org.hibernate.Session)
	 */
	@Override
	public int getAllGuestNumber(Session session) throws Exception {
		int count1= ((Long) session.createCriteria(Guest.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
		return count1;
		
	}
	
    

}
