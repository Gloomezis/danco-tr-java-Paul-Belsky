package com.danco.restcontroller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.danco.api.service.ICommentService;
import com.danco.model.Comment;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CommentController {

	@Autowired
	private ICommentService service;

	@Autowired
	private ObjectMapper mapper;

	public CommentController() {
		System.out.println("Created comment controller");
	}

	// TODO add pagination mb no pagination
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/posts/{postId}/comments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getCommentList(@PathVariable("postId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		List<Comment> responseEntity = service.getListByPostId(id);

		if (responseEntity.isEmpty()) {
			System.out.println("User with id " + id + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "Not found");
			return responseMap;
		}
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		responseMap.put("responseEntity", responseEntity);
		return responseMap;
	}
	
	//http://localhost:8080/restController/posts/3/commentspag?StartPostId=2&PageSize=3
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/posts/{postId}/commentspag", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getCommentListWithPagination(@PathVariable("postId") int id,@RequestParam(value="StartPostId",required=true) int startPostId ,@RequestParam(value="PageSize",required=true) int pageSize) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		List<Comment> responseEntity = service.getListByPostIdPagination(id,startPostId,pageSize);
		int entityCount= service.getCommentCountByPostId(id);
		int lastPageNumber = (int) ((entityCount / pageSize) + 1);

		if (responseEntity.isEmpty()) {
			System.out.println("User with id " + id + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "Not found");
			return responseMap;
		}
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		responseMap.put("responseEntity", responseEntity);
		responseMap.put("pageCount",lastPageNumber);
		return responseMap;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/posts/{postId}/comments/{commentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getComment(@PathVariable("commentId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		Comment responseEntity = service.getById(id);

		if (responseEntity == null) {
			System.out.println("Comment with id " + id + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "Not found");
			return responseMap;
		}
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		responseMap.put("comment", responseEntity);
		return responseMap;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/posts/{postId}/comments", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> createComment(
			@PathVariable("postId") int id, @RequestBody Comment comment) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			service.create(comment);
			responseMap.put("errorCode", 200);
			responseMap.put("errorMsg", "Ok");

			return responseMap;
		} catch (Exception e) {
			responseMap.put("errorCode", 409);
			responseMap.put("errorMsg", "Conflicted");
			return responseMap;
		}

	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/posts/{postId}/comments/{commentId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> updateComment(
			@PathVariable("postId") int postId,
			@PathVariable("commentId") int commentId,
			@RequestBody Comment comment) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println("Updating comment " + commentId);
		Comment currentComment = null;
		currentComment = service.getById(commentId);
		if (currentComment == null) {
			System.out.println("Comment with id " + commentId + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "not found");
			return responseMap;
		}
		currentComment = commentSetter(comment, currentComment);
		try {
			service.update(currentComment);
			responseMap.put("errorCode", 200);
			responseMap.put("errorMsg", "ok");
			return responseMap;
		} catch (Exception e) {
			responseMap.put("errorCode", 409);
			responseMap.put("errorMsg", "Conflicted");
			return responseMap;
		}

	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/posts/{postId}/comments/{commentId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> deleteComment(
			@PathVariable("postId") int postId,
			@PathVariable("commentId") int commentId) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println("Deleting comment id: " + commentId);
		Comment currentComment = null;
		currentComment = service.getById(commentId);
		if (currentComment == null) {
			System.out.println("Comment with id " + commentId + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "not found");
			return responseMap;
		}
		try {
			service.delete(currentComment);
			responseMap.put("errorCode", 200);
			responseMap.put("errorMsg", "ok");
			return responseMap;
		} catch (Exception e) {
			responseMap.put("errorCode", 409);
			responseMap.put("errorMsg", "Conflicted");
			return responseMap;
		}

	}

	private Comment commentSetter(Comment requestEntity, Comment updatedEntity) {
		Comment finallEntity = updatedEntity;
		finallEntity.setText(requestEntity.getText());
		return finallEntity;
	}

}
