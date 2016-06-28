package com.danco.restcontroller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.danco.api.service.IUserDetailsService;
import com.danco.model.UserDetails;

@RestController
public class UserDetailsController {

	@Autowired
	private IUserDetailsService service;

	public UserDetailsController() {
		System.out.println("Created group controller");
	}
	
	

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/me/userdetails", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> updateUserDetails(
	@RequestBody UserDetails userDetails) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println("Updating location " + userDetails.getId());
		UserDetails currentUserDetails = null;
		currentUserDetails = service.getById(userDetails.getId());
		if (currentUserDetails == null) {
			System.out.println("Userdetails with id " + userDetails.getId()
					+ " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "not found");
			return responseMap;
		}
		currentUserDetails = entitySetter(userDetails, currentUserDetails);
		try {
			service.update(currentUserDetails);
			responseMap.put("errorCode", 200);
			responseMap.put("errorMsg", "ok");
			return responseMap;
		} catch (Exception e) {
			responseMap.put("errorCode", 409);
			responseMap.put("errorMsg", "Conflicted");
			return responseMap;
		}

	}

	private UserDetails entitySetter(UserDetails requestEntity,
			UserDetails updatedEntity) {
		UserDetails finallEntity = updatedEntity;
		finallEntity.setDateOfBirth(requestEntity.getDateOfBirth());
		finallEntity.setEmail(requestEntity.getEmail());
		finallEntity.setFirstName(requestEntity.getFirstName());
		finallEntity.setLastName(requestEntity.getLastName());
		finallEntity.setGender(requestEntity.getGender());
		finallEntity.setPhoneNumber(requestEntity.getPhoneNumber());
		return finallEntity;
	}

}
