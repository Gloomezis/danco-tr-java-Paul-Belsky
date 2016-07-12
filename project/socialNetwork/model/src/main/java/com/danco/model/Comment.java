package com.danco.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class Comment.
 */
@Entity
@Table(name = Comment.COMMENT)
public class Comment extends BaseModel {

	/** The Constant POST_ID. */
	private static final String POST_ID = "post_id";
	
	/** The Constant USER_ID. */
	private static final String USER_ID = "user_id";
	
	/** The Constant TEXT2. */
	private static final String TEXT2 = "text";
	
	/** The Constant TIME_CREATION. */
	private static final String TIME_CREATION = "time_creation";
	
	/** The Constant ID_COMMENT. */
	private static final String ID_COMMENT = "idComment";
	
	/** The Constant COMMENT. */
	static final String COMMENT = "comment";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = ID_COMMENT)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The editing. */
	@Transient
	private Boolean editing = false;

	/** The text. */
	@Column(name = TEXT2)
	private String text;

	/** The time creation. */
	@Column(name = TIME_CREATION)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date timeCreation;

	/** The creator. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = USER_ID)
	private User creator;

	/** The post. */
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = POST_ID)
	private Post post;

	/**
	 * Instantiates a new comment.
	 */
	public Comment() {

	}

	/**
	 * Instantiates a new comment.
	 *
	 * @param text the text
	 * @param timeCreation the time creation
	 */
	public Comment(String text, Date timeCreation) {
		this.text = text;
		this.timeCreation = timeCreation;
	}

	/**
	 * Instantiates a new comment.
	 *
	 * @param id the id
	 * @param text the text
	 * @param timeCreation the time creation
	 * @param creator the creator
	 * @param post the post
	 */
	public Comment(int id, String text, Date timeCreation, User creator,
			Post post) {
		this.id = id;
		this.text = text;
		this.timeCreation = timeCreation;
		this.creator = creator;
		this.post = post;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the time creation.
	 *
	 * @return the time creation
	 */
	public Date getTimeCreation() {
		return timeCreation;
	}

	/**
	 * Sets the time creation.
	 *
	 * @param timeCreation the new time creation
	 */
	public void setTimeCreation(Date timeCreation) {
		this.timeCreation = timeCreation;
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
	 * Gets the creator.
	 *
	 * @return the creator
	 */
	public User getCreator() {
		return creator;
	}

	/**
	 * Sets the creator.
	 *
	 * @param creator the new creator
	 */
	public void setCreator(User creator) {
		this.creator = creator;
	}

	/**
	 * Gets the post.
	 *
	 * @return the post
	 */
	public Post getPost() {
		return post;
	}

	/**
	 * Sets the post.
	 *
	 * @param post the new post
	 */
	public void setPost(Post post) {
		this.post = post;
	}

	/**
	 * Gets the editing.
	 *
	 * @return the editing
	 */
	public Boolean getEditing() {
		return editing;
	}

	/**
	 * Sets the editing.
	 *
	 * @param editing the new editing
	 */
	public void setEditing(Boolean editing) {
		this.editing = editing;
	}

}
