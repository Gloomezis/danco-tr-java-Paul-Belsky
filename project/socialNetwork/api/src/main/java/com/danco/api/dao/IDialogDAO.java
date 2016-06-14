package com.danco.api.dao;

import java.util.List;








import com.danco.model.Dialog;


public interface IDialogDAO extends IDAO<Dialog>{


	@Override
	public default void create(Dialog dialog)throws Exception {
		
		IDAO.super.create(dialog);
	}

	@Override
	public default void delete(Dialog dialog)  throws Exception{
		
		IDAO.super.delete(dialog);
	}

	@Override
	public default void update(Dialog dialog) throws Exception {
		
		IDAO.super.update(dialog);
	}

	@Override
	public Dialog getById(int idDialog)throws Exception ;

	
	
	public List<Dialog> getList() throws Exception;

	

	

}