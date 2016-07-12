package com.danco.api.dao;

import java.util.List;

import com.danco.api.exception.MyException;
import com.danco.model.Comment;


/**
 * The Interface ICommentDAO.
 */
public interface ICommentDAO extends IDAO<Comment> {

	/**
	 * Gets the list by post id pagination.
	 *
	 * @param id the id
	 * @param startPostId the start post id
	 * @param pageSize the page size
	 * @return the list by post id pagination
	 * @throws MyException the my exception
	 */
	public List<Comment> getListByPostIdPagination(int id, int startPostId,
			int pageSize) throws MyException;

	/**
	 * Gets the message count by post id.
	 *
	 * @param id the id
	 * @return the message count by post id
	 * @throws MyException the my exception
	 */
	public int getmessageCountByPostId(int id) throws MyException;

}