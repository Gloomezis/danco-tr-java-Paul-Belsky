package com.danco.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The Class Post.
 */
@Entity
@Table(name = Post.POST)
public class Post extends BaseModel {

	/** The Constant USER_ID. */
	private static final String USER_ID = "user_id";
	
	/** The Constant TIME_CREATION. */
	private static final String TIME_CREATION = "time_creation";
	
	/** The Constant TEXT2. */
	private static final String TEXT2 = "text";
	
	/** The Constant ID_POST. */
	private static final String ID_POST = "idPost";
	
	/** The Constant POST. */
	static final String POST = "post";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = ID_POST)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

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

	/** The comments. */
	@JsonIgnore
	@OneToMany(targetEntity = Comment.class, mappedBy = POST, fetch = FetchType.LAZY)
	private List<Comment> comments;

	/** The editing. */
	@Transient
	private Boolean editing = false;

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
	 * Instantiates a new post.
	 */
	public Post() {
	}

	/**
	 * Instantiates a new post.
	 *
	 * @param id the id
	 * @param text the text
	 * @param timeCreation the time creation
	 * @param creator the creator
	 */
	public Post(int id, String text, Date timeCreation, User creator) {
		this.id = id;
		this.text = text;
		this.timeCreation = timeCreation;
		this.creator = creator;
		this.comments = new ArrayList<Comment>();
	}

	/**
	 * Instantiates a new post.
	 *
	 * @param text the text
	 * @param timeCreation the time creation
	 */
	public Post(String text, Date timeCreation) {
		this.text = text;
		this.timeCreation = timeCreation;
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
