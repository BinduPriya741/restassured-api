package com.api.models.response;

public class RegisterResponse {
	
	public RegisterResponse() {
		// TODO Auto-generated constructor stub
	}
	
	private int id;
	private String token;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public RegisterResponse(int id, String token) {
		super();
		this.id = id;
		this.token = token;
	}

	@Override
	public String toString() {
		return "RegisterResponse [id=" + id + ", token=" + token + "]";
	}
	
	

}
