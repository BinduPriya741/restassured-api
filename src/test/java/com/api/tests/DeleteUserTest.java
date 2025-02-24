package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.UserService;

import io.restassured.response.Response;

public class DeleteUserTest {

	
	@Test(description = "Verify Delete User API")
	public void deleteUserTest() {
	
		
		UserRegistrationTest userRegistrationTest = new UserRegistrationTest();
		int id = userRegistrationTest.getregisteredUserIdTest();
		System.out.println("id:::::"+id);
		
		UserService userService = new UserService();
		Response response=userService.deleteUser(id);
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 204);
		
		
	}
}
