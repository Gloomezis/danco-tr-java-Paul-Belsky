package com.danco.model;

import java.io.Serializable;

public class BaseModel implements IBaseModel, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	public BaseModel() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.model.IBase#getId()
	 */
	@Override
	public int getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.model.IBase#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {

		if (id == 0) {
			return super.hashCode();
		} else {
			return 555 * this.getId();
		}

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BaseModel && id != 0) {
			return this.getId() == ((BaseModel) obj).getId();
		}
		return super.equals(obj);
	}

	

}
