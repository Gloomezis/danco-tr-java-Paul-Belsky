package com.danco.api.dao;

import java.util.List;

import com.danco.api.exception.MyException;
import com.danco.model.Dialog;

/**
 * The Interface IDialogDAO.
 */
public interface IDialogDAO extends IDAO<Dialog> {

	/**
	 * Gets the list by group id.
	 *
	 * @param id the id
	 * @param startDialogId the start dialog id
	 * @param pageSize the page size
	 * @return the list by group id
	 * @throws MyException the my exception
	 */
	public List<Dialog> getListByGroupId(int id, int startDialogId, int pageSize)
			throws MyException;

	/**
	 * Gets the dialogs count by group id.
	 *
	 * @param id the id
	 * @return the dialogs count by group id
	 * @throws MyException the my exception
	 */
	public int getDialogsCountByGroupId(int id) throws MyException;

}