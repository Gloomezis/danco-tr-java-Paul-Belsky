package com.danco.api.service;

import java.util.HashMap;

import com.danco.api.exception.MyException;
import com.danco.model.Post;


/**
 * The Interface IPostService.
 */
public interface IPostService extends IService<Post> {

	/**
	 * Gets the list by user id.
	 *
	 * @param id the id
	 * @param startPostId the start post id
	 * @param pageSize the page size
	 * @return the list by user id
	 * @throws MyException the my exception
	 */
	public HashMap<String, Object> getListByUserId(int id, int startPostId,
			int pageSize) throws MyException;

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
	public HashMap<String, Object> getNewsPostList(int id, int startPostId,
			int pageSize) throws MyException;

}