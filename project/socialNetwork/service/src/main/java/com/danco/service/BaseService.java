package com.danco.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IDAO;
import com.danco.api.service.IService;
import com.danco.model.BaseModel;


	@Service
	public abstract class BaseService <T extends BaseModel> implements IService<T>{
		
		protected static final Logger LOGGER = LogManager.getLogger(BaseService.class);
		
		@Autowired
		private IDAO<T> dao;

		
		
		@Override
		@Transactional(rollbackFor=Exception.class)
		public void create(T model) throws Exception{
			try {
				dao.create(model);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				throw new Exception("not created");
			}		
		}

		@Override
		@Transactional(rollbackFor=Exception.class)
		public void update(T model) throws Exception{
			try {
				dao.update(model);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				throw new Exception("not updated");
			}
			
		}

		@Override
		@Transactional(rollbackFor=Exception.class)
		public void delete(T model) throws Exception{
			try {
				dao.delete(model);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				throw new Exception("not deleted");
			}
			
		}

		@Override
		@Transactional(readOnly = true,rollbackFor=Exception.class)
		public T getById(int idModel) {
			T model = null;
			try {
				model = dao.getById(idModel);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
			return model;
		}

		@Override
		@Transactional(readOnly = true,rollbackFor=Exception.class)
	   public List<T> getList() {
			List<T> list = null;
			try {
				list = dao.getList();
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
			return list;
		} 
}
