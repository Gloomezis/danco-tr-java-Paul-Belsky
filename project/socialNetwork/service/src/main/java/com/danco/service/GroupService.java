package com.danco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danco.api.dao.IGroupDAO;
import com.danco.api.service.IGroupService;
import com.danco.model.Group;


/**
 * The Class GroupService.
 */
@Service
public class GroupService extends BaseService<Group> implements IGroupService {

	/** The Constant GROUP_SERVICE_CEREATED. */
	private static final String GROUP_SERVICE_CEREATED = "Group service cereated";
	
	/** The dao. */
	@Autowired
	private IGroupDAO dao;

	/**
	 * Instantiates a new group service.
	 */
	public GroupService() {
		System.out.println(GROUP_SERVICE_CEREATED);
	}

}
