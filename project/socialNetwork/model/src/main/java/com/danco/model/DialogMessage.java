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

@Entity
@Table(name = "dialog_message")
public class DialogMessage extends BaseModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idDialog_message")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "text")
	private String text;

	@Column(name = "time_creation")
	@Temporal(value = TemporalType.DATE)
	private Date timeCreation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User creator;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dialog_id")
	private Dialog dialog;

	public DialogMessage() {

	}

	public DialogMessage(int id, String text, Date timeCreation, User creator,
			Dialog dialog) {
		this.id = id;
		this.text = text;
		this.timeCreation = timeCreation;
		this.creator = creator;
		this.dialog = dialog;

	}

	public DialogMessage(String text, Date timeCreation) {
		this.text = text;
		this.timeCreation = timeCreation;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getTimeCreation() {
		return timeCreation;
	}

	public void setTimeCreation(Date timeCreation) {
		this.timeCreation = timeCreation;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;

	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Dialog getDialog() {
		return dialog;
	}

	public void setDialog(Dialog dialog) {
		this.dialog = dialog;
	}

}
