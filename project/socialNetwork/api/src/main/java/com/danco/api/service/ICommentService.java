package com.danco.api.service;

import java.util.List;

import com.danco.model.Comment;

public interface ICommentService {

	public abstract void create(Comment comment)throws Exception;

	public abstract void update(Comment comment)throws Exception;

	public abstract void delete(Comment comment)throws Exception;

	public abstract Comment getById(int idModel)throws Exception;

	public abstract List<Comment> getList()throws Exception;

}