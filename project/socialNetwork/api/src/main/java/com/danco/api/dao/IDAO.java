package com.danco.api.dao;



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
	default void create(T model) {
		
	}

	/**
	 * Update.
	 *
	 * @param session the session
	 * @param model the model
	 * @throws Exception the exception
	 */
	default void update( T model) {
	
	}

	/**
	 * Delete.
	 *
	 * @param session the session
	 * @param model the model
	 * @throws Exception the exception
	 */
	default void delete( T model) {
		
	} 
	
	/**
	 * Gets the by id.
	 *
	 * @param session the session
	 * @param idModel the id model
	 * @return the by id
	 * @throws Exception the exception
	 */
	public T getById(int idModel) ; 
	
	
	

	

}
