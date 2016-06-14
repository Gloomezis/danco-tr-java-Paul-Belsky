package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IGroupDAO;
import com.danco.api.service.IGroupService;
import com.danco.model.Group;


	@Service
	public class GroupService implements IGroupService {

		private IGroupDAO dao;

		@Required
		@Autowired
		public void setDao(IGroupDAO dao) {
			this.dao = dao;
		}

		public GroupService() {
			System.out.println("Group service cereated");
		}

		/* (non-Javadoc)
		 * @see com.danco.service.IGroupService#create(com.danco.model.Group)
		 */
		@Override
		public void create(Group group)throws Exception {
			dao.create(group);
		}

		/* (non-Javadoc)
		 * @see com.danco.service.IGroupService#update(com.danco.model.Group)
		 */
		@Override
		@Transactional
		public void update(Group group)throws Exception {
			dao.update(group);
		}

		/* (non-Javadoc)
		 * @see com.danco.service.IGroupService#delete(com.danco.model.Group)
		 */
		@Override
		@Transactional
		public void delete(Group group) throws Exception{
			dao.delete(group);
		}

		/* (non-Javadoc)
		 * @see com.danco.service.IGroupService#getById(int)
		 */
		@Override
		@Transactional
		public Group getById(int idModel)throws Exception {
			return dao.getById(idModel);
		}

		/* (non-Javadoc)
		 * @see com.danco.service.IGroupService#getList()
		 */
		@Override
		@Transactional
		public List<Group> getList()throws Exception{
			return dao.getList();
		}

}
