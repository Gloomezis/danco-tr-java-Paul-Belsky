package com.danco.controller;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
//ыimport org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.danco.api.controller.IUserController;
import com.danco.api.service.IUserService;
import com.danco.model.User;

@RestController
@RequestMapping("/user")
public class UserController implements  IUserController{
	
	@Autowired
	private IUserService<User> service;
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	
    
	
	/* (non-Javadoc)
	 * @see com.danco.controller.IUserController#listAllUsers()
	 */
	//@ResponseBody
	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = service.getList();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
	
	 /* (non-Javadoc)
	 * @see com.danco.controller.IUserController#getUser(int)
	 */
	//@ResponseBody
	@Override
	@ResponseStatus(HttpStatus.OK)
	 @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
	        System.out.println("Fetching User with id " + id);
	        User user = service.getById(id);
	        if (user == null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<User>(user, HttpStatus.OK);
	    }
	
	 /* (non-Javadoc)
	 * @see com.danco.controller.IUserController#createUser(com.danco.model.User, org.springframework.web.util.UriComponentsBuilder)
	 */
	//@ResponseBody
	@Override
	@ResponseStatus(HttpStatus.OK)
	 @RequestMapping(value = "/user/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating User " + user.getLogin());
	 
	        if (service.isUserExist(user)) {
	            System.out.println("A User with name " + user.getLogin() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        service.create(user);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	 /* (non-Javadoc)
	 * @see com.danco.controller.IUserController#updateUser(int, com.danco.model.User)
	 */
	//@ResponseBody
	@Override
	@ResponseStatus(HttpStatus.OK)
	 @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
	        System.out.println("Updating User " + id);
	         
	        User currentUser = service.getById(id);
	         
	        if (currentUser==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentUser.setLogin(user.getLogin());
	        currentUser.setPassword(user.getPassword());
	        currentUser.setEmail(user.getEmail());
	         
	        service.update(currentUser);
	        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	    }
	
	 /* (non-Javadoc)
	 * @see com.danco.controller.IUserController#deleteUser(int)
	 */
	//@ResponseBody
	@Override
	@ResponseStatus(HttpStatus.OK)
	 @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
	        System.out.println("Fetching & Deleting User with id " + id);
	 
	        User user = service.getById(id);
	        if (user == null) {
	            System.out.println("Unable to delete. User with id " + id + " not found");
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }
	 
	        service.delete(user);
	        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	    }

}
