package com.pcgiang.models;

public class StudentProfile {
	private int id;
	private String username;
	private String name;
	private int age;
	private String favoriteColor;
	
	public StudentProfile(int id, String username, String name, int age, String favoriteColor) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.age = age;
		this.favoriteColor = favoriteColor;
	}
	
	public StudentProfile() { super(); }
		
	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", name=" + name + ", age=" + age + ", favoriteColor=" + favoriteColor + "]";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFavoriteColor() {
		return favoriteColor;
	}
	public void setFavoriteColor(String favoriteColor) {
		this.favoriteColor = favoriteColor;
	}

}
