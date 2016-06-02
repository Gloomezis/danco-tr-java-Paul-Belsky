package com.danco.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import com.danco.model.User;

public interface IUserController {

	public abstract ResponseEntity<List<User>> listAllUsers();

	public abstract ResponseEntity<User> getUser(int id);

	public abstract ResponseEntity<Void> createUser(User user,
			UriComponentsBuilder ucBuilder);

	public abstract ResponseEntity<User> updateUser(int id, User user);

	public abstract ResponseEntity<User> deleteUser(int id);

}