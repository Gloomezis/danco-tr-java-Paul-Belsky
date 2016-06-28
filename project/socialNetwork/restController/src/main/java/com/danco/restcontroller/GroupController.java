package com.danco.restcontroller;

import java.util.HashMap;
import java.util.List;

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

import com.danco.api.service.IGroupService;
import com.danco.model.Group;

@RestController
public class GroupController {

	@Autowired
	private IGroupService service;

	public GroupController() {
		System.out.println("Created group controller");
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/groups/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public HashMap<String, Object> getUsersBySearch(
					@RequestParam(value="searcTerms",required=true) String title
					) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
				List<Group> groups = service.searchByTitle(title);
				if (groups == null | groups.isEmpty() ) {
					System.out.println("User with userName " + title
							+ " not found");
					responseMap.put("errorCode", 404);
					responseMap.put("errorMsg", "Not found");
					return responseMap;
				}
				responseMap.put("errorCode", 200);
				responseMap.put("errorMsg", "Ok");
				responseMap.put("responseEntity", groups);
				return responseMap;
			}

	// TODO grouplist with pagination and add me to folder (add to getList(myID)

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/me/groups", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getMyGroupList()  {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		List<Group> responseEntity = service.getList();

		if (responseEntity == null) {
			System.out.println("My groups  not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "Not found");
			return responseMap;
		}
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		responseMap.put("responseEntity", responseEntity);
		return responseMap;
	}

	// TODO grouplist with pagination and user
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/users/{userId}/groups", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getUserGroupList(
			@PathVariable("userId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		List<Group> responseEntity = service.getListByUserId(id);

		if (responseEntity.isEmpty()) {
			System.out.println("group with id " + id + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "Not found");
			return responseMap;
		}
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		responseMap.put("responseEntity", responseEntity);
		return responseMap;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/groups/{groupId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getGroup(@PathVariable("groupId") int id)
			{
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		Group responseEntity = service.getById(id);

		if (responseEntity == null) {
			System.out.println("group with id " + id + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "Not found");
			return responseMap;
		}
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		responseMap.put("responseEntity", responseEntity);
		return responseMap;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/groups", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> createGroup(@RequestBody Group requestEntity) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			service.create(requestEntity);
			responseMap.put("errorCode", 200);
			responseMap.put("errorMsg", "Ok");
			return responseMap;
		} catch (Exception e) {
			responseMap.put("errorCode", 409);
			responseMap.put("errorMsg", "Conflicted");
			return responseMap;
		}

	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/groups/{groupId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> updateGroup(@PathVariable("groupId") int id,
			@RequestBody Group requestEntity) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println("Updating post " + id);
		Group currentEntity = null;
		currentEntity = service.getById(id);
		if (currentEntity == null) {
			System.out.println("Group with id " + id + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "not found");
			return responseMap;
		}
		currentEntity = entitySetter(requestEntity, currentEntity);
		try {
			service.update(currentEntity);
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
	@RequestMapping(value = "/groups/{groupId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> deleteGroup(@PathVariable("groupId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println("Deleting group id: " + id);
		Group currentEntity = null;
		currentEntity = service.getById(id);
		if (currentEntity == null) {
			System.out.println("Comment with id " + id + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "not found");
			return responseMap;
		}
		try {
			service.delete(currentEntity);
			responseMap.put("errorCode", 200);
			responseMap.put("errorMsg", "ok");
			return responseMap;
		} catch (Exception e) {
			responseMap.put("errorCode", 409);
			responseMap.put("errorMsg", "Conflicted");
			return responseMap;
		}

	}

	// TODO add me to group
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/groups/{groupId}/subscribe", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> subscribeGroup(
			@PathVariable("groupId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		return responseMap;
	}

	// TODO delete me from group
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/groups/{groupId}/deleteSubscribe", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> deleteSubscribeGroup(
			@PathVariable("groupId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		return responseMap;
	}

	// TODO write get group members
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/groups/{groupId}/members", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getGroupMembers(
			@PathVariable("groupId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		return responseMap;
	}

	private Group entitySetter(Group requestEntity, Group updatedEntity) {
		Group finallEntity = updatedEntity;
		finallEntity.setDescription(requestEntity.getDescription());
		finallEntity.setTitle(requestEntity.getTitle());
		return finallEntity;
	}

}
