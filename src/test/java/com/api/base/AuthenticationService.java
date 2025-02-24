package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.request.RegisterRequest;

import io.restassured.response.Response;

public class AuthenticationService extends BaseService{

	
	private static final String BASE_PATH ="/api";
	
	public Response login(LoginRequest payload) {
		return postRequest(payload, BASE_PATH+"/login");
	}
	
	public Response register(RegisterRequest payload) {
		return postRequest(payload, BASE_PATH+"/register");
	}
	
}
