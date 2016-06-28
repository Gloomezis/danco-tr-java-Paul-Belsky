package com.danco.api.dao;

import java.util.List;

import com.danco.model.DialogMessage;


public interface IDialogMessageDAO extends IDAO<DialogMessage>{

	public List<DialogMessage> getListByDialogId(int id) throws Exception;



}