package com.danco.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Set;






//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.danco.api.service.IUserService;
import com.danco.model.User;
import com.danco.model.UserDetails;
import com.danco.model.UserRole;
import com.danco.restcontroller.security.IJwtUtil;
import com.danco.restcontroller.security.JwtUtil;

@RestController
public class UserController {
	@Autowired
	private IUserService service;
	
	private IJwtUtil jwtUtil=new JwtUtil() ;



	
	

	public UserController() {
		System.out.println("Created user controller");
	}

	// <<<<<<<<<<<<<<<<USER METHODS>>>>>>>>>>>>>>>>>>>>>

	// TODO grouplist with pagination
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/users/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public HashMap<String, Object> getUsersBySearch(
					@RequestParam(value="searcTerms",required=true) String firstname
					) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
				List<User> users = service.searchByName(firstname);
				if (users == null) {
					System.out.println("User with userName " + firstname
							+ " not found");
					responseMap.put("errorCode", 404);
					responseMap.put("errorMsg", "Not found");
					return responseMap;
				}
				responseMap.put("errorCode", 200);
				responseMap.put("errorMsg", "Ok");
				responseMap.put("responseEntity", users);
				return responseMap;
			}

	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/users/logint", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> loginT() {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		User user=new User("root", "1111");
		System.out.println("login User " + user.getUsername()+" "+user.getPassword());
		
		User responseEntity = null;
		responseEntity = service.getByCredentials(user.getUsername(),
				user.getPassword());
		if (responseEntity == null) {
			System.out.println("User with user name " + user.getUsername()
					+ " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "Not found");
			return responseMap;
		}
		responseEntity.setToken(jwtUtil.generateToken(responseEntity));
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		responseMap.put("responseEntity", responseEntity);
		return responseMap;
	}
	
	
	
	
	
	
	
	
	// DONE //write request body by User user
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/users/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> login(@RequestBody User user) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		System.out.println("login User " + user.getUsername()+" "+user.getPassword());

		User responseEntity = null;
		responseEntity = service.getByCredentials(user.getUsername(),
				user.getPassword());
		if (responseEntity == null) {
			System.out.println("User with user name " + user.getUsername()
					+ " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "Not found");
			return responseMap;
		}
		responseEntity.setToken(jwtUtil.generateToken(responseEntity));
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		responseMap.put("responseEntity", responseEntity);
		return responseMap;
	}

	// TODO frontend Autservice write logout methods
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/users/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> login() {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		return responseMap;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/users/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> register(@RequestBody User user)
			throws Exception {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		System.out.println("register User "
				+ user.getUserDetails().getFirstName());
		if (!service.isUserExist(user)) {
			responseMap.put("errorCode", 406);
			responseMap.put("errorMsg",
					"Account with this username allready exist");
			return responseMap;
		}
		try {
			service.create(user);
			responseMap.put("errorCode", 200);
			responseMap.put("errorMsg", "Ok");

			return responseMap;
		} catch (Exception e) {
			responseMap.put("errorCode", 409);
			responseMap.put("errorMsg", "Conflicted");
			return responseMap;
		}

	}

	// frontend User: getDataAboutMe
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/me", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getDataAboutMe() {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		// User user = service.getById(id);

		// if (user==null) {
		// System.out.println("User with id " + //id + " not found");
		// responseMap.put("errorCode", 404);
		// responseMap.put("errorMsg", "Not found");
		// return responseMap;
		// }
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		// responseMap.put("friendUsers", user);
		return responseMap;
	}

	// TODO frontend: User editProfile update user write usersetter
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/me", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> editProfile(@RequestBody User user) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println("Updating user " + user.getId());
		User currentUser = null;
		currentUser = service.getById(user.getId());
		if (currentUser == null) {
			System.out.println("User with id " + user.getId() + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "not found");
			return responseMap;
		}
		// TODO entitySetter write
		currentUser = entitySetter(user, currentUser);
		try {
			service.update(currentUser);
			responseMap.put("errorCode", 200);
			responseMap.put("errorMsg", "ok");
			return responseMap;
		} catch (Exception e) {
			responseMap.put("errorCode", 409);
			responseMap.put("errorMsg", "Conflicted");
			return responseMap;
		}

	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/me/changepassword", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> changePassword(@RequestBody User user) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println("Updating password user id:" + user.getId());
		User currentUser = null;
		currentUser = service.getById(user.getId());
		if (currentUser == null) {
			System.out.println("User with id " + user.getId() + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "not found");
			return responseMap;
		}
		currentUser = entitySetterPassword(user, currentUser);
		try {
			service.update(currentUser);
			responseMap.put("errorCode", 200);
			responseMap.put("errorMsg", "ok");
			return responseMap;
		} catch (Exception e) {
			responseMap.put("errorCode", 409);
			responseMap.put("errorMsg", "Conflicted");
			return responseMap;
		}

	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getDataAboutUser(
			@PathVariable("userId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		User user = service.getById(id);

		if (user == null) {
			System.out.println("User with id " + id + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "Not found");
			return responseMap;

		}
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		responseMap.put("user", user);
		return responseMap;
	}

	// <<<<<<<<<<<<<<<<Friends METHODS>>>>>>>>>>>>>>>>>>>>>

	// QUESTION about friends getting

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/me/friends", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getAllMyFriends(@RequestParam("id") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		User user = service.getById(id);
		Set<User> users = user.getFriends();
		if (users.isEmpty()) {
			System.out.println("User with id " + id + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "Not found");
			return responseMap;

		}
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		responseMap.put("friends", users);
		return responseMap;
	}

	// TODO write method to get friend list by user id
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/users/{userId}/friends", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getAllUserFriends(@PathVariable("id") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		User user = service.getById(id);
		Set<User> users = user.getFriends();
		if (users.isEmpty()) {
			System.out.println("User with id " + id + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "Not found");
			return responseMap;

		}
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		responseMap.put("friendUsers", users);
		return responseMap;
	}

	// TODO write adding to friend by my id
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/me/request/{userId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> sendFriendRequest(
			@PathVariable("userId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		return responseMap;
	}

	// TODO write getting list friends by my id
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/me/request/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getFriendRequest() {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		return responseMap;
	}

	// TODO write me
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/me/request/{reqestUserId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> approveRejectFriendRequest(
			@PathVariable("reqestUserId") int id,
			@RequestParam(value="status",required=true) String status
			) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		if(status=="approved"){
			
		}
        if(status=="rejected"){
			
		} 
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		return responseMap;
	}



	private User entitySetter(User requestEntity, User updatedEntity) {

		User finallEntity = updatedEntity;
		finallEntity.setLang(requestEntity.getLang());
		return finallEntity;
	}

	private User entitySetterPassword(User requestEntity, User updatedEntity) {

		User finallEntity = updatedEntity;
		finallEntity.setPassword((requestEntity.getPassword()));
		return finallEntity;
	}

	private UserDetails entitySetter(UserDetails requestEntity,
			UserDetails updatedEntity) {
		UserDetails finallEntity = updatedEntity;
		finallEntity.setDateOfBirth(requestEntity.getDateOfBirth());
		finallEntity.setEmail(requestEntity.getEmail());
		finallEntity.setFirstName(requestEntity.getFirstName());
		finallEntity.setLastName(requestEntity.getLastName());
		finallEntity.setGender(requestEntity.getGender());
		finallEntity.setPhoneNumber(requestEntity.getPhoneNumber());
		return finallEntity;
	}

	private UserRole entitySetter(UserRole requestEntity, UserRole updatedEntity) {

		UserRole finallEntity = updatedEntity;
		finallEntity.setRole(requestEntity.getRole());
		return finallEntity;
	}


}
