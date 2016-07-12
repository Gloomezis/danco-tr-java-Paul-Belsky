package com.danco.restcontroller;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danco.api.exception.MyException;
import com.danco.api.message.MessageUtil;
import com.danco.api.service.IGroupService;
import com.danco.model.Group;


/**
 * The Class GroupController.
 */
@RestController
public class GroupController {

	/** The Constant MESSAGE. */
	private static final String MESSAGE = "message";
	
	/** The Constant RESPONSE_ENTITY. */
	private static final String RESPONSE_ENTITY = "responseEntity";
	
	/** The Constant GROUPS. */
	private static final String GROUPS = "/groups";
	
	/** The Constant CREATED_GROUP_CONTROLLER. */
	private static final String CREATED_GROUP_CONTROLLER = "Created group controller";
	
	/** The service. */
	@Autowired
	private IGroupService service;

	/**
	 * Instantiates a new group controller.
	 */
	public GroupController() {
		System.out.println(CREATED_GROUP_CONTROLLER);
	}

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager
			.getLogger(GroupController.class);

	
	/**
	 * Gets the group list.
	 *
	 * @return the group list
	 */
	@RequestMapping(value = GROUPS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getGroupList() {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		List<Group> responseEntity = null;
		try {
			responseEntity = service.getList();
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
		responseMap.put(RESPONSE_ENTITY, responseEntity);
		responseMap.put(MESSAGE, MessageUtil.EMPTY_MESSAGE);
		return responseMap;
	}

}
