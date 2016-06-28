package com.danco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.ICommentDAO;
import com.danco.api.service.ICommentService;
import com.danco.model.Comment;
import com.danco.model.User;

@Service
public class CommentService extends BaseService<Comment> implements
		ICommentService {

	@Autowired
	private ICommentDAO dao;

	public CommentService() {
		System.out.println("Comment service cereated");
	}

	@Override
	@Transactional(readOnly = true,rollbackFor=Exception.class)
	public List<Comment> getListByPostId(int id) {
		List<Comment> comments = null;
		try {
			comments = dao.getListByPostId(id);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return comments;
	}

	@Override
	@Transactional(readOnly = true,rollbackFor=Exception.class)
	public List<Comment> getListByPostIdPagination(int id, int startPostId,
			int pageSize) {
		List<Comment> comments = null;
		try {
			comments = dao.getListByPostIdPagination(id, startPostId, pageSize);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return comments;
	}

	@Transactional(readOnly = true,rollbackFor=Exception.class)
	@Override
	public int getCommentCountByPostId(int id) {

		int messageCount = 0;
		try {
			messageCount = dao.getmessageCountByPostId(id);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return messageCount;
	}

}
