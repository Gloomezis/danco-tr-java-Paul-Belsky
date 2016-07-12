package com.danco.api.service;

import java.util.HashMap;

import com.danco.api.exception.MyException;
import com.danco.model.Message;


/**
 * The Interface IMessageService.
 */
public interface IMessageService extends IService<Message> {

	/**
	 * Gets the list by user id.
	 *
	 * @param myId the my id
	 * @param startMessageId the start message id
	 * @param pageSize the page size
	 * @return the list by user id
	 * @throws MyException the my exception
	 */
	public HashMap<String, Object> getListByUserId(int myId,
			int startMessageId, int pageSize) throws MyException;

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
	public HashMap<String, Object> getListPrivateMessage(int myId, int userId,
			int startMessageId, int pageSize) throws MyException;

}