package com.danco.api.service;

import java.util.List;

import com.danco.model.Dialog;

public interface IDialogService extends IService<Dialog>{

	

	public List<Dialog> getListByGroupId(int id);


}