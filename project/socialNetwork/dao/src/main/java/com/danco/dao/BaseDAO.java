package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.danco.api.dao.IDAO;
import com.danco.api.exception.MessageException;
import com.danco.api.exception.MyException;
import com.danco.model.BaseModel;


/**
 * The Class BaseDAO.
 *
 * @param <T> the generic type
 */
public abstract class BaseDAO<T extends BaseModel> implements IDAO<T> {

	/** The Constant UNCHECKED. */
	private static final String UNCHECKED = "unchecked";

	/** The clazz. */
	private Class<T> clazz;

	/** The sf. */
	@Autowired
	protected SessionFactory sf;

	/**
	 * Instantiates a new base DAO.
	 *
	 * @param clazz the clazz
	 */
	public BaseDAO(Class<T> clazz) {
		this.clazz = clazz;
	}

	/**
	 * Gets the criteria.
	 *
	 * @return the criteria
	 * @throws MyException the my exception
	 */
	protected Criteria getCriteria() throws MyException {

		Criteria criteria = sf.getCurrentSession().createCriteria(clazz);
		if (criteria == null) {
			throw new MyException(MessageException.DB_ERROR);
		}
		return criteria;
	}

	/**
	 * Gets the session.
	 *
	 * @return the session
	 * @throws MyException the my exception
	 */
	protected Session getSession() throws MyException {
		Session session = null;
		session = sf.getCurrentSession();
		if (session == null) {
			throw new MyException(MessageException.DB_ERROR);
		}
		return session;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IDAO#create(com.danco.model.BaseModel)
	 */
	public void create(T model) throws MyException {
		getSession().save(model);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IDAO#update(com.danco.model.BaseModel)
	 */
	public void update(T model) throws MyException {
		getSession().update(model);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IDAO#delete(com.danco.model.BaseModel)
	 */
	public void delete(T model) throws MyException {
		getSession().delete(model);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IDAO#getById(int)
	 */
	@Override
	@SuppressWarnings(UNCHECKED)
	public T getById(int idModel) throws MyException {
		return (T) getSession().get(clazz, idModel);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.dao.IDAO#getList()
	 */
	@Override
	@SuppressWarnings(UNCHECKED)
	public List<T> getList() throws MyException {
		Criteria criteria = getCriteria();
		return criteria.list();
	}

}
