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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The Class Group.
 */
@Entity
@Table(name = Group.GROUPS)
public class Group extends BaseModel {

	/** The Constant GROUP. */
	private static final String GROUP = "group";
	
	/** The Constant DESCRIPTION2. */
	private static final String DESCRIPTION2 = "description";
	
	/** The Constant TITLE2. */
	private static final String TITLE2 = "title";
	
	/** The Constant ID_GROUP. */
	private static final String ID_GROUP = "idGroup";
	
	/** The Constant GROUPS. */
	static final String GROUPS = "groups";
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = ID_GROUP)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The title. */
	@Column(name = TITLE2)
	private String title;

	/** The description. */
	@Column(name = DESCRIPTION2)
	private String description;

	/** The dialogs. */
	@JsonIgnore
	@OneToMany(targetEntity = Dialog.class, mappedBy = GROUP, fetch = FetchType.LAZY)
	private List<Dialog> dialogs;

	/**
	 * Instantiates a new group.
	 */
	public Group() {
	}

	/**
	 * Instantiates a new group.
	 *
	 * @param id the id
	 * @param title the title
	 * @param description the description
	 * @param timeCreation the time creation
	 * @param creator the creator
	 */
	public Group(int id, String title, String description, Date timeCreation,
			User creator) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dialogs = new ArrayList<Dialog>();
	}

	/**
	 * Instantiates a new group.
	 *
	 * @param title the title
	 * @param description the description
	 * @param timeCreation the time creation
	 */
	public Group(String title, String description, Date timeCreation) {
		this.title = title;
		this.description = description;
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
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
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
}
