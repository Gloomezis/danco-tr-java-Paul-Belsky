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
import com.danco.api.service.IMessageService;
import com.danco.api.service.IUserService;
import com.danco.model.Message;
import com.danco.model.User;
import com.danco.restcontroller.security.IJwtUtil;
import com.danco.restcontroller.security.JwtUtil;


/**
 * The Class MessageController.
 */
@RestController
public class MessageController {

	/** The Constant ME_MESSAGES_USER_USER_ID. */
	private static final String ME_MESSAGES_USER_USER_ID = "/me/messages/user/{userId}";
	
	/** The Constant MESSAGE_ID. */
	private static final String MESSAGE_ID = "messageId";
	
	/** The Constant ME_MESSAGES_MESSAGE_ID. */
	private static final String ME_MESSAGES_MESSAGE_ID = "/me/messages/{messageId}";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "message";
	
	/** The Constant RESPONSE_ENTITY. */
	private static final String RESPONSE_ENTITY = "responseEntity";
	
	/** The Constant PAGE_SIZE. */
	private static final String PAGE_SIZE = "PageSize";
	
	/** The Constant AUTHORIZATION. */
	private static final String AUTHORIZATION = "Authorization";
	
	/** The Constant START_MESSAGE_ID. */
	private static final String START_MESSAGE_ID = "StartMessageId";
	
	/** The Constant ME_MESSAGES. */
	private static final String ME_MESSAGES = "/me/messages";
	
	/** The Constant CREATED_MESSAGE_CONTROLLER. */
	private static final String CREATED_MESSAGE_CONTROLLER = "Created message controller";
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager
			.getLogger(MessageController.class);

	/** The service. */
	@Autowired
	private IMessageService service;

	/** The user service. */
	@Autowired
	private IUserService userService;

	/** The jwt util. */
	private IJwtUtil jwtUtil = JwtUtil.getInstance();

	/**
	 * Instantiates a new message controller.
	 */
	public MessageController() {
		System.out.println(CREATED_MESSAGE_CONTROLLER);
	}

	
	/**
	 * Gets the my messages list.
	 *
	 * @param header the header
	 * @param startMessageId the start message id
	 * @param pageSize the page size
	 * @return the my messages list
	 */
	@RequestMapping(value = ME_MESSAGES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getMyMessagesList(
			@RequestHeader(AUTHORIZATION) String header,
			@RequestParam(value = START_MESSAGE_ID) int startMessageId,
			@RequestParam(value = PAGE_SIZE) int pageSize) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		User usFromHeader = jwtUtil.getUserFromHeader(header);
		int myId = usFromHeader.getId();
		try {
			responseMap = service.getListByUserId(myId, startMessageId,
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
	 * Gets the my messages one by one.
	 *
	 * @param header the header
	 * @param userId the user id
	 * @param startMessageId the start message id
	 * @param pageSize the page size
	 * @return the my messages one by one
	 */
	@RequestMapping(value = ME_MESSAGES_USER_USER_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getMyMessagesOneByOne(
			@RequestHeader(AUTHORIZATION) String header,
			@PathVariable("userId") int userId,
			@RequestParam(value = START_MESSAGE_ID) int startMessageId,
			@RequestParam(value = PAGE_SIZE) int pageSize) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		User usFromHeader = jwtUtil.getUserFromHeader(header);
		int myId = usFromHeader.getId();
		try {
			responseMap = service.getListPrivateMessage(myId, userId,
					startMessageId, pageSize);
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
	 * Creates the message.
	 *
	 * @param header the header
	 * @param userId the user id
	 * @param requestBody the request body
	 * @return the hash map
	 */
	@RequestMapping(value = ME_MESSAGES_MESSAGE_ID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> createMessage(
			@RequestHeader(AUTHORIZATION) String header,
			@PathVariable(MESSAGE_ID) int userId,
			@RequestBody Message requestBody) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			User usFromHeader = jwtUtil.getUserFromHeader(header);
			int myId = usFromHeader.getId();
			requestBody.setTimeCreation(new Date());
			requestBody.setSender(userService.getById(myId));
			requestBody.setReceiver(userService.getById(userId));
			service.create(requestBody);
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
		responseMap.put(MESSAGE, MessageUtil.MESSAGE_CREATED);
		return responseMap;
	}

	
	/**
	 * Update message.
	 *
	 * @param id the id
	 * @param requestEntity the request entity
	 * @return the hash map
	 */
	@RequestMapping(value = ME_MESSAGES_MESSAGE_ID, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> updateMessage(
			@PathVariable(MESSAGE_ID) int id,
			@RequestBody Message requestEntity) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		Message currentEntity = null;
		try {
			currentEntity = service.getById(requestEntity.getId());
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
		responseMap.put(MESSAGE, MessageUtil.MESSAGE_UPDATED);
		return responseMap;
	}

	
	/**
	 * Delete post.
	 *
	 * @param id the id
	 * @return the hash map
	 */
	@RequestMapping(value = ME_MESSAGES_MESSAGE_ID, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> deletePost(@PathVariable(MESSAGE_ID) int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			Message currentEntity = null;
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
		responseMap.put(MESSAGE, MessageUtil.MESSAGE_DELETED);
		return responseMap;
	}

	/**
	 * Entity setter.
	 *
	 * @param requestEntity the request entity
	 * @param updatedEntity the updated entity
	 * @return the message
	 */
	private Message entitySetter(Message requestEntity, Message updatedEntity) {
		Message finallEntity = updatedEntity;
		finallEntity.setText(requestEntity.getText());
		finallEntity.setDeleted(requestEntity.getDeleted());
		return finallEntity;
	}

}
