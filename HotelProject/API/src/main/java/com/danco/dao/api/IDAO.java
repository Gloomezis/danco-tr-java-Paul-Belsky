package com.danco.dao.api;

import org.hibernate.Session;

import com.danco.model.BaseModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface IDAO.
 *
 * @param <T> the generic type
 */
public interface IDAO<T extends BaseModel > {
	
	
	
	/**
	 * Creates the.
	 *
	 * @param session the session
	 * @param model the model
	 * @throws Exception the exception
	 */
	default void create(Session session, T model)throws Exception {
		session.save(model);
	}

	/**
	 * Update.
	 *
	 * @param session the session
	 * @param model the model
	 * @throws Exception the exception
	 */
	default void update(Session session, T model)throws Exception {
		session.update(model);
	}

	/**
	 * Delete.
	 *
	 * @param session the session
	 * @param model the model
	 * @throws Exception the exception
	 */
	default void delete(Session session, T model)throws Exception {
		session.delete(model);
	} 
	
	/**
	 * Gets the by id.
	 *
	 * @param session the session
	 * @param idModel the id model
	 * @return the by id
	 * @throws Exception the exception
	 */
	public T getById(Session session, int idModel)throws Exception ; 
	
	
	

	

}
