package com.danco.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * The Class Message.
 */
@Entity
@Table(name = Message.MESSAGE)
public class Message extends BaseModel {

	/** The Constant RECEIVER_ID. */
	private static final String RECEIVER_ID = "receiver_id";
	
	/** The Constant SENDER_ID. */
	private static final String SENDER_ID = "sender_id";
	
	/** The Constant TIME_CREATION. */
	private static final String TIME_CREATION = "time_creation";
	
	/** The Constant TEXT2. */
	private static final String TEXT2 = "text";
	
	/** The Constant DELETED2. */
	private static final String DELETED2 = "deleted";
	
	/** The Constant ID_MESSAGE. */
	private static final String ID_MESSAGE = "idMessage";
	
	/** The Constant MESSAGE. */
	static final String MESSAGE = "message";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = ID_MESSAGE)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The editing. */
	@Transient
	private Boolean editing = false;

	/** The deleted. */
	@Column(name = DELETED2)
	private Boolean deleted = false;

	/** The text. */
	@Column(name = TEXT2)
	private String text;

	/** The time creation. */
	@Column(name = TIME_CREATION)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date timeCreation;

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

	/** The sender. */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = SENDER_ID)
	private User sender;

	/** The receiver. */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = RECEIVER_ID)
	private User receiver;

	/**
	 * Instantiates a new message.
	 */
	public Message() {
	}

	/**
	 * Instantiates a new message.
	 *
	 * @param id the id
	 * @param text the text
	 * @param timeCreation the time creation
	 * @param isRead the is read
	 * @param sender the sender
	 * @param receiver the receiver
	 */
	public Message(int id, String text, Date timeCreation, boolean isRead,
			User sender, User receiver) {
		this.id = id;
		this.text = text;
		this.timeCreation = timeCreation;
		this.sender = sender;
		this.receiver = receiver;
	}

	/**
	 * Instantiates a new message.
	 *
	 * @param text the text
	 * @param timeCreation the time creation
	 */
	public Message(String text, Date timeCreation) {
		this.text = text;
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

	/**
	 * Gets the sender.
	 *
	 * @return the sender
	 */
	public User getSender() {
		return sender;
	}

	/**
	 * Sets the sender.
	 *
	 * @param sender the new sender
	 */
	public void setSender(User sender) {
		this.sender = sender;
	}

	/**
	 * Gets the receiver.
	 *
	 * @return the receiver
	 */
	public User getReceiver() {
		return receiver;
	}

	/**
	 * Sets the receiver.
	 *
	 * @param receiver the new receiver
	 */
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	/**
	 * Gets the deleted.
	 *
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * Sets the deleted.
	 *
	 * @param deleted the new deleted
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}
