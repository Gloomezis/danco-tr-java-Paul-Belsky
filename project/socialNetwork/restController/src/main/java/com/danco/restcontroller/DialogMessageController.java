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

import com.danco.api.service.IDialogMessageService;
import com.danco.model.DialogMessage;

@RestController
public class DialogMessageController {

	@Autowired
	private IDialogMessageService service;

	public DialogMessageController() {
		System.out.println("Created message controller");
	}

	// TODO add pagination
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/groups/{groupId}/dialogs/{dialogId}/messages/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getDialogList(
			@PathVariable("dialogId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		List<DialogMessage> responseEntity = service.getListByDialogId(id);

		if (responseEntity.isEmpty()) {
			System.out.println("DialogMessage with id " + id + " not found");
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
	@RequestMapping(value = "/groups/{groupId}/dialogs/{dialogId}/messages/{messageId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getDialogMessage(
			@PathVariable("dialogId") int id){
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		DialogMessage responseEntity = service.getById(id);

		if (responseEntity == null) {
			System.out.println("dialogMessage with id " + id + " not found");
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
	@RequestMapping(value = "/groups/{groupId}/dialogs/{dialogId}/messages", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> createDialog(
			@RequestBody DialogMessage requestEntity) {
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
	@RequestMapping(value = "/groups/{groupId}/dialogs/{dialogId}/messages/{messageId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> updateDialog(
			@PathVariable("dialogId") int id,
			@RequestBody DialogMessage requestEntity) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println("Updating dialogMessage " + id);
		DialogMessage currentEntity = null;
		currentEntity = service.getById(id);
		if (currentEntity == null) {
			System.out.println("DialogMessage with id " + id + " not found");
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
	@RequestMapping(value = "/groups/{groupId}/dialogs/{dialogId}/messages/{messageId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> deleteDialog(
			@PathVariable("messageId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println("Deleting dialogMessage id: " + id);
		DialogMessage currentEntity = null;
		currentEntity = service.getById(id);
		if (currentEntity == null) {
			System.out.println("DialogMessage with id " + id + " not found");
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

	private DialogMessage entitySetter(DialogMessage requestEntity,
			DialogMessage updatedEntity) {
		DialogMessage finallEntity = updatedEntity;
		finallEntity.setText(requestEntity.getText());
		return finallEntity;
	}

}
