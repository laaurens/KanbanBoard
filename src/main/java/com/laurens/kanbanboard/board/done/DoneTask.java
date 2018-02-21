package com.laurens.kanbanboard.board.done;

public class DoneTask {
	
	private long doneTaskId;
	private String discription;

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public long getToDoTaskId() {
		return doneTaskId;
	}

	public String toString() {
		return "DoneTask [Id=" + doneTaskId + ", Discription=" + discription + "]";
	}
}
