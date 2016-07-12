package com.danco.api.service;

import java.util.HashMap;

import com.danco.api.exception.MyException;
import com.danco.model.DialogMessage;


/**
 * The Interface IDialogMessageService.
 */
public interface IDialogMessageService extends IService<DialogMessage> {

	/**
	 * Gets the list by dialog id.
	 *
	 * @param id the id
	 * @param startDialogMessageId the start dialog message id
	 * @param pageSize the page size
	 * @return the list by dialog id
	 * @throws MyException the my exception
	 */
	public HashMap<String, Object> getListByDialogId(int id,
			int startDialogMessageId, int pageSize) throws MyException;

	/**
	 * Gets the dialog messages count by dialog id.
	 *
	 * @param id the id
	 * @return the dialog messages count by dialog id
	 * @throws MyException the my exception
	 */
	public int getDialogMessagesCountByDialogId(int id) throws MyException;

}