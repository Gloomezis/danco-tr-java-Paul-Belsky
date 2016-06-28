package com.danco.api.service;

import java.util.List;

import com.danco.model.DialogMessage;

public interface IDialogMessageService extends IService<DialogMessage>{

	public List<DialogMessage> getListByDialogId(int id);

	

}