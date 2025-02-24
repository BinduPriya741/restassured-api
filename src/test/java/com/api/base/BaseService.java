package com.api.base;

import static io.restassured.RestAssured.given;

import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//This acts as a Wrapper class for RestAssured methods
public class BaseService {

	private static final String BASE_URI = "https://reqres.in";
	private RequestSpecification requestSpecification;
	
	//we want it to execute only once.
	static {
		RestAssured.filters(new LoggingFilter());
	}
	
	public BaseService() {
		requestSpecification = given().baseUri(BASE_URI);
	} 
	
	//To make this method loosely coupled, change payload type from LoginRequest to Object 
	protected Response postRequest(Object payload, String endpoint) {
		
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
		
	}
	
	protected Response getRequest(String endpoint,int id) {
		
		return requestSpecification.pathParam("id",id ).get(endpoint,id);   
		
	}
	
	protected Response putRequest(Object payload, String endpoint,int id) {
		
		return requestSpecification.pathParam("id",id )
				.contentType(ContentType.JSON).body(payload).put(endpoint);
		
	}
	
	protected Response deleteRequest(String endpoint,int id) {
		return requestSpecification.pathParam("id", id).delete(endpoint,id);
		
	}
	
}
