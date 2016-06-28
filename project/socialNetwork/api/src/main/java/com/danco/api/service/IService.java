package com.danco.api.service;

import java.util.List;

import com.danco.model.BaseModel;

public interface IService  <T extends BaseModel>{
		
		public void create(T model) throws Exception;

		public void update(T model) throws Exception;

		public void delete(T model) throws Exception;

		public T getById(int idModel) ;

		public List<T> getList(); 
	
	
	
}
