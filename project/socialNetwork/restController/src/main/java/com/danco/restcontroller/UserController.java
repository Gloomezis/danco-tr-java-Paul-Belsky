package com.danco.restcontroller;

import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danco.api.exception.MyException;
import com.danco.api.message.MessageUtil;
import com.danco.api.service.IFriendshipService;
import com.danco.api.service.IUserDetailsService;
import com.danco.api.service.IUserService;
import com.danco.model.Friendship;
import com.danco.model.User;
import com.danco.restcontroller.security.IJwtUtil;
import com.danco.restcontroller.security.JwtUtil;
import com.danco.restcontroller.utils.SearchEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
@RestController
public class UserController {

	/** The Constant ME_REQUESTS_USER_ID. */
	private static final String ME_REQUESTS_USER_ID = "/me/requests/{userId}";
	
	/** The Constant PAGE_SIZE. */
	private static final String PAGE_SIZE = "PageSize";
	
	/** The Constant START_FOLLOWERS_ID. */
	private static final String START_FOLLOWERS_ID = "StartFollowersId";
	
	/** The Constant USER2. */
	private static final String USER2 = "user";
	
	/** The Constant START_FOLLOWINGS_ID. */
	private static final String START_FOLLOWINGS_ID = "StartFollowingsId";
	
	/** The Constant USER_ID. */
	private static final String USER_ID = "userId";
	
	/** The Constant ME_FOLLOWERS. */
	private static final String ME_FOLLOWERS = "/me/followers";
	
	/** The Constant USERS_USER_ID. */
	private static final String USERS_USER_ID = "/users/{userId}";
	
	/** The Constant ME_FOLLOWINGS. */
	private static final String ME_FOLLOWINGS = "/me/followings";
	
	/** The Constant IS_FRIEND. */
	private static final String IS_FRIEND = "isFriend";
	
	/** The Constant ME_CHANGEPASSWORD. */
	private static final String ME_CHANGEPASSWORD = "/me/changepassword";
	
	/** The Constant UPDATING_USER. */
	private static final String UPDATING_USER = "Updating user ";
	
	/** The Constant AUTHORIZATION. */
	private static final String AUTHORIZATION = "Authorization";
	
	/** The Constant USERS_REGISTER. */
	private static final String USERS_REGISTER = "/users/register";
	
	/** The Constant ME. */
	private static final String ME = "/me";
	
	/** The Constant USERS_LOGOUT. */
	private static final String USERS_LOGOUT = "/users/logout";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "message";
	
	/** The Constant USERS_LOGIN. */
	private static final String USERS_LOGIN = "/users/login";
	
	/** The Constant CREATED_USER_CONTROLLER. */
	private static final String CREATED_USER_CONTROLLER = "Created user controller";
	
	/** The Constant RESPONSE_ENTITY. */
	private static final String RESPONSE_ENTITY = "responseEntity";
	
	/** The Constant USERS_SEARCH. */
	private static final String USERS_SEARCH = "/users/search";

	/** The service. */
	@Autowired
	private IUserService service;

	/** The user details service. */
	@Autowired
	private IUserDetailsService userDetailsService;

	/** The friendship service. */
	@Autowired
	private IFriendshipService friendshipService;

	/** The jwt util. */
	private IJwtUtil jwtUtil = JwtUtil.getInstance();

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager
			.getLogger(UserController.class);

