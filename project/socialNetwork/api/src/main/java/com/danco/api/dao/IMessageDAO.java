package com.danco.api.dao;

import java.util.List;

import com.danco.api.exception.MyException;
import com.danco.model.Message;


/**
 * The Interface IMessageDAO.
 */
public interface IMessageDAO extends IDAO<Message> {

	/**
	 * Gets the list by user id.
	 *
	 * @param myId the my id
	 * @param startMessageId the start message id
	 * @param pageSize the page size
	 * @return the list by user id
	 * @throws MyException the my exception
	 */
	public List<Message> getListByUserId(int myId, int startMessageId,
			int pageSize) throws MyException;

	/**
	 * Gets the list private message.
	 *
	 * @param myId the my id
	 * @param userId the user id
	 * @param startMessageId the start message id
	 * @param pageSize the page size
	 * @return the list private message
	 * @throws MyException the my exception
	 */
	public List<Message> getListPrivateMessage(int myId, int userId,
			int startMessageId, int pageSize) throws MyException;

}