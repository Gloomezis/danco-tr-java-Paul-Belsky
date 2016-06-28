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

import com.danco.api.service.IPostService;
import com.danco.model.Post;

@RestController
public class PostController {

	@Autowired
	private IPostService service;

	public PostController() {
		System.out.println("Created post controller");
	}

	// get getPosts: /me/feed?StartPostId=' + lastPostId + '&PageSize=' +
	// pageSize;

	// get getUserPosts: '/users/' + username + '/wall?StartPostId=' +
	// lastPostId + '&PageSize=' + pageSize;

	
	

	// TODO write pagination and gett my info to getList(myId)
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/me/feed", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getMyPostList(@RequestParam(value="StartPostId") int startPostId,@RequestParam(value="PageSize") int pageSize)  {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		int myId=1;
		int entityCount= service.getPostCountByUserId(myId);
		
		List<Post> responseEntity = service.getListByUserId(myId,startPostId,pageSize);

		if (responseEntity == null) {
			System.out.println("My posts  not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "Not found");
			return responseMap;
		}
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		responseMap.put("pageCount",(entityCount/pageSize)+1);
		responseMap.put("responseEntity", responseEntity);
		return responseMap;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/users/{userId}/wall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getUserPostList(@PathVariable("userId") int id,
			@RequestParam(value="StartPostId",required=false) int startPostId ,@RequestParam(value="PageSize",required=false) int pageSize	)  {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		int entityCount= service.getPostCountByUserId(id);
		int lastPageNumber = (int) ((entityCount / pageSize) + 1);
		List<Post> responseEntity = service.getListByUserId(id,startPostId,pageSize);

		if (responseEntity==null) {
			System.out.println("List post user: " + id + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "Not found");
			responseMap.put("pageCount",lastPageNumber);
			return responseMap;
	}
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		responseMap.put("pageCount",lastPageNumber);
		responseMap.put("responseEntity", responseEntity);
		return responseMap;
	}

	// TODO write method to get post of all my friend ordering by time creation
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/events", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getEventAllPostList()  {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		List<Post> responseEntity = service.getList();

		if (responseEntity == null) {
			System.out.println("My posts  not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "Not found");
			return responseMap;
		}
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		responseMap.put("responseEntity", responseEntity);
		return responseMap;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/posts/{postId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> getPost(@PathVariable("postId") int id)
			 {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		Post responseEntity = service.getById(id);

		if (responseEntity == null) {
			System.out.println("Post with id " + id + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "Not found");
			return responseMap;
		}
		responseMap.put("errorCode", 200);
		responseMap.put("errorMsg", "Ok");
		responseMap.put("responseEntity", responseEntity);
		return responseMap;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/posts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> createPost(@RequestBody Post requestEntity) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		try {
			service.create(requestEntity);
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
	@RequestMapping(value = "/posts/{postId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> updatePost(@PathVariable("postId") int id,
			@RequestBody Post requestEntity) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println("Updating post " + id);
		Post currentEntity = null;
		currentEntity = service.getById(id);
		if (currentEntity == null) {
			System.out.println("Post with id " + id + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "not found");
			return responseMap;
		}
		currentEntity = entitySetter(requestEntity, currentEntity);
		try {
			service.update(currentEntity);
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
	@RequestMapping(value = "/posts/{postId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, Object> deletePost(@PathVariable("postId") int id) {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println("Deleting post id: " + id);
		Post currentEntity = null;
		currentEntity = service.getById(id);
		if (currentEntity == null) {
			System.out.println("Comment with id " + id + " not found");
			responseMap.put("errorCode", 404);
			responseMap.put("errorMsg", "not found");
			return responseMap;
		}
		try {
			service.delete(currentEntity);
			responseMap.put("errorCode", 200);
			responseMap.put("errorMsg", "ok");
			return responseMap;
		} catch (Exception e) {
			responseMap.put("errorCode", 409);
			responseMap.put("errorMsg", "Conflicted");
			return responseMap;
		}

	}

	private Post entitySetter(Post requestEntity, Post updatedEntity) {
		Post finallEntity = updatedEntity;
		finallEntity.setText(requestEntity.getText());
		return finallEntity;
	}

}
