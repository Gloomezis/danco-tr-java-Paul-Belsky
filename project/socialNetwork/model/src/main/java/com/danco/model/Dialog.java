package com.danco.model;

import java.io.Serializable;
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

@Entity
@Table(name = "dialog")
public class Dialog extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idDialog")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="title")
	private String title;

	@Column(name="text")
	private String text;

	@Column(name= "time_creation")
	@Temporal(value=TemporalType.DATE)
	private Date timeCreation;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id") 
	private User creator;
	
	@JsonIgnore
	@OneToMany(targetEntity = DialogMessage.class, mappedBy = "dialog",fetch = FetchType.LAZY)
	private List<DialogMessage> dialogMessages;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id") 
	private Group group;

	public Dialog(int id, String title, Date timeCreation,User creator,Group group) {
		this.id=id;
		this.title=title;
		this.timeCreation=timeCreation;
		this.creator=creator;
		this.group=group;
		this.dialogMessages=new ArrayList<DialogMessage>();
	}
	
	public Dialog(String title, Date timeCreation) {
		this.title=title;
		this.timeCreation=timeCreation;
	}
	
	public Dialog() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public List<DialogMessage> getDialogMessages() {
		return dialogMessages;
	}

	public void setDialogMessages(List<DialogMessage> dialogMessages) {
		this.dialogMessages = dialogMessages;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
