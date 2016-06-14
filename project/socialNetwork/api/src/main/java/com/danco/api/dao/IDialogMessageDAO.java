package com.danco.api.dao;

import java.util.List;








import com.danco.model.DialogMessage;


public interface IDialogMessageDAO extends IDAO<DialogMessage>{


	@Override
	public default void create(DialogMessage dialogMessage) throws Exception{
		
		IDAO.super.create(dialogMessage);
	}

	@Override
	public default void delete(DialogMessage dialogMessage)  throws Exception{
		
		IDAO.super.delete(dialogMessage);
	}

	@Override
	public default void update(DialogMessage dialogMessage) throws Exception {
		
		IDAO.super.update(dialogMessage);
	}

	@Override
	public DialogMessage getById(int idDialogMessage)throws Exception ;

	
	
	public List<DialogMessage> getList()throws Exception;

	

	

}