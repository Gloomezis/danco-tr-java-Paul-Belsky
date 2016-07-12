package com.danco.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IPostDAO;
import com.danco.api.exception.MessageException;
import com.danco.api.exception.MyException;
import com.danco.api.service.IPostService;
import com.danco.model.Post;


/**
 * The Class PostService.
 */
@Service
public class PostService extends BaseService<Post> implements IPostService {

	/** The Constant RESPONSE_ENTITY. */
	private static final String RESPONSE_ENTITY = "responseEntity";
	
	/** The Constant COUNT2. */
	private static final String COUNT2 = "count";
	
	/** The Constant POST_SERVICE_CREATED. */
	private static final String POST_SERVICE_CREATED = "Post service created";
	
	/** The dao. */
	@Autowired
	private IPostDAO dao;

	/**
	 * Instantiates a new post service.
	 */
	public PostService() {
		System.out.println(POST_SERVICE_CREATED);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IPostService#getPostCountByUserId(int)
	 */
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	@Override
	public int getPostCountByUserId(int id) throws MyException {
		int postsCount = 0;
		postsCount = dao.getPostCountByUserId(id);
		return postsCount;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IPostService#getListByUserId(int, int, int)
	 */
	@Transactional(rollbackFor = MyException.class)
	@Override
	public HashMap<String, Object> getListByUserId(int id, int startPostId,
			int pageSize) throws MyException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		List<Post> posts = null;
		int count = getPostCountByUserId(id);
		if (count == 0) {
			return res;
		} else {
			posts = dao.getListByUserId(id, startPostId, pageSize);
			if (posts.isEmpty()) {
				throw new MyException(MessageException.ITS_ALL);
			} else {
				res.put(COUNT2, count);
				res.put(RESPONSE_ENTITY, posts);
			}
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IPostService#getNewsPostList(int, int, int)
	 */
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	@Override
	public HashMap<String, Object> getNewsPostList(int id, int startPostId,
			int pageSize) throws MyException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		List<Post> posts = null;
		posts = dao.getNewsPostList(id, startPostId, pageSize);
		if (posts.isEmpty()) {
			throw new MyException(MessageException.ITS_ALL);
		} else {
			res.put(RESPONSE_ENTITY, posts);
		}
		return res;
	}

}
