package com.laurens.kanbanboard.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="USERS")    
public class User {

	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private int userId; 
	
	@Column(name="USER_NAME")
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
