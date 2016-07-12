package com.danco.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IFriendshipDAO;
import com.danco.api.exception.MessageException;
import com.danco.api.exception.MyException;
import com.danco.api.service.IFriendshipService;
import com.danco.model.Friendship;


/**
 * The Class FriendshipService.
 */
@Service
public class FriendshipService extends BaseService<Friendship> implements
		IFriendshipService {

	/** The Constant RESPONSE_ENTITY. */
	private static final String RESPONSE_ENTITY = "responseEntity";
	
	/** The Constant COUNT2. */
	private static final String COUNT2 = "count";
	
	/** The Constant FRIENDSHIP_SERVICE_CREATED. */
	private static final String FRIENDSHIP_SERVICE_CREATED = "Friendship service created";
	
	/** The dao. */
	@Autowired
	private IFriendshipDAO dao;

	/**
	 * Instantiates a new friendship service.
	 */
	public FriendshipService() {
		System.out.println(FRIENDSHIP_SERVICE_CREATED);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IFriendshipService#getFollowersCount(int)
	 */
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	@Override
	public int getFollowersCount(int id) throws MyException {
		int postsCount = 0;
		postsCount = dao.getFollowersCount(id);
		return postsCount;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IFriendshipService#getMyFollowers(int, int, int)
	 */
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	@Override
	public HashMap<String, Object> getMyFollowers(int id, int startFollowersId,
			int pageSize) throws MyException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		List<Friendship> fr = null;
		int count = getFollowersCount(id);
		if (count == 0) {
			return res;
		} else {
			fr = dao.getMyFollowers(id, startFollowersId, pageSize);
			if (fr.isEmpty()) {
				throw new MyException(MessageException.ITS_ALL);
			} else {
				res.put(COUNT2, count);
				res.put(RESPONSE_ENTITY, fr);
			}
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IFriendshipService#getFollowingsCount(int)
	 */
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	@Override
	public int getFollowingsCount(int id) throws MyException {
		int postsCount = 0;
		postsCount = dao.getFollowingsCount(id);
		return postsCount;

	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IFriendshipService#getMyFollowings(int, int, int)
	 */
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	@Override
	public HashMap<String, Object> getMyFollowings(int id,
			int startFollowingsId, int pageSize) throws MyException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		List<Friendship> fr = null;
		int count = getFollowingsCount(id);
		if (count == 0) {
			return res;
		} else {
			fr = dao.getMyFollowings(id, startFollowingsId, pageSize);
			if (fr.isEmpty()) {
				throw new MyException(MessageException.ITS_ALL);
			} else {
				res.put(COUNT2, count);
				res.put(RESPONSE_ENTITY, fr);
			}
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IFriendshipService#getFriendship(int, int)
	 */
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	@Override
	public Friendship getFriendship(int myId, int friendId) throws MyException {
		Friendship fr = null;
		fr = dao.getByBothId(myId, friendId);
		if (fr == null) {
			throw new MyException(MessageException.NOT_FOUND);
		}
		return fr;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IFriendshipService#isFriend(int, int)
	 */
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	@Override
	public boolean isFriend(int myId, int friendId) throws MyException {
		return dao.getByBothId(myId, friendId) != null;
	}

}
