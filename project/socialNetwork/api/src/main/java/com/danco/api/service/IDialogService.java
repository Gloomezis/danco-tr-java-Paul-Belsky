package com.danco.api.service;

import java.util.List;

import com.danco.model.Dialog;

public interface IDialogService {

	public abstract void create(Dialog dialog)throws Exception;

	public abstract void update(Dialog dialog)throws Exception;

	public abstract void delete(Dialog dialog)throws Exception;

	public abstract Dialog getById(int idModel)throws Exception;

	public abstract List<Dialog> getList()throws Exception;

}