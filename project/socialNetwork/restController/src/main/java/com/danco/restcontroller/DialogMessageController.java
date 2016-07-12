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
import com.danco.api.service.IDialogMessageService;
import com.danco.api.service.IDialogService;
import com.danco.model.DialogMessage;
import com.danco.restcontroller.security.IJwtUtil;
import com.danco.restcontroller.security.JwtUtil;


/**
 * The Class DialogMessageController.
 */
@RestController
public class DialogMessageController {

	/** The Constant MESSAGE_ID. */
	private static final String MESSAGE_ID = "messageId";
	
	/** The Constant GROUPS_GROUP_ID_DIALOGS_DIALOG_ID_MESSAGES_MESSAGE_ID. */
	private static final String GROUPS_GROUP_ID_DIALOGS_DIALOG_ID_MESSAGES_MESSAGE_ID = "/groups/{groupId}/dialogs/{dialogId}/messages/{messageId}";
	
	/** The Constant AUTHORIZATION. */
	private static final String AUTHORIZATION = "Authorization";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "message";
	
	/** The Constant RESPONSE_ENTITY. */
	private static final String RESPONSE_ENTITY = "responseEntity";
	
	/** The Constant PAGE_SIZE. */
	private static final String PAGE_SIZE = "PageSize";
	
	/** The Constant START_DIALOG_MESSAGE_ID. */
	private static final String START_DIALOG_MESSAGE_ID = "StartDialogMessageId";
	
	/** The Constant DIALOG_ID. */
	private static final String DIALOG_ID = "dialogId";
	
	/** The Constant GROUPS_GROUP_ID_DIALOGS_DIALOG_ID_MESSAGES. */
	private static final String GROUPS_GROUP_ID_DIALOGS_DIALOG_ID_MESSAGES = "/groups/{groupId}/dialogs/{dialogId}/messages";
	
	/** The Constant CREATED_MESSAGE_CONTROLLER. */
	private static final String CREATED_MESSAGE_CONTROLLER = "Created message controller";
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager
			.getLogger(DialogMessageController.class);

	/** The service. */
	@Autowired
	private IDialogMessageService service;

	/** The dialog service. */
	@Autowired
	private IDialogService dialogService;

	/** The jwt util. */
	private IJwtUtil jwtUtil = JwtUtil.getInstance();

	/**
	 * Instantiates a new dialog message controller.
	 */
	public DialogMessageController() {
		System.out.println(CREATED_MESSAGE_CONTROLLER);
	}

	
	/**
	 * Gets the dialog list.
	 *
	 * @param id the id
	 * @param startDialogMessageId the start dialog message id
	 * @param pageSize the page size
	 * @return the dialog list
	 */
	@RequestMapping(value = GROUPS_GROUP_ID_DIALOGS_DIALOG_ID_MESSAGES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getDialogList(
			@PathVariable(DIALOG_ID) int id,
			@RequestParam(value = START_DIALOG_MESSAGE_ID) int startDialogMessageId,
			@RequestParam(value = PAGE_SIZE) int pageSize) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			responseMap = service.getListByDialogId(id, startDialogMessageId,
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
	 * Creates the dialog.
	 *
	 * @param requestEntity the request entity
	 * @param header the header
	 * @param id the id
	 * @return the hash map
	 */
	@RequestMapping(value = GROUPS_GROUP_ID_DIALOGS_DIALOG_ID_MESSAGES, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> createDialog(
			@RequestBody DialogMessage requestEntity,
			@RequestHeader(AUTHORIZATION) String header,
			@PathVariable(DIALOG_ID) int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			requestEntity.setTimeCreation(new Date());
			requestEntity.setCreator(jwtUtil.getUserFromHeader(header));
			requestEntity.setDialog(dialogService.getById(id));
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
		responseMap.put(MESSAGE, MessageUtil.DIALOG_MESSAGE_CREATED);
		return responseMap;

	}


	/**
	 * Update dialog.
	 *
	 * @param id the id
	 * @param requestEntity the request entity
	 * @return the hash map
	 */
	@RequestMapping(value = GROUPS_GROUP_ID_DIALOGS_DIALOG_ID_MESSAGES_MESSAGE_ID, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> updateDialog(
			@PathVariable(DIALOG_ID) int id,
			@RequestBody DialogMessage requestEntity) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		DialogMessage currentEntity = null;
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
		responseMap.put(MESSAGE, MessageUtil.DIALOG_MESSAGE_UPDATED);
		return responseMap;
	}

	
	/**
	 * Delete dialog.
	 *
	 * @param id the id
	 * @return the hash map
	 */
	@RequestMapping(value = GROUPS_GROUP_ID_DIALOGS_DIALOG_ID_MESSAGES_MESSAGE_ID, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> deleteDialog(
			@PathVariable(MESSAGE_ID) int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		DialogMessage currentEntity = null;
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
		responseMap.put(MESSAGE, MessageUtil.DIALOG_MESSAGE_DELETED);
		return responseMap;
	}

	/**
	 * Entity setter.
	 *
	 * @param requestEntity the request entity
	 * @param updatedEntity the updated entity
	 * @return the dialog message
	 */
	private DialogMessage entitySetter(DialogMessage requestEntity,
			DialogMessage updatedEntity) {
		DialogMessage finallEntity = updatedEntity;
		finallEntity.setText(requestEntity.getText());
		return finallEntity;
	}

}
