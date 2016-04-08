package com.danco.gloomezis.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.danco.dao.api.IOrdersDAO;
import com.danco.model.HotelRoom;
import com.danco.model.Orders;

// TODO: Auto-generated Javadoc
/**
 * The Class OrdersDAO.
 */
public class OrdersDAO implements  IOrdersDAO {

	/**
	 * Instantiates a new orders dao.
	 */
	public OrdersDAO() {

	}

	
	/* (non-Javadoc)
	 * @see com.danco.dao.api.IDAO#getById(org.hibernate.Session, int)
	 */
	@Override
	public Orders getById(Session session, int id) throws Exception {
		Orders order = (Orders) session.get(Orders.class, id);
		return order;
	}
	
	/* (non-Javadoc)
	 * @see com.danco.dao.api.IOrdersDAO#getList(org.hibernate.Session, java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Orders> getList(Session session, String sortCondition)
			throws Exception {
		Criteria crit = session.createCriteria(Orders.class);
		List<Orders> chekList = crit.addOrder(Order.asc(sortCondition)).list();
		return chekList;
	}

	/* (non-Javadoc)
	 * @see com.danco.dao.api.IOrdersDAO#getOrdersForIdGuest(org.hibernate.Session, int)
	 */
	@Override
	public Orders getOrdersForIdGuest(Session session, int idGuest)
			throws Exception {
		Criteria crit = session.createCriteria(Orders.class);

		Orders order = (Orders) crit.add(Restrictions.and(
				Restrictions.eq("guest_id", idGuest),
				Restrictions.eq("status", false)));

		return order;
	} 
	
	/* (non-Javadoc)
	 * @see com.danco.dao.api.IOrdersDAO#getPriceOrderForGuest(org.hibernate.Session, int)
	 */
	@Override
	public int getPriceOrderForGuest(Session session, int idGuest)
			throws Exception {

		Criteria crit = session.createCriteria(HotelRoom.class);
		crit.createCriteria("orders", JoinType.RIGHT_OUTER_JOIN)
				.add(Restrictions.eq("guest.id", idGuest)).add(Restrictions.eq("paid", false));
		crit.uniqueResult();
		HotelRoom hr=(HotelRoom) crit.list();
		int sum = hr.getRoomPrice();

		return sum;
	} 
	
	


	
}
