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
@Table(name = "post")
public class Post extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idPost")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "text")
	private String text;

	@Column(name = "time_creation")
	@Temporal(value = TemporalType.DATE)
	private Date timeCreation;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User creator;

	@JsonIgnore
	@OneToMany(targetEntity = Comment.class, mappedBy = "post", fetch = FetchType.LAZY)
	private List<Comment> comments;

	public Post(int id, String text, Date timeCreation, User creator) {
		this.id = id;
		this.text = text;
		this.timeCreation = timeCreation;
		this.creator = creator;
		this.comments = new ArrayList<Comment>();
	}

	public Post(String text, Date timeCreation) {
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

}
