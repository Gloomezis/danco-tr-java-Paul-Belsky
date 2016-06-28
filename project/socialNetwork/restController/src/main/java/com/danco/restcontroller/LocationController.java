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

import com.danco.api.service.ILocationService;
import com.danco.model.Location;

@RestController
public class LocationController {

	@Autowired
	private ILocationService service;

	public LocationController() {
		System.out.println("Created location controller");
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/me/location/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> updateLocation(

	 @RequestBody Location location) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println("Updating location " +location.getId());
		Location currentLocation = null;
		currentLocation = service.getById(location.getId());
		if (currentLocation == null) {
			System.out.println("Location with id " + location.getId() + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "not found");
			return responseMap;
		}
		currentLocation = entitySetter(location, currentLocation);
		try {
			service.update(currentLocation);
			responseMap.put("errorCode", 200);
			responseMap.put("errorMsg", "ok");
			return responseMap;
		} catch (Exception e) {
			responseMap.put("errorCode", 409);
			responseMap.put("errorMsg", "Conflicted");
			return responseMap;
		}

	}

	private Location entitySetter(Location requestEntity, Location updatedEntity) {
		Location finallEntity = updatedEntity;
		finallEntity.setCity(requestEntity.getCity());
		finallEntity.setState(requestEntity.getState());
		finallEntity.setCountry(requestEntity.getCountry());
		return finallEntity;
	}

}
