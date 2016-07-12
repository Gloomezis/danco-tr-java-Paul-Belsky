package com.danco.api.dao;

import java.util.List;

import com.danco.api.exception.MyException;
import com.danco.model.DialogMessage;


/**
 * The Interface IDialogMessageDAO.
 */
public interface IDialogMessageDAO extends IDAO<DialogMessage> {

	/**
	 * Gets the list by dialog id.
	 *
	 * @param id the id
	 * @param startDialogMessageId the start dialog message id
	 * @param pageSize the page size
	 * @return the list by dialog id
	 * @throws MyException the my exception
	 */
	public List<DialogMessage> getListByDialogId(int id,
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