package com.danco.api.service;

import java.util.List;

import com.danco.model.DialogMessage;

public interface IDialogMessageService {

	public abstract void create(DialogMessage dialogMessage)throws Exception;

	public abstract void update(DialogMessage dialogMessage)throws Exception;

	public abstract void delete(DialogMessage dialogMessage)throws Exception;

	public abstract DialogMessage getById(int idModel)throws Exception;

	public abstract List<DialogMessage> getList()throws Exception;

}