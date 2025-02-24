package com.api.models.response;

public class PutResponse {

	private String name;
	private String job;
	private String updatedAt;
	
	public PutResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "PutResponse [name=" + name + ", job=" + job + ", updatedAt=" + updatedAt + "]";
	}
	public PutResponse(String name, String job, String updatedAt) {
		super();
		this.name = name;
		this.job = job;
		this.updatedAt = updatedAt;
	}
	
	
	
}
	
	

