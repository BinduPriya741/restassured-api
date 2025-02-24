package com.api.models.request;

public class RegisterRequest {

	private String email;
	private String password; 
	
	
	
	private RegisterRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getUsername() {
		return email;
	}
	public void setUsername(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginRequest [email=" + email + ", password=" + password + "]";
	}
	
	public static class Builder {
		
		private String email;
		private String password; 
		
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		
		public RegisterRequest build() {
			RegisterRequest registerRequest = new RegisterRequest(email, password);
			return registerRequest;
		}
	}
	
}
