package com.danco.model;

import java.util.Collection;
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
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User extends BaseModel implements
		org.springframework.security.core.userdetails.UserDetails {

	private static final long serialVersionUID = 1L;

	// Spring Security
	@Transient
	private String token;
	
	//private Collection<? extends GrantedAuthority> authorities;

	@Id
	@Column(name = "idUser")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "time_registration")
	@Temporal(value = TemporalType.DATE)
	private Date registrationDate;

	@Column(name = "lang")
	private String lang;

	@OneToOne()
	@JoinColumn(name = "user_role_id")
	private UserRole userRole;

	@OneToOne()
	@JoinColumn(name = "user_details_id")
	private UserDetails userDetails;

	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "group_list", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
	private List<Group> groups;

	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "friend_list", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "friend_id") })
	private Set<User> users = new HashSet<User>();

	@JsonIgnore
	@ManyToMany(mappedBy = "users")
	private Set<User> friends = new HashSet<User>();

	@JsonIgnore
	@OneToMany(targetEntity = Message.class, mappedBy = "sender", fetch = FetchType.LAZY)
	private List<Message> messages_sended;

	@JsonIgnore
	@OneToMany(targetEntity = Message.class, mappedBy = "receiver", fetch = FetchType.LAZY)
	private List<Message> messages_received;

	@JsonIgnore
	@OneToMany(targetEntity = Comment.class, mappedBy = "creator", fetch = FetchType.LAZY)
	private List<Comment> commenst;

	@JsonIgnore
	@OneToMany(targetEntity = Post.class, mappedBy = "creator", fetch = FetchType.LAZY)
	private List<Post> posts;

	@JsonIgnore
	@OneToMany(targetEntity = Dialog.class, mappedBy = "creator", fetch = FetchType.LAZY)
	private List<Dialog> dialogs;

	@JsonIgnore
	@OneToMany(targetEntity = Group.class, mappedBy = "creator", fetch = FetchType.LAZY)
	private List<Group> groupsCreated;

	public User() {

	}

	public User(int id, String username, String token) {
		this.id = id;
		this.username = username;
		this.token = token;
		
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, UserDetails userDetails) {
		super();
		this.username = username;
		this.password = password;
		this.userDetails = userDetails;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;

	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getLang() {
		return lang;
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

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// <<<<<<<<<SPRING SECURITY>>>>>>>>>>>>>>> USERDETAILS implementation
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		
		return true;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setAuthorities(
		Collection<? extends GrantedAuthority> authorities) {
		
	}

}
