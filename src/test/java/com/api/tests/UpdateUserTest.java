package com.api.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.UserService;
import com.api.models.request.PutRequest;
import com.api.models.response.PutResponse;
import com.api.util.PropertiesUtils;

import io.restassured.response.Response;

public class UpdateUserTest {
	
	
	
	@Test(description = "Verify update user - Put API")
	public void putUserTest() { 
	UserService userService = new UserService();
	UserRegistrationTest userRegistrationTest = new UserRegistrationTest();
	int id = userRegistrationTest.getregisteredUserIdTest();
	System.out.println("id:::::"+id);
	try {
	PropertiesUtils.loadProperties("userData.properties");

	PutRequest putRequest = new PutRequest(PropertiesUtils.getProString("update_user_name"),PropertiesUtils.getProString("update_user_job"));
	Response response = userService.putUser(putRequest, id);
	System.out.println(response.statusCode());
	Assert.assertEquals(response.statusCode(), 200);
	PutResponse putResponse =response.as(PutResponse.class);
	putResponse.getJob();
	System.out.println("putResponse.getJob()____"+putResponse.getJob());
	Assert.assertEquals(putResponse.getJob(), "zion resident");
	Assert.assertNotNull(putResponse.getUpdatedAt());
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
}
