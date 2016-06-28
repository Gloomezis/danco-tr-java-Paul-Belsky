package com.danco.api.service;

import java.util.List;

import com.danco.model.Comment;

public interface ICommentService extends IService<Comment>{

	public abstract List<Comment> getListByPostId(int id) ;

	public abstract List<Comment> getListByPostIdPagination(int id,
			int startPostId, int pageSize);

	public abstract int getCommentCountByPostId(int id);

}