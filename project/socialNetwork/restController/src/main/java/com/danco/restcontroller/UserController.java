package com.danco.restcontroller;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
















import java.util.Map;

import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


















import com.danco.api.service.IUserService;
import com.danco.model.User;
import com.danco.model.UserRole;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserController {
	
	
	private IUserService service;
	
	
	@Required
	@Autowired
	public void setService(IUserService service) {
		this.service = service;
	}

	
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	private static final String EXCEPTION = "Exception";

    
	
	public UserController() {
		System.out.println("Created user controller");
	}



	
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() throws Exception{
        List<User> users = null;
			users = service.getList();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
	
	
	 @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<User> getUser(@PathVariable("id") int id) throws Exception{
	        System.out.println("Fetching User with id " + id);
	        User user = null;
				user = service.getById(id);
	        if (user == null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<User>(user, HttpStatus.OK);
	    }
	
	
	 @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user)throws Exception {
	        System.out.println("Updating User " + id);
	        User currentUser = null;
				currentUser = service.getById(id);
	        if (currentUser==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }
	        currentUser=userSetter(user,currentUser);
				service.update(currentUser);
	        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	    }
	
	
	
	 @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) throws Exception{
	        System.out.println("Fetching & Deleting User with id " + id);
	        User user = null;
				user = service.getById(id);
	        if (user == null) {
	            System.out.println("Unable to delete. User with id " + id + " not found");
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }
				service.delete(user);
	        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	    }
	 
	 
	 
	 
	 public String objectToJson(Object obj) throws JsonProcessingException {
		 ObjectMapper mapper = new ObjectMapper();
		 String jsonObject = mapper.writeValueAsString(obj);
		 return jsonObject;
		 }

		 public Object jsonToObject(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		 Object obj = mapper.readValue(json, User.class);
		 return obj;
		 }
	 
		 @ResponseStatus(HttpStatus.OK)
		 @RequestMapping(value = "/jackson/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		    public String getUserJackson(@PathVariable("id") int id) throws Exception{
		        System.out.println("Fetching User with id " + id);
		        User user = service.getById(id);;
		        ObjectMapper mapper = new ObjectMapper();
				String jsonObject = mapper.writeValueAsString(user);
			    return jsonObject;
		    }
	
		 @RequestMapping(value = "/register", method = RequestMethod.POST)
		    public ResponseEntity<Void> login(@RequestBody User user,    UriComponentsBuilder ucBuilder) throws Exception {
		        System.out.println("Creating User " + user.getLogin());
					if (service.isUserExist(user)) {
					    System.out.println("A User with name " + user.getLogin() + " already exist");
					    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
					}
		        service.create(user);
		       
		        HttpHeaders headers = new HttpHeaders();
		        headers.setLocation(ucBuilder.path("/index").buildAndExpand().toUri());
		        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		    }
	 
	 
		 @RequestMapping(value = "/login", method = RequestMethod.POST)
		    public ResponseEntity<Object> login(@PathVariable("login") String login,  @PathVariable("password") String password ) throws Exception {
		        System.out.println("login User " + login);
		        
		        User user = null;
				user = service.getByLoginAndPassword(login,password);
	        if (user == null) {
	            System.out.println("User with login " + login + " not found");
	            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
	        }
	        Map<String,Object> res = new HashMap<String,Object>();
	        res.put("id", user.getId());
	        res.put("role",user.getUserRole().getRole());
	        return new ResponseEntity<Object>(res, HttpStatus.OK);
		    }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 
	 
	 
	 

	private User userSetter(User userFromRequest,User updatedUser){
		updatedUser.setLogin(userFromRequest.getLogin());
		updatedUser.setPassword(userFromRequest.getPassword());
		updatedUser.setEmail(userFromRequest.getEmail());
		return updatedUser;
	}
	 
}
