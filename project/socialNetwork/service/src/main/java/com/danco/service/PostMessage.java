package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IPostDAO;
import com.danco.api.service.IPostService;
import com.danco.model.Post;

@Service
public class PostMessage implements IPostService {

	private IPostDAO dao;

	@Required
	@Autowired
	public void setDao(IPostDAO dao) {
		this.dao = dao;
	}

	public PostMessage() {
		System.out.println("Post service created");
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IPostService#create(com.danco.model.Post)
	 */
	@Override
	public void create(Post post)throws Exception{
		dao.create(post);
	}
	

	/* (non-Javadoc)
	 * @see com.danco.service.IPostService#update(com.danco.model.Post)
	 */
	@Override
	@Transactional
	public void update(Post post) throws Exception{
		dao.update(post);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IPostService#delete(com.danco.model.Post)
	 */
	@Override
	@Transactional
	public void delete(Post post)throws Exception {
		dao.delete(post);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IPostService#getById(int)
	 */
	@Override
	@Transactional
	public Post getById(int idModel)throws Exception {
		return dao.getById(idModel);
	}

	/* (non-Javadoc)
	 * @see com.danco.service.IPostService#getList()
	 */
	@Override
	@Transactional
	public List<Post> getList() throws Exception{
		return dao.getList();
	}
}
