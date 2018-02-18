package com.laurens.kanbanboard.board;

import java.util.List;

import com.laurens.kanbanboard.board.tasks.DoingTask;
import com.laurens.kanbanboard.board.tasks.DoneTask;
import com.laurens.kanbanboard.board.tasks.ToDoTask;
import com.laurens.kanbanboard.user.User;

public class KanbanBoard {

	private long kanbanBoardId;
	private User user;
	private List<ToDoTask> toDoTasks;
	private List<DoingTask> doingTasks;
	private List<DoneTask> doneTasks;

	public KanbanBoard() {

	}

	public KanbanBoard(User user) {
		this.user = user;
	}

	public long getKanbanBoardId() {
		return kanbanBoardId;
	}

	public User getUser() {
		return user;
	}

	public List<ToDoTask> getToDoTasks() {
		return toDoTasks;
	}

	public List<DoingTask> getDoingTasks() {
		return doingTasks;
	}

	public List<DoneTask> getDoneTasks() {
		return doneTasks;
	}

}
