package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.IPostDAO;
import com.danco.api.service.IPostService;
import com.danco.model.Comment;
import com.danco.model.Post;

@Service
public class PostService extends BaseService<Post> implements IPostService {
	
	@Autowired
	private IPostDAO dao;

	

	public PostService() {
		System.out.println("Post service created");
	}


    @Transactional(rollbackFor=Exception.class)
	@Override
	public List<Post> getListByUserId(int id,int startPostId,int pageSize) {
		List<Post> posts = null;
		try {
			posts=dao.getListByUserId(id,startPostId,pageSize);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return  posts;
	}

    @Transactional(readOnly = true,rollbackFor=Exception.class)
	@Override
	public int getPostCountByUserId(int id) {
		int postsCount = 0;
		try {
			postsCount= dao.getPostCountByUserId(id);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return postsCount;
	}
	
	
	
	
	
	
	
	
	

	
}
