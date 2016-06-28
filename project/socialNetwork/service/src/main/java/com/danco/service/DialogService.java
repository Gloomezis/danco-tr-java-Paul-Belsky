package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IDialogDAO;
import com.danco.api.service.IDialogService;
import com.danco.model.Comment;
import com.danco.model.Dialog;

@Service
public class DialogService extends BaseService<Dialog> implements IDialogService {
	@Autowired
	private IDialogDAO dao;


	public DialogService() {
		System.out.println("Dialog service cereated");
	}


	@Override
	@Transactional (readOnly = true,rollbackFor=Exception.class)
	public List<Dialog> getListByGroupId(int id)  {
		List<Dialog> dialogs = null;
		try {
			dialogs=dao.getListByGroupId(id);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return  dialogs;
	}


	

	
}
