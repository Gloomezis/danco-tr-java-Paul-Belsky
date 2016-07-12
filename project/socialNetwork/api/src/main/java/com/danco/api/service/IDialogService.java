package com.danco.api.service;

import java.util.HashMap;

import com.danco.api.exception.MyException;
import com.danco.model.Dialog;


/**
 * The Interface IDialogService.
 */
public interface IDialogService extends IService<Dialog> {

	/**
	 * Gets the list by group id.
	 *
	 * @param id the id
	 * @param startDialogId the start dialog id
	 * @param pageSize the page size
	 * @return the list by group id
	 * @throws MyException the my exception
	 */
	public HashMap<String, Object> getListByGroupId(int id, int startDialogId,
			int pageSize) throws MyException;

	/**
	 * Gets the dialogs count by group id.
	 *
	 * @param id the id
	 * @return the dialogs count by group id
	 * @throws MyException the my exception
	 */
	public int getDialogsCountByGroupId(int id) throws MyException;

}