	/**
	 * Instantiates a new user controller.
	 */
	public UserController() {
		System.out.println(CREATED_USER_CONTROLLER);
	}

	
	/**
	 * Gets the users by search.
	 *
	 * @param searchEntity the search entity
	 * @return the users by search
	 */
	@RequestMapping(value = USERS_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getUsersBySearch(
			@RequestBody SearchEntity searchEntity) {
		String s = searchEntity.getParam();
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			responseMap = service.searchByName(s);
		} catch (MyException e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, e.getMessage());
			return responseMap;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, MessageUtil.SERVER_ERROR);
		}
		responseMap.put(MESSAGE, MessageUtil.EMPTY_MESSAGE);
		return responseMap;
	}

	
	/**
	 * Login.
	 *
	 * @param user the user
	 * @return the hash map
	 */
	@RequestMapping(value = USERS_LOGIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> login(@RequestBody User user) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		User responseEntity = null;
		try {
			responseEntity = service.getByCredentials(user.getUsername(),
					user.getPassword());
		} catch (MyException e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, e.getMessage());
			return responseMap;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, MessageUtil.SERVER_ERROR);
		}
		responseEntity.setToken(jwtUtil.generateToken(responseEntity));
		responseMap.put(MESSAGE, MessageUtil.LOGGIN);
		responseMap.put(RESPONSE_ENTITY, responseEntity);
		return responseMap;
	}

	
	/**
	 * Login.
	 *
	 * @return the hash map
	 */
	@RequestMapping(value = USERS_LOGOUT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> login() {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put(MESSAGE, MessageUtil.LOGGOUT);
		return responseMap;
	}

	
	/**
	 * Register.
	 *
	 * @param user the user
	 * @return the hash map
	 */
	@RequestMapping(value = USERS_REGISTER, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> register(@RequestBody User user) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		user.setRegistrationDate(new Date());
		try {
			service.create(user);
		} catch (MyException e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, e.getMessage());
			return responseMap;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, MessageUtil.SERVER_ERROR);
		}
		responseMap.put(MESSAGE, MessageUtil.REGISTERED);
		return responseMap;
	}


	/**
	 * Gets the data about me.
	 *
	 * @param header the header
	 * @return the data about me
	 */
	@RequestMapping(value = ME, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getDataAboutMe(
			@RequestHeader(AUTHORIZATION) String header) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		User user = null;
		try {
			User usFromHeader = jwtUtil.getUserFromHeader(header);
			user = service.getById(usFromHeader.getId());
		} catch (MyException e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, e.getMessage());
			return responseMap;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, MessageUtil.SERVER_ERROR);
		}
		responseMap.put(RESPONSE_ENTITY, user);
		responseMap.put(MESSAGE, MessageUtil.EMPTY_MESSAGE);
		return responseMap;
	}

	
	/**
	 * Edits the profile.
	 *
	 * @param user the user
	 * @return the hash map
	 */
	@RequestMapping(value = ME, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> editProfile(@RequestBody User user) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			System.out.println(UPDATING_USER + user.getUsername());
			userDetailsService.update(user.getUserDetails());
		} catch (MyException e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, e.getMessage());
			return responseMap;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, MessageUtil.SERVER_ERROR);
		}
		responseMap.put(MESSAGE, MessageUtil.UPDATED);
		return responseMap;
	}

	
	/**
	 * Change password.
	 *
	 * @param user the user
	 * @return the hash map
	 */
	@RequestMapping(value = ME_CHANGEPASSWORD, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> changePassword(@RequestBody User user) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			User currentUser = null;
			currentUser = service.getById(user.getId());
			currentUser = entitySetterPassword(user, currentUser);
			service.update(currentUser);
		} catch (MyException e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, e.getMessage());
			return responseMap;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, MessageUtil.SERVER_ERROR);
		}
		responseMap.put(MESSAGE, MessageUtil.PASSWORD_CHANGED);
		return responseMap;
	}

	/**
	 * Gets the data about user.
	 *
	 * @param header the header
	 * @param id the id
	 * @return the data about user
	 */
	@RequestMapping(value = USERS_USER_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getDataAboutUser(
			@RequestHeader(AUTHORIZATION) String header,
			@PathVariable(USER_ID) int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		User user = null;
		Boolean isFriend = false;
		try {
			user = service.getById(id);
			User me = jwtUtil.getUserFromHeader(header);
			isFriend = friendshipService.isFriend(me.getId(), id);
			responseMap.put(IS_FRIEND,
					friendshipService.isFriend(me.getId(), id));
		} catch (MyException e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, e.getMessage());
			return responseMap;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, MessageUtil.SERVER_ERROR);
		}
		responseMap.put(USER2, user);
		responseMap.put(IS_FRIEND, isFriend);
		responseMap.put(MESSAGE, MessageUtil.EMPTY_MESSAGE);
		return responseMap;
	}

	// <<<<<<<<<<<<<<<<Friends METHODS>>>>>>>>>>>>>>>>>>>>>

	
	/**
	 * Gets the my followers.
	 *
	 * @param header the header
	 * @param startFollowersId the start followers id
	 * @param pageSize the page size
	 * @return the my followers
	 */
	@RequestMapping(value = ME_FOLLOWERS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getMyFollowers(
			@RequestHeader(AUTHORIZATION) String header,
			@RequestParam(value = START_FOLLOWERS_ID) int startFollowersId,
			@RequestParam(value = PAGE_SIZE) int pageSize) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		User my = jwtUtil.getUserFromHeader(header);
		try {
			responseMap = friendshipService.getMyFollowers(my.getId(),
					startFollowersId, pageSize);
		} catch (MyException e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, e.getMessage());
			return responseMap;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, MessageUtil.SERVER_ERROR);
		}
		responseMap.put(MESSAGE, MessageUtil.EMPTY_MESSAGE);
		return responseMap;
	}

	
	/**
	 * Gets the my followings.
	 *
	 * @param header the header
	 * @param startFollowingsId the start followings id
	 * @param pageSize the page size
	 * @return the my followings
	 */
	@RequestMapping(value = ME_FOLLOWINGS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getMyFollowings(
			@RequestHeader(AUTHORIZATION) String header,
			@RequestParam(value = START_FOLLOWINGS_ID) int startFollowingsId,
			@RequestParam(value = PAGE_SIZE) int pageSize) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		User my = jwtUtil.getUserFromHeader(header);
		try {
			responseMap = friendshipService.getMyFollowings(my.getId(),
					startFollowingsId, pageSize);
		} catch (MyException e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, e.getMessage());
			return responseMap;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, MessageUtil.SERVER_ERROR);
		}
		responseMap.put(MESSAGE, MessageUtil.EMPTY_MESSAGE);
		return responseMap;
	}

	
	/**
	 * Subscribe.
	 *
	 * @param id the id
	 * @param header the header
	 * @return the hash map
	 */
	@RequestMapping(value = ME_REQUESTS_USER_ID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> subscribe(@PathVariable(USER_ID) int id,
			@RequestHeader(AUTHORIZATION) String header) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			User friend = service.getById(id);
			User meUser = jwtUtil.getUserFromHeader(header);
			Friendship friendship = new Friendship();
			friendship.setUser(meUser);
			friendship.setFriend(friend);
			friendshipService.create(friendship);
		} catch (MyException e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, e.getMessage());
			return responseMap;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, MessageUtil.SERVER_ERROR);
		}
		responseMap.put(MESSAGE, MessageUtil.SUBSCRIBED);
		return responseMap;
	}

	
	/**
	 * Unsubscribe.
	 *
	 * @param id the id
	 * @param header the header
	 * @return the hash map
	 */
	@RequestMapping(value = ME_REQUESTS_USER_ID, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> unsubscribe(@PathVariable(USER_ID) int id,
			@RequestHeader(AUTHORIZATION) String header) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		User me = jwtUtil.getUserFromHeader(header);
		Friendship fr = null;
		try {
			fr = friendshipService.getFriendship(me.getId(), id);
			friendshipService.delete(fr);
		} catch (MyException e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, e.getMessage());
			return responseMap;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			responseMap.put(RESPONSE_ENTITY, null);
			responseMap.put(MESSAGE, MessageUtil.SERVER_ERROR);
		}
		responseMap.put(MESSAGE, MessageUtil.DELETED);
		return responseMap;
	}

	/**
	 * Entity setter password.
	 *
	 * @param requestEntity the request entity
	 * @param updatedEntity the updated entity
	 * @return the user
	 */
	private User entitySetterPassword(User requestEntity, User updatedEntity) {
		User finallEntity = updatedEntity;
		finallEntity.setPassword((requestEntity.getPassword()));
		return finallEntity;
	}

}
