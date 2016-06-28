package com.danco.api.dao;

import java.util.List;

import com.danco.model.Group;


public interface IGroupDAO extends IDAO<Group>{

	public List<Group> searchByTitle(String title);

	public List<Group> getListByUserId(int id);


	

}