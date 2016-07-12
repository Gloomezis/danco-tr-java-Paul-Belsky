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

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The Class DialogMessage.
 */
@Entity
@Table(name = DialogMessage.DIALOG_MESSAGE)
public class DialogMessage extends BaseModel {

	/** The Constant DIALOG_ID. */
	private static final String DIALOG_ID = "dialog_id";
	
	/** The Constant USER_ID. */
	private static final String USER_ID = "user_id";
	
	/** The Constant TIME_CREATION. */
	private static final String TIME_CREATION = "time_creation";
	
	/** The Constant TEXT2. */
	private static final String TEXT2 = "text";
	
	/** The Constant ID_DIALOG_MESSAGE. */
	private static final String ID_DIALOG_MESSAGE = "idDialog_message";
	
	/** The Constant DIALOG_MESSAGE. */
	static final String DIALOG_MESSAGE = "dialog_message";
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = ID_DIALOG_MESSAGE)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The text. */
	@Column(name = TEXT2)
	private String text;

	/** The time creation. */
	@Column(name = TIME_CREATION)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date timeCreation = new Date();

	/** The creator. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = USER_ID)
	private User creator;

	/** The dialog. */
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = DIALOG_ID)
	private Dialog dialog;

	/**
	 * Instantiates a new dialog message.
	 */
	public DialogMessage() {
	}

	/**
	 * Instantiates a new dialog message.
	 *
	 * @param id the id
	 * @param text the text
	 * @param timeCreation the time creation
	 * @param creator the creator
	 * @param dialog the dialog
	 */
	public DialogMessage(int id, String text, Date timeCreation, User creator,
			Dialog dialog) {
		this.id = id;
		this.text = text;
		this.timeCreation = timeCreation;
		this.creator = creator;
		this.dialog = dialog;
	}

	/**
	 * Instantiates a new dialog message.
	 *
	 * @param text the text
	 * @param timeCreation the time creation
	 */
	public DialogMessage(String text, Date timeCreation) {
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
	 * Gets the dialog.
	 *
	 * @return the dialog
	 */
	public Dialog getDialog() {
		return dialog;
	}

	/**
	 * Sets the dialog.
	 *
	 * @param dialog the new dialog
	 */
	public void setDialog(Dialog dialog) {
		this.dialog = dialog;
	}
}
