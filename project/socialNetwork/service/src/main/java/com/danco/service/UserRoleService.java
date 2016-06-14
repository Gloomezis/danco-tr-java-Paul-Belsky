package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IUserRoleDAO;
import com.danco.api.service.IUserRoleService;
import com.danco.model.UserRole;

@Service
public class UserRoleService implements IUserRoleService {

	private IUserRoleDAO dao;

	@Required
	@Autowired
	public void setDao(IUserRoleDAO dao) {
		this.dao = dao;
	}

	public UserRoleService() {
		System.out.println("User role service created");
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IUserRoleService#create(com.danco.model.UserRole)
	 */
	@Override
	public void create(UserRole userRole)throws Exception{
		dao.create(userRole);
	}
	

	/* (non-Javadoc)
	 * @see com.danco.service.IUserRoleService#update(com.danco.model.UserRole)
	 */
	@Override
	@Transactional
	public void update(UserRole userRole) throws Exception{
		dao.update(userRole);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IUserRoleService#delete(com.danco.model.UserRole)
	 */
	@Override
	@Transactional
	public void delete(UserRole userRole)throws Exception {
		dao.delete(userRole);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IUserRoleService#getById(int)
	 */
	@Override
	@Transactional
	public UserRole getById(int idModel) throws Exception{
		return dao.getById(idModel);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IUserRoleService#getList()
	 */
	@Override
	@Transactional
	public List<UserRole> getList()throws Exception {
		return dao.getList();
	}


}
