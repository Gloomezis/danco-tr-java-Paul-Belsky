package com.danco.api.service;

import java.util.HashMap;

import com.danco.api.exception.MyException;
import com.danco.model.Friendship;


/**
 * The Interface IFriendshipService.
 */
public interface IFriendshipService extends IService<Friendship>{

	/**
	 * Checks if is friend.
	 *
	 * @param myId the my id
	 * @param friendId the friend id
	 * @return true, if is friend
	 * @throws MyException the my exception
	 */
	public boolean isFriend(int myId, int friendId) throws MyException;

	/**
	 * Gets the friendship.
	 *
	 * @param myId the my id
	 * @param friendId the friend id
	 * @return the friendship
	 * @throws MyException the my exception
	 */
	public Friendship getFriendship(int myId, int friendId) throws MyException;

	/**
	 * Gets the followers count.
	 *
	 * @param id the id
	 * @return the followers count
	 * @throws MyException the my exception
	 */
	public int getFollowersCount(int id) throws MyException;
	
	/**
	 * Gets the my followers.
	 *
	 * @param id the id
	 * @param startFollowersId the start followers id
	 * @param pageSize the page size
	 * @return the my followers
	 * @throws MyException the my exception
	 */
	public HashMap<String, Object> getMyFollowers(int id, int startFollowersId,
			int pageSize) throws MyException;

	/**
	 * Gets the followings count.
	 *
	 * @param id the id
	 * @return the followings count
	 * @throws MyException the my exception
	 */
	public int getFollowingsCount(int id) throws MyException;

	/**
	 * Gets the my followings.
	 *
	 * @param id the id
	 * @param startFollowingsId the start followings id
	 * @param pageSize the page size
	 * @return the my followings
	 * @throws MyException the my exception
	 */
	public HashMap<String, Object> getMyFollowings(int id, int startFollowingsId,
			int pageSize) throws MyException;

	

}
