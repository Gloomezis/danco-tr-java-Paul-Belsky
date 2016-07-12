package com.danco.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IDAO;
import com.danco.api.exception.MessageException;
import com.danco.api.exception.MyException;
import com.danco.api.service.IService;
import com.danco.model.BaseModel;


/**
 * The Class BaseService.
 *
 * @param <T> the generic type
 */
@Service
public abstract class BaseService<T extends BaseModel> implements IService<T> {

	/** The Constant LOGGER. */
	protected static final Logger LOGGER = LogManager
			.getLogger(BaseService.class);

	/** The dao. */
	@Autowired
	private IDAO<T> dao;

	/* (non-Javadoc)
	 * @see com.danco.api.service.IService#create(com.danco.model.BaseModel)
	 */
	@Override
	@Transactional(rollbackFor = MyException.class)
	public void create(T model) throws MyException {
		try {
			dao.create(model);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new MyException(MessageException.NOT_CREATED);
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IService#update(com.danco.model.BaseModel)
	 */
	@Override
	@Transactional(rollbackFor = MyException.class)
	public void update(T model) throws MyException {
		try {
			dao.update(model);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new MyException(MessageException.NOT_UPDATED);
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IService#delete(com.danco.model.BaseModel)
	 */
	@Override
	@Transactional(rollbackFor = MyException.class)
	public void delete(T model) throws MyException {
		try {
			dao.delete(model);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new MyException(MessageException.NOT_DELETED);
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IService#getById(int)
	 */
	@Override
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	public T getById(int idModel) throws MyException {
		T model = null;
		model = dao.getById(idModel);
		if (model == null) {
			throw new MyException(MessageException.NOT_FOUND);
		}
		return model;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IService#getList()
	 */
	@Override
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	public List<T> getList() throws MyException {
		List<T> list = null;

		list = dao.getList();
		if (list == null) {
			throw new MyException(MessageException.NOT_FOUND);
		}
		return list;
	}
}
