package com.laurens.kanbanboard.board.doing;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.laurens.kanbanboard.user.User;

@Entity(name="DOING_TASK_ID")
public class DoingTask {

	@Id
	@GeneratedValue
	@Column(name="DOING_TASK_ID")
	private long doingTaskId;
	
	@Column(name="CONTENT")
	private String content;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;

	public DoingTask() {
	}

	public DoingTask(User user, String discription) {
		this.user = user;
		this.content = discription;
	}

	public String getDiscription() {
		return content;
	}

	public void setDiscription(String discription) {
		this.content = discription;
	}

	public long getToDoTaskId() {
		return doingTaskId;
	}

	public String toString() {
		return "DoingTask [Id=" + doingTaskId + ", Discription=" + content + "]";
	}
}
