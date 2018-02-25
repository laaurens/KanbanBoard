package com.laurens.kanbanboard.board.done;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.laurens.kanbanboard.board.KanbanBoard;
import com.laurens.kanbanboard.user.User;

@Entity(name="Done_TASKS")
public class DoneTask {
	
	@Id
	@GeneratedValue
	@Column(name = "DONE_TASK_ID")
	private long doneTaskId;
	
	@Column(name="content")
	private String content;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "KANDBANBOARD_ID")
	private KanbanBoard kanbanBoard;
	
	public DoneTask() {
	}

	public DoneTask(User user, KanbanBoard kanbanBoard, String content) {
		this.user = user;
		this.kanbanBoard = kanbanBoard;
		this.content = content;
	}
	
	String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getToDoTaskId() {
		return doneTaskId;
	}

	public String toString() {
		return "DoneTask [Id=" + doneTaskId + ", Content=" + content + "]";
	}
}
