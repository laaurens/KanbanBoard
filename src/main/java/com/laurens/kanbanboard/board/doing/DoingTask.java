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

import com.laurens.kanbanboard.board.KanbanBoard;
import com.laurens.kanbanboard.user.User;

@Entity(name="DOING_TASKS")
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
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "KANDBANBOARD_ID")
	private KanbanBoard kanbanBoard;

	public DoingTask() {
	}

	public DoingTask(User user, KanbanBoard kanbanBoard, String content) {
		this.user = user;
		this.kanbanBoard = kanbanBoard;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getToDoTaskId() {
		return doingTaskId;
	}

	public String toString() {
		return "DoingTask [Id=" + doingTaskId + ", Content=" + content + "]";
	}
}
