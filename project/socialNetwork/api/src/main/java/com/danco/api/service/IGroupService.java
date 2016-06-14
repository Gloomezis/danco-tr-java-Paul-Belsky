package com.danco.api.service;

import java.util.List;

import com.danco.model.Group;

public interface IGroupService {

	public abstract void create(Group group)throws Exception;

	public abstract void update(Group group)throws Exception;

	public abstract void delete(Group group)throws Exception;

	public abstract Group getById(int idModel)throws Exception;

	public abstract List<Group> getList()throws Exception;

}