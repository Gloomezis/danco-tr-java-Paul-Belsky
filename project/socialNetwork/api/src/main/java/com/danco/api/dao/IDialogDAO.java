package com.danco.api.dao;

import java.util.List;

import com.danco.model.Dialog;


public interface IDialogDAO extends IDAO<Dialog>{

	public List<Dialog> getListByGroupId(int id) throws Exception;


}