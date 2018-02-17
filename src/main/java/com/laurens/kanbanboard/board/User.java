package com.laurens.kanbanboard.board;

public class User {

	private int userId;
	private String userName;

	public User() {

	}

	public User(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}
	
	public String toString() {
		return "User [Id=" + userId + ", UserName=" + userName + "]";
	}

	
}
