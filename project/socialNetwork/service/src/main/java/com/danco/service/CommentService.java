package com.danco.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.api.dao.ICommentDAO;
import com.danco.api.service.ICommentService;
import com.danco.api.exception.MessageException;
import com.danco.api.exception.MyException;
import com.danco.model.Comment;


/**
 * The Class CommentService.
 */
@Service
public class CommentService extends BaseService<Comment> implements
		ICommentService {

	/** The Constant RESPONSE_ENTITY. */
	private static final String RESPONSE_ENTITY = "responseEntity";
	
	/** The Constant COUNT. */
	private static final String COUNT = "count";
	
	/** The Constant COMMENT_SERVICE_CEREATED. */
	private static final String COMMENT_SERVICE_CEREATED = "Comment service cereated";
	
	/** The dao. */
	@Autowired
	private ICommentDAO dao;

	/**
	 * Instantiates a new comment service.
	 */
	public CommentService() {
		System.out.println(COMMENT_SERVICE_CEREATED);
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.ICommentService#getCommentCountByPostId(int)
	 */
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	@Override
	public int getCommentCountByPostId(int id) throws MyException {
		int commentCount = 0;
		commentCount = dao.getmessageCountByPostId(id);
		return commentCount;
	}

	/* (non-Javadoc)
	 * @see com.danco.api.service.ICommentService#getListByPostIdPagination(int, int, int)
	 */
	@Override
	@Transactional(readOnly = true, rollbackFor = MyException.class)
	public HashMap<String, Object> getListByPostIdPagination(int id,
			int startPostId, int pageSize) throws MyException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		List<Comment> comments = null;
		int commentCount = getCommentCountByPostId(id);
		if (commentCount == 0) {
			return res;
		} else {
			comments = dao.getListByPostIdPagination(id, startPostId, pageSize);
			if (comments.isEmpty()) {
				throw new MyException(MessageException.ITS_ALL);
			} else {
				res.put(COUNT, commentCount);
				res.put(RESPONSE_ENTITY, comments);
			}
		}
		return res;
	}

}
