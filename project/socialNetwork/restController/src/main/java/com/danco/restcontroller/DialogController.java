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

import com.danco.api.service.IDialogService;
import com.danco.model.Dialog;

@RestController
public class DialogController {

	@Autowired
	private IDialogService service;

	public DialogController() {
		System.out.println("Created dialog controller");
	}

	// TODO  add pagination
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/groups/{groupId}/dialogs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getDialogList(@PathVariable("groupId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		List<Dialog> responseEntity = service.getListByGroupId(id);

		if (responseEntity==null) {
			System.out.println("User with id " + id + " not found");
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
	@RequestMapping(value = "/groups/{groupId}/dialogs/{dialogId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getDialog(@PathVariable("dialogId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		Dialog responseEntity = service.getById(id);

		if (responseEntity == null) {
			System.out.println("dialog with id " + id + " not found");
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
	@RequestMapping(value = "/groups/{groupId}/dialogs", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> createDialog(
			@RequestBody Dialog requestEntity) {
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
	@RequestMapping(value = "/groups/{groupId}/dialogs/{dialogId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> updateDialog(
			@PathVariable("dialogId") int id, @RequestBody Dialog requestEntity) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println("Updating dialog " + id);
		Dialog currentEntity = null;
		currentEntity = service.getById(id);
		if (currentEntity == null) {
			System.out.println("Dialog with id " + id + " not found");
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
	@RequestMapping(value = "/groups/{groupId}/dialogs/{dialogId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> deleteDialog(@PathVariable("dialogId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println("Deleting dialog id: " + id);
		Dialog currentEntity = null;
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

	private Dialog entitySetter(Dialog requestEntity, Dialog updatedEntity) {
		Dialog finallEntity = updatedEntity;
		finallEntity.setText(requestEntity.getText());
		finallEntity.setTitle(requestEntity.getTitle());
		return finallEntity;
	}

}
