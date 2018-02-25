package com.laurens.kanbanboard.board.todo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.laurens.kanbanboard.board.KanbanBoard;
import com.laurens.kanbanboard.user.User;

@Entity(name="TODO_TASKS")
public class ToDoTask {

	@Id
	@GeneratedValue
	@Column(name = "TODO_TASK_ID")
	private long toDoTaskId;
	
	@Column(name = "CONTENT")
	private String content;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "KANDBANBOARD_ID")
	private KanbanBoard kanbanBoard;
	
	
	public ToDoTask() {
	}

	public ToDoTask(User user, KanbanBoard kanbanBoard, String content) {
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
		return toDoTaskId;
	}
	
	public String toString() {
		return "ToDoTask [Id=" + toDoTaskId + ", Content=" + content + "]";
	}

}
