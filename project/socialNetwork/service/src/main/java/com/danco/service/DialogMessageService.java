package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IDialogMessageDAO;
import com.danco.api.service.IDialogMessageService;
import com.danco.model.Dialog;
import com.danco.model.DialogMessage;

@Service
public class DialogMessageService extends BaseService<DialogMessage> implements IDialogMessageService {
	@Autowired
	private IDialogMessageDAO dao;


	public DialogMessageService() {
		System.out.println("Dialog message service cereated");
	}

	@Transactional (readOnly = true,rollbackFor=Exception.class)
	@Override
	public List<DialogMessage> getListByDialogId(int id) {
		
			List<DialogMessage> dialogMessages = null;
			try {
				dialogMessages =dao.getListByDialogId(id);
				
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
			return  dialogMessages;
		}
	}

	

