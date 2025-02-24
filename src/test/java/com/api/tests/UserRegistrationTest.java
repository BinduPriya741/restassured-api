package com.api.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthenticationService;
import com.api.models.request.RegisterRequest;
import com.api.models.response.RegisterResponse;
import com.api.util.PropertiesUtils;

import io.restassured.response.Response;

public class UserRegistrationTest {

	Response response = null;
	
	@Test(description = "User registration")
	public void registerUserTest() {

		response = userResistration();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	public int getregisteredUserIdTest(){

		response = userResistration();
		RegisterResponse registerResponse = response.as(RegisterResponse.class);
		System.out.println("id::::" + registerResponse.getId());
		System.out.println("token::::" + registerResponse.getToken());

		return registerResponse.getId();
	}

	private Response userResistration(){
		
		try {
		PropertiesUtils.loadProperties("userData.properties");
		
		
		RegisterRequest registerRequest = new RegisterRequest.Builder().
																email(PropertiesUtils.getProString("register_user_email")).
																password(PropertiesUtils.getProString("register_user_pwd")).
																build();
		AuthenticationService authenticationService = new AuthenticationService();
		response = authenticationService.register(registerRequest);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Response::::" + response.asPrettyString());
		return response;
	
	}
}