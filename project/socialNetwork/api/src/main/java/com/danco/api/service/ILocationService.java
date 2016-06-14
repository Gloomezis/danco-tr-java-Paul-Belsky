package com.danco.api.service;

import java.util.List;

import com.danco.model.Location;

public interface ILocationService {

	public abstract void create(Location location)throws Exception;

	public abstract void update(Location location)throws Exception;

	public abstract void delete(Location location)throws Exception;

	public abstract Location getById(int idModel)throws Exception;

	public abstract List<Location> getList()throws Exception;

}