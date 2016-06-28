package com.danco.api.dao;

import java.util.List;

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
	 * @throws Exception the exception
	 */
	public void create(T model) throws Exception;

	/**
	 * Update.
	 *
	 * @param model the model
	 * @throws Exception the exception
	 */
	public void update(T model) throws Exception;

	/**
	 * Delete.
	 *
	 * @param model the model
	 * @throws Exception the exception
	 */
	public void delete(T model) throws Exception;

	/**
	 * Gets the by id.
	 *
	 * @param idModel the id model
	 * @return the by id
	 * @throws Exception the exception
	 */
	public T getById(int idModel) throws Exception;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 * @throws Exception the exception
	 */
	public List<T> getList() throws Exception;

	

}
