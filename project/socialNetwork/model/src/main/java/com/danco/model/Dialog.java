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

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The Class Dialog.
 */
@Entity
@Table(name = Dialog.DIALOG)
public class Dialog extends BaseModel  {
	
	/** The Constant GROUP_ID. */
	private static final String GROUP_ID = "group_id";
	
	/** The Constant TIME_CREATION. */
	private static final String TIME_CREATION = "time_creation";
	
	/** The Constant USER_ID. */
	private static final String USER_ID = "user_id";
	
	/** The Constant TEXT. */
	private static final String TEXT = "text";
	
	/** The Constant TITLE. */
	private static final String TITLE = "title";
	
	/** The Constant ID_DIALOG. */
	private static final String ID_DIALOG = "idDialog";
	
	/** The Constant DIALOG. */
	static final String DIALOG = "dialog";
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = ID_DIALOG)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/** The title. */
	@Column(name=TITLE)
	private String title;

	/** The text. */
	@Column(name=TEXT)
	private String text;

	
	/** The time creation. */
	@Column(name= TIME_CREATION)
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date timeCreation;
	
	
	/** The creator. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = USER_ID) 
	private User creator;
	
	/** The dialog messages. */
	@JsonIgnore
	@OneToMany(targetEntity = DialogMessage.class, mappedBy = DIALOG,fetch = FetchType.LAZY)
	private List<DialogMessage> dialogMessages;
	
	/** The group. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = GROUP_ID) 
	private Group group;

	/**
	 * Instantiates a new dialog.
	 *
	 * @param id the id
	 * @param title the title
	 * @param timeCreation the time creation
	 * @param creator the creator
	 * @param group the group
	 */
	public Dialog(int id, String title, Date timeCreation,User creator,Group group) {
		this.id=id;
		this.title=title;
		this.timeCreation=timeCreation;
		this.creator=creator;
		this.group=group;
		this.dialogMessages=new ArrayList<DialogMessage>();
	}
	
	/**
	 * Instantiates a new dialog.
	 *
	 * @param title the title
	 * @param text the text
	 */
	public Dialog(String title,String text) {
		this.title=title;
		this.text=title;
	}
	
	/**
	 * Instantiates a new dialog.
	 */
	public Dialog() {
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * Gets the dialog messages.
	 *
	 * @return the dialog messages
	 */
	public List<DialogMessage> getDialogMessages() {
		return dialogMessages;
	}

	/**
	 * Sets the dialog messages.
	 *
	 * @param dialogMessages the new dialog messages
	 */
	public void setDialogMessages(List<DialogMessage> dialogMessages) {
		this.dialogMessages = dialogMessages;
	}

	/**
	 * Gets the group.
	 *
	 * @return the group
	 */
	public Group getGroup() {
		return group;
	}

	/**
	 * Sets the group.
	 *
	 * @param group the new group
	 */
	public void setGroup(Group group) {
		this.group = group;
	}

}
