package com.entity;

public class Jobs {
	
	private int id ;
	private String title ;
	private String category ;
	private String status ;
	private String location ;
	public Jobs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Jobs(String title, String category, String status, String location) {
		super();
		this.title = title;
		this.category = category;
		this.status = status;
		this.location = location;
	}

	
	
	

}
