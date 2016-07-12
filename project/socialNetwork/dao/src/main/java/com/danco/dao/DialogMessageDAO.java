package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IDialogMessageDAO;
import com.danco.api.exception.MyException;
import com.danco.model.DialogMessage;


/**
 * The Class DialogMessageDAO.
 */
@Repository
public class DialogMessageDAO extends BaseDAO<DialogMessage> implements
		IDialogMessageDAO {

	/** The Constant B. */
	private static final String B = "b";
	
	/** The Constant DIALOG. */
	private static final String DIALOG = "dialog";
	
	/** The Constant CREATOR. */
	private static final String CREATOR = "creator";
	
	/** The Constant UNCHECKED2. */
	private static final String UNCHECKED2 = "unchecked";
	
	/** The Constant ID2. */
	private static final String ID2 = "id";
	
	/** The Constant DIALOG_MESSAGE_DAO_CREATED. */
	private static final String DIALOG_MESSAGE_DAO_CREATED = "DialogMessage dao created";

	/**
	 * Instantiates a new dialog message DAO.
	 */
	public DialogMessageDAO() {
		super(DialogMessage.class);
		System.out.println(DIALOG_MESSAGE_DAO_CREATED);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IDialogMessageDAO#getListByDialogId(int, int, int)
	 */
	@SuppressWarnings(UNCHECKED2)
	@Override
	public List<DialogMessage> getListByDialogId(int id,
			int startDialogMessageId, int pageSize) throws MyException {
		Criteria criteria = sf.getCurrentSession().createCriteria(
				DialogMessage.class);
		criteria.setFirstResult(startDialogMessageId);
		criteria.setMaxResults(pageSize);
		criteria.addOrder(Order.desc(ID2));
		criteria.setFetchMode(CREATOR, FetchMode.JOIN).createAlias(CREATOR,
				B);
		criteria.createCriteria(DIALOG, JoinType.RIGHT_OUTER_JOIN).add(
				Restrictions.eq(ID2, id));
		List<DialogMessage> dialogMessageList = (List<DialogMessage>) criteria
				.list();
		return dialogMessageList;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IDialogMessageDAO#getDialogMessagesCountByDialogId(int)
	 */
	@Override
	public int getDialogMessagesCountByDialogId(int id) throws MyException {
		Criteria criteria = sf.getCurrentSession().createCriteria(
				DialogMessage.class);
		criteria.createCriteria(DIALOG, JoinType.LEFT_OUTER_JOIN)
				.add(Restrictions.eq(ID2, id))
				.setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();
		return count.intValue();
	}

}
