package com.danco.api.dao;

import java.util.List;

import com.danco.api.exception.MyException;
import com.danco.model.BaseModel;


/**
 * The Interface IDAO.
 *
 * @param <T> the generic type
 */
public interface IDAO<T extends BaseModel> {

	/**
	 * Creates the.
	 *
	 * @param model the model
	 * @throws MyException the my exception
	 */
	public void create(T model) throws MyException;

	/**
	 * Update.
	 *
	 * @param model the model
	 * @throws MyException the my exception
	 */
	public void update(T model) throws MyException;

	/**
	 * Delete.
	 *
	 * @param model the model
	 * @throws MyException the my exception
	 */
	public void delete(T model) throws MyException;

	/**
	 * Gets the by id.
	 *
	 * @param idModel the id model
	 * @return the by id
	 * @throws MyException the my exception
	 */
	public T getById(int idModel) throws MyException;

	/**
	 * Gets the list.
	 *
	 * @return the list
	 * @throws MyException the my exception
	 */
	public List<T> getList() throws MyException;

}
