package com.danco.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IDialogMessageDAO;
import com.danco.api.exception.MessageException;
import com.danco.api.exception.MyException;
import com.danco.api.service.IDialogMessageService;
import com.danco.model.DialogMessage;


/**
 * The Class DialogMessageService.
 */
@Service
public class DialogMessageService extends BaseService<DialogMessage> implements
		IDialogMessageService {
	
	/** The Constant RESPONSE_ENTITY. */
	private static final String RESPONSE_ENTITY = "responseEntity";
	
	/** The Constant COUNT2. */
	private static final String COUNT2 = "count";
	
	/** The Constant DIALOG_MESSAGE_SERVICE_CEREATED. */
	private static final String DIALOG_MESSAGE_SERVICE_CEREATED = "Dialog message service cereated";
	
	/** The dao. */
	@Autowired
	private IDialogMessageDAO dao;

	/**
	 * Instantiates a new dialog message service.
	 */
	public DialogMessageService() {
		System.out.println(DIALOG_MESSAGE_SERVICE_CEREATED);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IDialogMessageService#getDialogMessagesCountByDialogId(int)
	 */
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	public int getDialogMessagesCountByDialogId(int id) throws MyException {
		int dialogMessageCount = 0;
		dialogMessageCount = dao.getDialogMessagesCountByDialogId(id);
		return dialogMessageCount;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IDialogMessageService#getListByDialogId(int, int, int)
	 */
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	@Override
	public HashMap<String, Object> getListByDialogId(int id,
			int startDialogMessageId, int pageSize) throws MyException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		List<DialogMessage> dialogMessages = null;

		int count = getDialogMessagesCountByDialogId(id);
		if (count == 0) {
			return res;
		} else {
			dialogMessages = dao.getListByDialogId(id, startDialogMessageId,
					pageSize);
			if (dialogMessages.isEmpty()) {
				throw new MyException(MessageException.ITS_ALL);

			} else {
				res.put(COUNT2, count);
				res.put(RESPONSE_ENTITY, dialogMessages);
			}
		}
		return res;
	}

}
