package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IDAO;
import com.danco.model.BaseModel;

@Repository
public abstract class BaseDAO <T extends BaseModel> implements IDAO<T> {
	
	
	private Class<T> clazz;
	 
	@Autowired 
	 protected SessionFactory sf;

	   

	   public BaseDAO(Class<T> clazz) {
	    	  this.clazz = clazz;
	    	 }

	    	 protected Criteria getCriteria (){
	    	  return sf.getCurrentSession().createCriteria(clazz);
	    	 }
	    
	    
	
	public void create(T model)throws Exception {
		sf.getCurrentSession().save(model);
	}
	
	public void update(T model)throws Exception {
		sf.getCurrentSession().update(model);
	}
	
	public void delete(T model)throws Exception {
		sf.getCurrentSession().delete(model);
	}	
	@Override
	@SuppressWarnings("unchecked")
	public T getById(int idModel)throws Exception {
		return (T)sf.getCurrentSession().get(clazz,idModel);
	} 
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> getList() throws Exception{
		Criteria criteria = getCriteria();
		return criteria.list();
	} 
	

 }
