package com.danco.restcontroller;

import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danco.api.exception.MyException;
import com.danco.api.message.MessageUtil;
import com.danco.api.service.IDialogService;
import com.danco.api.service.IGroupService;
import com.danco.api.service.IUserService;
import com.danco.model.Dialog;
import com.danco.model.User;
import com.danco.restcontroller.security.IJwtUtil;
import com.danco.restcontroller.security.JwtUtil;


/**
 * The Class DialogController.
 */
@Controller
public class DialogController {

	/** The Constant DIALOG_ID. */
	private static final String DIALOG_ID = "dialogId";
	
	/** The Constant GROUPS_GROUP_ID_DIALOGS_DIALOG_ID. */
	private static final String GROUPS_GROUP_ID_DIALOGS_DIALOG_ID = "/groups/{groupId}/dialogs/{dialogId}";
	
	/** The Constant APPLICATION_JSON. */
	private static final String APPLICATION_JSON = "application/json";
	
	/** The Constant AUTHORIZATION. */
	private static final String AUTHORIZATION = "Authorization";
	
	/** The Constant MESSAGE. */
	private static final String MESSAGE = "message";
	
	/** The Constant RESPONSE_ENTITY. */
	private static final String RESPONSE_ENTITY = "responseEntity";
	
	/** The Constant PAGE_SIZE. */
	private static final String PAGE_SIZE = "PageSize";
	
	/** The Constant START_DIALOG_ID. */
	private static final String START_DIALOG_ID = "StartDialogId";
	
	/** The Constant GROUP_ID. */
	private static final String GROUP_ID = "groupId";
	
	/** The Constant GROUPS_GROUP_ID_DIALOGS. */
	private static final String GROUPS_GROUP_ID_DIALOGS = "/groups/{groupId}/dialogs";
	
	/** The Constant CREATED_DIALOG_CONTROLLER. */
	private static final String CREATED_DIALOG_CONTROLLER = "Created dialog controller";

	/** The service. */
	@Autowired
	private IDialogService service;

	/** The user service. */
	@Autowired
	private IUserService userService;

	/** The group service. */
	@Autowired
	private IGroupService groupService;

	/** The jwt util. */
	private IJwtUtil jwtUtil = JwtUtil.getInstance();

	/**
	 * Instantiates a new dialog controller.
	 */
	public DialogController() {
		System.out.println(CREATED_DIALOG_CONTROLLER);
	}

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager
			.getLogger(DialogController.class);

	
	/**
	 * Gets the dialog list.
	 *
	 * @param id the id
	 * @param startDialogId the start dialog id
	 * @param pageSize the page size
	 * @return the dialog list
	 */
	@ResponseBody
	@RequestMapping(value = GROUPS_GROUP_ID_DIALOGS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getDialogList(
			@PathVariable(GROUP_ID) int id,
			@RequestParam(value = START_DIALOG_ID) int startDialogId,
			@RequestParam(value = PAGE_SIZE) int pageSize) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			responseMap = service.getListByGroupId(id, startDialogId, pageSize);
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
	 * @throws Exception the exception
	 */
	@ResponseBody
	@RequestMapping(value = GROUPS_GROUP_ID_DIALOGS, method = RequestMethod.POST, produces = APPLICATION_JSON)
	public HashMap<String, Object> createDialog(
			@RequestBody Dialog requestEntity,
			@RequestHeader(AUTHORIZATION) String header,
			@PathVariable(GROUP_ID) int id) throws Exception {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			User usFromHeader = jwtUtil.getUserFromHeader(header);
			requestEntity.setTimeCreation(new Date());
			requestEntity.setCreator(usFromHeader);
			requestEntity.setGroup(groupService.getById(id));
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
		responseMap.put(MESSAGE, MessageUtil.DIALOG_CREATED);
		return responseMap;
	}

	
	/**
	 * Delete dialog.
	 *
	 * @param id the id
	 * @return the hash map
	 */
	@RequestMapping(value = GROUPS_GROUP_ID_DIALOGS_DIALOG_ID, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> deleteDialog(@PathVariable(DIALOG_ID) int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			Dialog currentEntity = service.getById(id);
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
		responseMap.put(MESSAGE, MessageUtil.DIALOG_DELETED);
		return responseMap;
	}

}
