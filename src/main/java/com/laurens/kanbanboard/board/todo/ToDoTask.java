package com.laurens.kanbanboard.board.todo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity(name="TODO_TASKS")
public class ToDoTask {

	//@Id
	//@GeneratedValue
	//@Column(name = "TODO_TASK_ID")
	private long toDoTaskId;
	
	//@Column(name = "CONTENT")
	private String content;

	public String getDiscription() {
		return content;
	}

	public void setDiscription(String discription) {
		this.content = discription;
	}

	public long getToDoTaskId() {
		return toDoTaskId;
	}
	
	public String toString() {
		return "ToDoTask [Id=" + toDoTaskId + ", Discription=" + content + "]";
	}

}
