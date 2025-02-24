package com.api.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.UserService;

import io.restassured.response.Response;

public class UserDetailsTest {
	
	@Test
	public void getUserDetailsByIdTest(){
		
	UserService userService = new UserService();
	UserRegistrationTest userRegistrationTest = new UserRegistrationTest();
	int id = userRegistrationTest.getregisteredUserIdTest();
	System.out.println("id:::::"+id);
	Response response = userService.getUser(id);
	
	Map userResponseMap = response.as(Map.class);
	System.out.println("userResponseMap"+userResponseMap);
	
	System.out.println(userResponseMap.get("data"));
	Map userMap = (Map) userResponseMap.get("data");
	
	System.out.println("iddddddd"+userMap.get("id"));
	Assert.assertEquals(userMap.get("id"),id);
	
	/*ObjectMapper mapper = new ObjectMapper();
	//mapper.configure(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION);
	
	System.out.println("responseStrings"+response.asString());
	try {
		String testString = "{\n"
				+ "   \"data\":{\n"
				+ "      \"id\":4,\n"
				+ "      \"email\":\"eve.holt@reqres.in\",\n"
				+ "      \"first_name\":\"Eve\",\n"
				+ "      \"last_name\":\"Holt\",\n"
				+ "      \"avatar\":\"\"\n"
				+ "   }\n"
				+ "}";
		JsonNode root = mapper.readTree(testString);
		System.out.println("--------"+root.asText());
		String userResponseString = root.get("data").asText();
		System.out.println("userResponseString-------"+userResponseString);
		UserResponse userResponse = mapper.readValue(userResponseString, UserResponse.class);
		userResponse.getId();
		System.out.println(userResponse.getId());
		System.out.println(userResponse.getEmail());
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	
	*/
	
	
	}
}
