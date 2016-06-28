package com.danco.api.dao;

import java.util.List;

import com.danco.model.Comment;



public interface ICommentDAO extends IDAO<Comment>{

	public List<Comment> getListByPostId(int id) throws Exception;

	

	public List<Comment> getListByPostIdPagination(int id, int startPostId,
			int pageSize)throws Exception;




	public int getmessageCountByPostId(int id) throws Exception;


}