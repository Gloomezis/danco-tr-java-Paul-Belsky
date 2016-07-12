package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IDialogDAO;
import com.danco.api.exception.MyException;
import com.danco.model.Dialog;


/**
 * The Class DialogDAO.
 */
@Repository
public class DialogDAO extends BaseDAO<Dialog> implements IDialogDAO {

	/** The Constant C_ID. */
	private static final String C_ID = "c.id";
	
	/** The Constant C. */
	private static final String C = "c";
	
	/** The Constant GROUP. */
	private static final String GROUP = "group";
	
	/** The Constant CREATOR. */
	private static final String CREATOR = "creator";
	
	/** The Constant ID2. */
	private static final String ID2 = "id";
	
	/** The Constant UNCHECKED2. */
	private static final String UNCHECKED2 = "unchecked";
	
	/** The Constant DIALOG_DAO_CREATED. */
	private static final String DIALOG_DAO_CREATED = "Dialog dao created";

	/**
	 * Instantiates a new dialog DAO.
	 */
	public DialogDAO() {
		super(Dialog.class);
		System.out.println(DIALOG_DAO_CREATED);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IDialogDAO#getListByGroupId(int, int, int)
	 */
	@SuppressWarnings(UNCHECKED2)
	@Override
	public List<Dialog> getListByGroupId(int id, int startDialogId, int pageSize)
			throws MyException {
		Criteria criteria = sf.getCurrentSession().createCriteria(Dialog.class);
		criteria.setFirstResult(startDialogId);
		criteria.setMaxResults(pageSize);
		criteria.addOrder(Order.desc(ID2));
		criteria.setFetchMode(CREATOR, FetchMode.JOIN);
		criteria.createAlias(GROUP, C).add(Restrictions.eq(C_ID, id));
		List<Dialog> dialogList = (List<Dialog>) criteria
				.list();
		return dialogList;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IDialogDAO#getDialogsCountByGroupId(int)
	 */
	@Override
	public int getDialogsCountByGroupId(int id) throws MyException {
		Criteria criteria = sf.getCurrentSession().createCriteria(Dialog.class);
		criteria.createCriteria(GROUP, JoinType.LEFT_OUTER_JOIN)
				.add(Restrictions.eq(ID2, id))
				.setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();

		return count.intValue();
	}

}
