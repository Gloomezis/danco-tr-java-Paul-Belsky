package com.danco.api.service;

import java.util.List;

import com.danco.model.Post;

public interface IPostService extends IService<Post>{

	
	public List<Post> getListByUserId(int id, int startPostId, int pageSize);

	public int getPostCountByUserId(int id);



}