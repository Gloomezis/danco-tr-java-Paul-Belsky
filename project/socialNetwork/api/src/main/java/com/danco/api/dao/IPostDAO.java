package com.danco.api.dao;

import java.util.List;

import com.danco.api.exception.MyException;
import com.danco.model.Post;


/**
 * The Interface IPostDAO.
 */
public interface IPostDAO extends IDAO<Post> {

	/**
	 * Gets the list by user id.
	 *
	 * @param id the id
	 * @param startPostId the start post id
	 * @param pageSize the page size
	 * @return the list by user id
	 * @throws MyException the my exception
	 */
	public List<Post> getListByUserId(int id, int startPostId, int pageSize)
			throws MyException;

	/**
	 * Gets the post count by user id.
	 *
	 * @param id the id
	 * @return the post count by user id
	 * @throws MyException the my exception
	 */
	public int getPostCountByUserId(int id) throws MyException;

	/**
	 * Gets the news post list.
	 *
	 * @param id the id
	 * @param startPostId the start post id
	 * @param pageSize the page size
	 * @return the news post list
	 * @throws MyException the my exception
	 */
	public List<Post> getNewsPostList(int id, int startPostId, int pageSize)
			throws MyException;

}