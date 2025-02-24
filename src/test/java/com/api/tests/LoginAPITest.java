package com.api.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthenticationService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.util.PropertiesUtils;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class) 
public class LoginAPITest {
	
	@Test(description = "verify Post API is working")
	public void loginTest() {
		try {
		PropertiesUtils.loadProperties("userData.properties");
		LoginRequest loginRequest = new LoginRequest(PropertiesUtils.getProString("login_user_email"),PropertiesUtils.getProString("login_user_pwd"));
		AuthenticationService authService = new AuthenticationService();
		Response response = authService.login(loginRequest);
		//here the response is coming in JSON format. To extract values we need to convert it into java object. Deserialization
		LoginResponse loginRresponse = response.as(LoginResponse.class); 
		System.out.println("Resonse::"+response.asString() );
		System.out.println("Login Response:::"+loginRresponse.getToken());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertNotNull(loginRresponse.getToken());
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
