package com.danco.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IDialogDAO;
import com.danco.api.exception.MessageException;
import com.danco.api.exception.MyException;
import com.danco.api.service.IDialogService;
import com.danco.model.Dialog;


/**
 * The Class DialogService.
 */
@Service
public class DialogService extends BaseService<Dialog> implements
		IDialogService {
	
	/** The Constant RESPONSE_ENTITY. */
	private static final String RESPONSE_ENTITY = "responseEntity";
	
	/** The Constant COUNT2. */
	private static final String COUNT2 = "count";
	
	/** The Constant DIALOG_SERVICE_CEREATED. */
	private static final String DIALOG_SERVICE_CEREATED = "Dialog service cereated";
	
	/** The dao. */
	@Autowired
	private IDialogDAO dao;

	/**
	 * Instantiates a new dialog service.
	 */
	public DialogService() {
		System.out.println(DIALOG_SERVICE_CEREATED);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IDialogService#getDialogsCountByGroupId(int)
	 */
	@Override
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	public int getDialogsCountByGroupId(int id) throws MyException {
		int dialogsCount = 0;
		dialogsCount = dao.getDialogsCountByGroupId(id);
		return dialogsCount;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IDialogService#getListByGroupId(int, int, int)
	 */
	@Override
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	public HashMap<String, Object> getListByGroupId(int id, int startDialogId,
			int pageSize) throws MyException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		List<Dialog> dialogs = null;
		int count = getDialogsCountByGroupId(id);
		if (count == 0) {
			return res;
		} else {
			dialogs = dao.getListByGroupId(id, startDialogId, pageSize);
			if (dialogs.isEmpty()) {
				throw new MyException(MessageException.ITS_ALL);
			} else {
				res.put(COUNT2, count);
				res.put(RESPONSE_ENTITY, dialogs);
			}
		}
		return res;
	}

}
