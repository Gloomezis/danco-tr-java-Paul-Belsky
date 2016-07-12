package com.danco.api.service;

import java.util.HashMap;

import com.danco.api.exception.MyException;
import com.danco.model.Comment;


/**
 * The Interface ICommentService.
 */
public interface ICommentService extends IService<Comment> {

	/**
	 * Gets the list by post id pagination.
	 *
	 * @param id the id
	 * @param startPostId the start post id
	 * @param pageSize the page size
	 * @return the list by post id pagination
	 * @throws MyException the my exception
	 */
	public HashMap<String, Object> getListByPostIdPagination(int id,
			int startPostId, int pageSize) throws MyException;

	/**
	 * Gets the comment count by post id.
	 *
	 * @param id the id
	 * @return the comment count by post id
	 * @throws MyException the my exception
	 */
	public int getCommentCountByPostId(int id) throws MyException;

}