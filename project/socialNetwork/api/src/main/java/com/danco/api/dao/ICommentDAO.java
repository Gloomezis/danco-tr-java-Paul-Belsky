package com.danco.api.dao;

import java.util.List;

import com.danco.model.Comment;



public interface ICommentDAO extends IDAO<Comment>{


	@Override
	public default void create(Comment comment) throws Exception{
		
		IDAO.super.create(comment);
	}

	@Override
	public default void delete(Comment comment)  throws Exception{
		
		IDAO.super.delete(comment);
	}

	@Override
	public default void update(Comment comment) throws Exception {
		
		IDAO.super.update(comment);
	}

	@Override
	public Comment getById(int IdComment) throws Exception;

	
	
	public List<Comment> getList() throws Exception;

	

	

}