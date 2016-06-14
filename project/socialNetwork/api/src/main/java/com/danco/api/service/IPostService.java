package com.danco.api.service;

import java.util.List;

import com.danco.model.Post;

public interface IPostService {

	public abstract void create(Post post)throws Exception;

	public abstract void update(Post post)throws Exception;

	public abstract void delete(Post post)throws Exception;

	public abstract Post getById(int idModel)throws Exception;

	public abstract List<Post> getList()throws Exception;

}