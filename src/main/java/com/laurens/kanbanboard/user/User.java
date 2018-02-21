package com.laurens.kanbanboard.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.laurens.kanbanboard.board.doing.DoingTask;

@Entity(name = "USERS")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;


	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private List<DoingTask> doingTasks;

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

	public List<DoingTask> getDoingTasks() {
		return doingTasks;
	}

	public String toString() {
		return "User [Id=" + userId + ", UserName=" + userName + "]";
	}

}
