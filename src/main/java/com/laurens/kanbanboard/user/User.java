package com.laurens.kanbanboard.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.laurens.kanbanboard.board.doing.DoingTask;
import com.laurens.kanbanboard.board.done.DoneTask;
import com.laurens.kanbanboard.board.todo.ToDoTask;

@NamedQueries({

		@NamedQuery(name = "User.readAll", query = "SELECT u FROM USERS u"),
		@NamedQuery(name = "User.readByName", query = "SELECT u FROM USERS u WHERE u.userName =:username")

})

@Entity(name = "USERS")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private long userId;

	@Column(name = "USER_NAME")
	private String userName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private List<DoingTask> doingTasks;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private List<ToDoTask> toDoTasks;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private List<DoneTask> doneTasks;

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

	public long getUserId() {
		return userId;
	}

	public List<DoingTask> getDoingTasks() {
		return doingTasks;
	}

	public String toString() {
		return "User [Id=" + userId + ", UserName=" + userName + "]";
	}

}
