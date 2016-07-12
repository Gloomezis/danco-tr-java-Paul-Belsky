package com.danco.restcontroller;

import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danco.api.exception.MyException;
import com.danco.api.message.MessageUtil;
import com.danco.api.service.IPostService;
import com.danco.model.Post;
import com.danco.model.User;
import com.danco.restcontroller.security.IJwtUtil;
import com.danco.restcontroller.security.JwtUtil;


/**
 * The Class PostController.
 */
@RestController
public class PostController {

	/** The Constant POST_ID. */
	private static final String POST_ID = "postId";
	
	/** The Constant POSTS_POST_ID. */
	private static final String POSTS_POST_ID = "/posts/{postId}";
	
	/** The Constant ME_NEWS. */
	private static final String ME_NEWS = "/me/news";
	
	/** The Constant USERS_USER_ID_POSTS. */
	private static final String USERS_USER_ID_POSTS = "/users/{userId}/posts";
	
	/** The Constant USER_ID. */
	private static final String USER_ID = "userId";
	
	/** The Constant USERS_USER_ID_WALL. */
	private static final String USERS_USER_ID_WALL = "/users/{userId}/wall";
	
	/** The Constant AUTHORIZATION. */
	private static final String AUTHORIZATION = "Authorization";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "message";
	
	/** The Constant RESPONSE_ENTITY. */
	private static final String RESPONSE_ENTITY = "responseEntity";
	
	/** The Constant ME_FEED. */
	private static final String ME_FEED = "/me/feed";
	
	/** The Constant PAGE_SIZE. */
	private static final String PAGE_SIZE = "PageSize";
	
	/** The Constant START_POST_ID. */
	private static final String START_POST_ID = "StartPostId";
	
	/** The Constant CREATED_POST_CONTROLLER. */
	private static final String CREATED_POST_CONTROLLER = "Created post controller";

	/** The service. */
	@Autowired
	private IPostService service;

	/** The jwt util. */
	private IJwtUtil jwtUtil = JwtUtil.getInstance();

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager
			.getLogger(PostController.class);

	/**
	 * Instantiates a new post controller.
	 */
	public PostController() {
		System.out.println(CREATED_POST_CONTROLLER);
	}

	
	/**
	 * Gets the my post list.
	 *
	 * @param startPostId the start post id
	 * @param pageSize the page size
	 * @param header the header
	 * @return the my post list
	 */
	@RequestMapping(value = ME_FEED, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getMyPostList(
			@RequestParam(value = START_POST_ID) int startPostId,
			@RequestParam(value = PAGE_SIZE) int pageSize,
			@RequestHeader(AUTHORIZATION) String header) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		User usFromHeader = jwtUtil.getUserFromHeader(header);
		int myId = usFromHeader.getId();
		try {
			responseMap = service.getListByUserId(myId, startPostId, pageSize);
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
	 * Gets the user post list.
	 *
	 * @param id the id
	 * @param startPostId the start post id
	 * @param pageSize the page size
	 * @return the user post list
	 */
	@RequestMapping(value = USERS_USER_ID_WALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getUserPostList(
			@PathVariable(USER_ID) int id,
			@RequestParam(value = START_POST_ID, required = false) int startPostId,
			@RequestParam(value = PAGE_SIZE, required = false) int pageSize) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			responseMap = service.getListByUserId(id, startPostId, pageSize);
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
	 * Gets the news post list.
	 *
	 * @param header the header
	 * @param startPostId the start post id
	 * @param pageSize the page size
	 * @return the news post list
	 */
	@RequestMapping(value = ME_NEWS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getNewsPostList(
			@RequestHeader(AUTHORIZATION) String header,
			@RequestParam(value = START_POST_ID) int startPostId,
			@RequestParam(value = PAGE_SIZE) int pageSize) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		User u = jwtUtil.getUserFromHeader(header);
		try {
			responseMap = service.getNewsPostList(u.getId(), startPostId,
					pageSize);
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
	 * Creates the post.
	 *
	 * @param header the header
	 * @param requestEntity the request entity
	 * @return the hash map
	 */
	@RequestMapping(value = USERS_USER_ID_POSTS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> createPost(
			@RequestHeader(AUTHORIZATION) String header,
			@RequestBody Post requestEntity) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			User currentUser = jwtUtil.getUserFromHeader(header);
			requestEntity.setCreator(currentUser);
			requestEntity.setTimeCreation(new Date());
			service.create(requestEntity);
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
		responseMap.put(MESSAGE, MessageUtil.POST_CREATED);
		return responseMap;
	}

	
	/**
	 * Update post.
	 *
	 * @param id the id
	 * @param requestEntity the request entity
	 * @return the hash map
	 */
	@RequestMapping(value = POSTS_POST_ID, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> updatePost(@PathVariable(POST_ID) int id,
			@RequestBody Post requestEntity) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		Post currentEntity = null;
		try {
			currentEntity = service.getById(id);
			currentEntity = entitySetter(requestEntity, currentEntity);
			service.update(currentEntity);
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
		responseMap.put(MESSAGE, MessageUtil.POST_UPDATED);
		return responseMap;

	}

	
	/**
	 * Delete post.
	 *
	 * @param id the id
	 * @return the hash map
	 */
	@RequestMapping(value = POSTS_POST_ID, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> deletePost(@PathVariable(POST_ID) int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		Post currentEntity = null;
		try {
			currentEntity = service.getById(id);
			service.delete(currentEntity);
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
		responseMap.put(MESSAGE, MessageUtil.POST_DELETED);
		return responseMap;
	}

	/**
	 * Entity setter.
	 *
	 * @param requestEntity the request entity
	 * @param updatedEntity the updated entity
	 * @return the post
	 */
	private Post entitySetter(Post requestEntity, Post updatedEntity) {
		Post finallEntity = updatedEntity;
		finallEntity.setText(requestEntity.getText());
		return finallEntity;
	}

}
