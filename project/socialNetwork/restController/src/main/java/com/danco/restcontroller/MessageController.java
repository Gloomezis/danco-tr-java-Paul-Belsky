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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.danco.api.service.IMessageService;
import com.danco.model.Message;

@RestController
public class MessageController {

	@Autowired
	private IMessageService service;

	public MessageController() {
		System.out.println("Created message controller");
	}

	// TODO write getted messageList ordered by datetime (one last message by
	// one user) creating bylast users
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/me/messages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getMyMessagesList() {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		// write GetList(myID) list messages uniq users by last shown message
		// ordered by datetime
		List<Message> responseEntity = service.getList();

		if (responseEntity == null) {
			System.out.println("My posts  not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "Not found");
			return responseMap;
		}
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		responseMap.put("responseEntity", responseEntity);
		return responseMap;
	}

	// TODO get list message one by one with selected user
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/me/messages/user/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getMyMessagesOneByOne(
			@PathVariable("userId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		// write GetList(myID,userId)
		List<Message> responseEntity = service.getList();

		if (responseEntity.isEmpty()) {
			System.out.println("List post user: " + id + " not found");
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
	@RequestMapping(value = "/me/messages", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> createMessage(@RequestBody Message message) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			service.create(message);
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
	@RequestMapping(value = "/me/messages/{messageId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> updateMessage(
			@PathVariable("messageId") int id,
			@RequestBody Message requestEntity) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println("Updating message " + requestEntity.getId());
		Message currentEntity = null;
		currentEntity = service.getById(requestEntity.getId());
		if (currentEntity == null) {
			System.out.println("Post with id " + id + " not found");
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
	@RequestMapping(value = "/me/messages/{messageId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> deletePost(@PathVariable("messageId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println("Deleting post id: " + id);
		Message currentEntity = null;
		currentEntity = service.getById(id);
		if (currentEntity == null) {
			System.out.println("Message with id " + id + " not found");
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

	private Message entitySetter(Message requestEntity, Message updatedEntity) {
		Message finallEntity = updatedEntity;
		finallEntity.setText(requestEntity.getText());
		finallEntity.setRead(requestEntity.isRead());
		return finallEntity;
	}

}
