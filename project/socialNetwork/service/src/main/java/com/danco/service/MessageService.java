package com.danco.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IMessageDAO;
import com.danco.api.exception.MessageException;
import com.danco.api.exception.MyException;
import com.danco.api.service.IMessageService;
import com.danco.model.Message;


/**
 * The Class MessageService.
 */
@Service
public class MessageService extends BaseService<Message> implements
		IMessageService {

	/** The Constant RESPONSE_ENTITY. */
	private static final String RESPONSE_ENTITY = "responseEntity";
	
	/** The Constant MESSAGE_SERVICE_CREATED. */
	private static final String MESSAGE_SERVICE_CREATED = "Message service created";
	
	/** The dao. */
	@Autowired
	private IMessageDAO dao;

	/**
	 * Instantiates a new message service.
	 */
	public MessageService() {
		System.out.println(MESSAGE_SERVICE_CREATED);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IMessageService#getListByUserId(int, int, int)
	 */
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	@Override
	public HashMap<String, Object> getListByUserId(int myId,
			int startMessageId, int pageSize) throws MyException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		List<Message> messages = null;
		messages = dao.getListByUserId(myId, startMessageId, pageSize);
		if (messages.isEmpty()) {
			throw new MyException(MessageException.ITS_ALL);
		} else {
			res.put(RESPONSE_ENTITY, messages);
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.IMessageService#getListPrivateMessage(int, int, int, int)
	 */
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	@Override
	public HashMap<String, Object> getListPrivateMessage(int myId, int userId,
			int startMessageId, int pageSize) throws MyException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		List<Message> messages = null;
		messages = dao.getListPrivateMessage(myId, userId, startMessageId,
				pageSize);
		if (messages.isEmpty()) {
			throw new MyException(MessageException.ITS_ALL);
		} else {
			res.put(RESPONSE_ENTITY, messages);
		}
		return res;
	}

}
