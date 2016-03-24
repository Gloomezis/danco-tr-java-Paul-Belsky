package com.danco.model;

import java.io.Serializable;

public class BaseModel implements IBaseModel ,Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private int id;
	
	public BaseModel() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 
	
	
	
	
	
}
