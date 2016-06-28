package com.danco.api.service;

import java.util.List;

import com.danco.model.Group;

public interface IGroupService extends IService<Group>{

	

	public  List<Group> searchByTitle(String title);

	public  List<Group> getListByUserId(int id);

}