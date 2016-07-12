package com.danco.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The Class User.
 */
@Entity
@Table(name = User.USER)
public class User extends BaseModel implements
		org.springframework.security.core.userdetails.UserDetails {

	/** The Constant CREATOR. */
	private static final String CREATOR = "creator";
	
	/** The Constant RECEIVER. */
	private static final String RECEIVER = "receiver";
	
	/** The Constant SENDER. */
	private static final String SENDER = "sender";
	
	/** The Constant FRIEND. */
	private static final String FRIEND = "friend";
	
	/** The Constant USER_DETAILS_ID. */
	private static final String USER_DETAILS_ID = "user_details_id";
	
	/** The Constant TIME_REGISTRATION. */
	private static final String TIME_REGISTRATION = "time_registration";
	
	/** The Constant PASSWORD2. */
	private static final String PASSWORD2 = "password";
	
	/** The Constant USERNAME2. */
	private static final String USERNAME2 = "username";
	
	/** The Constant ID_USER. */
	private static final String ID_USER = "idUser";
	
	/** The Constant USER. */
	static final String USER = "user";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The token. */
	@Transient
	private String token;

	/** The id. */
	@Id
	@Column(name = ID_USER)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The username. */
	@Column(name = USERNAME2)
	private String username;

	/** The password. */
	@JsonIgnore
	@Column(name = PASSWORD2)
	private String password;

	/** The registration date. */
	@Column(name = TIME_REGISTRATION)
	@Temporal(value = TemporalType.DATE)
	private Date registrationDate;

	/** The user details. */
	@JsonManagedReference
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = USER_DETAILS_ID)
	private UserDetails userDetails;

	/** The subscribers. */
	@JsonIgnore
	@OneToMany(targetEntity = Friendship.class, mappedBy = USER, fetch = FetchType.LAZY)
	private List<Friendship> subscribers;

	/** The followers. */
	@JsonIgnore
	@OneToMany(targetEntity = Friendship.class, mappedBy = FRIEND, fetch = FetchType.LAZY)
	private List<Friendship> followers;

	/**
	 * Gets the subscribers.
	 *
	 * @return the subscribers
	 */
	public List<Friendship> getSubscribers() {
		return subscribers;
	}

	/**
	 * Sets the subscribers.
	 *
	 * @param subscribers the new subscribers
	 */
	public void setSubscribers(List<Friendship> subscribers) {
		this.subscribers = subscribers;
	}

	/**
	 * Gets the followers.
	 *
	 * @return the followers
	 */
	public List<Friendship> getFollowers() {
		return followers;
	}

	/**
	 * Sets the followers.
	 *
	 * @param followers the new followers
	 */
	public void setFollowers(List<Friendship> followers) {
		this.followers = followers;
	}

	/** The messages sended. */
	@JsonIgnore
	@OneToMany(targetEntity = Message.class, mappedBy = SENDER, fetch = FetchType.LAZY)
	private List<Message> messages_sended;

	/** The messages received. */
	@JsonIgnore
	@OneToMany(targetEntity = Message.class, mappedBy = RECEIVER, fetch = FetchType.LAZY)
	private List<Message> messages_received;

	/** The comments. */
	@JsonIgnore
	@OneToMany(targetEntity = Comment.class, mappedBy = CREATOR, fetch = FetchType.LAZY)
	private List<Comment> comments;

	/** The posts. */
	@JsonIgnore
	@OneToMany(targetEntity = Post.class, mappedBy = CREATOR, fetch = FetchType.LAZY)
	private List<Post> posts;

	/** The dialogs. */
	@JsonIgnore
	@OneToMany(targetEntity = Dialog.class, mappedBy = CREATOR, fetch = FetchType.LAZY)
	private List<Dialog> dialogs;

	/** The dialog message. */
	@JsonIgnore
	@OneToMany(targetEntity = DialogMessage.class, mappedBy = CREATOR, fetch = FetchType.LAZY)
	private List<DialogMessage> dialogMessage;

	/**
	 * Instantiates a new user.
	 */
	public User() {
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param id the id
	 * @param username the username
	 * @param token the token
	 */
	public User(int id, String username, String token) {
		this.id = id;
		this.username = username;
		this.token = token;
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 * @param userDetails the user details
	 */
	public User(String username, String password, UserDetails userDetails) {
		super();
		this.username = username;
		this.password = password;
		this.userDetails = userDetails;
	}

	/**
	 * Gets the dialog message.
	 *
	 * @return the dialog message
	 */
	public List<DialogMessage> getDialogMessage() {
		return dialogMessage;
	}

	/**
	 * Sets the dialog message.
	 *
	 * @param dialogMessage the new dialog message
	 */
	public void setDialogMessage(List<DialogMessage> dialogMessage) {
		this.dialogMessage = dialogMessage;
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

	/**
	 * Gets the registration date.
	 *
	 * @return the registration date
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * Sets the registration date.
	 *
	 * @param registrationDate the new registration date
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * Gets the messages sended.
	 *
	 * @return the messages sended
	 */
	public List<Message> getMessages_sended() {
		return messages_sended;
	}

	/**
	 * Sets the messages sended.
	 *
	 * @param messages_sended the new messages sended
	 */
	public void setMessages_sended(List<Message> messages_sended) {
		this.messages_sended = messages_sended;
	}

	/**
	 * Gets the messages received.
	 *
	 * @return the messages received
	 */
	public List<Message> getMessages_received() {
		return messages_received;
	}

	/**
	 * Sets the messages received.
	 *
	 * @param messages_received the new messages received
	 */
	public void setMessages_received(List<Message> messages_received) {
		this.messages_received = messages_received;
	}

	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * Sets the comments.
	 *
	 * @param comments the new comments
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	/**
	 * Gets the posts.
	 *
	 * @return the posts
	 */
	public List<Post> getPosts() {
		return posts;
	}

	/**
	 * Sets the posts.
	 *
	 * @param posts the new posts
	 */
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	/**
	 * Gets the dialogs.
	 *
	 * @return the dialogs
	 */
	public List<Dialog> getDialogs() {
		return dialogs;
	}

	/**
	 * Sets the dialogs.
	 *
	 * @param dialogs the new dialogs
	 */
	public void setDialogs(List<Dialog> dialogs) {
		this.dialogs = dialogs;
	}

	/**
	 * Gets the user details.
	 *
	 * @return the user details
	 */
	public UserDetails getUserDetails() {
		return userDetails;
	}

	/**
	 * Sets the user details.
	 *
	 * @param userDetails the new user details
	 */
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	// <<<<<<<<<SPRING SECURITY>>>>>>>>>>>>>>> 

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the token.
	 *
	 * @param token the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Sets the authorities.
	 *
	 * @param authorities the new authorities
	 */
	public void setAuthorities(
			Collection<? extends GrantedAuthority> authorities) {
	}

}
