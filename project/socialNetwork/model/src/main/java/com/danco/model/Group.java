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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "group")
public class Group extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idGroup")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "time_creation")
	@Temporal(value = TemporalType.DATE)
	private Date timeCreation;

	@JsonIgnore
	@ManyToMany(mappedBy = "groups")
	private List<User> members;

	@JsonIgnore
	@OneToMany(targetEntity = Dialog.class, mappedBy = "group", fetch = FetchType.LAZY)
	private List<Dialog> dialogs;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User creator;

	public Group() {

	}

	public Group(int id, String title, String description,Date timeCreation,User creator) {
		this.id=id;
		this.title=title;
		this.description=description;
		this.timeCreation=timeCreation;
		this.creator=creator;
		this.dialogs=new ArrayList<Dialog>();
		this.members=new ArrayList<User>();

	}
	
	public Group(String title, String description,Date timeCreation) {
		this.title=title;
		this.description=description;
		this.timeCreation=timeCreation;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public List<Dialog> getDialogs() {
		return dialogs;
	}

	public void setDialogs(List<Dialog> dialogs) {
		this.dialogs = dialogs;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

}
