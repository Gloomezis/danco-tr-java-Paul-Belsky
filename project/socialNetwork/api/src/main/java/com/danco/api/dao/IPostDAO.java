package com.danco.api.dao;

import java.util.List;

import com.danco.model.Post;


public interface IPostDAO extends IDAO<Post>{

	public List<Post> getListByUserId(int id, int startPostId, int pageSize) throws Exception;

	public int getPostCountByUserId(int id) throws Exception;



}