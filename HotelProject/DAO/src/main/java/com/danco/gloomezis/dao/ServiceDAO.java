/*
 * 
 */
package com.danco.gloomezis.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.danco.dao.api.IServiceDAO;
import com.danco.model.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceDAO.
 */
public class ServiceDAO implements  IServiceDAO {

	/**
	 * Instantiates a new service dao.
	 */
	public ServiceDAO() {

	}
	
	/* (non-Javadoc)
	 * @see com.danco.dao.api.IDAO#getById(org.hibernate.Session, int)
	 */
	@Override
	public Service getById(Session session, int id) throws Exception {
		return (Service) session.get(Service.class, id);
	}
	
	/* (non-Javadoc)
	 * @see com.danco.dao.api.IServiceDAO#getList(org.hibernate.Session, java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Service> getList(Session session, String sortCondition)
			throws Exception {
		Criteria crit = session.createCriteria(Service.class);
		List<Service> serviceList = (List<Service>) crit.addOrder(
				Order.asc(sortCondition)).list();

		return serviceList;
	}
	
	/* (non-Javadoc)
	 * @see com.danco.dao.api.IServiceDAO#getGuestThemServices(org.hibernate.Session, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Service> getGuestThemServices(Session session, int idGuest)
			throws Exception {

		Criteria crit = session.createCriteria(Service.class);
		List<Service> serviceList = (List<Service>) crit.createCriteria("orders", JoinType.RIGHT_OUTER_JOIN)
				.add(Restrictions.eq("guest.id", idGuest)).add(Restrictions.eq("paid", false)).list();
		return serviceList;
	}

	/* (non-Javadoc)
	 * @see com.danco.dao.api.IServiceDAO#getSumServiceForGuest(org.hibernate.Session, int)
	 */
	@Override
	public int getSumServiceForGuest(Session session, int idGuest)
			throws Exception {

		Criteria crit = session.createCriteria(Service.class);
		crit.setProjection(Projections.sum("price"))
				.createCriteria("orders", JoinType.RIGHT_OUTER_JOIN)
				.add(Restrictions.eq("guest.id", idGuest)).add(Restrictions.eq("paid", false));
		crit.uniqueResult();
		Long summ = (Long) crit.uniqueResult();
		int sum = summ.intValue();

		return sum;
	} 
	
	
	/* (non-Javadoc)
	 * @see com.danco.dao.api.IServiceDAO#getPriceService(org.hibernate.Session)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> getPriceService(Session session) throws Exception{
		String hql="SELECT s.name, s.price from service as s ORDER by s.price DESC";
		Query query =session.createQuery(hql);
		@SuppressWarnings("rawtypes")
		List list = query.list();
		return list;
	}
	
	
}
