package com.api.base;

import com.api.models.request.PutRequest;

import io.restassured.response.Response;

public class UserService extends BaseService{
	
	private static final String BASE_PATH ="/api/users/{id}";
	
	public Response getUser(int id) {
		return getRequest(BASE_PATH, id);
	}
	
	public Response putUser(PutRequest payload,int id) {
		return putRequest(payload,BASE_PATH,id);
	}
	
	public Response deleteUser(int id) {
		return deleteRequest(BASE_PATH,id);
	}

}
