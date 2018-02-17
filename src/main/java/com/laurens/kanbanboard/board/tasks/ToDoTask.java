package com.laurens.kanbanboard.board.tasks;

public class ToDoTask {

	private long toDoTaskId;
	private String discription;

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public long getToDoTaskId() {
		return toDoTaskId;
	}
	
	public String toString() {
		return "ToDoTask [Id=" + toDoTaskId + ", Discription=" + discription + "]";
	}

}
