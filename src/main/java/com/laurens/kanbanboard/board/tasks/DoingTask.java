package com.laurens.kanbanboard.board.tasks;

public class DoingTask {

	private long doingTaskId;
	private String discription;

	public DoingTask() {
	}

	public DoingTask(String discription) {
		this.discription = discription;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public long getToDoTaskId() {
		return doingTaskId;
	}

	public String toString() {
		return "DoingTask [Id=" + doingTaskId + ", Discription=" + discription + "]";
	}
}
