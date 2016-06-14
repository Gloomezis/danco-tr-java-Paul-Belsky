package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IMessageDAO;
import com.danco.api.service.IMessageService;
import com.danco.model.Message;

@Service
public class MessageService implements IMessageService {

	private IMessageDAO dao;

	@Required
	@Autowired
	public void setDao(IMessageDAO dao) {
		this.dao = dao;
	}

	public MessageService() {
		System.out.println("Message service created");
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IMessageService#create(com.danco.model.Message)
	 */
	@Override
	public void create(Message message)throws Exception {
		dao.create(message);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IMessageService#update(com.danco.model.Message)
	 */
	@Override
	@Transactional
	public void update(Message message)throws Exception {
		dao.update(message);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IMessageService#delete(com.danco.model.Message)
	 */
	@Override
	@Transactional
	public void delete(Message message)throws Exception {
		dao.delete(message);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IMessageService#getById(int)
	 */
	@Override
	@Transactional
	public Message getById(int idModel) throws Exception{
		return dao.getById(idModel);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IMessageService#getList()
	 */
	@Override
	@Transactional
	public List<Message> getList() throws Exception{
		return dao.getList();
	}
}
