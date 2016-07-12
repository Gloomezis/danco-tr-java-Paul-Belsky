package com.danco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The Class Friendship.
 */
@Entity
@Table(name = Friendship.FRIEND_LIST)
public class Friendship extends BaseModel {

	/** The Constant FRIEND_ID. */
	private static final String FRIEND_ID = "friend_id";
	
	/** The Constant USER_ID. */
	private static final String USER_ID = "user_id";
	
	/** The Constant ID_FRIEND. */
	private static final String ID_FRIEND = "idFriend";
	
	/** The Constant FRIEND_LIST. */
	static final String FRIEND_LIST = "friend_list";
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = ID_FRIEND)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The user. */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = USER_ID)
	private User user;

	/** The friend. */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = FRIEND_ID)
	private User friend;

	/**
	 * Instantiates a new friendship.
	 */
	public Friendship() {
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the friend.
	 *
	 * @return the friend
	 */
	public User getFriend() {
		return friend;
	}

	/**
	 * Sets the friend.
	 *
	 * @param friend the new friend
	 */
	public void setFriend(User friend) {
		this.friend = friend;
	}

	/* (non-Javadoc)
	 * @see com.danco.model.BaseModel#getId()
	 */
	@Override
	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.danco.model.BaseModel#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}
}
