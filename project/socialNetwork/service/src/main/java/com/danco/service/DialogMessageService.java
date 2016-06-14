package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IDialogMessageDAO;
import com.danco.api.service.IDialogMessageService;
import com.danco.model.DialogMessage;

@Service
public class DialogMessageService implements IDialogMessageService {

	private IDialogMessageDAO dao;

	@Required
	@Autowired
	public void setDao(IDialogMessageDAO dao) {
		this.dao = dao;
	}

	public DialogMessageService() {
		System.out.println("Dialog message service cereated");
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IDialogMessageService#create(com.danco.model.DialogMessage)
	 */
	@Override
	public void create(DialogMessage dialogMessage) throws Exception{
		dao.create(dialogMessage);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IDialogMessageService#update(com.danco.model.DialogMessage)
	 */
	@Override
	@Transactional
	public void update(DialogMessage dialogMessage)throws Exception {
		dao.update(dialogMessage);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IDialogMessageService#delete(com.danco.model.DialogMessage)
	 */
	@Override
	@Transactional
	public void delete(DialogMessage dialogMessage)throws Exception {
		dao.delete(dialogMessage);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IDialogMessageService#getById(int)
	 */
	@Override
	@Transactional
	public DialogMessage getById(int idModel)throws Exception {
		return dao.getById(idModel);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IDialogMessageService#getList()
	 */
	@Override
	@Transactional
	public List<DialogMessage> getList() throws Exception{
		return dao.getList();
	}
}
