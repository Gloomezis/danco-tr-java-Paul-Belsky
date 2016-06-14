package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.ICommentDAO;
import com.danco.api.service.ICommentService;
import com.danco.model.Comment;

@Service
public class CommentService implements ICommentService {

	private ICommentDAO dao;

	@Required
	@Autowired
	public void setDao(ICommentDAO dao) {
		this.dao = dao;
	}

	public CommentService() {
		System.out.println("Comment service cereated");
	}

	/* (non-Javadoc)
	 * @see com.danco.service.ICommentService#create(com.danco.model.Comment)
	 */
	@Override
	public void create(Comment comment)throws Exception {
		dao.create(comment);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.ICommentService#update(com.danco.model.Comment)
	 */
	@Override
	@Transactional
	public void update(Comment comment) throws Exception{
		dao.update(comment);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.ICommentService#delete(com.danco.model.Comment)
	 */
	@Override
	@Transactional
	public void delete(Comment comment)throws Exception {
		dao.delete(comment);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.ICommentService#getById(int)
	 */
	@Override
	@Transactional
	public Comment getById(int idModel) throws Exception{
		return dao.getById(idModel);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.ICommentService#getList()
	 */
	@Override
	@Transactional
	public List<Comment> getList() throws Exception{
		return dao.getList();
	}

}
