package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IGroupDAO;
import com.danco.api.service.IGroupService;
import com.danco.model.Group;
import com.danco.model.Post;

@Service
public class GroupService extends BaseService<Group> implements IGroupService {

	@Autowired
	private IGroupDAO dao;

	public GroupService() {
		System.out.println("Group service cereated");
	}
	@Transactional(readOnly = true,rollbackFor=Exception.class)
	@Override
	public List<Group> searchByTitle(String title) {
		try {
			return dao.searchByTitle(title);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Transactional(readOnly = true,rollbackFor=Exception.class)
	@Override
	public List<Group> getListByUserId(int id) {
		List<Group> groups = null;
		try {
			groups = dao.getListByUserId(id);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return groups;
	}

}
