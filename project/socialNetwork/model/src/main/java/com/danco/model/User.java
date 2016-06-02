package com.danco.model;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="user")
public class User extends BaseModel implements  Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "idUser")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The name. */
	@Column(name="login")
	private String login;
	
	
	/** The name. */
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name= "time_registration")
	@Temporal(value=TemporalType.DATE)
	private Date registrationDate;
	
	@Column(name="lang")
	private String lang;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_role_id")
	private UserRole userRole;
	
	
	
	
	
	@ManyToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY)
			@JoinTable(name="group_list", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="group_id"))  
	private List<Group> groups;
	
	
	@ManyToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinTable(name="friend_list",
                joinColumns={@JoinColumn(name="user_id")},
                inverseJoinColumns={@JoinColumn(name="friend_id")})
    private Set<User> users = new HashSet<User>();
 
    @ManyToMany(mappedBy="users")
    private Set<User> friends = new HashSet<User>();
    
    /** The services. */
	@OneToMany(targetEntity = Message.class, mappedBy = "sender",fetch = FetchType.LAZY)
	private List<Message> messages_sended;
	
	@OneToMany(targetEntity = Message.class, mappedBy = "receiver",fetch = FetchType.LAZY)
	private List<Message> messages_received;

	@OneToMany(targetEntity = Comment.class, mappedBy = "creator",fetch = FetchType.LAZY)
	private List<Comment> commenst;
	
	@OneToMany(targetEntity = Post.class, mappedBy = "creator",fetch = FetchType.LAZY)
	private List<Post> posts;
	
	@OneToMany(targetEntity = Dialog.class, mappedBy = "creator",fetch = FetchType.LAZY)
	private List<Dialog> dialogs;
	
	@OneToMany(targetEntity = Group.class, mappedBy = "creator",fetch = FetchType.LAZY)
	private List<Group> groupsCreated;
	
	
	
	
	
	public User() {
		
	}
	
   
	
	public User(String name,  String password) {
		super();
		this.login = name;
		this.password = password;
	}



	@Override
	public int getId() {
		return id;
	}


	@Override
	public void setId(int id) {
		this.id = id;
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getRegistrationDate() {
		return registrationDate;
	}



	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}



	public String getLang() {
		return  lang;
	}



	public void setLang(String lang) {
		this.lang = lang;
	}



	public UserRole getUserRole() {
		return userRole;
	}



	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}



	public List<Group> getGroups() {
		return groups;
	}



	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}



	public Set<User> getUsers() {
		return users;
	}



	public void setUsers(Set<User> users) {
		this.users = users;
	}



	public Set<User> getFriends() {
		return friends;
	}



	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}



	public List<Message> getMessages_sended() {
		return messages_sended;
	}



	public void setMessages_sended(List<Message> messages_sended) {
		this.messages_sended = messages_sended;
	}



	public List<Message> getMessages_received() {
		return messages_received;
	}



	public void setMessages_received(List<Message> messages_received) {
		this.messages_received = messages_received;
	}



	public List<Comment> getCommenst() {
		return commenst;
	}



	public void setCommenst(List<Comment> commenst) {
		this.commenst = commenst;
	}



	public List<Post> getPosts() {
		return posts;
	}



	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}



	public List<Dialog> getDialogs() {
		return dialogs;
	}



	public void setDialogs(List<Dialog> dialogs) {
		this.dialogs = dialogs;
	}



	public List<Group> getGroupsCreated() {
		return groupsCreated;
	}



	public void setGroupsCreated(List<Group> groupsCreated) {
		this.groupsCreated = groupsCreated;
	}
	
	
}
