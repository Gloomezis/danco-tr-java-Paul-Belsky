package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;








import com.danco.api.dao.IUserDetailsDAO;
import com.danco.api.service.IUserDetailsService;
import com.danco.model.UserDetails;

@Service
public class UserDetailsService implements IUserDetailsService {

	private IUserDetailsDAO dao;

	@Required
	@Autowired
	public void setDao(IUserDetailsDAO dao) {
		this.dao = dao;
	}

	public UserDetailsService() {
		System.out.println("User detail service created");
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IUserDetailsService#create(com.danco.model.UserDetails)
	 */
	@Override
	public void create(UserDetails userDetails)throws Exception{
		dao.create(userDetails);
	}
	

	/* (non-Javadoc)
	 * @see com.danco.service.IUserDetailsService#update(com.danco.model.UserDetails)
	 */
	@Override
	@Transactional
	public void update(UserDetails userDetails) throws Exception{
		dao.update(userDetails);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IUserDetailsService#delete(com.danco.model.UserDetails)
	 */
	@Override
	@Transactional
	public void delete(UserDetails userDetails) throws Exception{
		dao.delete(userDetails);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IUserDetailsService#getById(int)
	 */
	@Override
	@Transactional
	public UserDetails getById(int idModel)throws Exception {
		return dao.getById(idModel);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IUserDetailsService#getList()
	 */
	@Override
	@Transactional
	public List<UserDetails> getList()throws Exception {
		return dao.getList();
	}

}
