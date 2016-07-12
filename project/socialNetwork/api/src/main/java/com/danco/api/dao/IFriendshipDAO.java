package com.danco.api.dao;

import java.util.List;

import com.danco.api.exception.MyException;
import com.danco.model.Friendship;


/**
 * The Interface IFriendshipDAO.
 */
public interface IFriendshipDAO extends IDAO<Friendship> {

	/**
	 * Gets the by both id.
	 *
	 * @param myId the my id
	 * @param friendId the friend id
	 * @return the by both id
	 * @throws MyException the my exception
	 */
	public Friendship getByBothId(int myId, int friendId) throws MyException;

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
	public List<Friendship> getMyFollowers(int id, int startFollowersId,
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
	public List<Friendship> getMyFollowings(int id, int startFollowingsId,
			int pageSize) throws MyException;

}
