package com.danco.api.dao;

import java.util.List;








import com.danco.model.Post;


public interface IPostDAO extends IDAO<Post>{


	@Override
	public default void create(Post post) throws Exception{
		
		IDAO.super.create(post);
	}

	@Override
	public default void delete(Post post) throws Exception {
		
		IDAO.super.delete(post);
	}

	@Override
	public default void update(Post post) throws Exception {
		
		IDAO.super.update(post);
	}

	@Override
	public Post getById(int idPost) throws Exception;

	
	
	public List<Post> getList()throws Exception;


}