package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IDialogDAO;
import com.danco.api.service.IDialogService;
import com.danco.model.Dialog;

@Service
public class DialogService implements IDialogService {

	private IDialogDAO dao;

	@Required
	@Autowired
	public void setDao(IDialogDAO dao) {
		this.dao = dao;
	}

	public DialogService() {
		System.out.println("Dialog service cereated");
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IDialogService#create(com.danco.model.Dialog)
	 */
	@Override
	public void create(Dialog dialog)throws Exception {
		dao.create(dialog);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IDialogService#update(com.danco.model.Dialog)
	 */
	@Override
	@Transactional
	public void update(Dialog dialog)throws Exception {
		dao.update(dialog);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IDialogService#delete(com.danco.model.Dialog)
	 */
	@Override
	@Transactional
	public void delete(Dialog dialog) throws Exception{
		dao.delete(dialog);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IDialogService#getById(int)
	 */
	@Override
	@Transactional
	public Dialog getById(int idModel) throws Exception{
		return dao.getById(idModel);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IDialogService#getList()
	 */
	@Override
	@Transactional
	public List<Dialog> getList() throws Exception{
		return dao.getList();
	}
}
