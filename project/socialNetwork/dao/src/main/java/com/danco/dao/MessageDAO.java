package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IMessageDAO;
import com.danco.api.exception.MyException;
import com.danco.model.Message;


/**
 * The Class MessageDAO.
 */
@Repository
public class MessageDAO extends BaseDAO<Message> implements IMessageDAO {

	/** The Constant R_ID. */
	private static final String R_ID = "r.id";
	
	/** The Constant S_ID. */
	private static final String S_ID = "s.id";
	
	/** The Constant DELETED. */
	private static final String DELETED = "deleted";
	
	/** The Constant ID. */
	private static final String ID = "id";
	
	/** The Constant R. */
	private static final String R = "r";
	
	/** The Constant RECEIVER. */
	private static final String RECEIVER = "receiver";
	
	/** The Constant S. */
	private static final String S = "s";
	
	/** The Constant SENDER. */
	private static final String SENDER = "sender";
	
	/** The Constant UNCHECKED2. */
	private static final String UNCHECKED2 = "unchecked";
	
	/** The Constant LOCATION_DAO_CREATED. */
	private static final String LOCATION_DAO_CREATED = "Location dao created";

	/**
	 * Instantiates a new message DAO.
	 */
	public MessageDAO() {
		super(Message.class);
		System.out.println(LOCATION_DAO_CREATED);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IMessageDAO#getListByUserId(int, int, int)
	 */
	@SuppressWarnings(UNCHECKED2)
	@Override
	public List<Message> getListByUserId(int myId, int startMessageId,
			int pageSize) throws MyException {
		Criteria criteria = sf.getCurrentSession()
				.createCriteria(Message.class);
		criteria.setFetchMode(SENDER, FetchMode.JOIN).createAlias(SENDER,
				S);
		criteria.setFetchMode(RECEIVER, FetchMode.JOIN).createAlias(
				RECEIVER, R);
		criteria.setFirstResult(startMessageId);
		criteria.setMaxResults(pageSize);
		criteria.addOrder(Order.desc(ID));
		criteria.add(Restrictions.eq(DELETED, false));
		Disjunction or = Restrictions.disjunction();
		or.add(Restrictions.eq(S_ID, myId));
		or.add(Restrictions.eq(R_ID, myId));
		criteria.add(or);
		List<Message> messageList = (List<Message>) criteria.list();
		return messageList;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IMessageDAO#getListPrivateMessage(int, int, int, int)
	 */
	@SuppressWarnings(UNCHECKED2)
	@Override
	public List<Message> getListPrivateMessage(int myId, int userId,
			int startMessageId, int pageSize) throws MyException {
		Criteria criteria = sf.getCurrentSession()
				.createCriteria(Message.class);
		criteria.setFetchMode(SENDER, FetchMode.JOIN).createAlias(SENDER,
				S);
		criteria.setFetchMode(RECEIVER, FetchMode.JOIN).createAlias(
				RECEIVER, R);
		criteria.setFirstResult(startMessageId);
		criteria.setMaxResults(pageSize);
		criteria.addOrder(Order.desc(ID));
		criteria.add(Restrictions.eq(DELETED, false));
		Disjunction or = Restrictions.disjunction();
		or.add(Restrictions.and(Restrictions.eq(S_ID, myId),
				Restrictions.eq(R_ID, userId)));
		or.add(Restrictions.and(Restrictions.eq(R_ID, myId),
				Restrictions.eq(S_ID, userId)));
		criteria.add(or);
		List<Message> messageList = (List<Message>) criteria.list();
		return messageList;
	}
}