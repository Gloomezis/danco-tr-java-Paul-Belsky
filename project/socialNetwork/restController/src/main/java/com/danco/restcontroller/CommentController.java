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
import com.danco.api.service.ICommentService;
import com.danco.api.service.IPostService;
import com.danco.model.Comment;
import com.danco.model.Post;
import com.danco.restcontroller.security.IJwtUtil;
import com.danco.restcontroller.security.JwtUtil;


/**
 * The Class CommentController.
 */
@RestController
public class CommentController {

	/** The Constant COMMENT_ID. */
	private static final String COMMENT_ID = "commentId";
	
	/** The Constant POSTS_POST_ID_COMMENTS_COMMENT_ID. */
	private static final String POSTS_POST_ID_COMMENTS_COMMENT_ID = "/posts/{postId}/comments/{commentId}";
	
	/** The Constant AUTHORIZATION. */
	private static final String AUTHORIZATION = "Authorization";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "message";
	
	/** The Constant RESPONSE_ENTITY. */
	private static final String RESPONSE_ENTITY = "responseEntity";
	
	/** The Constant PAGE_SIZE. */
	private static final String PAGE_SIZE = "PageSize";
	
	/** The Constant START_COMMENT_ID. */
	private static final String START_COMMENT_ID = "StartCommentId";
	
	/** The Constant POST_ID. */
	private static final String POST_ID = "postId";
	
	/** The Constant POSTS_POST_ID_COMMENTS. */
	private static final String POSTS_POST_ID_COMMENTS = "/posts/{postId}/comments";
	
	/** The Constant CREATED_COMMENT_CONTROLLER. */
	private static final String CREATED_COMMENT_CONTROLLER = "Created comment controller";
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager
			.getLogger(CommentController.class);

	/** The service. */
	@Autowired
	private ICommentService service;

	/** The post service. */
	@Autowired
	private IPostService postService;

	/** The jwt util. */
	private IJwtUtil jwtUtil = JwtUtil.getInstance();

	/**
	 * Instantiates a new comment controller.
	 */
	public CommentController() {
		System.out.println(CREATED_COMMENT_CONTROLLER);
	}

	
	/**
	 * Gets the comment list with pagination.
	 *
	 * @param id the id
	 * @param startCommentId the start comment id
	 * @param pageSize the page size
	 * @return the comment list with pagination
	 */
	@RequestMapping(value = POSTS_POST_ID_COMMENTS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getCommentListWithPagination(
			@PathVariable(POST_ID) int id,
			@RequestParam(value = START_COMMENT_ID, required = true) int startCommentId,
			@RequestParam(value = PAGE_SIZE, required = true) int pageSize) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			responseMap = service.getListByPostIdPagination(id, startCommentId,
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
	 * Creates the comment.
	 *
	 * @param requestEntity the request entity
	 * @param header the header
	 * @param id the id
	 * @return the hash map
	 */
	@RequestMapping(value = POSTS_POST_ID_COMMENTS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> createComment(
			@RequestBody Comment requestEntity,
			@RequestHeader(AUTHORIZATION) String header,
			@PathVariable(POST_ID) int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			requestEntity.setTimeCreation(new Date());
			requestEntity.setCreator(jwtUtil.getUserFromHeader(header));
			Post post = postService.getById(id);
			requestEntity.setPost(post);
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
		responseMap.put(MESSAGE, MessageUtil.COMMENT_CREATED);
		return responseMap;

	}

	
	/**
	 * Update comment.
	 *
	 * @param postId the post id
	 * @param commentId the comment id
	 * @param comment the comment
	 * @return the hash map
	 */
	@RequestMapping(value = POSTS_POST_ID_COMMENTS_COMMENT_ID, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> updateComment(
			@PathVariable(POST_ID) int postId,
			@PathVariable(COMMENT_ID) int commentId,
			@RequestBody Comment comment) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		Comment currentComment = null;
		try {
			currentComment = service.getById(commentId);
			currentComment = commentSetter(comment, currentComment);
			service.update(currentComment);
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
		responseMap.put(MESSAGE, MessageUtil.COMMENT_UPDATED);
		return responseMap;
	}

	
	/**
	 * Delete comment.
	 *
	 * @param postId the post id
	 * @param commentId the comment id
	 * @return the hash map
	 */
	@RequestMapping(value = POSTS_POST_ID_COMMENTS_COMMENT_ID, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> deleteComment(
			@PathVariable(POST_ID) int postId,
			@PathVariable(COMMENT_ID) int commentId) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		Comment currentComment = null;
		try{
		currentComment = service.getById(commentId);
		service.delete(currentComment);
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
		responseMap.put(MESSAGE, MessageUtil.COMMENT_DELETED);
		return responseMap;
	}

	/**
	 * Comment setter.
	 *
	 * @param requestEntity the request entity
	 * @param updatedEntity the updated entity
	 * @return the comment
	 */
	private Comment commentSetter(Comment requestEntity, Comment updatedEntity) {
		Comment finallEntity = updatedEntity;
		finallEntity.setText(requestEntity.getText());
		return finallEntity;
	}
}
